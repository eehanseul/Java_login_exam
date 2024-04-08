package day04;

import java.util.HashMap;
import java.util.List;
public class DAO {
    private HashMap<String, Member> user;

    public DAO() {
        user = new HashMap<>();
    }

    // 회원 추가 메서드
    public void addMember(String id, String password, String name) {
        if(user.containsKey(id)){
            System.out.println("중복된 id입니다.");
        }else{
            Member member = new Member(id, password, name);
            user.put(id, member);
            System.out.println(name + " 님 회원가입 완료");
        }
    }

    // 회원 정보 조회 메서드
    public String getName(String id) {
        Member member = user.get(id);
        String name = member.getName();
        return name;
    }
    public boolean login(String id, String pw){
        Member member = user.get(id);

        if(member==null){
            System.out.println("일치하는 회원이 없습니다.");
            return false;
        }
        else{
            String ID = member.getId();
            String PW = member.getPassword();

            if(ID.equals(id) && PW.equals(pw)){
                System.out.println(member.getName() + " 님 로그인 완료");
                return true;
            }
            else{
                return false;
            }
        }
    }

    public void putPW(String id, String newPw){
        Member member = user.get(id);
        member.setPassword(newPw);
        user.replace(id, member);
    }
    public void putName(String id, String newName){
        Member member = user.get(id);
        member.setName(newName);
        user.replace(id, member);
    }

    // 회원 삭제 메서드
    public void removeMember(String id) {
        user.remove(id);
    }
}

// Member 클래스 정의
class Member {
    private String id;
    private String password;
    private String name;

    public Member(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
