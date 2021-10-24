public class Client {
    int [] moneyList = {0, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
    protected int currentAmount; //현재 금액

    public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}

    public void calAmount(int i){
        this.currentAmount += moneyList[i];
    }
}