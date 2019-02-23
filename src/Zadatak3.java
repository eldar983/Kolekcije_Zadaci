import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Zadatak3 {
	/**
	 * Napisati program koji pita korisnika da unose neodreðeni broj cijelih brojeva
	 * (0 prekida unos). Nakon što korisnik unese cijele brojeve, program treba da
	 * pita korisnika: da li želi da ispiše zbir svih unesenih brojeva? da li želi
	 * da ispiše prosjek svih unesenih brojeva? da li želi da ispiše zbir svih: a)
	 * parnih brojeva? b) neparnih brojeva? c) brojeva na parnim pozicijama? d)
	 * brojeva na neparnim pozicijama? da li želi da ispiše sve unikatne brojeve? da
	 * li želi da ispiše sve brojeve koji se ponavljaju više od jednom?
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		List<Integer> brojevi = new ArrayList<>();

		System.out.println("Unesite neodredjeni broj cijelih brojeva (0 prekida unos) ");

		int korisnikovUnos = reTry(input);

		while (korisnikovUnos != 0) {
			brojevi.add(korisnikovUnos);
			korisnikovUnos = reTry(input);
		}
		main: while (true) {
			System.out.println("Izaberite zeljenu opciju:" + "\n1. Zbir svih unesenih brojeva"
					+ "\n2. Prosjek svih unesenih brojeva" + "\n3. Zbir svih parnih brojeva"
					+ "\n4. Zbir svih neparnih brojeva" + "\n5. Zbir svih brojeva na parnim pozicijama"
					+ "\n6. Zbir svih brojeva na neparnim pozicijama" + "\n7. Ispis svih unikatnih brojeva"
					+ "\n8. Ispis svih brojeva koji se ponavljaju vise od jednom" + "\n9. Exit");
			int opcija = reTry(input);

			while (opcija < 1 || opcija > 8) {
				System.out.println("Unesite validan broj (1 - 8): ");
				opcija = reTry(input);
			}

			switch (opcija) {
			case 1:
				int suma = 0;
				for (Integer i : brojevi) {
					suma += i;
				}
				System.out.println(suma);

				break;
			case 2:
				suma = 0;
				int prosjek = 0;
				for (Integer i : brojevi) {
					suma += i;
					prosjek = suma / brojevi.size();
				}
				System.out.println(prosjek);
				break;
			case 3:
				int zbirParnih = 0;
				for (Integer i : brojevi) {
					if (i % 2 == 0) {
						zbirParnih += i;
					}
				}
				System.out.println(zbirParnih);
				break;
			case 4:
				int zbirNeparnih = 0;
				for (Integer i : brojevi) {
					if (i % 2 != 0) {
						zbirNeparnih += i;
					}
				}
				System.out.println(zbirNeparnih);
				break;
			case 5:
				int zbirPanihPozicija = 0;
				for (int i = 0; i < brojevi.size(); i++) {
					if (i % 2 == 0) {
						zbirPanihPozicija += brojevi.get(i);
					}
				}
				System.out.println(zbirPanihPozicija);
				break;
			case 6:
				int zbirNeparnihPozicija = 0;
				for (int i = 0; i < brojevi.size(); i++) {
					if (i % 2 != 0) {
						zbirNeparnihPozicija += brojevi.get(i);
					}
				}
				System.out.println(zbirNeparnihPozicija);
				break;
			case 7:
				Set<Integer> unikatniBrojevi = new HashSet<>();
				for (Integer i : brojevi) {
					unikatniBrojevi.add(i);

				}

				for (Integer i : unikatniBrojevi) {
					System.out.print(i + " ");
				}
				System.out.println();
				break;
			case 8:
				Set<Integer> unikatni = new HashSet<>();
				List<Integer> duplikati = new ArrayList<>();

				for (Integer i : brojevi) {
					if (!unikatni.add(i))
						duplikati.add(i);

				}

				for (Integer i : duplikati) {
					System.out.print(i + " ");
				}
				System.out.println();

				break;
			case 9:
				System.exit(korisnikovUnos);

				continue main;

			}
		}
	}

	public static int reTry(Scanner input) {

		try {
			return input.nextInt();
		} catch (InputMismatchException ex) {
			input.nextLine(); // Ova linija prebacuje kursor na sljedecu liniju
			System.out.println("Unos treba biti tipa integer, pokusajte ponovo:");
			return reTry(input);
		}
	}
}
