import java.io.IOException;
import java.util.*;

public class Controller {
    static Help help = new Help();
    static Client client = new Client();
    static Admin admin = new Admin();
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
        String [] buyArr = {"buy", "bu", "b","$"};
        String [] deposArr = {"depos", "depo", "de","dp", "d", "+"};
        String [] changeArr = {"change", "chang", "chan", "cha", "ch", "c", "-"};
        String [] adminArr = {"admin", "admi", "adm", "ad", "a", "%"};
        String [] quitArr = {"quit", "qui", "qu", "q", "."};
        for(String obj: helpArr){
            cmdList.put(obj, 1);
        }
        for(String obj: listArr){
            cmdList.put(obj, 2);
        }
        for(String obj: buyArr){
            cmdList.put(obj, 3);
        }
        for(String obj: deposArr){
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
        System.out.println("[Vending Machine]");
        System.out.printf("< 현재 금액 : %d >\n", client.currentAmount);

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

    }


    public void checkGrammar(ArrayList<String> rUserInput) throws IOException {
        int mode = cmdList.get(rUserInput.get(0));
        switch(mode){
            //help
            case 1:
                if(rUserInput.size()==1){
                    help.printHowToUse();
                }
                else if(rUserInput.size()==2){
                    try{
                        int tmp = cmdList.get(rUserInput.get(1));
                        if(tmp!=1){
                            help.printCmdDesc(tmp);
                        }
                        else{
                            help.printInputError();
                        }
                    }
                    catch(NullPointerException e){
                        help.printInputError();
                    }
                }
                else{
                    help.printInputError();
                }
                break;

            //list
            case 2:
                if(rUserInput.size()==1){
                    List list = Controller.getList();

                    HashMap<String, Integer> count =list.getCountHM();
                    Iterator<String> keys = count.keySet().iterator();
                    System.out.println("------------------------------------------------------------\n" +
                            "Drink List\n" +
                            "--------------------------------------------------------------");
                    while(keys.hasNext()){
                        String key = keys.next();
                        int tmp = count.get(key);
                        if(tmp!=0){
                            System.out.printf("%s : %d\n", key, tmp);
                        }else{
                            System.out.printf("%s : 품절\n", key);
                        }
                    }
                }
                else{
                    list.printNoArgError();
                }
                break;

            //buy
            case 3:
                break;

            //depos
            case 4:
                if(rUserInput.size()==1){
                    System.out.println("--------------------------------\n" +
                            "1 | 50000 2 | 10000\n" +
                            "3 | 5000 4 | 1000\n" +
                            "5 | 500 6 | 100\n" +
                            "7 | 50 8 | 10\n" +
                            "------------------------------------");

                    Client client = Controller.getClient();

                    //입력받는 부분
                    String scanStr;
                    scanStr = scan.nextLine();

                    //String 처리 부분(공백제거)
                    String [] userInput = scanStr.strip().split(" ");
                    ArrayList<Integer> money = new ArrayList<Integer>();
                    boolean flag = true;
                    for(int i=0; i< userInput.length; i++){
                        if(userInput[i]==" "){
                            continue;
                        }
                        int tmp = Integer.parseInt(userInput[i]);
                        if(1<=tmp && tmp<=8){
                            money.add(tmp);
                        }
                        else{
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        for(int i: money) {
                            client.calAmount(i);
                        }
                    }

                }

                break;

            //change
            case 5:
                break;

            //admin
            case 6:
                break;

            //quit
            case 7:
                break;

            //
            default:
                break;
        }
    }
}