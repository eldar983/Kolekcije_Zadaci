import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Zadatak4 {
	/**
	 * Napisati program koji pohranjuje 5 miliona cijelih brojeva u listu
	 * (ArrayListu, LinkedListu) te testira i ispisuje vrijeme potrebno da se prodje
	 * kroz listu i ispise svaki element na konzoli: koristeæi se get(index) metodom
	 * koristeæi se foreach petljom / iteratorom.
	 */

	public static void main(String[] args) {

		List<Number> arayLista = new ArrayList<>();
		List<Number> linkedLista = new LinkedList<>();

		for (long i = 0; i < 5000; i++) {
			arayLista.add(i);
			linkedLista.add(i);
		}

		long pocetnoVrijemeGetMetodeArayListe = System.currentTimeMillis();

		for (int i = 0; i < arayLista.size(); i++) {
			System.out.print(arayLista.get(i));
		}
		long vrijemePotrebnoZaIzvrsenjeGetMetodeArayListe = System.currentTimeMillis()
				- pocetnoVrijemeGetMetodeArayListe;
		System.out.println();
		System.out.println("Vrijeme potrebno za prolazak kroz array listu pomocu get() metode je: "
				+ vrijemePotrebnoZaIzvrsenjeGetMetodeArayListe + " ms");

		long pocetnoVrijemeForEachMetodeArayListe = System.currentTimeMillis();
		for (Number i : arayLista) {
			System.out.print(i + " ");
		}
		long vrijemePotrebnoZaIzvrsenjeForEachMetodeArayListe = System.currentTimeMillis()
				- pocetnoVrijemeForEachMetodeArayListe;
		System.out.println();
		System.out.println("Vrijeme potrebno za prolazak kroz array listu pomocu forEach metode je: "
				+ vrijemePotrebnoZaIzvrsenjeForEachMetodeArayListe + " ms");

		long pocetnoVrijemeGetMetodeLinkedListe = System.currentTimeMillis();
		for (int i = 0; i < linkedLista.size(); i++) {
			System.out.print(linkedLista.get(i));
		}

		long vrijemePotrebnoZaIzvrsenjeGetMetodeLinkedListe = System.currentTimeMillis()
				- pocetnoVrijemeGetMetodeLinkedListe;
		System.out.println();
		System.out.println("Vrijeme potrebno za prolazak kroz linked listu pomocu get() metode je: "
				+ vrijemePotrebnoZaIzvrsenjeGetMetodeLinkedListe + " ms");

		long pocetnoVrijemeForEachMetodeLinkedListe = System.currentTimeMillis();
		for (Number i : linkedLista) {
			System.out.print(i + " ");
		}
		long vrijemePotrebnoZaIzvrsenjeForEachMetodeLinkedListe = System.currentTimeMillis()
				- pocetnoVrijemeForEachMetodeLinkedListe;
		System.out.println();
		System.out.println("Vrijeme potrebno za prolazak kroz linked listu pomocu forEach metode je: "
				+ vrijemePotrebnoZaIzvrsenjeForEachMetodeLinkedListe + " ms");

	}
}
