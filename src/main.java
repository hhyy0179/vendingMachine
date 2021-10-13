import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        client Client = new client();
        help Help = new help();


        //        1.명령어
        Scanner scan = new Scanner(System.in);
        String tempCmd;
        tempCmd = scan.next();
        String [] cmd = tempCmd.split(" ");
        help.showMenu(cmd);





//        2. 자판기
//        금액 입력
//        음료수 이름 입력
//        재고 파일 읽기
//        음료수 내보내기
//        거스름돈 반환

    }
}