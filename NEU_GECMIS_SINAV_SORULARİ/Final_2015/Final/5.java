public class Main {

    public static int yanyanaMaxTirnak(String data_str){

        int data=0;
        int enb=0;

        for(int i=0;i<data_str.length();i++){

            if(data_str.charAt(i)=='\"'){
                data+=1;
            }

            else{

                if(data>=enb){
                    enb=data;
                }

                data=0;
            }

            if(i==data_str.length()-1){
                if(data>=enb){
                    enb=data;
                }
            }

        }

        return enb;

    }

    public static void main(String[] args){

        String data_str = "asd\"\"\"\"\"dsagfd\"\"fdsfjods\"\"\"\"";

        System.out.println(yanyanaMaxTirnak(data_str));


    }


}