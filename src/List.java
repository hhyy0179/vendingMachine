import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class List {
    HashMap<String, Integer> count = new HashMap<String, Integer>();
    HashMap<String, Integer> price = new HashMap<String, Integer>();

    public void start() throws IOException {
        //프로그램 실행 후 최초 1회만 실행한다.
        //프로그램 실행 중에는 메모리에서 가격과 개수를 관리한다.
        BufferedReader reader = new BufferedReader(
                new FileReader("file.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String [] beverage = str.split(" ");
        }
        reader.close();
    }

    public void quit() throws IOException{
        //프로그램 종료 전에 stockList.txt를 업데이트 한다.
    }
}