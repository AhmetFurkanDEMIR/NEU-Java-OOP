public class Main {

    public static int toplam(int sy, int tp){

        if(sy==1){
            return tp;
        }

        else if(sy%2!=0){
            tp+=sy;
        }

        tp=toplam(sy-1, tp);

        return tp;

    }

    public static void main(String[] args){

        int tp=1;
        System.out.println(toplam(10, tp));


    }

    
}