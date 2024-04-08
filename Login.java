package day04;

public class Login {
    private String Id;
    private String pw;
    DAO dao = new DAO();

    Login(String id, String pw){
        this.Id = id;
        this.pw = pw;
    }
//    void verify(){
//        Member member = dao.getMember(Id);
//    }


}
