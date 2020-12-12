// Personel Classi
public class Personel {
	
	// degiskenler
    private int depNo;
    private static int perID0 = 0;
    private int perID;
    private String perAd;
    private String perSoyad;
    private int perYas;
    
    // Constructor
    public void Personel(int depNo, String perAd, String perSoyad, int perYas){

        this.setDepNo(depNo);
        this.setPerAd(perAd);
        this.setPerSoyad(perSoyad);
        this.setPerYas(perYas);
        this.setPerID0();
        this.setPerID(this.getPerID0());

    }
    
    // getter ve setter fonksiyonlari.
    
    public int getDepNo() {

        return depNo;
    }

    public void setDepNo(int depNo) {

        this.depNo = depNo;
    }

    public String getPerAd() {

        return perAd;
    }

    public void setPerAd(String perAd) {

        this.perAd = perAd;
    }

    public String getPerSoyad() {

        return perSoyad;
    }

    public void setPerSoyad(String perSoyad) {

        this.perSoyad = perSoyad;
    }

    public int getPerYas() {

        return perYas;
    }

    public void setPerYas(int perYas) {

        this.perYas = perYas;
    }

    public int getPerID0() {
        return perID0;
    }

    public void setPerID0() {
        perID0 += 1;
    }
    
    public int getPerID() {
        return perID;
    }

    public void setPerID(int perID) {
        this.perID = perID;
    }
}
