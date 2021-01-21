public class DorduncuSoru {

    public static int toplam(int data_number, int data_top){

        if(data_number==0){
            return data_top;
        }

        if(data_number%2!=0){
            data_top+=data_number;
        }

        data_top = toplam(data_number-1, data_top);

        return data_top;
    }

    public static void main(String[] args) {

        int n=9;
        System.out.println(toplam(n,0));

    }

}