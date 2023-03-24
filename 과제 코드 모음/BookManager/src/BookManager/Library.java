package BookManager;

import java.io.IOException;
import java.text.ParseException;

public class Library {
    private static Library instance;
    BookList booklist = BookList.getInstance();
    RentalList rentalList = RentalList.getInstance();
    MemberList memberList = MemberList.getInstance();
    
    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            synchronized (BookList.class) {
                if (instance == null) {
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    public void open() throws IOException {
        BackUpHandler.loadFile("BackUpBooklist.csv", booklist);
        BackUpHandler.loadFile("BackUpRentallist.csv", rentalList);
        BackUpHandler.loadFile("BackUpMemberlist.csv", memberList);
    }
    
    public void close() throws IOException {
        BackUpHandler.saveFile("BackUpBooklist.csv", booklist);
        BackUpHandler.saveFile("BackUpRentallist.csv", rentalList);
        BackUpHandler.saveFile("BackUpMemberlist.csv", memberList);
    }
    
    public void rent(String memberId, String BookId, boolean extension) throws IOException, ParseException {
        RentalCase rental = new RentalCase(extension, BookId, memberId);
        rentalList.addToList(rental);
        Book book = booklist.findById(BookId);
        Member member = memberList.findById(memberId);
        book.setRentalStatus(true);
        member.setRentStatus(true);
    }
    
    public void extens(String memberId, String BookId) throws IOException, ParseException, CloneNotSupportedException {
        rentalList.setContent(BookId);
    }
    
    public Member resign(String memberId) throws IOException, ParseException, CloneNotSupportedException {
        memberList.deleteFromList(memberId);
        return MemberList.resigner;
    }
    
    public void undoResign() throws NullPointerException {
        memberList.addToList(MemberList.resigner);
    }
}
