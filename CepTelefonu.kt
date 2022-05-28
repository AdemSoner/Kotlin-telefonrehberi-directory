package TelefonRehberUyg

class CepTelefonu (kendiNo:String) {
    private val rehber: ArrayList<Kisi>
    init {
        this.rehber= ArrayList()
    }

    fun kisiEkle(yeniKisi:Kisi): Boolean {
        if(kisiBul(yeniKisi) >= 0 || kisiBul(yeniKisi.telNo)>=0)
        {
            println("Rehberde ${yeniKisi.telNo} bu numara zaten kayıtlı...")
            return false
        }


        this.rehber.add(yeniKisi)
        return true

    }

    fun kisiBul(aranacakKisi: Kisi): Int {
      //  println("Aranacak kisinin bilgileri ${aranacakKisi.isim} ${aranacakKisi.telNo}")
        return this.rehber.indexOf(aranacakKisi)
    }                           // is not working.

    fun kisiBul(aranacakTel:String): Int {
        for(i : Int in rehber.indices)
        {
            val oankiTelNo=rehber[i]
            if(oankiTelNo.telNo == aranacakTel)
            {
                return i
            }
        }
        return -1
    }

    fun kisiyiGoster(kisiId:Int) {
        val gosterilecekKisi = rehber[kisiId]
        if (kisiId>=0)
            println("Bulunan kisinin bilgileri ${gosterilecekKisi.isim} , ${gosterilecekKisi.telNo}")
        else
            println("Boyle biri rehberde kayitli degil")

    }

    fun kisiGuncelle(yeniAd:String, yeniTel:String, id:Int): Kisi{
        val mevcutKisi = rehber[id]
        mevcutKisi.isim=yeniAd
        mevcutKisi.telNo=yeniTel
        return mevcutKisi
    }

    fun kisiSil(silinecekKisi: Kisi): Boolean{
        if(kisiBul(silinecekKisi.isim)<0)
        {
            println("Boyle biri yok.")
            return false
        }
        this.rehber.remove(silinecekKisi)
        return true
    }

    fun rehberGoruntule(){
        var sayac=1
        println("\n**************************** REHBER ****************************")
        for (oankiKisi:Kisi in rehber)
        {
            println("$sayac. -> ${oankiKisi.isim} ,  ${oankiKisi.telNo}")
            sayac++
        }
        if(sayac==1)
            println("Rehber bos.\nLutfen kayit ekleyin...")

    }

}

