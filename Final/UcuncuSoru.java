/*

Overload bir metodun aşırı yüklenmesi anlamına gelir. Java'da overload ile aynı isimde birden fazla metot yazabiliriz.
Bu metotları birbirinden ayıran fark aldıkları parametreler olur. Örneğin programımızda selamVer adında bir metot olsun.
Bu metodu selamVer() şeklinde yazarak ekrana sadece selam yazdırabiliriz. Aynı şekilde başka bir metot olarak selamVer(String isim) şeklinde tanımlayabiliriz.
Programımızda selamVer metodunu bir string değer ile çağırırsak ikinci metot çağırılır eğer parametresiz çağırırsak birinci metot çağırılır.
Java burada metodun aldığı parametrelere bakarak hangi metodun çağırılacağına karar verir. Bu işleme overload denir.
Burada dikkat edilmesi gereken konular ise parametrelerin sayısı, tipi ve sırası farklı ise kodumuz sorunsuz çalışacaktır.
Ancak aynı parametreler ile aynı isimde iki metot yazarsa burada hata alırız. Bir diğer konu ise Java dönüş değerine göre metotları ayırt edemez.
Yani void selamVer() metodu ve String selamVer() metodunu programımıza yazarsa Java bu ikisi arasındaki farkı anlayamaz ve hata verir. Çünkü selamVer() metodunu çağırdığımız yerde hangi dönüş değerini beklediğimizi belirtmek zorunda değilizdir.


 */

public class UcuncuSoru {

    public static void selamVer() {
        System.out.print("Selamun aleykum \n");
    }

    public static void selamVer(String ad) {
        System.out.print("Selamun aleykum " + ad + " Kardes \n");
    }

    public static void main(String[] args) {

        System.out.print("Overload ornek... \n");
        selamVer();
        selamVer("Ahmet Furkan");

    }

}