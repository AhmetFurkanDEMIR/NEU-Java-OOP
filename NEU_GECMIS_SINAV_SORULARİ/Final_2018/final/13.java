import java.io.FileWriter;
import java.io.IOException;

public class Main{

        public static void main(String[] args) throws IOException {

            boolean knt;
            FileWriter myWriter = new FileWriter("asal.txt", true);
            String temp = "";

            for(int i=2; i<1011;i++){
                knt=false;

                for(int j=2;j<i;j++){

                    if(i%j==0){
                        knt=true;
                    }
                }

                if(knt==false){
                    temp+= Integer.toString(i) +"\n";
                }

            }
            myWriter.write(temp);
            myWriter.close();
        }

}
