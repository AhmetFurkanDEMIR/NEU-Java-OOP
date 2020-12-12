/*
olusturulan personelleri ve servisleri tutmak icin kullandigim yapi.
*/
import java.util.ArrayList;

// Departman classi
public class Departman {
	
    private int depNo;
    private String depAd;
    
    // personel dizisi
    private Personel[] personeller;
    
    // servis dizisi
    private Servis[] servisler;
    
    // servis ve personellerin adeti (dungulerde kullanmak icin.).
    private int int_personeller=0;
    private int int_servisler=0;
    
    // departman adeti (dungulerde kullanmak icin.).
    private static int depSayi = 0;
    
    // Constructor
    public void Departman(int depNo, String depAd){
    	
        this.setDepNo(Integer.toString(depNo));
        this.setDepAd(depAd);

    }
    
    // getter ve setter fonksiyonlari.

    public void setDepAd(String depAd){

        this.depAd = depAd;
        depNo += 1;
        setDepSayi();

    }
    public String getDepAd(){

        return depAd;
    }

    public int setDepNo(String depNo){
    	
    	int kn=0;
    	int no=0;
    	try {

            no = Integer.parseInt(depNo);
        } catch (NumberFormatException ex) {
        	kn = 1;
        }
    	
    	if(kn==0) {
    		
    		this.depNo=no;
    		
    	}
    	
    	return kn;
    }

    public int getDepNo(){

        return depNo;
    }

    public void setPersoneller(){

        personeller = new Personel[getInt_personeller()];
        
        for(int i=0; i<getInt_personeller(); i++) {
        	personeller[i] = new Personel();
        }
    }

    public Personel getPersoneller(int index){

        return personeller[index];
    }

    public void setServisler(){

        servisler = new Servis[getInt_servisler()];
        
        for(int i=0; i<getInt_servisler(); i++) {
        	servisler[i] = new Servis();
        }
    }

    public Servis getServisler(int index){

        return servisler[index];
    }

    public int getInt_personeller() {

        return int_personeller;
    }

    public int setInt_personeller(String adet) {
    	
    	int kn=0;
    	int pr_adet = 0;

    	try {

            pr_adet = Integer.parseInt(adet);
        } catch (NumberFormatException ex) {
        	
        	kn=1;

        }
    	
    	if(pr_adet<0) {
    		kn=1;
    	}
    	
    	if(kn==0) {
    		int_personeller = pr_adet;
    	}
    	
    	return kn;
    }

    public int getInt_servisler() {

        return int_servisler;
    }

    public int setInt_servisler(String adet) {

    	int kn=0;
    	int ser_adet = 0;

    	try {

            ser_adet = Integer.parseInt(adet);
        } catch (NumberFormatException ex) {
        	
        	kn=1;

        }
    	
    	if(ser_adet<0) {
    		kn=1;
    	}
    	
    	if(kn==0) {
    		int_servisler = ser_adet;
    	}
    	
    	return kn;
    }

    public static int getDepSayi() {

        return depSayi;
    }

    public static void setDepSayi() {

        depSayi+=1;
    }

}
