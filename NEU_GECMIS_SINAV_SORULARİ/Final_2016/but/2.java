import java.io.IOException;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter myWriter = new FileWriter("sayi.txt", true);
        String yz = "";

        for(int i=1; i<101;i++){

            if(i%2==0){
                yz+=Integer.toString(i)+"\n";
            }

        }

        myWriter.write(yz);
        myWriter.close();

    }

}