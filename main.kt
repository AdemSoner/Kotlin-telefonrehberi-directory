package TelefonRehberUyg
import java.util.Scanner

private val tara=Scanner(System.`in`)
private val cepTelefonu= CepTelefonu("555-55-5")

fun main()
{
    telefonuBaslat()
    menuGoster()
    var cikis:Boolean=false
    while(!cikis)
    {
        print("\n\n\nLutfen secim yapiniz (Menu icin '0' tuslayiniz)=")
        var secim= tara.next()
        when(secim)
        {
            "0" -> menuGoster()
            "1" -> kisiListeleFonk()
            "2" -> kisiEkleFonk()
            "3" -> kisiSorgulaFonk()
            "4" -> kisiGuncelleFonk()
            "5"-> kisiSilFonk()
            "9" -> cikis = cikisYapFonk()
            else -> println("Yanlis secim yaptiniz...")
        }
    }
}

fun kisiListeleFonk() {
    cepTelefonu.rehberGoruntule()
}
fun kisiEkleFonk() {
    print("Lutfen eklenecek kisinin ismini giriniz= ")
    val isim:String = tara.next()
    print("Lutfen eklenecek kisinin numarasini giriniz=")
    val no:String = tara.next()
    if(cepTelefonu.kisiEkle(Kisi(isim,no)))
        println("Kisi ekleme basarili")

}
fun kisiSorgulaFonk() {
    print("Lutfen aradiginiz kisinin telefon numarasini giriniz= ")
    val aranacakTel:String = tara.next()
    cepTelefonu.kisiyiGoster(cepTelefonu.kisiBul(aranacakTel))

}
fun kisiGuncelleFonk() {
    kisiListeleFonk()
    print("Lutfen guncellenecek kisinin basindaki sayiyi giriniz= ")
    var guncellenecekId= tara.nextInt()
    guncellenecekId -=1
    print("Lutfen yeni isim giriniz= ")
    val yeniAd= tara.next()
    print("Lutfen yeni telefon numarasi giriniz= ")
    val yeniTel= tara.next()
    val yeniKisiBilgileri:Kisi= cepTelefonu.kisiGuncelle(yeniAd,yeniTel,guncellenecekId)
    println("Guncellenen kisinin yeni bilgileri \n${yeniKisiBilgileri.isim} , ${yeniKisiBilgileri.telNo}")
}
fun kisiSilFonk() {
    println("Kisi siliniyor...")
}

fun telefonuBaslat() {
    println("Telefon Baslatildi...\n")
}
fun menuGoster() {
    println("******************************* MENU *******************************")
    println("Kisileri listelemek icin -> 1\n"+
            "Yeni kisi eklemek icin   -> 2\n"+
            "Kisi sorgulamak icin     -> 3\n"+
            "Kisi guncellemek icin    -> 4\n"+
            "Kisi silmek icin         -> 5\n"+
            "Programdan cikmak icin   -> 9")
}
fun cikisYapFonk() : Boolean{
    println("Cikis yapiliyor...")
    return true
}
