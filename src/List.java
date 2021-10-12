import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class List {
    int coke;
    int cider;
    int tejava;
    int pepper;
    int cornTea;
    int samdasu;

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("d:\\file.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String [] beverage = str.split(" ");
            if(beverage[0]=="콜라"){
                this.coke = Integer.parseInt(beverage[1]);
            }
        }
        reader.close();
    }
}
