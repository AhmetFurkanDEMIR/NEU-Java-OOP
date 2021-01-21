public class MatematikOgretmeni extends Ogretmen{

    static private int Id = 0;
    public int gs;
    public double tp;


    public MatematikOgretmeni(String ad, String Soyad, int Yas, int gs) {
        super(ad, Soyad, Yas);
        this.Brans = "Matematik";
        this.gs = gs;
        this.tp = gs*0.4;
        Id+=1;
    }

    @Override
    public void BilgileriYazdir() {

        System.out.println("\n-----------------");
        System.out.println("Ogretmen adi : "+ Ad);
        System.out.println("Ogretmen Soyadi : " + Soyad);
        System.out.println("Ogretmen Yas : " + Yas);
        System.out.println("Ogretmen Brans : " + Brans);
        System.out.println("Ogretmen TP : " + tp);
    }
}
