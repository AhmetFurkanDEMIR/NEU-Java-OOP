import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        FileWriter myWriter = new FileWriter("isciler.txt", true);
        Scanner input = new Scanner(System.in);

        System.out.print(" Isci adedi giriniz : ");
        int isci_adet = input.nextInt();

        ArrayList<Isci> isci = new ArrayList<Isci>();

        String ad, soyad;
        int yas, cs;

        for(int i=0; i<isci_adet; i++){

            clear();
            input.nextLine();

            System.out.print((i+1)+". Isci Adi : ");
            ad = input.nextLine();

            System.out.print((i+1)+". Isci Soyadi : ");
            soyad = input.nextLine();

            System.out.print((i+1)+". Isci Yasi : ");
            yas = input.nextInt();

            System.out.print((i+1)+". Isci Cocuk sayisi : ");
            cs = input.nextInt();

            isci.add(new Isci(ad,soyad,yas,cs));
        }

        yazdir(isci, isci_adet,myWriter,0);

        yazdir(isci, isci_adet,myWriter,1);
        myWriter.close();

    }

    public static void yazdir(ArrayList<Isci> isci, int adet, FileWriter myWriter, int kn) throws IOException {

        if(kn==0) {
            clear();

            for (int i = 0; i < adet; i++) {

                Isci temp = isci.get(i);

                System.out.println("\n\n -------------");
                System.out.println((i + 1) + ". Isci id : " + temp.id);
                System.out.println((i + 1) + ". Isci Adi : " + temp.ad);
                System.out.println((i + 1) + ". Isci Soyadi : " + temp.soyad);
                System.out.println((i + 1) + ". Isci Maas : " + temp.MaasHesapla());
                System.out.println((i + 1) + ". Isci Gorev : " + temp.gorev);


            }
        }

        else{

            String yaz = "";
            for (int i = 0; i < adet; i++) {

                Isci temp = isci.get(i);

                yaz += temp.id+","+temp.ad+","+temp.soyad+","+temp.MaasHesapla()+","+temp.gorev+"\n";

            }

            myWriter.write(yaz);
            myWriter.close();
        }

    }

    public static void clear(){

        for(int i=0; i<25; i++){
            System.out.println();
        }

    }

}
