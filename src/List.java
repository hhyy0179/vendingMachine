import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class List {
    static ArrayList<String> beverage = new ArrayList<String>();
    static HashMap<String, Integer> count = new HashMap<String, Integer>();
    static HashMap<String, Integer> price = new HashMap<String, Integer>();

    public int getCount(String name){
        return count.get(name);
    }

    public void buy(String name){
        count.replace(name, count.get(name)-1);
    }

    public int getPrice(String name){
        return price.get(name);
    }

    public ArrayList<String> getBeverageList(){
        return beverage;
    }

    public HashMap<String, Integer> getCountHM(){
        return count;
    }

    public static void readList() throws IOException {
        //프로그램 실행 후 최초 1회만 실행한다.
        //프로그램 실행 중에는 메모리에서 가격과 개수를 관리한다.
        BufferedReader reader = new BufferedReader(
                new FileReader("/Users/jadesuiii/vendingMachine/src/stockList.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String [] tmp = str.split(" ");
            beverage.add(tmp[0]);
            count.put(tmp[0], Integer.parseInt(tmp[1]));
        }
        reader.close();
    }

    public void writeList() throws IOException{
        //프로그램 종료 전에 stockList.txt를 업데이트 한다.
        BufferedWriter writer = new BufferedWriter(new FileWriter("stockList.txt"));
        for(HashMap.Entry<String, Integer> elem : count.entrySet() ){
            System.out.println( String.format("키 : %s, 값 : %s", elem.getKey(), elem.getValue()) );
            String str = elem.getKey() + " " + Integer.toString(elem.getValue()) + "\n";
            writer.write(str);
        }
    }

    public void printNoArgError(){
        System.out.println("[오류] : 명령어 뒤에 인자가 없어야 합니다. 다시 입력해주세요.");
    }
}