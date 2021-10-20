import java.util.ArrayList;
import java.util.Scanner;

public class Depos {
    public static Scanner scan = new Scanner(System.in);
    private ArrayList <Integer> arr_list = new ArrayList<>();
    private int price = 0;

    public int getPrice() {
        return price;
    }

    public void start() {
        T : while(true) {
            System.out.println("---------------------------------");
            System.out.println("1  |   50000  2 |   10000 ");
            System.out.println("3  |   5000   4 |   1000 ");
            System.out.println("5  |   500    6 |   100 ");
            System.out.println("7  |   50     8 |   10 ");
            System.out.println("---------------------------------");
            System.out.print("입금할 돈을 해당 번호로 입력해 주세요. : ");
            String input_num = scan.nextLine();
            String[] arr = input_num.split(" ");
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.parseInt(arr[i]);
                if(num < 1 || num > 8) {
                    System.out.println("[오류!] : 잘못된 번호 입니다. 다시 입력해 주세요!");
                    continue T;
                }
                else {
                    arr_list.add(num);
                }
            }
            break;
        }
    }

    public int Sum() {
        for (int i = 0; i < arr_list.size(); i++) {
            if (arr_list.get(i) % 2 == 0) { //짝수면
                this.price += Math.pow(10, (5 - (arr_list.get(i) / 2)));
            }
            else {
                this.price += 5 * Math.pow(10, (4 - (arr_list.get(i) / 2)));
            }
        }
        return this.price;
    }
}