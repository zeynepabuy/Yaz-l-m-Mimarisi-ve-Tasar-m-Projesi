
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
