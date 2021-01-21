import java.io.FileWriter;
import java.io.IOException;

public class Main{

        public static int carpim(int n){

            int crp=1;

            for(int i=1; i<=n; i+=2){
                crp*=i;
            }

            return crp;
        }

        public static void main(String[] args) throws IOException {

            System.out.println(carpim(7));

        }

}
