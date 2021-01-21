public class Main {

    public static int say7(int data, int say){

        if(data==0){
            return say;
        }

        if(data%10==7){
            say+=1;
        }

        data=data/10;

        say = say7(data,say);

        return say;
    }

    public static void main(String[] args){

        System.out.println(say7(712757, 0));


    }


}