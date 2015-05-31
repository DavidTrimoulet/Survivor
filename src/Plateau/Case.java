package Plateau;

import elements.Element;
import elements.Fou;
import elements.Garde;
import elements.Hero;
import elements.Monstre;
import elements.Mur;
import elements.Rocher;
import elements.Sol;

public class Case {
	
	private Element element;
	
	public void setContent(Element element)
	{
		this.element = element;
	}
	

	public Case(String string, int i, int j) {
		
		if(string.equalsIgnoreCase("mur"))
		{
			this.element = new Mur();
		}
		else if(string.equalsIgnoreCase("rocher"))
		{
			this.element = new Rocher();
		}
		else if(string.equalsIgnoreCase("hero"))
		{
			this.element = new Hero(i,j);
		}
		else if(string.equalsIgnoreCase("fou"))
		{
			this.element = new Fou(i,j);
		}
		else if(string.equalsIgnoreCase("garde"))
		{
			this.element = new Garde(i,j);
		}
		else if(string.equalsIgnoreCase("monstre"))
		{
			this.element = new Monstre(i,j);
		}
		else 
		{
			this.element= new Sol();
		}
	}



	public Element getContent()
	{
		return element;
	}
}
