public class Main {

    public static int[] cevir2likTabana(int num){

        int binary[] = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num%2;
            num = num/2;
        }

        return binary;
    }

    public static void main(String[] args){

        int data[] = cevir2likTabana(90);

        for (int x: data) {

            System.out.println(x);
        }


    }


}