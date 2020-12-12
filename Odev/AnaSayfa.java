// input
import java.util.Scanner;

// eclipse icin yazdigim wipeConsole fonksiyonu icin gerekli moduller.
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

// Main classi
public class AnaSayfa {
	
	/*
	 clear = 0 => eclipse IDE 'sinin varsayýlan consol temizleme kisa yollarýni kullanarak,
	 ekran temizleme islemi yapar.
	 
	 clear = 1 => ekranda 30 tane \n yazdirir ve eski ciktiyi gormemenizi saglar.
	 */
	public static int clear = 0;
	
	// departmanlar dizisi
	static Departman[] departmanlar;
	
	// departman adedi
	static public int dp_adet;
	
	// en buyuk ve en kucuk personeller icin
	static public int enb=10;
	static public int enkc=150;
    
    // input (Scanner)
    static Scanner input = new Scanner(System.in);
    
    // main methodu
    public static void main(String[] args) throws AWTException{
    	
    	// kullanicidan istedigi kadar departman, personel ve servis alinir.
        departmanlar = DpEkle();
        
        // menu kontrolu icin.
        int secim = 0;
        
        // arama islemleri icin.
        String add;
        
        // menu dongusu.
        while (true) {
        	
        	// ekran temizleme.
        	wipeConsole();
        	
        	// menu.
            System.out.println("\n - demir.ai Sirket (Ana menu) -");
            System.out.println("\n\n    1-) Tum Departmanlari Listele");
            System.out.println("\n    2-) Departman Ara");
            System.out.println("\n    3-) Personel Ara");
            System.out.println("\n    4-) Servis Ara");
            System.out.println("\n    5-) Yasi En Buyuk ve En Kucuk Personel/Personelleri Ara");
            System.out.println("\n    6-) Cikis");
            System.out.printf("\n       Secim : ");
            
            // kullanicinin istedigim sekilde input girmesini sagladim.
            while (true) {
            	
            	// int veri tipinde girmeli
                try {

                    secim = Integer.parseInt(input.nextLine());
                    
                    // 0 ile 7 arasýnda deger giremeli
                    if (secim <= 0 || secim >= 7) {
                        secim = Integer.parseInt("Eror-404");
                    }
                } catch (NumberFormatException ex) { 
                	
                	// hata mesaji kismi.
                	
                	wipeConsole();

                    System.out.printf("\n       Seciminiz 0 ile 7 arasinda bir Int tam sayi olamali. Tekrar secim yapmak için Enter'e basiniz.  ");
                    input.nextLine();

                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Ana menu) -");
                    System.out.println("\n\n    1-) Tum Departmanlari Listele");
                    System.out.println("\n    2-) Departman Ara");
                    System.out.println("\n    3-) Personel Ara");
                    System.out.println("\n    4-) Servis Ara");
                    System.out.println("\n    5-) Yasi En Buyuk ve En Kucuk Personel/Personelleri Ara");
                    System.out.println("\n    6-) Cikis");
                    System.out.printf("\n       Secim : ");

                    continue;
                }
                break;
            }
            
            // girilen secim degiskenine gore kod bloklari haraket ettirilir.
            switch (secim) {
            	
            	// departman listele.
                case 1:
                	
                	wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Departmanlari Listele) -\n\n");

                    for (int i = 0; i < Departman.getDepSayi(); i++) {
                        listele(departmanlar[i], i);
                        System.out.println();
                        System.out.println();
                    }

                    System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                    input.nextLine();

                    break;
                
                // departman ara
                case 2:
                	
                	wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Departman Ara) -\n\n");

                    System.out.printf("     Aranacak Departman Adi : ");
                    add = input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Departman Ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        if (departmanlar[i].getDepAd().equals(add)) {

                            listele(departmanlar[i], -10);

                            System.out.println();
                            System.out.println();

                            secim = 1;
                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Departman bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                        
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();
                    }

                    break;
                
                // personel ara
                case 3:
                	
                	wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Personel Ara) -\n\n");

                    System.out.printf("     Aranacak Personel Adi : ");
                    add = input.nextLine();

                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Personel Ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        for (int j = 0; j < departmanlar[i].getInt_personeller(); j++) {

                            if (departmanlar[i].getPersoneller(j).getPerAd().equals(add)) {

                                pr_listele(departmanlar[i].getPersoneller(j), departmanlar[i]);

                                secim = 1;

                            }

                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Personel bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();

                    }
                    break;
                
                // servis guzergahi ara.
                case 4:
                	
                	wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Servis Guzergahi Ara) -\n\n");

                    System.out.printf("     Aranacak Servis Guzergahi : ");
                    add = input.nextLine();

                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Servis Guzergahi Ara) -\n\n");

                    secim = 0;

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        for (int j = 0; j < departmanlar[i].getInt_servisler(); j++) {

                            if (departmanlar[i].getServisler(j).getServisGuzergah().equals(add)) {

                                ser_listele(departmanlar[i].getServisler(j), departmanlar[i]);

                                secim = 1;

                            }

                        }
                    }

                    if (secim == 0) {

                        System.out.println("      Servis bulunamadi. Ana menuye donmek icin Enter'e basiniz.");
                        input.nextLine();
                    } else {

                        System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                        input.nextLine();

                    }
                    break;
                
                // en buyuk en kucuk yas.
                case 5:
                	
                	wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Yas istatistikleri) -\n\n");

                    for (int i = 0; i < Departman.getDepSayi(); i++) {

                        for (int j = 0; j < departmanlar[i].getInt_personeller(); j++) {
                        	
                        	if(departmanlar[i].getPersoneller(j).getPerYas()==enkc) {
                        		
                        		istatistik_yazdir(departmanlar[i].getPersoneller(j), departmanlar[i], 1);
                        	}
                        	
                        	
                        	if(departmanlar[i].getPersoneller(j).getPerYas()==enb) {
                        		
                        		istatistik_yazdir(departmanlar[i].getPersoneller(j), departmanlar[i], 0);	
                        	}
                        	
                        }
                    }
                    
                    System.out.printf("      Ana menuye donmek icin Enter'e basiniz. ");
                    input.nextLine();
                    
                    break;
                	
                // cikis.	
                case 6:
                	wipeConsole();
                    return;

            }
        }

    }
    
    // departman ekleme methodu
    public static Departman[] DpEkle() throws AWTException{

        String ad;
        
        wipeConsole();
        
        System.out.println("\n - demir.ai Sirket (Departman Ekle) -");
        
        System.out.print("\n    Kaç adet departman eklenecek : ");
        
        // departman adedi
        while (true) {

            try {

                dp_adet = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException ex) {
            	
            	wipeConsole();
                System.out.printf("\n     Eklenecek departman adeti, Int veri tipinde olmali. Tekrar Departman adeti girmek icin Enter'e basiniz. ");
                input.nextLine();
                
                wipeConsole();
                System.out.println("\n - demir.ai Sirket (Departman Ekle) -");
                System.out.print("\n    Kaç adet departman eklenecek : ");
                continue;
            }
            
            if(dp_adet<0) {
            	
            	wipeConsole();
                System.out.printf("\n     Eklenecek departman adeti 0 dan buyuk olmalidir. Tekrar Departman adeti girmek icin Enter'e basiniz. ");
                input.nextLine();
                
                wipeConsole();
                System.out.println("\n - demir.ai Sirket (Departman Ekle) -");
                System.out.print("\n    Kaç adet departman eklenecek : ");
                continue;
            	
            }
            
            
            break;
        }
        
        // deparman dizisini olusturdum
        // en son bu dizi return edilecek ve method sonlanacak
        Departman[] departmanlar = new Departman[dp_adet];
        
        // bilgileri alip, departman dizisine ekledigim dongu.
        for(int i=1;i<dp_adet+1;i++){ 
        	
        	departmanlar[i-1] = new Departman();
        	
        	wipeConsole();
            
            System.out.println("\n - demir.ai Sirket (Departman Ekle) -");

            System.out.printf("\n   " + i + ". Departman no : ");

            while (true) {
            	
            	if(departmanlar[i-1].setDepNo(input.nextLine())==0) {
            		break;
            	}
            	
            	else {
            		
            		wipeConsole();
            		System.out.printf("\n     Departman no, Int veri tipinde olmali. Tekrar Departman no girmek icin Enter'e basiniz. ");
            		input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Departman Ekle) -");
                    System.out.printf("\n   " + i + ". Departman no : ");
                    
            		
            	}
            }

            System.out.printf("\n   " + i + ". Departman ad : ");
            ad = input.nextLine();
            
            departmanlar[i-1].setDepAd(ad);
            
            wipeConsole();
            
            System.out.println("\n - demir.ai Sirket (Personel Ekle) -");
            
            System.out.print("\n    Kaç adet personel eklenecek : ");
            
            while (true) {
            	
            	if(departmanlar[i-1].setInt_personeller(input.nextLine())==0) {
            		break;
            	}
            	
            	else {
            		
            		wipeConsole();
                    System.out.printf("\n     Eklenecek personel adeti, Int veri tipinde olmali ve 0 dan buyuk olmali. Tekrar personel adeti girmek icin Enter'e basiniz. ");
                    input.nextLine();
                    
                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Departman Ekle) -");
                    System.out.print("\n    Kaç adet personel eklenecek : ");
            		
            	}

            }
            
            // secili departmanda istenilen adet kadar personel ekleme
            departmanlar[i-1].setPersoneller();

            String ad1;
            String syd;
            int yas;

            
            // personel ekleme dongusu.
            for(int j=1; j<departmanlar[i-1].getInt_personeller()+1;j++){
            	
            	wipeConsole();

                System.out.println("\n - demir.ai Sirket (Kisi Ekle) -");
                System.out.println("\n   " + i + ". Departman no : " + departmanlar[i-1].getDepNo());
                System.out.println("\n   " + i + ". Departman ad : " + ad);

                System.out.printf("\n     " + j + ". Personel Adi : ");
                ad1 = input.nextLine();

                System.out.printf("\n     " + j + ". Personel Soyadi : ");
                syd = input.nextLine();

                System.out.printf("\n     " + j + ". Personel Yasi : ");

                while (true) {
                	
                	int kn = 0;
                	yas = 0;

                    try {

                        yas = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException ex) {
                    	
                    	kn=1;
                    	
                    }
                    
                    if(kn!=1) {
                    	
                    	if(yas<16) {
                        	
                        	kn=9;
                        }
                    }
                    
                    if(kn==1 || kn==9) {
                    	
                    	wipeConsole();
                    	
                    	if(kn==1) {
                            
                    		System.out.printf("\n        Personel yasi, Int veri tipinde olmalidir. Tekrar Personel yasi girmek icin Enter'e basiniz. ");

                    	}
                    	
                    	else {
                    		System.out.printf("\n        Personel yasi minumum 16 olabilir. Tekrar Personel yasi girmek icin Enter'e basiniz. ");

                    	}
                    	
                        input.nextLine();
                        
                        wipeConsole();
                        System.out.println("\n - demir.ai Sirket (Kisi Ekle) -");
                        System.out.println("\n   " + j + ". Departman no : " + departmanlar[i-1].getDepNo());
                        System.out.println("\n   " + j + ". Departman ad : " + ad);

                        System.out.printf("\n     " + i + ". Personel Adi : " + ad1);

                        System.out.printf("\n\n     " + i + ". Personel Soyadi : " + syd);

                        System.out.printf("\n\n     " + i + ". Personel Yasi : ");

                        continue;
                    }
                    break;
                }
                
                departmanlar[i-1].getPersoneller(j-1).Personel(departmanlar[i-1].getDepNo(), ad1, syd, yas);
                
                if(yas>=enb) {
                	enb = yas;
                }
                
                if(yas<=enkc) {
                	enkc = yas;
                }
                
            }
            
            wipeConsole();
            
            System.out.println("\n - demir.ai Sirket (Servis Ekle) -");
                
            System.out.print("\n    Kaç adet servis eklenecek : ");
                
            while (true) {
                	
            	if(departmanlar[i-1].setInt_servisler(input.nextLine())==0) {
                break;
            	}
                	
                else {
                		
                	wipeConsole();
                    System.out.printf("\n     Eklenecek servis adeti, Int veri tipinde olmali ve 0 dan büyük olmali. Tekrar servis adeti girmek icin Enter'e basiniz. ");
                    input.nextLine();
                        
                    wipeConsole();
                    System.out.println("\n - demir.ai Sirket (Servis Ekle) -");
                    System.out.print("\n    Kaç adet servis eklenecek : ");
                		
                }

            }
            
         // secili departmanda istenilen adet kadar servis ekleme
            departmanlar[i-1].setServisler();

            for(int k=1; k<departmanlar[i-1].getInt_servisler()+1;k++){
                    	
            	wipeConsole();

                System.out.println("\n - demir.ai Sirket (Servis Ekle) -");
                System.out.println("\n   " + i + ". Departman no : " + departmanlar[i-1].getDepNo());
                System.out.println("\n   " + i + ". Departman ad : " + ad);

                System.out.printf("\n     " + k + ". Servis Güzergahi : ");
                ad1 = input.nextLine();
                    
                departmanlar[i-1].getServisler(k-1).Servis(departmanlar[i-1].getDepNo(), ad1);
                   
            }


        }
        
        // geriye departmanlar dizisi dondurulur
        return departmanlar;
            
        }

    // listeleme methodu
    public static void listele(Departman departman, int i) {
    	
    	// temp ve temp0 adlý degiskendeki bilgiler yazdirilir.

        System.out.println("    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");

        String temp;
        String temp0;
        int j = 0, z = 0;

        if(i<0){

            temp = " Departman Ad : " + departman.getDepAd();

            temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        }

        else{

            temp = " Departman No : " + Integer.toString(departman.getDepNo()) + ", Departman Ad : " + departman.getDepAd();
            temp0 = Integer.toString(i + 1) + ". Departman";

        }

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");

        for (z = 0; z < departman.getInt_personeller(); z++) {

            if (z != 0) {
                System.out.println("    |||" + "|                |                                                                         |");
            }

            temp0 = Integer.toString(z + 1) + ". Personel";

            System.out.printf("    |||" + "| " + temp0);

            for (j = 0; j < 15 - temp0.length(); j++) {
                System.out.printf(" ");
            }
            
            // temp adli degisken ekrana yazdirilacaktir.
            temp = " perID : " + Integer.toString(departman.getPersoneller(z).getPerID());
            temp += ", perAd-perSoyad : " + departman.getPersoneller(z).getPerAd();
            temp += " " + departman.getPersoneller(z).getPerSoyad();
            temp += ", perYaþ : " + Integer.toString(departman.getPersoneller(z).getPerYas());

            System.out.printf("|" + temp);

            for (j = 0; j < 73 - temp.length(); j++) {

                System.out.printf(" ");

            }
            System.out.println("|");

            System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        }

        System.out.println("    |||" + "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");

        for (z = 0; z < departman.getInt_servisler(); z++) {

            if (z != 0) {
                System.out.println("    |||" + "|                |                                                                         |");
            }

            temp0 = Integer.toString(z + 1) + ". Servis";

            System.out.printf("    |||" + "| " + temp0);

            for (j = 0; j < 15 - temp0.length(); j++) {
                System.out.printf(" ");
            }

            temp = " servisID : " + Integer.toString(departman.getServisler(z).getServisID());
            temp += ", servisGüzergah : " + departman.getServisler(z).getServisGuzergah();

            System.out.printf("|" + temp);

            for (j = 0; j < 73 - temp.length(); j++) {

                System.out.printf(" ");

            }
            System.out.println("|");

            System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        }

    }
    
    // personel listele
    public static void pr_listele(Personel personel, Departman departman) {
    	
    	// temp ve temp0 adlý degiskendeki bilgiler yazdirilir.

        System.out.println("    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");

        temp0 = "perID : "+Integer.toString(personel.getPerID());

        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " perAd-perSoyad : " + personel.getPerAd();
        temp += " " + personel.getPerSoyad();
        temp += ", perYaþ : " + Integer.toString(personel.getPerYas());

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        System.out.println("\n");

    }
    
    // servis listele methodu
    public static void ser_listele(Servis servis, Departman departman) {
    	
    	// temp ve temp0 adlý degiskendeki bilgiler yazdirilir.
    	
    	System.out.println("    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");

        System.out.println("    |||" + "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");

        temp0 = "servisID : "+Integer.toString(servis.getServisID());

        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " Servis Guzergah : " + servis.getServisGuzergah();

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |||" + "|________________|_________________________________________________________________________|");

        System.out.println("\n");
    	
    }
    
    // en buyuk en kucuk yasa sahip personeller.
    public static void istatistik_yazdir(Personel personel, Departman departman, int knt) {
    	
    	// temp ve temp0 adlý degiskendeki bilgiler yazdirilir.
    	
    	System.out.println("    |¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        String temp = " Departman Ad : " + departman.getDepAd();
        int j = 0;

        String temp0 = "depNo : "+Integer.toString(departman.getDepNo());

        System.out.printf("    | " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        System.out.printf("|" + temp);

        for (j = 0; j < 76 - temp.length(); j++) {

            System.out.printf(" ");

        }
        System.out.println("|");

        System.out.println("    |________________|____________________________________________________________________________|");
    	
        System.out.println("    |||" + "|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
        
        if(knt==0) {
        	temp0 = "En buyuk";
        }
        
        else {
        	temp0 = "En kucuk";
        }


        System.out.printf("    |||" + "| " + temp0);

        for (j = 0; j < 15 - temp0.length(); j++) {
            System.out.printf(" ");
        }

        temp = " perID : " + Integer.toString(personel.getPerID());
        temp += ", perAd-perSoyad : " + personel.getPerAd();
        temp += " " + personel.getPerSoyad();
        temp += ", perYaþ : " + Integer.toString(personel.getPerYas());

        System.out.printf("|" + temp);

        for (j = 0; j < 73 - temp.length(); j++) {

            System.out.printf(" ");

        }
        
        System.out.println("|");
        System.out.println("    |||" + "|________________|_________________________________________________________________________|");
        
        System.out.println("\n");
        
    }
    
    // ekran temizleme methodu
    public static void wipeConsole() throws AWTException{
    	
    	// kýsa yollari kullanarak ekran temizler
    	if(clear==0) {
    		
    		Robot robbie = new Robot();
            
            //clears the console
            robbie.keyPress(KeyEvent.VK_SHIFT);
            robbie.keyPress(KeyEvent.VK_F10);
            robbie.keyRelease(KeyEvent.VK_SHIFT);
            robbie.keyRelease(KeyEvent.VK_F10);
            robbie.keyPress(KeyEvent.VK_R);
            robbie.keyRelease(KeyEvent.VK_R);
            
            if(Departman.getDepSayi()==0) {
            	robbie.keyPress(KeyEvent.VK_ESCAPE);
                robbie.keyRelease(KeyEvent.VK_ESCAPE);
            }
            
            try {
        	    Thread.sleep(1 * 500);
        	} catch (InterruptedException ie) {
        	    Thread.currentThread().interrupt();
        	}
    		
    	}
    	
    	// 30 tane \n kullanarak ekran temizleme
    	else {
    		
    		for(int i=0;i<30;i++) {
    			System.out.println(" ");
    		}
    		
    	}
    	
    }

}
