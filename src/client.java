public class client {
//    10, 50, 100, 500, 1000, 5000, 10000, 50000
    int [] moneyList = {0, 50000, 10000, 5000, 1000, 500, 100, 50, 10};
    int sum;

    void calSum(int i){
        this.sum += moneyList[i];
    }
}
