package vm;

import java.util.HashMap;

public class Client {
    public static int [] moneyList = {0, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
    public static HashMap<Integer, Integer> moneyCount=new HashMap<>();
    static int currentAmount=0;//현재 금액
    

   
    Client(){
	for(int a : moneyList) { //처음 client 객체 생성시 돈 0원
		moneyCount.put(a, 0);
	}
	currentAmount=0;
}
    
    public static HashMap<Integer, Integer> getMoneyCount() {
	return moneyCount;
}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	
    void calAmount(int i){
        this.currentAmount += moneyList[i];
    }
}