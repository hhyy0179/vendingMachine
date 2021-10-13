import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class List {
    HashMap<String, Integer> count = new HashMap<String, Integer>();
    HashMap<String, Integer> price = new HashMap<String, Integer>();

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("file.txt")
        );

        String str;
        while ((str = reader.readLine()) != null) {
            String [] beverage = str.split(" ");
        }
        reader.close();
    }
}