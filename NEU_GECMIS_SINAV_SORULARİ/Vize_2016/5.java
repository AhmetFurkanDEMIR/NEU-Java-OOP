
class Daire{

    protected float cap;
    public Daire(float cap2){

        this.cap = cap2;

    }
    public float tabanAlan(){
        float alan = (float)(3.14 * cap*cap);
        return alan;
    }

}

class Silindir extends Daire{

    private float yukseklik;

    public Silindir(float cap2, float yukseklik) {
        super(cap2);
        this.setYukseklik(yukseklik);
    }

    public float HacimHesapla(){

        return tabanAlan() * getYukseklik();

    }

    public float getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(float yukseklik) {
        this.yukseklik = yukseklik;
    }
}

public class Main{

        public static void main(String[] args) {

            Silindir silindir = new Silindir(10,20);
            System.out.println(silindir.HacimHesapla());


        }

}
