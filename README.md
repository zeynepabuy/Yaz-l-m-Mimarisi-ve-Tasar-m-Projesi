# Yazilim Mimarisi Projesi
# Konu:Şirket Eleman Alımı Otomasyonu Arayüzü Tasarım Deseni ve Strateji Tasarım Deseni Örneği
  
# Şirket Eleman Alımı Otomasyonu Arayüzü Tasarım Deseni:
  Şirket Eleman Alımı Otomasyonu Arayüzü tasarım deseni, insan kaynakları departmanının yaptığı işi hafifletmek amacıyla oluşturulan bir sistemdir. İşe alım sisteminin şirket insan kaynaklarından otomasyon sistemine devredilmesidir. Bu yordam ile belirli bir sistem hiyerarşisindeki işe alım sırası aday eleme sorumluluğu belirli bir otomasyona verilerek sistemden soyutlanmış olur. Böylece işe alım kodlarında, kod tekrarları ve gereksiz insan gücü gereksinimi önlenmiş olur. Sistem içinde aday havuzu yeri tek olduğu için, ilgili mantıklar bir arada toplanabilir.
 ![Image of Class](https://github.com/zeynepabuy/Yazilim-Mimarisi-Projesi/blob/master/ClassDiagram.png)
 
 
 somut sınıf
 ```java

public class Uygunaday implements aday {

	@Override
	public void basvuru(int puan) {

		System.out.println("Kriterlerimize uygun değilsiniz." );
		System.out.println("Biz sizi arayacağız :)");
	}

}

```
somut sınıf
 ```java

public class Elenecekaday implements aday {
	@Override
	public void basvuru(int puan) {

		System.out.println("Kriterlerimize uygun değilsiniz.");
		System.out.println("Biz sizi arayacağız :)");
	}

}

 ```
 Alınan puana göre elenecek ve kabul edilecek başvurulara karar verilir. 
  ```java

public class degerlendirme {

	public aday puanaraligi(int puan) {
		if(puan<=80) {
			System.out.println("Kriterlerimize uygun değilsiniz.");
			return new Elenecekaday();
		}
		else {
			System.out.println("Biz sizi arayacağız :)");
			return new Uygunaday();
		}
	}

}

 ```
 Main:
 Burda sayım işlemi ile katagori ayrımı yapılır. Puan aralığına göre katagori ayrımı yapılarak eleme işlemi bitirilir.
  ```java
  
public class ele {

	 public static void main( final String[] args ) {

	      	  int puan=80;
	    	  degerlendirme degerlendir = new degerlendirme();
		      aday puan = degerlendir.puanaraligi(puan);
		      puan.islem(puan);
	   }
}

interface
   ```java
 public interface aday {

	void basvuru(int puan);
}

 
 ```
# Strateji Tasarım Deseni:
 Strateji(Strategy) tasarım deseni, behavioral tasarım desenlerinden biridir. Bir dizi algoritma tanımlar, bu algoritmaların erişimi için arayüz sağlar ve algoritmaları tanımlarken birbirlerinin yerine kullanılabilir özellikte tasarlar. Ayrıca client runtime zamanında dilediği algoritmayı seçebilir. 
  
  
  ![Image of Class](https://github.com/zeynepabuy/Yazilim-Mimarisi-Projesi/blob/master/StrategyDesign.png)
  


# Ne zaman Kullanılır?

Belirli bir iş için birden çok algoritmaya(yönteme) sahip olduğumuzda kullanılır.

# Nasıl Kullanılır?

Öncelikle bir algoritma interface'i oluşturulur .Daha sonra oluşturulan interface'i implement edecek algoritma sınıfları yaratılır. Context sınıfı yaratılır. Bu sınıf içerisinde algoritma interface türünden algoritmaların set edilmesi için bir metod bulunur. Bu metod sayesinde Context sınıfı algoritma nesnesini tutmuş olur. Son olarak bir Client sınıfı oluşturulur. Bu sınıf Context sınıfından ve algoritma sınıflardan nesneler üreterek işlemlerin yapılmasını sağlar 

Interface
  ```java
public interface Communicate {
    public void submission();
}
 
 ```
Context Sınıfı
  ```java
  public class Context {
    private Communicate communicate;

    public void setCommunicate(Communicate communicate) {
        this.communicate = communicate;
    }
    public void sendInformation(){
        communicate.submission();
    }
}

 ```
 Somut Sınıf
 ```java
 public class Read implements Communicate {
    @Override
    public void submission() {
        System.out.println("Read the result");
    }
}


 ```
 Somut Sınıf
 ```java
 public class Finalize implements Communicate {
    @Override
    public void submission() {
        System.out.println("Decided to new workers.. ");
    }
}


 ```
Test Sınıf
 ```java
public class Approve {
    public static void main(String[] args) {
        Context context=new Context();
        context.setCommunicate(new Read());
        context.sendInformation();
        context.setCommunicate(new Finalize());
        context.sendInformation();
    }
}
