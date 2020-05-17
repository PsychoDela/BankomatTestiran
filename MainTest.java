import static org.junit.Assert.*;
import org.junit.Test;

public class MainTest 
{
	@Test
	public void unosImenaTest()
	{
		assertEquals("", Main.unosImena());
	}
	
	@Test
	public void unosBrojaRacunaTest()
	{
		assertEquals(0, Main.unosBrojaRacuna());
	}
	
	@Test
	public void unosPocIznosaTest()
	{
		assertEquals(0, Main.unosPocIznosa());
	}
}