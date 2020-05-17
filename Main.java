import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
	static Scanner sc = new Scanner (System.in);
	static ArrayList <User> useri = new ArrayList <User> ();
	
	public static void main(String[] args) 
	{
		start();
	}
	
	public static void start()
	{
		System.out.println("~~~Bankomat~~~");
		System.out.println("1 - Napravi racun\n2 - Transfer novca\n3 - Izlaz\n4 - Detalji");
		
		int odabir = sc.nextInt();
		
		router(odabir);
	}
	
	public static void router (int odabir)
	{
		switch (odabir)
		{
			case 1:
				napraviRacun();
				break;
			
			case 2:
				transfer();
				break;
			
			case 3:
				izlaz();
				break;
			
			case 4:
				detalji();
				break;
				
			default:
				greska();
				break;
		}
	}
	
	public static void napraviRacun()
	{
		System.out.println("Unesite ime");
		String ime = unosImena();
		System.out.println("Unesite broj racuna");
		int brojRacuna = unosBrojaRacuna();
		System.out.println("Unesite pocetni iznos");
		int pocIznos = unosPocIznosa();
		
		User user = new User(ime, brojRacuna, pocIznos);
		
		if (user.isCreated() == false)
		{
			greska();
		}
		
		else
		{
			System.out.println("Ime: " + user.getIme() + "\nBroj racuna: " + user.getBrojRacuna() + "\nPocetni iznos: " + user.getIznos());
			start();
		}
		
	}
	
	public static void transfer()
	{
		System.out.println("Unesite broj racuna s kojeg prebacujete sredstva");
		int brojIzvornogRacuna = unosBrojaRacuna();
		
		System.out.println("Unesite broj racuna na koji prebacujete: ");
		int brojCiljanogRacuna = unosBrojaRacuna();
		
		System.out.println("Unesite iznos koji prebacujete: ");
		int iznos = unosPocIznosa();
		
		if (User.transfer(brojIzvornogRacuna, brojCiljanogRacuna, iznos))
		{
			System.out.println("Transfer uspjesan!");
		}
		
		start();
	}
	
	public static void detalji()
	{
		System.out.println("Unesite broj racuna");
		int brojRacuna = unosBrojaRacuna();
		
		System.out.println(User.ispisDetalja(brojRacuna));
		
		start();
	}
	
	public static String unosImena()
	{
		sc.nextLine();
		String ime = sc.nextLine();
		return ime;
	}
	
	public static int unosBrojaRacuna()
	{
		return sc.nextInt();
	}
	
	public static int unosPocIznosa()
	{
		return sc.nextInt();
	}
	
	public static void izlaz()
	{
		System.out.println("Program ugasen.");
		System.exit(0);
	}
	
	public static void greska()
	{
		System.out.println("Greska! Pokusaj ponovo!");
		start();
	}
}