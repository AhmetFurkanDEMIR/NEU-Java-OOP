
class Islem extends Thread {

    private String isim="";
    private int donguSay=0;

    public Islem(String isim, int donguSay){

        this.setIsim(isim);
        this.setDonguSay(donguSay);

    }

    @Override
    public void run() {

        for(int i=0;i<donguSay;i++){
            System.out.println(i+". "+getIsim()+" yazdirildi");
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getDonguSay() {
        return donguSay;
    }

    public void setDonguSay(int donguSay) {
        this.donguSay = donguSay;
    }
}

public class Main {

    public static void main(String[] args){

        Islem islem1 = new Islem("mehmet", 10);
        Islem islem2 = new Islem("kalemci", 8);

        islem1.start();
        islem2.start();

    }
    
}