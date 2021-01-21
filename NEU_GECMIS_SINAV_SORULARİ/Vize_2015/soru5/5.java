
class Ders{

    private String ad;
    private double not;
    private int kredi;

    public Ders(String ad, double not, int kredi){

        this.setAd(ad);
        this.setNot(not);
        this.setKredi(kredi);

    }

    public Ders(){

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getNot() {
        return not;
    }

    public void setNot(double not) {
        this.not = not;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }
}

class Ogrenci{

    private String no;
    private int total_ders_sayisi;
    private int kayitli_ders_sayisi;
    private Ders[] ders;
    private static int count=0;

    public Ogrenci(String no, int total_ders_sayisi){

        this.setNo(no);
        this.setTotal_ders_sayisi(total_ders_sayisi);
        ders = new Ders[getTotal_ders_sayisi()];

    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getTotal_ders_sayisi() {
        return total_ders_sayisi;
    }

    public void setTotal_ders_sayisi(int total_ders_sayisi) {
        this.total_ders_sayisi = total_ders_sayisi;
    }


    public Ders[] getDers() {
        return ders;
    }

    public boolean setDers(Ders ders) {

        try {
            this.ders[count] = ders;
            setCount();
        } catch (Exception e){
            return false;
        }

        return true;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount() {
        Ogrenci.count += 1;
    }
}

public class Main{

        public static void main(String[] args) {

            Ogrenci[] ogrenciler = new Ogrenci[36];

            Ders ders = new Ders();
            ders.setAd("Algoritma");
            ders.setNot(89.33);
            ders.setKredi(4);
            int total_ders_sayisi = 2;
            ogrenciler[0] = new Ogrenci("15001", total_ders_sayisi);
            boolean eklendimi = ogrenciler[0].setDers(ders);

            ogrenciler[1] = new Ogrenci("15002", total_ders_sayisi);
            ders = new Ders("Java", 95, 5);
            eklendimi = ogrenciler[1].setDers(ders);
            ders = new Ders("veri tabani", 90,4);
            eklendimi = ogrenciler[1].setDers(ders);
            ders = new Ders("Fizik", 70 ,3);
            eklendimi = ogrenciler[1].setDers(ders);
            int ders_sayisi = ogrenciler[1].getDers().length;


        }

}
