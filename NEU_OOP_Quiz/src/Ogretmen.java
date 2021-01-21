public class Ogretmen {

    public String Ad;
    public String Soyad;
    public int Yas;
    public String Brans;
    static private int count = 0;

    public Ogretmen(String Ad, String Soyad, int Yas){
        setCount(getCount() + 1);
        this.Ad = Ad;
        this.Soyad = Soyad;
        this.Yas = Yas;

    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Ogretmen.count = count;
    }

    public void BilgileriYazdir(){

        System.out.println("\n-----------------");
        System.out.println("Ogretmen adi : "+ Ad);
        System.out.println("Ogretmen Soyadi : " + Soyad);
        System.out.println("Ogretmen Yas : " + Yas + "\n");

    }

    public int OgretmenSayisiVer(){

        return getCount();

    }

}
