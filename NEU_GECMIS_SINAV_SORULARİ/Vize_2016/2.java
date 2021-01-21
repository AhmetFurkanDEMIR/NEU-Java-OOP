
public class Main{

        public static int carpim(int data, int carp){

            if(data==1){
                return carp;
            }

            if(data%2!=0) {
                carp *= data;
            }

            carp = carpim(data-1, carp);

            return carp;

        }

        public static void main(String[] args) {

            System.out.println(carpim(7, 1));

        }

}
