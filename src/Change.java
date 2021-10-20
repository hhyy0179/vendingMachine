import java.util.ArrayList;
import java.util.Scanner;

public class Change {
	
	Scanner scan= new Scanner(System.in);
	
    public void start(Client c){
    	//입력받는 부분
        String scanStr;
        scanStr = scan.nextLine();

        //String 처리 부분(공백제거)
        String [] userInput = scanStr.strip().split("");
        ArrayList<String> rUserInput = new ArrayList<String>();
        for(int i=0; i< userInput.length; i++){
            if(userInput[i]!=" "){
                rUserInput.add(userInput[i]);
            }
        }
        if(rUserInput.size()!=1) {
        	System.out.println("명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.\n");
        }
        else {
        	if(c.getCurrentAmount()==0) {
        		System.out.println("반환할 돈이 없습니다.");
        	}
        	else if(c.getCurrentAmount()>0) {
        		System.out.println("잔돈("+c.getCurrentAmount()+")원이 반환되었습니다./n");
        		c.setCurrentAmount(0);
        	}
        }
    }
}