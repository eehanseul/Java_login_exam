package day04;

// 스캐너(콘솔 입력)로 사용자에게 1~4 입력받음
// 1~4 입력에 따라 회원가입, 로그인, 회원정보 수정, 회원 탈퇴 기능 구현
// DAO / Repository : DB와 소통 (을 클래스로 대체) => class DAO { Map db / }

import java.util.Scanner;
public class HashExam {
    public static void main(String[] args) {
        DAO dao = new DAO();
        boolean isLogin = false;
        String loginID="";

        while(true){
            System.out.println("1: 회원가입, 2: 로그인, 3: 회원정보 수정, 4: 회원탈퇴 0: 종료");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();

            if(num == 1) {
                // 회원가입
                System.out.print("id를 입력해주세요 : ");
                String id = sc.next();
                System.out.print("pw를 입력해주세요 : ");
                String pw = sc.next();
                System.out.print("이름을 입력해주세요 : ");
                String name = sc.next();

                dao.addMember(id,pw,name);


            }
            else if(num ==2){
                // 로그인
                System.out.print("id를 입력해주세요 : ");
                String id = sc.next();
                System.out.print("pw를 입력해주세요 : ");
                String pw = sc.next();

                isLogin = dao.login(id,pw);

                if(isLogin) {
                    loginID = id;
                }
                else System.out.println("로그인 실패");
            }
            else if(num==3){
                // 회원정보 수정
                if(isLogin){
                    System.out.print("1: 비밀번호 수정, 2: 이름 수정 ");
                    int type = sc.nextInt();

                    switch (type){
                        case 1:
                            System.out.print("수정할 비밀번호를 입력해주세요 : ");
                            String newPW = sc.next();
                            dao.putPW(loginID,newPW);
                            break;
                        case 2:
                            System.out.print("수정할 이름을 입력해주세요 : ");
                            String newName = sc.next();
                            dao.putName(loginID,newName);
                            break;
                        default:
                            System.out.println("잘못된 입력입니다.");
                            break;
                    }
                }
                else{
                    System.out.println("로그인 상태가 아닙니다");
                }
            }
            else if(num ==4){
                // 회원탈퇴
                if(isLogin){
                    dao.removeMember(loginID);
                    System.out.println("회원탈퇴 완료 bye~~~~");
                }
                else{
                    System.out.println("로그인 상태가 아닙니다");
                }
            }
            else if(num==0){
                break;
            }
            else{
                System.out.println("잘못됐어 돌아가");
            }
        }

    }
}


