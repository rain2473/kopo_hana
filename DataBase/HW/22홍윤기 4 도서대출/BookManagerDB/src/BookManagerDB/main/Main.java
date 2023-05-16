package BookManagerDB.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import BookManagerDB.system.LibrarySystem;

public class Main {
	static LibrarySystem librarysystem = LibrarySystem.getInstance();
	public static void main(String[] args) throws IOException, ParseException, CloneNotSupportedException, ClassNotFoundException, SQLException {
		librarysystem.open();
		System.out.println("정상적으로 로딩 되었습니다.");
		librarysystem.showMain();
		librarysystem.close();
		System.out.println("정상적으로 저장 되었습니다.");
		System.exit(1);
	}
}