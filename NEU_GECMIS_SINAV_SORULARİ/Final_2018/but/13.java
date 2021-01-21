import java.io.FileWriter;
import java.io.IOException;

public class Main{

        public static void main(String[] args) throws IOException {

            int top=0;
            FileWriter myWriter = new FileWriter("mukemmel.txt", true);
            String temp = "";

            for(int i=2; i<10000;i++){

                top=0;

                for(int j=1;j<i;j++){

                    if(i%j==0){
                        top+=j;
                    }
                }

                if(top==i){
                    temp+=Integer.toString(i)+"\n";
                }

            }
            myWriter.write(temp);
            myWriter.close();
        }

}
