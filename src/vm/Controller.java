package vm;

import java.io.IOException;
import java.util.*;

public class Controller {
    static Help help = new Help();
    static Client client = new Client();
    static Admin admin = new Admin();
    static Buy buy = new Buy();
    static Change change = new Change();
    static List list = new List();
   

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
   

    static Map<String, Integer> cmdList = new HashMap<String, Integer>();
    static Map<String, String> itemList= new HashMap<String,String>(); 		//이름  , 대표이름
    public static void setCmdList(){
        //최초 1회 실행시켜서 cmdList를 초기화한다.
        String [] helpArr = {"help", "he", "h","?"};
        String [] listArr = {"list", "li", "ls", "l", "/"};
        String [] deposArr = {"depos", "depo", "de","dp", "d", "+"};
        String [] buyArr = {"buy", "bu", "b","$"};
        String [] changeArr = {"change", "chang", "chan", "cha", "ch", "c", "-"};
        String [] adminArr = {"admin", "admi", "adm", "ad", "a", "%"};
        String [] quitArr = {"quit", "qui", "qu", "q", "."};
        String [] drink1= {"코카콜라","coca-cola","cocacola","coke"};
        String [] drink2= {"칠성사이다","chilseongcider","cider"};
        String [] drink3= {"밀키스","milkis"};
        String [] drink4= {"데자와","tejava","milktea"};
        String [] drink5= {"닥터페퍼","dr.pepper"};
        String [] drink6= {"옥수수수염차","corntea"};
        String [] drink7= {"삼다수","samdasu","water"};
        for(String obj: helpArr) cmdList.put(obj, 1);
        for(String obj: listArr) cmdList.put(obj, 2);        
        for(String obj: deposArr) cmdList.put(obj, 3);        
        for(String obj: buyArr) cmdList.put(obj, 4);       
        for(String obj: changeArr)cmdList.put(obj, 5);        
        for(String obj: adminArr)cmdList.put(obj, 6);       
        for(String obj: quitArr)cmdList.put(obj, 7);       
        for(String obj: drink1) itemList.put(obj, "코카콜라");       
        for(String obj: drink2) itemList.put(obj, "칠성사이다");      
        for(String obj: drink3) itemList.put(obj, "밀키스");      
        for(String obj: drink4) itemList.put(obj, "데자와");     
        for(String obj: drink5) itemList.put(obj, "닥터페퍼");     
        for(String obj: drink6) itemList.put(obj, "옥수수수염차");    
        for(String obj: drink7) itemList.put(obj, "삼다수");
        
    }

    public void run() throws IOException {
        while(true){
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
            executeCmd(rUserInput);
        }
    }

    public void executeCmd(ArrayList<String> rUserInput) throws IOException {
        int mode;
		try {
			mode = cmdList.get(rUserInput.get(0));
		} catch (Exception e1) {
			System.out.println("[오류] : 잘못된 입력 입니다. <’help’ 또는 ‘?’> 명령어를 입력하여 확인하세요.");
			return;
		}
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
                    //List list = Controller.getList();

                    HashMap<String, Integer> count =list.count;
                    HashMap<String, Integer> count2 =list.price;
                    Iterator<String> keys = count.keySet().iterator();	//갯수 iterator
                    Iterator<String> keys2 = count2.keySet().iterator();//가격 iterator
                    System.out.println("------------------------------------------------------------\n" +
                            "Drink List\n" +
                            "--------------------------------------------------------------");
                    while(keys.hasNext()){
                        String key = keys.next();
                        String key2=keys2.next();
                        int tmp = count.get(key);  //갯수
                        int tmp2= count2.get(key); //가격
                        if(tmp!=0){
                            System.out.printf("%s : %d\n", key, tmp2);
                        }else{
                            System.out.printf("%s : 품절\n", key);
                        }
                    }
                }
                else{
                    list.printNoArgError();
                }
                break;

            
                //depos
            case 3:
                if(rUserInput.size()==1){
                    System.out.println("--------------------------------\n" +
                            "1 | 50000 2 | 10000\n" +
                            "3 | 5000 4 | 1000\n" +
                            "5 | 500 6 | 100\n" +
                            "7 | 50 8 | 10\n" +
                            "------------------------------------");

                    //Client client = Controller.getClient();

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
                            int t=client.moneyList[tmp];
                            client.moneyCount.put(t, client.moneyCount.get(t)+1);
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
                else {
                	System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
                	
                }
                break;
            //buy
            case 4:{
            	if(rUserInput.size()==2) {
            		Iterator<String> itr=itemList.keySet().iterator();
            		boolean flag=false;
            		while(itr.hasNext()) {
            			String key=itr.next();
            			
            			if(rUserInput.get(1).equals(key)) {	
            				String name=itemList.get(key);	//음료 대표이름 저장
            				int price=list.price.get(name);	//음료가격 가져오기
            				if(client.currentAmount<price) {
            					System.out.println("[오류] : 잔액부족으로 구매가 불가능 합니다. <’+’ 또는 ‘depos’> 명령어를 입력하여 입금해주세요.");
            					flag=true;
            					break;
            				}
            				else {
            					client.currentAmount-=price;
            					System.out.println("정상적으로 구매되었습니다. 감사합니다.");
            					flag=true;
            					break;
            				}
                			
            			}
            			else {
            				continue;
            			}
            			
            		}
            		if(flag==false) System.out.println("입력하신 "+rUserInput.get(1)+"는 목록에 존재하지 않는 항목입니다.");
            	}
            	else {
            		System.out.println("[오류] : 명령어 뒤에 인자는 하나만 입력해주세요");
            		break;
            	}
            	break;
            }
            //change
            case 5:
            	if(rUserInput.size()!=1) {
            		System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
            		break;
            	}
            	if(client.getCurrentAmount()==0) {
            		System.out.println("[오류] : 반환할 돈이 없습니다.");
            		break;
            	}
            	else {
            		System.out.println("잔돈("+client.currentAmount+")원이 반환되었습니다.");
            		for(int a : client.moneyList) { //지폐 갯수 0개로 초기화
            			client.moneyCount.put(a, 0);
            		}
            		
            		client.currentAmount=0; //총 돈 0원
            		break;
            	}

            //admin
            case 6:{
            	if(rUserInput.size()!=1) {
            		System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
            	}
            	else {
            		admin.run();
            	}
                break;
            }
            //quit
            case 7:
            	if(rUserInput.size()!=1) {
            		System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
            		break;
            	}
            	if(client.getCurrentAmount()!=0) {
            		System.out.println("[오류]: 잔액이 존재합니다. <’change’ 또는 ‘-‘> 명령어를 입력하여 잔돈을 반환해주세요.");
            		break;
            	}
            	else {
            		System.out.println("프로그램을 종료합니다.");
            		System.exit(0);
            	}
            //
            default:
            	//System.out.println("[오류] : 잘못된 입력 입니다. <’help’ 또는 ‘?’> 명령어를 입력하여 확인하세요.");
                break;
        }
    }
}