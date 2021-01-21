import java.io.FileWriter;
import java.io.IOException;

public class Main{

        public static int convert(double data){

            int data_int = (int)data;
            double data_double = data-data_int;

            if(data_double<(double)0.5){
                return data_int;
            }

            else{
                return data_int+1;
            }

        }

        public static void main(String[] args) throws IOException {

            System.out.println(convert(7.49999));

        }

}
