import java.io.IOException;
import java.util.*;

public class Help {

    public void printHowToUse(){
        System.out.println("--------------------------------------------------------------------------------\n" +
                "명령어군 | 올바른 인자들 | 설명\n" +
                "------------------+---------------------+--------------------------------------\n" +
                "? help | 없거나,명령어1개 | 전체 혹은 명령어 별 도움말 출력\n" +
                "/ list | 없음 | 구매 가능한 음료수 출력\n" +
                "$ buy | 없거나,음료 1개 | 음료수 구매하기\n" +
                "+ depos | 없음 | 금액 입금하기\n" +
                "- change | 없음 | 잔돈 전체 반환하기\n" +
                "% admin | 없음 | 관리자 모드\n" +
                ". quit | 없음 | 종료하기\n" +
                "---------------------------------------------------------------------------------");
    }

    public void printCmdDesc(int mode){
        switch(mode){
            //help
            case 1:
                printHowToUse();
                break;

            //list
            case 2:
                System.out.println("[list] 는 구매 가능한 음료수 정보를 출력하는 명령어 입니다,\n" +
                        "동의어 : / lis li ls l");
                break;

            //buy
            case 3:
                System.out.println();
                break;

            //depos
            case 4:
                System.out.println();
                break;

            //change
            case 5:
                System.out.println();
                break;

            //admin
            case 6:
                System.out.println();
                break;

            //quit
            case 7:
                System.out.println();
                break;

        }

    }

    public void printInputError() {
        System.out.println("[오류] : 잘못된 입력 입니다. <’help’ 또는 ‘?’> 명령어를 입력하여 확인하세요.");
    }
}