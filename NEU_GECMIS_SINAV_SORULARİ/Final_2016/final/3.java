import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("sayilar.txt"));
        String data;

        while(true) {

            data = br.readLine();
            if (data == null) {
                break;
            }
            System.out.println(data);

        }

    }

}