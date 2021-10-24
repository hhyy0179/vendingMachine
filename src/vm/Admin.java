package vm;

import java.util.*;
import java.io.*;
public class Admin {
	
	 static Map<String, Integer> adminCmd= new HashMap();
	 
	 Scanner scan=new Scanner(System.in);
	 
	 public static void setAdminCmdList() {
		String [] addArr= {"추가","add","ㅊㄱ","+"};
		String [] deleteArr= {"제거","delete","ㅈㄱ","-"};
		String [] modifyArr={"변경","modify","ㅂㄱ"};
		String [] backArr= {"뒤로가기","back","ㄷㄹㄱㄱ"};
		
		for(String obj: addArr){
            adminCmd.put(obj, 1);
        }
		for(String obj: deleteArr){
            adminCmd.put(obj, 2);
        }
		for(String obj: modifyArr){
            adminCmd.put(obj, 3);
        }
		for(String obj: backArr){
            adminCmd.put(obj, 4);
        }
	}
    public void run() throws IOException{
    	 while(true){
             System.out.println("[관리자모드]");
             System.out.printf("1 : 상품관리\n"+
             		           "2 : 잔고관리\n"+
            		 		   "3 : 도움말");

             //입력받는 부분
             String scanStr;
             scanStr = scan.nextLine();

             //String 처리 부분(공백제거)
             String userInput = scanStr.strip();
             userInput=userInput.toLowerCase();
             if(userInput.equals("1")||userInput.equals("2")||userInput.equals("3")) {
            	executeCmd(userInput);
             }
             else {
            	 System.out.println("1, 2, 3 중 하나를 입력해주십시오");
            	 continue;
             }
             if(userInput=="exit") break;
            
            
             
         }
    }
    public void executeCmd(String userInput) throws IOException { //1번 상품관리 2번 잔고관리 3번 도움말
    	switch (userInput) {
		case "1": {
			adminFirstMenu();
		break;
		}
		case "2":{//잔고관리
			adminSecondMenu();
		}
		case "3":{
			System.out.println("exit : 메인메뉴로 이동합니다.");
		}
		default:
			 System.out.println("1, 2, 3 중 하나를 입력해주십시오");
			break;
		}
    }
    
    public void adminFirstMenu() {
    	System.out.println("[상품관리]");
		
		Iterator<String> itr2=List.price.keySet().iterator(); //가격 iterator
		Iterator<String> itr3=List.count.keySet().iterator(); //갯수 iterator
		
		while(itr2.hasNext()) {
			String temp1=itr2.next();
			String temp2=itr3.next();
			 int tmp = List.count.get(temp1);  //갯수
             int tmp2= List.price.get(temp2); //가격
			System.out.println(temp1+"/"+tmp2+"원/"+tmp+"개");
			
		}
		 //입력받는 부분
        String scanStr;
        scanStr = scan.nextLine();

        //String 처리 부분(공백제거)
        String [] userInput2 = scanStr.strip().split(" ");
        ArrayList<String> rUserInput = new ArrayList<String>();
        for(int j=0; j<userInput2.length; j++){
            if(userInput2[j]!=" "){
                rUserInput.add(userInput2[j]);
            }
        }
        int mode;
        try {
			mode=adminCmd.get(rUserInput.get(0));
		} catch (Exception e1) {
			System.out.println("[오류] : 잘못된 입력 입니다. <’help’ 또는 ‘?’> 명령어를 입력하여 확인하세요.");
			return;
		}
		switch(mode) {
		
		case 1:{	//추가
			if(!Controller.itemList.containsKey(rUserInput.get(1))) { //동일한 이름의 음료수가 자판기에 존재하지 않는다면
				System.out.println("[오류] : 존재하는 상품을 입력해주세요");
				return;
			 }
			
			if(rUserInput.get(1).equals("코카콜라")||rUserInput.get(1).equals("coke")||rUserInput.get(1).equals("coca-cola")||rUserInput.get(1).equals("cocacola")) {
				List.count.put("코카콜라", Integer.parseInt(rUserInput.get(2))+List.count.get("코카콜라"));
				 System.out.println("코카콜라가"+ rUserInput+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("칠성사이다")||rUserInput.get(1).equals("cider")||rUserInput.get(1).equals("chilseongcider")) {
				List.count.put("칠성사이다", Integer.parseInt(rUserInput.get(2))+List.count.get("칠성사이다"));
				System.out.println("칠성사이다가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("밀키스")||rUserInput.get(1).equals("milkis")){
				List.count.put("밀키스", Integer.parseInt(rUserInput.get(2))+List.count.get("밀키스"));
				System.out.println("밀키스가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("데자와")||rUserInput.get(1).equals("tejava")||rUserInput.get(1).equals("milktea")) {
				List.count.put("데자와", Integer.parseInt(rUserInput.get(2))+List.count.get("데자와"));
				System.out.println("데자와가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("닥터페퍼")||rUserInput.get(1).equals("dr.pepper")) {
				List.count.put("닥터페퍼", Integer.parseInt(rUserInput.get(2))+List.count.get("닥터페퍼"));
				System.out.println("닥터페퍼가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("옥수수수염차")||rUserInput.get(1).equals("corntea")) {
				List.count.put("옥수수수염차", Integer.parseInt(rUserInput.get(2))+List.count.get("옥수수수염차"));
				System.out.println("옥수수수염차가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("삼다수")||rUserInput.get(1).equals("samdasu")||rUserInput.get(1).equals("water")) {
				List.count.put("삼다수", Integer.parseInt(rUserInput.get(2))+List.count.get("삼다수"));
				System.out.println("삼다수가"+ rUserInput.get(2)+" 개 추가되었습니다.");
				break;
			}

			 break;
		}
			
		
		case 2:{	//제거
			if(!Controller.itemList.containsKey(rUserInput.get(1))) { //동일한 이름의 음료수가 자판기에 존재하지 않는다면
				System.out.println("[오류] : 존재하는 상품을 입력해주세요");
				return;
			 }
			
			if(rUserInput.get(1).equals("코카콜라")||rUserInput.get(1).equals("coke")||rUserInput.get(1).equals("coca-cola")||rUserInput.get(1).equals("cocacola")) {
				if(List.count.get("코카콜라")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("코카콜라", List.count.get("코카콜라")-Integer.parseInt(rUserInput.get(2)));
				 System.out.println("코카콜라가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("칠성사이다")||rUserInput.get(1).equals("cider")||rUserInput.get(1).equals("chilseongcider")) {
				if(List.count.get("칠성사이다")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("칠성사이다", List.count.get("칠성사이다")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("칠성사이다가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("밀키스")||rUserInput.get(1).equals("milkis")){
				if(List.count.get("밀키스")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("밀키스", List.count.get("밀키스")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("밀키스가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("데자와")||rUserInput.get(1).equals("tejava")||rUserInput.get(1).equals("milktea")) {
				if(List.count.get("데자와")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("데자와", List.count.get("데자와")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("데자와가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("닥터페퍼")||rUserInput.get(1).equals("dr.pepper")) {
				if(List.count.get("닥터페퍼")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("닥터페퍼", List.count.get("닥터페퍼")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("닥터페퍼가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("옥수수수염차")||rUserInput.get(1).equals("corntea")) {
				if(List.count.get("옥수수수염차")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("옥수수수염차", List.count.get("옥수수수염차")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("옥수수수염차가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("삼다수")||rUserInput.get(1).equals("samdasu")||rUserInput.get(1).equals("water")) {
				if(List.count.get("삼다수")-Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("갯수는 음수가 될수없습니다.");
					return;
				}
				List.count.put("삼다수", List.count.get("삼다수")-Integer.parseInt(rUserInput.get(2)));
				System.out.println("삼다수가"+ rUserInput.get(2)+" 개 제거되었습니다.");
				break;
			}


			
			break;
		}
		case 3:{	//가격변경
			if(!Controller.itemList.containsKey(rUserInput.get(1))) { //동일한 이름의 음료수가 자판기에 존재하지 않는다면
				System.out.println("[오류] : 존재하는 상품을 입력해주세요");
				return;
			 }
			if(rUserInput.get(1).equals("코카콜라")||rUserInput.get(1).equals("coke")||rUserInput.get(1).equals("coca-cola")||rUserInput.get(1).equals("cocacola")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("코카콜라", Integer.parseInt(rUserInput.get(2)));
				 System.out.println("코카콜라가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("칠성사이다")||rUserInput.get(1).equals("cider")||rUserInput.get(1).equals("chilseongcider")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("칠성사이다", Integer.parseInt(rUserInput.get(2)));
				System.out.println("칠성사이다가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("밀키스")||rUserInput.get(1).equals("milkis")){
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("밀키스", Integer.parseInt(rUserInput.get(2)));
				System.out.println("밀키스가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("데자와")||rUserInput.get(1).equals("tejava")||rUserInput.get(1).equals("milktea")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("데자와", Integer.parseInt(rUserInput.get(2)));
				System.out.println("데자와가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("닥터페퍼")||rUserInput.get(1).equals("dr.pepper")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("닥터페퍼", Integer.parseInt(rUserInput.get(2)));
				System.out.println("닥터페퍼가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("옥수수수염차")||rUserInput.get(1).equals("corntea")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("옥수수수염차", Integer.parseInt(rUserInput.get(2)));
				System.out.println("옥수수수염차가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}
			if(rUserInput.get(1).equals("삼다수")||rUserInput.get(1).equals("samdasu")||rUserInput.get(1).equals("water")) {
				if(Integer.parseInt(rUserInput.get(2))<0) {
					System.out.println("가격은 음수가 될수없습니다.");
					return;
				}
				List.price.put("삼다수", Integer.parseInt(rUserInput.get(2)));
				System.out.println("삼다수가"+ rUserInput.get(2)+" 원으로 변경되었습니다.");
				break;
			}

			
			break;
		}
		case 4:{	//뒤로가기
			break;
		}
		default:
			break;
		}
    }
    public void adminSecondMenu() {
    	
    	System.out.println("[잔고관리]");
		Iterator<Integer> itr=Client.moneyCount.keySet().iterator(); //지폐 iterator
		while(itr.hasNext()) {
			int temp_key=itr.next();
			if(temp_key==0) continue;
			System.out.println(temp_key+"원/ "+Client.moneyCount.get(temp_key));
		}
		String scanStr;					//명령어 화폐단위 갯수
        scanStr = scan.nextLine();
        
		String [] userInput2 = scanStr.strip().split(" ");
        ArrayList<String> rUserInput = new ArrayList<String>();
        for(int j=0; j<userInput2.length; j++){
            if(userInput2[j]!=" "){
                rUserInput.add(userInput2[j]);
            }
        }
        int mode;
		try {
			mode = adminCmd.get(rUserInput.get(0));
		} catch (Exception e) {
			System.out.println("[오류] : 잘못된 입력 입니다. <’help’ 또는 ‘?’> 명령어를 입력하여 확인하세요.");
			return;
		}
		
		if(mode==3)return;						//잔고관리에서는 변경을 사용하지않는다.
		switch(mode) {
		case 1:{								//현금 추가
			itr=Client.moneyCount.keySet().iterator();
			while(itr.hasNext()) {
				int str=itr.next();
				if(str==Integer.parseInt(rUserInput.get(1))&&Integer.parseInt(rUserInput.get(1))>=0&&Integer.parseInt(rUserInput.get(1))>=1000) {
					Client.moneyCount.put(str, Client.moneyCount.get(str)+Integer.parseInt(rUserInput.get(2)));
		
					break;
				}
			}
			break;
		}
		case 2:{								//현금 제거
			itr=Client.moneyCount.keySet().iterator();
			while(itr.hasNext()) {
				int str=itr.next();
				if(str==Integer.parseInt(rUserInput.get(1))&&Integer.parseInt(rUserInput.get(1))>=0&&Integer.parseInt(rUserInput.get(1))>=1000) {
					Client.moneyCount.put(str, Client.moneyCount.get(str)-Integer.parseInt(rUserInput.get(2)));
					break;
				}
			}
			break;
		}
		case 4:{								//뒤로가기
			break;
		}
		default:{
			System.out.println("추가/제거/변경중 하나를 입력해주세요");
			break;
		}
		}
    }
}