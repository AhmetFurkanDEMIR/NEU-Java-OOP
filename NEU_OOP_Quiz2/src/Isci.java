public class Isci extends Calisan implements Maas {

    public String gorev;

    public Isci(String ad, String soyad, int yas, int cs) {
        super(ad, soyad, yas, cs);
        gorev = "Isci";
    }

    @Override
    double ZamOraniHesapla() {
        double temp = cs*100.0 + (yas*(2.0/3.0));
        return temp;
    }

    @Override
    public double MaasHesapla() {
        return ZamOraniHesapla()+3000;
    }
}
