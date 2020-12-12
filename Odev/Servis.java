// Servis classi
public class Servis {

	// degiskenler
	private static int servisID0 = 0;
	private int servisID;
    private int depNo;
    private String servisGuzergah;
    
    // Constructor
    public void Servis(int depNo, String servisGuzergah){

        this.setDepNo(depNo);
        this.setServisGuzergah(servisGuzergah);
        this.setServisID0();
        this.setServisID(this.getServisID0());
    }
    
    // getter ve setter fonksiyonlari.
    
    public int getDepNo() {

        return depNo;
    }

    public void setDepNo(int depNo) {

        this.depNo = depNo;
    }

    public String getServisGuzergah() {

        return servisGuzergah;
    }

    public void setServisGuzergah(String servisGuzergah) {

        this.servisGuzergah = servisGuzergah;
    }

    public int getServisID0() {

        return servisID0;
    }

    public void setServisID0() {
        servisID0 += 1;
    }
    
    public int getServisID() {

        return servisID;
    }

    public void setServisID(int servisID) {
        this.servisID = servisID;
    }
}
