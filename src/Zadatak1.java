import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Zadatak1 {
	
	/*Napisati program koji cita rijeci iz tekstualnog fajla te ispisuje te rijeci u rastucem
	 * abecednom redu. Program treba da pita korisnika da unese ime fajla te:
	 * a) da li korisnik zeli da ispise sve rijeci, ukljucujuci duplikate
	 * b) da li korisnik zeli da ispise samo unikatne rijeci, ne ukljucujuci duplikate.
	 */
	
	static Scanner input = new Scanner (System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Unesite ime fajla (npr. fajl.txt): ");
		String imeFajla = input.next();

		System.out.println("Izaberite zeljenu opciju: ");
		System.out.println("1. Ispis svih rijeci iz fajla, ukljucujuci duplikate.");
		System.out.println("2. Ispis unikatnih rijeci iz fajla, (ne ukljucujuci duplikate)");

		int korisnikovUnos = reTry();

		while(korisnikovUnos < 1 || korisnikovUnos > 2) {
			System.out.println("Unesite validan broj (1 - 2): ");
			korisnikovUnos = reTry();
		}

		Collection<String> rijeci;

		if (korisnikovUnos == 1) {
			rijeci = rijeciIzFajlaUListu(imeFajla);
		}else
			rijeci = rijeciIzListeUHashSet(imeFajla);
		
		for (String s : rijeci)
			System.out.print(s + " ");

		input.close();
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
	
	public static int reTry() {
		 try {
		     return input.nextInt();
		 } catch (InputMismatchException ex) {
		     input.nextLine(); //Ova linija prebacuje kursor na sljedecu liniju
		     System.out.println("Unos treba biti tipa integer, pokusajte ponovo:");
		     return reTry();
		 }
	}
}
