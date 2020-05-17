public class User 
{
	private String ime;
	private int brojRacuna;
	private int iznos;
	private boolean created;
	
	public User(String ime, int brojRacuna, int iznos) 
	{
		if (validacija (ime, brojRacuna, iznos) == true)
		{
			setIme(ime);
			setBrojRacuna(brojRacuna);
			setIznos(iznos);
			setCreated(true);
			Main.useri.add(this);
		}
	}
	
	public boolean validacija(String ime, int brojRacuna, int iznos)
	{
		if (validacijaIme(ime) == true && validacijaBrojRacuna(brojRacuna) == true && validacijaIznos(iznos) == true)
		{
			return true;
		}
		
		return false;
	}
	
	public static boolean validacijaIme(String ime)
	{
		for (int i = 0; i < Main.useri.size(); i++)
		{
			if (ime.equals(Main.useri.get(i).getIme()))
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean validacijaBrojRacuna(int brojRacuna)
	{
		if (brojRacuna < 0)
		{
			return false;
		}
		
		for (int i = 0; i < Main.useri.size(); i++)
		{
			if (brojRacuna == Main.useri.get(i).getBrojRacuna())
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean validacijaIznos(int iznos)
	{
		if (iznos < 0)
		{
			return false;
		}
		
		return true;
	}
	
	public static boolean validacijaIznosaZaBrojRacuna(int brojRacuna, int amount)
	{
		for (int i = 0; i < Main.useri.size(); i++)
		{
			if(Main.useri.get(i).getBrojRacuna() == brojRacuna)
			{
				if (Main.useri.get(i).getIznos() >= amount)
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public String getIme() 
	{
		return ime;
	}

	public void setIme(String ime) 
	{
		this.ime = ime;
	}

	public int getBrojRacuna() 
	{
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) 
	{
		this.brojRacuna = brojRacuna;
	}

	public int getIznos() 
	{
		return iznos;
	}

	public void setIznos(int iznos) 
	{
		this.iznos = iznos;
	}

	public boolean isCreated() 
	{
		return created;
	}

	public void setCreated(boolean created) 
	{
		this.created = created;
	}
	
	public static boolean transferValidate(int srcAcc, int tgtAcc, int amount)
	{
		if (validacijaBrojRacuna(srcAcc) == false && validacijaBrojRacuna(tgtAcc) == false)
		{
			if (validacijaIznosaZaBrojRacuna(srcAcc, amount))
			{
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean transfer(int srcAcc, int tgtAcc, int amount)
	{
		int indexSrc = indexBrojaRacuna(srcAcc);
		int indexTgt = indexBrojaRacuna(tgtAcc);
		
		if (transferValidate(srcAcc, tgtAcc, amount) == true)
		{
			Main.useri.get(indexSrc).setIznos(Main.useri.get(indexSrc).getIznos() - amount);
			Main.useri.get(indexTgt).setIznos(Main.useri.get(indexTgt).getIznos() + amount);
			
			return true;
		}
		
		return false;
	}
	
	public static int indexBrojaRacuna(int brojRacuna)
	{
		for (int i = 0; i < Main.useri.size(); i++)
		{
			if (Main.useri.get(i).getBrojRacuna() == brojRacuna)
			{
				return i;
			}
		}
		
		return -1;
	}
	
	public static String ispisDetalja(int brojRacuna)
	{
		int indexRacuna = -1;
		String detalji = "";
		
		if (validacijaBrojRacuna(brojRacuna) == false)
		{
			indexRacuna = indexBrojaRacuna(brojRacuna);
		}
		
		else
		{
			return null;
		}
		
		detalji += "Ime: " + Main.useri.get(indexRacuna).getIme() + "\nIznos na racunu: " + Main.useri.get(indexRacuna).getIznos();
		
		return detalji;
	}
}
