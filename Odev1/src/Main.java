import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {

		ArrayList<Kursiyer> kursiyer = new ArrayList<Kursiyer>();
		kursiyer = (ArrayList<Kursiyer>)read(kursiyer,1);

		ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
		kurslar = (ArrayList<Kurs>)read(kurslar,0);

		Scanner input = new Scanner(System.in);

		while(true){

			clear();

			System.out.println(" -- demir.ai kurs merkezi (Ana menu) --");
			System.out.println("\n 1-) Kurs Ekle");
			System.out.println("\n 2-) Kurs Listele");
			System.out.println("\n 3-) Kursiyer Ekle");
			System.out.println("\n 4-) Kursiyer Ara");
			System.out.println("\n 5-) Kursiyer Sil");
			System.out.println("\n 6-) Kursiyer Listele");
			System.out.println("\n 7-) Kursiyer Listele-Detayli");
			System.out.println("\n 8-) Aylik ucret hesaplama");
			System.out.print("\n   Secim : ");

			String secim = input.next();

			if(secim.equals("1")){

				input.nextLine();

				while(true){

					clear();
					System.out.println(" -- demir.ai kurs merkezi (Ana menu) --");

					System.out.print("\n   Eklenecek kurs Id : ");
					String id0 = input.nextLine();
					int id = 0;
					try{

						id = Integer.parseInt(id0);

					}catch(Exception e){
						System.out.println("\n\n Kurs Id int veri tipinde olmali, tekrar denemek icin Enter'e basiniz. ");
						input.nextLine();
						continue;
					}

					System.out.print("\n   Eklenecek kurs ad : ");
					String ad = input.nextLine();

					kurslar = Kurs.Kurs_add(kurslar,id,ad);

					System.out.println("   Ana menuye donmek icin Enter'e basiniz. ");
					input.nextLine();
					break;
				}

			}

			else if(secim.equals("2")){

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Kurs Listele) --");

				Kurs.listele(kurslar);

				input.nextLine();
				System.out.println("\n   Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();
			}

			else if(secim.equals("3")){

				input.nextLine();
				int id=0;
				int yas=0;
				String ad = "";

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle) --");

				System.out.print("\n  Kursiyer Id : ");
				String id0 = input.nextLine();

				System.out.print("\n  Kursiyer Ad,soyad : ");
				ad = input.nextLine();

				System.out.print("\n  Kursiyer Yas : ");
				String yas0 = input.nextLine();
				boolean flagb=true, flagc=true;

				while(true){

					if(flagb==false){

						clear();
						System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle) --");

						System.out.print("\n  Kursiyer Id : ");
						id0 = input.nextLine();

						System.out.print("\n  Kursiyer Ad,Soyad : "+ad);

						System.out.print("\n\n  Kursiyer Yas : ");
						yas0 = input.nextLine();
					}

					else if(flagc==false){

						clear();
						System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle) --");

						System.out.print("\n  Kursiyer Id : "+id);


						System.out.print("\n\n  Kursiyer Ad,Soyad : "+ad);

						System.out.print("\n\n  Kursiyer Yas : ");
						yas0 = input.nextLine();
					}

					flagb=true;
					flagc = true;

					try{
						id = Integer.parseInt(id0);
					} catch (Exception e){
						flagb=false;
						System.out.println("\n\n  Kursiyer Id int veri tipinde olmali, tekrar denemek icin Enter'e basiniz. ");
						input.nextLine();
						continue;
					}

					if(Kursiyer.control(kursiyer, id)==1){

						flagb=false;
						System.out.println("\n\n   Kursiyer Id baska bir kursiyere ait, tekrar denemek icin Enter'e basiniz. ");
						input.nextLine();
						continue;
					}

					try{
						yas = Integer.parseInt(yas0);
					} catch (Exception e){
						flagc=false;
						System.out.println("\n\n  Kursiyer yas int veri tipinde olmali, tekrar denemek icin Enter'e basiniz. ");
						input.nextLine();
						continue;
					}

					if(yas<14 || yas>100){

						flagc=false;
						System.out.println("\n\n  Kursiyer yasi 14 ile 100 arasinda olmalidir, tekrar denemek icin Enter'e basiniz. ");
						input.nextLine();
						continue;

					}

					break;
				}


				boolean flag = true;
				int i=1;
				ArrayList<Kurs> kurslar0 = new ArrayList<Kurs>();

				while(flag){

					String id_kurs0 = "";
					int id_kurs = 0;

					while(true){

						clear();
						System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle - Kurs Ekle) --");

						Kurs.listele(kurslar);

						System.out.print("\n\n   "+i+". Kursiyere Ekelencek Kurs Id : ");
						id_kurs0 = input.nextLine();

						try{
							id_kurs = Integer.parseInt(id_kurs0);
						} catch (Exception e){
							System.out.println("\n\n   Kurs Id int veri tipinde olmali, tekrar denemek icin Enter'e basiniz. ");
							input.nextLine();
							continue;
						}

						int control = Kurs.control(kurslar, id_kurs);
						String kurs_ad="";

						if(control==1){

							for(int j=0;j<kurslar.size();j++){
								if(id_kurs==kurslar.get(j).getKursId()){
									kurs_ad = kurslar.get(j).getKursAd();
									break;
								}
							}

							kurslar0.add(new Kurs(id_kurs, kurs_ad));
							break;
						}
						else{
							System.out.println("\n\n    Eklenecek kurs Id bulunamadi, tekrar denemek icin Enter'e basiniz. ");
							input.nextLine();
						}
					}

					clear();
					System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle - Kurs Ekle) --");
					System.out.print("\n   "+i+". Kurs ekleme basarili, eklemeye devam etmek icin 1'e basiniz : ");
					String control0 = input.nextLine();

					if(control0.equals("1")){
						flag = true;
						i+=1;

					}
					else{
						flag=false;
					}
				}

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ekle) --");
				Kursiyer.add(kursiyer,id,ad,yas ,kurslar0);

				System.out.println("\n\n   Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();

			}

			else if(secim.equals("4")){

				clear();
				input.nextLine();
				System.out.println(" -- demir.ai kurs merkezi (Kursiyer Ara) --");
				System.out.print("\n   Kursiyer ad,soyad : ");
				String ad = input.nextLine();

				Kursiyer.ara(kursiyer, ad);

				System.out.println("\n  Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();

			}

			else if(secim.equals("5")){

				int id=0;
				input.nextLine();

				while(true){

					clear();
					System.out.println(" -- demir.ai kurs merkezi (Kursiyer Sil) --");
					System.out.print("\n   Kursiyer Id : ");
					String id0 = input.nextLine();

					try {
						id = Integer.parseInt(id0);
					}
					catch(Exception e){
						System.out.println("\n\n   Kursiyer Id int veri tipinde olmalidir, tekrar denemek icin Enter'e  basiniz.");
						input.nextLine();
						continue;
					}

					break;

				}

				kursiyer = Kursiyer.remove(kursiyer, id);
				System.out.println("  Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();
			}

			else if(secim.equals("6")){

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Kursiyer Listele) --"+"\n");

				Kursiyer.listele(kursiyer, 1);

				System.out.println("\n  Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();
				input.nextLine();

			}

			else if(secim.equals("7")){

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Kursiyer Listele-Detayli) --"+"\n");

				Kursiyer.listele(kursiyer, 2);

				System.out.println("\n  Ana menuye donmek icin Enter'e basiniz. ");
				input.nextLine();
				input.nextLine();
			}

			else if(secim.equals("8")){

				input.nextLine();
				int id=0;

				while(true){

				clear();
				System.out.println(" -- demir.ai kurs merkezi (Aylik ucret hesapla) --");
				System.out.print("\n   Kursiyer Id : ");
				String id0 = input.nextLine();

				try {
					id = Integer.parseInt(id0);
				}
				catch(Exception e){
					System.out.println("\n\n   Kursiyer Id int veri tipinde olmalidir, tekrar denemek icin Enter'e  basiniz.");
					input.nextLine();
					continue;
				}

				break;

			}

			Kursiyer.cal(kursiyer, id);
			System.out.println("  Ana menuye donmek icin Enter'e basiniz. ");
			input.nextLine();

			}

		}

	}

	public static <E> ArrayList<E> read(ArrayList<E> e, int control) throws IOException {

		if(control==1){

			int i=1, j=1;
			BufferedReader br = new BufferedReader(new FileReader("kursiyer.txt"));

			boolean flag = true, flaga=true;
			String data;

			ArrayList<Kurs> kurslar = new ArrayList<Kurs>();

			String id = "";
			String ad = "";
			String yas = "";

			while(flag){

				try {

					data = br.readLine();

					if(data.charAt(0)=='#'){

						if(flaga!=true){

							((ArrayList<Kursiyer>) e).add(new Kursiyer(Integer.parseInt(id),ad, Integer.parseInt(yas), kurslar));
						}

						kurslar = new ArrayList<Kurs>();
						flaga = false;
						i=1;

						id = "";
						ad = "";
						yas = "";

						while(true){

							if(data.charAt(i)=='-'){
								break;
							}
							id+= data.charAt(i);

							i+=1;

						}

						while(true){

							i+=1;

							if(data.charAt(i)=='-'){
								break;
							}
							ad+= data.charAt(i);

						}

						while(true){

							i+=1;

							if(i==data.length()){
								break;
							}
							yas+= data.charAt(i);
						}
					}

					else if(data.charAt(0)=='*'){

						String kursId = "";
						String kursAd = "";
						j = 1;

						while(true){

							if(data.charAt(j)=='-'){
								break;
							}
							kursId+= data.charAt(j);

							j+=1;
						}

						while(true){

							j+=1;

							if(j==data.length()){
								break;
							}
							kursAd+= data.charAt(j);
						}
						kurslar.add(new Kurs(Integer.parseInt(kursId), kursAd));
					}
				}
				catch(Exception a) {
					((ArrayList<Kursiyer>) e).add(new Kursiyer(Integer.parseInt(id),ad, Integer.parseInt(yas), kurslar));
					break;
				}
			}

			return e;
		}

		else{

			int i=0;
			BufferedReader br = new BufferedReader(new FileReader("kurs.txt"));

			String data;
			boolean flag=true;

			while(flag){

				try {

					String id = "";
					String ad = "";
					i=0;
					data = br.readLine();

					while(true){

						if(data.charAt(i)=='-'){
							break;
						}
						id+= data.charAt(i);

						i+=1;

					}

					while(true){

						i+=1;

						if(i==data.length()){
							break;
						}
						ad+= data.charAt(i);

					}

					((ArrayList<Kurs>) e).add(new Kurs(Integer.parseInt(id), ad));

				}
				catch(Exception a) {
					break;
				}
			}

			return e;
		}
	}

	public static void clear(){

		for(int i=0; i<25;i++){
			System.out.println("");
		}

	}

}
