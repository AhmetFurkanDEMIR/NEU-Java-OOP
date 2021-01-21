public class Ordek extends Kus implements Kosabilme {

    private String ad;

    public Ordek(int kanat_sayisi, String ad) {
        super(kanat_sayisi);
        this.setAd(ad);
    }

    @Override
    public void kos() {
        System.out.println("Kos");
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
