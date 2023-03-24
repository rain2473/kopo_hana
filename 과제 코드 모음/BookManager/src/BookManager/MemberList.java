package BookManager;

import java.util.*;
import java.util.stream.*;

public class MemberList implements Listable<Member> {
    private static MemberList instance;
    private static int members = 0;
    public static HashMap<String, Member> list = new HashMap<>();
    public static Member resigner = null;

    private MemberList() {}

    public static MemberList getInstance() {
        if (instance == null) {
            synchronized (MemberList.class) {
                if (instance == null) {
                    instance = new MemberList();
                }
            }
        }
        return instance;
    }

    @Override
    public void loadFromBackup(List<String> informations) throws UnsupportedOperationException {
        informations = new ArrayList<>(informations);
        try {
            String memberId = informations.get(0);
            informations.remove(0);
            boolean rentStatus = false;
            switch (informations.get(informations.size() - 1)) {
                case "대출있음": {
                    rentStatus = true;
                }
                default: {
                    rentStatus = false;
                }
            }
            MemberList.list.put(memberId, new Member(memberId, rentStatus, informations));
            MemberList.members++;
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addToList(Member member) {
        MemberList.list.put(member.getMemberId(), member);
        MemberList.members++;
    }

    @Override
    public List<Member> listUp() {
        return MemberList.list.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }


    @Override
    public List<String> searchByKeyword(String keyword) {
        List<Member> values = listUp();
        return values.stream().filter(member -> member.contains(keyword))
                .map(member -> member.getMemberId()).toList();
    }

    @Override
    public Member findById(String memberId) {
        return MemberList.list.get(memberId);
    }

    @Override
    public void deleteFromList(String memberId) throws NullPointerException{
        try {
            resigner = MemberList.getInstance().findById(memberId).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        list.remove(memberId);
        MemberList.members--;
    }

    @Override
    public int length() {
        return MemberList.members;
    }

    public void sort(String input) {
        input = input.toLowerCase();
        if ("rentStatus".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.RentStatus2String().compareTo(c2.RentStatus2String());
                }
            });
        } else if ("memberid".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getMemberId().compareTo(c2.getMemberId());
                }
            });
        } else if ("name".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getName().compareTo(c2.getName());
                }
            });
        } else if ("joindate".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getJoinDate().compareTo(c2.getJoinDate());
                }
            });
        } else if ("address".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getAddress().compareTo(c2.getAddress());
                }
            });
        } else if ("contect".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getContect().compareTo(c2.getContect());
                }
            });
        } else if ("birthday".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getBirthDay().compareTo(c2.getBirthDay());
                }
            });
        } else if ("age".equals(input)) {
            Collections.sort(this.listUp(), new Comparator<Member>() {
                @Override
                public int compare(Member c1, Member c2) {
                    return c1.getAge().compareTo(c2.getAge());
                }
            });
        } else {
            this.sort();
        }
    }

    @Override
    public void sort() {
        Collections.sort(this.listUp());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("회원Id,이름,등록일자,주소,연락처,생일,나이,현재대출여부\n");
        return result.toString();
    }

}
