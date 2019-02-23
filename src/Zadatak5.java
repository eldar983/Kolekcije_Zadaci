import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak5 {
	/**
	 * Napisati program koji pita korisnika da proslijedi ime filea. Nakon što je
	 * korisnik proslijedio ime filea, program treba da: ispiše broj unikatnih
	 * rijeèi u fileu ukupan broj rijeèi u fileu broj samoglasnika u fileu broj
	 * suglasnika u fileu
	 */

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Unesite ime fajla (npr. novifajl.txt): ");
		String imeFajla = input.next();

		main: while (true) {

			System.out.println("Izaberite zeljenu opciju:" + "\n1. Ispis broja unikatnih rijeci u fajlu"
					+ "\n2. Ukupan broj rijeci u fajlu" + "\n3. Broj samoglasnika u fajlu"
					+ "\n4. Broj suglasnika u fajlu" + "\n5. Exit");

			int opcija = reTry(input);

			while (opcija < 1 || opcija > 5) {
				System.out.println("Unesite validan broj (1 - 5): ");
				opcija = reTry(input);
			}

			switch (opcija) {
			case 1:
				System.out.println("Broj unikatnih rijeci u fajlu je: " + rijeciIzListeUHashSet(imeFajla).size());
				System.out.println();
				break;
			case 2:
				System.out.println("Ukupan broj rijeci u fajlu je: " + rijeciIzFajlaUListu(imeFajla).size());
				System.out.println();
				break;
			case 3:
				ArrayList<String> fajlZaSamoglasnike = rijeciIzFajlaUListu(imeFajla);
				int brojSamoglasnika = 0;
				for (String rijeci : fajlZaSamoglasnike) {
					for (int i = 0; i < rijeci.length(); i++) {
						char ch = rijeci.charAt(i);
						if (Character.isLetter(ch) && ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i'
								|| ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U') {
							brojSamoglasnika++;
						}
					}
				}
				System.out.println("Broj samoglasnika u fajlu je: " + brojSamoglasnika);
				System.out.println();
				break;
			case 4:
				ArrayList<String> fajlZaSuglasnike = rijeciIzFajlaUListu(imeFajla);
				int brojSuglasnika = 0;
				for (String rijeci : fajlZaSuglasnike) {
					for (int i = 0; i < rijeci.length(); i++) {
						char ch = rijeci.charAt(i);
						if (Character.isLetter(ch) && ch != 'a' || ch != 'A' || ch != 'e' || ch != 'E' || ch != 'i'
								|| ch != 'I' || ch != 'o' || ch != 'O' || ch != 'u' || ch != 'U') {
							brojSuglasnika++;
						}
					}
				}
				System.out.println("Broj suglasnika u fajlu je: " + brojSuglasnika);
				System.out.println();
				break;

			case 5:
				System.exit(opcija);

				continue main;

			}
		}

	}

	public static ArrayList<String> rijeciIzFajlaUListu(String imeFajla) {

		ArrayList<String> rijeci = new ArrayList<>();
		Scanner input;

		try {
			input = new Scanner(new File(imeFajla));
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije kreiran!");
			return null;
		}

		while (input.hasNext())
			rijeci.add(input.next());

		input.close();
		return rijeci;
	}

	public static HashSet<String> rijeciIzListeUHashSet(String imeFajla) {

		HashSet<String> rijeci = new HashSet<>();
		Scanner input;

		try {
			input = new Scanner(new File(imeFajla));
		} catch (FileNotFoundException e) {
			System.out.println("Fajl nije kreiran!");
			return null;
		}

		while (input.hasNext())
			rijeci.add(input.next());

		input.close();
		return rijeci;
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
