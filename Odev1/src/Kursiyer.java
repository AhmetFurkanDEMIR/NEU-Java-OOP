import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Kursiyer {

    private int KursiyerId;
    private String KursiyerAdSoyad;
    private int KursiyerYas;
    private ArrayList<Kurs> AlinanKurslar;

    public Kursiyer(int KursiyerId, String KursiyerAdSoyad, int KursiyerYas, ArrayList<Kurs> AlinanKurslar){

        this.setKursiyerId(KursiyerId);
        this.setKursiyerAdSoyad(KursiyerAdSoyad);
        this.setKursiyerYas(KursiyerYas);
        this.setAlinanKurslar(AlinanKurslar);

    }

    public static ArrayList<Kursiyer> add(ArrayList<Kursiyer> kursiyerler, int id, String ad, int yas, ArrayList<Kurs> AlinanKurslar) throws IOException {

        if(control(kursiyerler, id)==0){
            Kursiyer temp = new Kursiyer(id, ad, yas, AlinanKurslar);
            kursiyerler.add(temp);
            write(kursiyerler);
            System.out.println(" Kursiyer basariyla eklendi.");
        }
        else{
            System.out.println(" Bu Kursiyer id baska bir kursiyere ait, ekleme basarisiz.");
        }
        return kursiyerler;

    }

    public static int control(ArrayList<Kursiyer> kursiyerler, int id){

        int a = 0;

        for(int i=0;i<kursiyerler.size();i++){
            if(id==kursiyerler.get(i).getKursiyerId()){
                a=1;
            }
        }
        return a;
    }

    public static void write(ArrayList<Kursiyer> kursiyerler) throws IOException {

        FileWriter myWriter = new FileWriter("kursiyer.txt");

        String data="";

        for(int i=0;i<kursiyerler.size();i++){

            data+="#"+kursiyerler.get(i).getKursiyerId()+"-"+kursiyerler.get(i).getKursiyerAdSoyad();
            data+="-"+kursiyerler.get(i).getKursiyerYas()+"\n";

            for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){

                data+="*"+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId();
                data+="-"+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd()+"\n";

            }
        }

        myWriter.write(data);
        myWriter.close();

    }

    public static void ara(ArrayList<Kursiyer> kursiyerler, String ad){

        boolean flag = false;

        for(int i=0;i<kursiyerler.size();i++){

            if(kursiyerler.get(i).getKursiyerAdSoyad().equals(ad)){

                flag = true;
                System.out.println("-----------------");
                System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
                System.out.println(" Kursiyer adi : "+kursiyerler.get(i).getKursiyerAdSoyad());
                System.out.println(" Kursiyer yas : "+kursiyerler.get(i).getKursiyerYas());

                System.out.println("  Kurslar ;");

                for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){

                    System.out.println("    "+(j+1)+". Kurs Id : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId());
                    System.out.println("    "+(j+1)+". Kurs Ad : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd());

                }
            }
        }

        if(flag!=true){
            System.out.printf("\n  Aranan kisi bulunamadi");
        }
    }

    public static ArrayList<Kursiyer> remove(ArrayList<Kursiyer> kursiyerler, int id) throws IOException {

        boolean flag = true;

        for(int i=0;i<kursiyerler.size();i++){

            if(kursiyerler.get(i).getKursiyerId()==id){

                kursiyerler.remove(i);
                write(kursiyerler);

                System.out.println("\n  id : "+id+" Silme islemi basarili.");
                flag=false;
                break;

            }

        }

        if(flag==true){
            System.out.println("\n  Silme islemi basarisiz, kullanici bulunamadi. ");
        }

        return kursiyerler;

    }

    public static void listele(ArrayList<Kursiyer> kursiyerler, int flag){

        if(flag==1){

            for(int i=0;i<kursiyerler.size();i++){

                int id = kursiyerler.get(i).getKursiyerId();
                String ad = kursiyerler.get(i).getKursiyerAdSoyad();
                int yas = kursiyerler.get(i).getKursiyerYas();

                System.out.println("-----------------");
                System.out.println(id+" "+ad+" "+yas);

            }

        }

        else if(flag==2){

            for(int i=0;i<kursiyerler.size();i++){

                System.out.println("-----------------");
                System.out.println(" Kursiyer Id : "+kursiyerler.get(i).getKursiyerId());
                System.out.println(" Kursiyer Ad,Soyad : "+kursiyerler.get(i).getKursiyerAdSoyad());
                System.out.println(" Kursiyer Yas : "+kursiyerler.get(i).getKursiyerYas());

                System.out.println("  Kurslar ;");

                for(int j=0;j<kursiyerler.get(i).getAlinanKurslar().size();j++){

                    System.out.println("    "+(j+1)+". Kurs Id : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursId());
                    System.out.println("    "+(j+1)+". Kurs Ad : "+kursiyerler.get(i).getAlinanKurslar().get(j).getKursAd());

                }
            }

        }

    }

    public static void cal(ArrayList<Kursiyer> kursiyerler, int id){

        float ucret = -99;
        int count = 0;

        for(int i=0;i<kursiyerler.size();i++){

            if(id==kursiyerler.get(i).getKursiyerId()){

                count = kursiyerler.get(i).getAlinanKurslar().size();

                if(count==0 || count==1){

                    ucret = (100*4) * count;

                    System.out.println("\n  Herhangi bir kampanyadan yararlanilamiyor, Odenecek toplam tutar (Aylik) : "+ucret);
                }

                else if(count==2){

                    ucret = (100*4) + (85*4);

                    System.out.println("\n  Kampanya 1 den yararlanılıyor, Odenecek toplam tutar (Aylik) : "+ucret);

                }

                else if(count==3){

                    ucret = (100*4) + (100*4) + (75*4);

                    System.out.println("\n  Kampanya 2 den yararlanılıyor, Odenecek toplam tutar (Aylik) : "+ucret);
                }

                else if(count>3){

                    ucret = (90*4) * count;

                    System.out.println("\n  Kampanya 3 den yararlanılıyor, Odenecek toplam tutar (Aylik) : "+ucret);
                }

                break;

            }

        }

        if((int)ucret==-99){
            System.out.println("\n  Kullanici Id bulunamadi.");
        }

    }

    public int getKursiyerId() {

        return KursiyerId;
    }

    public void setKursiyerId(int kursiyerId) {

        KursiyerId = kursiyerId;
    }

    public String getKursiyerAdSoyad() {

        return KursiyerAdSoyad;
    }

    public void setKursiyerAdSoyad(String kursiyerAdSoyad) {

        KursiyerAdSoyad = kursiyerAdSoyad;
    }

    public int getKursiyerYas() {

        return KursiyerYas;
    }

    public void setKursiyerYas(int kursiyerYas) {

        KursiyerYas = kursiyerYas;
    }

    public ArrayList<Kurs> getAlinanKurslar() {

        return AlinanKurslar;
    }

    public void setAlinanKurslar(ArrayList<Kurs> alinanKurslar) {

        AlinanKurslar = alinanKurslar;
    }
}
