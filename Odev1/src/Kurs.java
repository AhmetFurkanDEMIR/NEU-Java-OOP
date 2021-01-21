import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Kurs {

    private int KursId;
    private String KursAd;

    public Kurs(int KursId, String KursAd){

        this.setKursId(KursId);
        this.setKursAd(KursAd);
    }

    public static ArrayList<Kurs> Kurs_add(ArrayList<Kurs> kurslar, int id, String ad) throws IOException {

        if(control(kurslar, id)==0){
            Kurs temp = new Kurs(id, ad);
            kurslar.add(temp);
            write(temp);
            System.out.println("\n   Kurs basariyla eklendi.");
        }
        else{
            System.out.println("\n   Bu kurs id baska bir kursa ait, ekleme basarisiz.");
        }
        return kurslar;
    }

    public static int control(ArrayList<Kurs> kurslar, int id){

        int a = 0;

        for(int i=0;i<kurslar.size();i++){
            if(id==kurslar.get(i).getKursId()){
                a=1;
            }
        }
        return a;
    }

    public static void write(Kurs kurs) throws IOException {

        FileWriter myWriter = new FileWriter("kurs.txt", true);
        String temp = "\n"+kurs.getKursId()+"-"+kurs.getKursAd();
        myWriter.write(temp);
        myWriter.close();
    }

    public static void listele(ArrayList<Kurs> kurslar){

        System.out.println("Kurs Id,  Kurs adi");
        System.out.println("------------------");

        for(int i=0; i<kurslar.size();i++){

            int id= Integer.toString(kurslar.get(i).getKursId()).length();

            System.out.print(kurslar.get(i).getKursId());
            for(int j=0;j<7-id;j++){
                System.out.print(" ");
            }
            System.out.println(",  "+kurslar.get(i).getKursAd());
        }

    }

    public int getKursId() {

        return KursId;
    }

    public void setKursId(int kursId) {

        KursId = kursId;
    }

    public String getKursAd() {

        return KursAd;
    }

    public void setKursAd(String kursAd) {

        KursAd = kursAd;
    }
}
