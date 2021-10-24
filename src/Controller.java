import java.io.IOException;
import java.util.*;

public class Controller {
    static Help help = new Help();
    static Client client = new Client();
    static Admin admin = new Admin();
    static Depos depos = new Depos();
    static Buy buy = new Buy();
    static Change change = new Change();
    static List list = new List();
    static Quit quit = new Quit();

    Scanner scan = new Scanner(System.in);

    static public Help getHelp(){
        return help;
    }
    static public Client getClient(){
        return client;
    }
    static public Admin getAdmin(){
        return admin;
    }
    static public Buy getBuy(){
        return buy;
    }
    static public Change getChange(){
        return change;
    }
    static public List getList(){
        return list;
    }
    static public Quit getQuit(){
        return quit;
    }

    static Map<String, Integer> cmdList = new HashMap<String, Integer>();

    public static void setCmdList(){
        //최초 1회 실행시켜서 cmdList를 초기화한다.
        String [] helpArr = {"help", "he", "h","?"};
        String [] listArr = {"list", "li", "ls", "l", "/"};
        String [] deposArr = {"depos", "depo", "de","dp", "d", "+"};
        String [] buyArr = {"buy", "bu", "b","$"};
        String [] changeArr = {"change", "chang", "chan", "cha", "ch", "c", "-"};
        String [] adminArr = {"admin", "admi", "adm", "ad", "a", "%"};
        String [] quitArr = {"quit", "qui", "qu", "q", "."};
        for(String obj: helpArr){
            cmdList.put(obj, 1);
        }
        for(String obj: listArr){
            cmdList.put(obj, 2);
        }
        for(String obj: deposArr){
            cmdList.put(obj, 3);
        }
        for(String obj: buyArr){
            cmdList.put(obj, 4);
        }
        for(String obj: changeArr){
            cmdList.put(obj, 5);
        }
        for(String obj: adminArr){
            cmdList.put(obj, 6);
        }
        for(String obj: quitArr){
            cmdList.put(obj, 7);
        }
    }

    public void run() throws IOException {
        while(true){
            System.out.println("[Vending Machine]");
            System.out.printf("< 현재 금액 : %d >\n", client.getCurrentAmount());
            System.out.print(">> ");

            //입력받는 부분
            String scanStr;
            scanStr = scan.nextLine();

            //String 처리 부분(공백제거)
            String [] userInput = scanStr.strip().split(" ");
            ArrayList<String> rUserInput = new ArrayList<String>();
            for(int i=0; i< userInput.length; i++){
                if(userInput[i]!=" "){
                    rUserInput.add(userInput[i]);
                }
            }
            executeCmd(rUserInput);
        }
    }

    public void executeCmd(ArrayList<String> rUserInput) throws IOException {
        int mode = cmdList.get(rUserInput.get(0));
        switch(mode) {
            //help
            case 1:
                if (rUserInput.size() == 1) {
                    help.printHowToUse();
                } else if (rUserInput.size() == 2) {
                    try {
                        int tmp = cmdList.get(rUserInput.get(1));
                        if (tmp != 1) {
                            help.printCmdDesc(tmp);
                        } else {
                            help.printInputError();
                        }
                    } catch (NullPointerException e) {
                        help.printInputError();
                    }
                } else {
                    help.printInputError();
                }
                break;

            //list
            case 2:
                if (rUserInput.size() == 1) {
                    List list = Controller.getList();

                    HashMap<String, Integer> count = list.getCountHM();
                    Iterator<String> keys = count.keySet().iterator();
                    System.out.println("-------------------------------\n" +
                            "          Drink List\n" +
                            "-------------------------------");
                    while (keys.hasNext()) {
                        String key = keys.next();
                        int tmp = count.get(key);
                        if (tmp != 0) {
                            System.out.printf("%s : %d\n", key, tmp);
                        } else {
                            System.out.printf("%s : 품절\n", key);
                        }
                    }
                    System.out.println();
                } else {
                    list.printNoArgError();
                }
                break;

            //depos
            case 3:
                if (rUserInput.size() == 1) {
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
                                client.calAmount(m);
                            }
                            break;
                        }
                    }
                }
                break;

            //buy
            case 4:
                List list = Controller.getList();

                HashMap<String, Integer> count = list.getCountHM();
                Iterator<String> keys = count.keySet().iterator();

                if (rUserInput.size() == 1) { // 뒤에 인자가 없을 경우
                    System.out.print("어떤 음료를 구매하시겠습니까? : ");
                    String drink = scan.next();

                    while (keys.hasNext()) {
                        String key = keys.next();
                        int tmp = count.get(key);
                        if (!key.equals(drink) && tmp != 0) { //목록에 없으면
                            System.out.println("입력하신 '" + drink + "'는 목록에 존재하지 않는 항목 입니다.");
                            break;
                        } else if (tmp == 0) { // 품절상품이면
                            System.out.println("현재 품절된 상품 입니다. 다른 상품을 선택해 주세요.");
                            break;
                        } else if (client.getCurrentAmount() == 0) { //잔액이 0원이면
                            System.out.println("잔액 부족으로 구매가 불가능 합니다. <’+’ 또는 ‘depos’> 명령어를 입력하여 입금해주세요.");
                            break;
                        }
                        else { //구매 완료
                            System.out.println("구매가 완료되었습니다.");
                            break;
                        }
                    }
//

                } else if (rUserInput.size() == 2) { //인자가 2개 일 경우
                    switch (buy.start(rUserInput.get(1))) {
                        case 1:
                            System.out.println("입력하신 '" + rUserInput.get(1) + "'는 목록에 존재하지 않는 항목 입니다.");
                            break;
                        case 2:
                            System.out.println("현재 품절된 상품 입니다. 다른 상품을 선택해 주세요.");
                            break;
                        case 3:
                            System.out.println("잔액 부족으로 구매가 불가능 합니다. <’+’ 또는 ‘depos’> 명령어를 입력하여 입금해주세요.");
                            break;
                        case 4:
                            System.out.println("구매가 완료되었습니다.");
                            break;
                    }
                } else {
                    System.out.println("잘못된 입력 입니다.");
                }

                break;
            //change
            case 5:
            	for(int i=1;i<rUserInput.size();i++) {
            		if(rUserInput.get(i)==" ") continue;
            		if(rUserInput.get(i)!=" ") {
            			System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
            			break;
            		}
            	}
            	if(client.getCurrentAmount()==0) {
            		System.out.println("[오류] : 반환할 돈이 없습니다.");
            		break;
            	}
            	else {
                    System.out.println("돈이 반환되었습니다.");
            		client.setCurrentAmount(0);
            		break;
            	}

            //admin
            case 6:
                break;

            //quit
            case 7:
            	for(int i=1;i<rUserInput.size();i++) {
            		if(rUserInput.get(i)==" ") continue;
            		
            		if(rUserInput.get(i)!=" ") {
            			System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
            			break;
            		}
            	}
            	if(client.getCurrentAmount()!=0) {
            		System.out.println("[오류]: 잔액이 존재합니다. <’change’ 또는 ‘-‘> 명령어를 입력하여 잔돈을 반환해주세요.");
            		break;
            	}
            	else {
            		System.out.println("프로그램을 종료합니다.");
            		break;
            	}
            //
            default:
                break;
        }
    }
}