public class Kaplan implements Avlanabilme {

    private String ad;

    public Kaplan(String ad){
        this.setAd(ad);
    }


    @Override
    public void avlan() {
        System.out.println("Avlan");
    }

    public void dahaHizliKos(){
        System.out.println("Hizli kos");
    }

    public void kos(){
        System.out.println("Kos");
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }
}
