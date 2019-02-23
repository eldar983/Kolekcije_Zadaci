import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Zadatak2 {
	/**
	 * Napisati program koji pita korisnika da unese neodreðeni broj cijelih brojeva 
	 * (0 prekida unos). 
	 * Nakon što je korisnik unio brojeve, pitati korisnika da li želi: 
	 * da sortira brojeve? (sort)
	 * da promiješa brojeve? (shuffle)
	 * da sortira brojeve u silazeæem redosljedu? (reverse sort)
	 * Nakon svake izabrane opcije, ispisati brojeve na konzoli. 
	 * Ne pohranjivati duplikate brojeva.
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
			System.out.println(
					"Izaberite zeljenu opciju:\n1.Sortiranje brojeva\n2. Promijesati brojeve\n3. Sortiranje brojeva u silazecem redoslijedu"
							+ "\n4. Exit");
			int opcija = reTry(input);

			while (opcija < 1 || opcija > 4) {
				System.out.println("Unesite validan broj (1 , 2, 3 ili 4): ");
				opcija = reTry(input);
			}

			if (opcija == 1) {
				Collections.sort(brojevi);

			} else {
				if (opcija == 2) {
					Collections.shuffle(brojevi);
				} else {
					if (opcija == 3) {
						Collections.reverse(brojevi);
					} else if (opcija == 4) {
						System.exit(opcija);
					}

				}
			}

			for (Integer lista : brojevi) {
				System.out.print(lista + " ");
			}
			System.out.println();

			continue main;
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
