import java.util.ArrayList;
import java.util.Scanner;

public class Depos extends Client{
    public static Scanner scan = new Scanner(System.in);

    public void showexec() {
        boolean check = true;
        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1  |   50000  2 |   10000 ");
            System.out.println("3  |   5000   4 |   1000 ");
            System.out.println("5  |   500    6 |   100 ");
            System.out.println("7  |   50     8 |   10 ");
            System.out.println("---------------------------------");
            System.out.print("입금할 돈을 해당 번호로 입력해 주세요. : ");
            String input_num = scan.nextLine();
            String[] userInput = input_num.strip().split(" ");
            ArrayList <Integer> money = new ArrayList<Integer>();
            for (int i = 0; i < userInput.length; i++) {
                if (userInput[i] == " ") {
                    continue;
                }
                int num = Integer.parseInt(userInput[i]);
                if (num >= 1 && num <= 8) {
                    money.add(num);
                } else {
                    System.out.println("[오류!] : 잘못된 번호 입니다. 다시 입력해 주세요!");
                    check = false;
                }
            }
            if (check) {
                for (int m : money) {
                    this.calAmount(m);
                }
                break;
            }
        }
    }

}