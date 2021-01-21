public class BirinciSoru {

    public static String cevir2likTabana(int number){

        String temp = "";
        while(number > 0){
            temp = number%2+temp;
            number = number/2;
        }

        return temp;
    }

    public static void main(String[] args){

        String data = cevir2likTabana(90);

        System.out.println(data);

    }
    
}