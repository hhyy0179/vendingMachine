import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Buy extends List {
    static Client client = new Client();
    HashMap<String, Integer> count =this.getCountHM();
    Iterator<String> keys = count.keySet().iterator();

    public char start(String drink) {
        while (keys.hasNext()) {
            String key = keys.next();
            int tmp = count.get(key);
            if (!key.equals(drink)) { //목록에 없으면
                return 'A';
            } else if (tmp == 0) { // 품절상품이면
                return 'B';
            } else if (client.getCurrentAmount() == 0) { //잔액이 0원이면
                return 'C';
            }
            else { //구매 완료
                return 'D';
            }
        }
        return 0;
    }
}