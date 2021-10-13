public class Client {
    int [] moneyList = {0, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
    int currentAmount; //현재 금액

    void calAmount(int i){
        this.currentAmount += moneyList[i];
    }
}