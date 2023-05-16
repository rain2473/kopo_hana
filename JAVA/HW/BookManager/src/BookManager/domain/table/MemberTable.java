package BookManager.domain.table;

import java.util.*;
import java.util.stream.*;

import BookManager.domain.model.MemberInformation;
import BookManager.domain.model.Member;

public class MemberTable implements DataTable<Member> {
    private static MemberTable instance;
    private static int members = 0;
    public static HashMap<String, Member> table = new HashMap<>();
    public Member resigner;

    private MemberTable() {}

    public static MemberTable getInstance() {
        if (instance == null) {
            synchronized (MemberTable.class) {
                if (instance == null) {
                    instance = new MemberTable();
                }
            }
        }
        return instance;
    }

    @Override
    public void loadFromBackup(List<String> input) throws UnsupportedOperationException {
    	input = new ArrayList<>(input);
        try {
            String memberId = input.get(0);
            input.remove(0);
            boolean rentStatus = false;
            switch (input.get(0)) {
                case "대출있음": {
                    rentStatus = true;
                }
                case "대출가능": {
                	rentStatus = true;
                }
                default: {
                    rentStatus = false;
                }
            }
            input.remove(0);
            MemberInformation informations = new MemberInformation(input);
            MemberTable.table.put(memberId, new Member(memberId, rentStatus, informations));
            MemberTable.members++;
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(Member member) {
        MemberTable.table.put(member.getMemberId(), member);
        MemberTable.members++;
    }

    @Override
    public List<Member> listUp() {
        return MemberTable.table.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<Member> values = listUp();
        return values.stream().filter(member -> member.contains(keyword))
                .map(member -> member.getMemberId()).toList();
    }

    @Override
    public Member findById(String memberId) {
        return MemberTable.table.get(memberId);
    }

    @Override
    public void deleteFromList(String memberId){
        try {
            resigner = MemberTable.getInstance().findById(memberId).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        table.remove(memberId);
        MemberTable.members--;
    }

    @Override
    public int length() {
        return MemberTable.members;
    }

    public List<Member> sortedListUp(String input) {
        List<Member> result = new ArrayList<Member>(this.listUp());
        input = input.toLowerCase();
        if ("rentstatus".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.RentStatus2String().compareTo(c2.RentStatus2String());
                }
            });
        } else if ("memberid".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getMemberId().compareTo(c2.getMemberId());
                }
            });
        } else if ("name".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getMemberName().compareTo(c2.getMemberName());
                }
            });
        } else if ("joindate".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getJoinDate().compareTo(c2.getJoinDate());
                }
            });
        } else if ("address".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getAddress().compareTo(c2.getAddress());
                }
            });
        } else if ("contect".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getContect().compareTo(c2.getContect());
                }
            });
        } else if ("birthday".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getBirthDay().compareTo(c2.getBirthDay());
                }
            });
        } else if ("age".equals(input)) {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getAge().compareTo(c2.getAge());
                }
            });
        } else {
            Collections.sort(result, new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getAge().compareTo(c2.getAge());
                }
            });
        }
        return result;
    }

    @Override
    public void sort() {
        Collections.sort(this.listUp());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("회원Id,현재대출여부,이름,등록일자,주소,연락처,생일,나이\n");
        return result.toString();
    }

}
