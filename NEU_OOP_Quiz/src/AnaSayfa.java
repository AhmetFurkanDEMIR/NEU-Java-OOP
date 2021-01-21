import java.util.Scanner;

public class AnaSayfa {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("\n -- Ogretmen ekle --");

        System.out.print("\n   Kaç adet ressim ogretmeni eklenecek : ");
        int ressim_adet = input.nextInt();

        System.out.print("\n   Kaç adet Matematik ogretmeni eklenecek : ");
        int matematik_adet = input.nextInt();

        clear();

        MatematikOgretmeni[] mat = new MatematikOgretmeni[matematik_adet];
        RessimOgretmeni[] res = new RessimOgretmeni[ressim_adet];

        String Ad;
        String Soyad;
        int Yas;
        int Gs;

        for(int i = 0; i< ressim_adet; i++){

            input.nextLine();
            System.out.println("\n -- Ogretmen ekle (Ressim) --");

            System.out.print("\n Ogretmen Adi : ");
            Ad = input.nextLine();

            System.out.print(" Ogretmen Soyadi : ");
            Soyad = input.nextLine();

            System.out.print(" Ogretmen Yas : ");
            Yas = input.nextInt();

            System.out.print(" Ogretmen Görev Süresi : ");
            Gs = input.nextInt();

            res[i] = new RessimOgretmeni(Ad,Soyad,Yas, Gs);
            clear();

        }


        for(int i = 0; i< matematik_adet; i++){

            System.out.println("\n -- Ogretmen ekle (Matematik) --");
            input.nextLine();
            System.out.print("\n Ogretmen Adi : ");
            Ad = input.nextLine();

            System.out.print(" Ogretmen Soyadi : ");
            Soyad = input.nextLine();

            System.out.print(" Ogretmen Yas : ");
            Yas = input.nextInt();

            System.out.print(" Ogretmen Görev Süresi : ");
            Gs = input.nextInt();

            mat[i] = new MatematikOgretmeni(Ad,Soyad,Yas, Gs);
            clear();

        }

        System.out.println("  Toplam ogretmen adeti : " + Ogretmen.getCount());
        System.out.print("\n\n  Tum ogretmenleri yazdirmek icin Enter'e basiniz : ");
        input.nextLine();

        clear();

        System.out.println("\n -- Ressim ogretmenleri --\n");

        for(int i=0; i<ressim_adet;i++){

            res[i].BilgileriYazdir();
        }

        System.out.println("\n -- Matematik ogretmenleri --\n");

        for(int i=0; i<matematik_adet;i++){

            mat[i].BilgileriYazdir();
        }

        res = OgretmenSirala(res);
        mat = OgretmenSirala(mat);

        System.out.print("\n\n Ogretmenleri siralnmis(TP) olarak gormek icin Enter'e basiniz :");
        input.nextLine();
        clear();

        System.out.println("\n -- Ressim ogretmenleri (TP) --\n");

        for(int i=0; i<ressim_adet;i++){

            res[i].BilgileriYazdir();
        }

        System.out.println("\n -- Matematik ogretmenleri (TP) --\n");

        for(int i=0; i<matematik_adet;i++){

            mat[i].BilgileriYazdir();
        }

    }

    public static MatematikOgretmeni[] OgretmenSirala(MatematikOgretmeni mat[]) {

        int n = mat.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (mat[j].tp < mat[j + 1].tp) {
                    MatematikOgretmeni temp = mat[j];
                    mat[j] = mat[j + 1];
                    mat[j + 1] = temp;
                }
            }

        }
        return mat;
    }

    public static RessimOgretmeni[] OgretmenSirala(RessimOgretmeni res[]) {

        int n = res.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                if (res[j].tp < res[j + 1].tp) {
                    RessimOgretmeni temp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = temp;
                }
            }

        }
        return res;
    }


    public static void clear(){
        for(int i=0; i<25;i++){
            System.out.println();
        }
    }

}

