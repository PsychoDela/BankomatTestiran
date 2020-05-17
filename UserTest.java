import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest 
{
	User huso = new User ("Huso", 1111, 9);
	User mehemed = new User ("Mehemed", 1235, 10);
	static String ime = "Faris";
	static String invalidName = "Huso";
	static int brojRacunaValidan = 1234;
	static int brojRacunaInvalidan = - 1234;
	static int pocIznosValidan = 1;
	static int pocIznosInvalidan = - 1;
	
	@Test
	public void validNameShouldReturnTrue() 
	{
		assertTrue("'Faris' treba da vrati true", User.validacijaIme(ime));
	}
	
	@Test
	public void invalidNameShouldReturnFalse()
	{
		assertFalse("'Huso' treba da vrati false, jer ime vec postoji", User.validacijaIme(invalidName));
	}
	
	@Test
	public void validAccNumberShouldReturnTrue()
	{
		assertTrue("'1234' treba da vrati true", User.validacijaBrojRacuna(brojRacunaValidan));
	}
	
	@Test
	public void invalidAccNumberShouldReturnFalse()
	{
		assertFalse("'1111' treba da vrati false, jer taj broj racuna vec postoji", User.validacijaBrojRacuna(1111));
	}
	
	@Test
	public void invalidAccNumberShouldReturnFalseWhileNegative()
	{
		assertFalse("'-1111' treba da vrati false, jer je broj negativan", User.validacijaBrojRacuna(brojRacunaInvalidan));
	}
	
	@Test
	public void validStartAmountShouldReturnTrue()
	{
		assertTrue("'1' treba da vrati true", User.validacijaIznos(pocIznosValidan));
	}
	
	@Test
	public void invalidStartAmountShouldReturnFalseWhileNegative()
	{
		assertFalse("'-1' treba da vrati false", User.validacijaIznos(pocIznosInvalidan));
	}
	
	@Test
	public void amountLessThanBalanceShouldReturnTrue()
	{
		assertTrue("'5' treba da vrati true jer Mehemed ima na svom racunu 10$", User.validacijaIznosaZaBrojRacuna(1235, 5));
	}
	
	@Test
	public void amountGreaterThanBalanceShouldReturnFalse()
	{
		assertFalse("'20' treba da vrati false jer Mehemed ima na svom racunu 10$", User.validacijaIznosaZaBrojRacuna(1235, 20));
	}
	
	@Test
	public void shouldReturnTrueIfAccountsEligibleForTransfer()
	{
		assertTrue("Treba da vrati true jer brojevi racuna postoje i iznos je manji ili jednak iznosu na izvoronom racunu", User.transferValidate(1111, 1235, 3));
	}
	
	@Test
	public void shouldReturnFalseIfAccountsDontExist()
	{
		assertFalse("Treba da vrati false jer brojevi racuna ne postoje", User.transferValidate(9999, 8888, 764));
	}
	
	@Test
	public void shouldReturnTrueIfAccountsEligibleForTransfer2()
	{
		assertTrue("Treba da vrati true jer brojevi racuna postoje i iznos je manji ili jednak iznosu na izvoronom racunu", User.transfer(1111, 1235, 3));
	}
	
	@Test
	public void shouldReturnFalseIfAccountsDontExist2()
	{
		assertFalse("Treba da vrati false jer brojevi racuna ne postoje", User.transfer(9999, 8888, 764));
	}
	
	@Test
	public void detailsTest()
	{
		assertEquals("Husini detalji trebaju da vrate ime i iznos na racunu ", "Ime: Huso\nIznos na racunu: 9", User.ispisDetalja(1111));
	}
	
	@Test
	public void detailsShouldReturnNullIfAccountNumberDoesNotExist()
	{
		assertEquals(null, User.ispisDetalja(78687324));
	}
}
