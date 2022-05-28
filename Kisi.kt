package TelefonRehberUyg

class Kisi (var isim: String,var telNo: String)
{
    object companion{
        fun kisiOlustur(isim:String,telNo:String): Kisi
        {
            return Kisi(isim,telNo)
        }
    }

}