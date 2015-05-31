package elements;

import Affichage.IsAffichable;


public abstract class Decors extends Element implements IsAffichable {

	protected String imageUrl;
	
	public String getImageUrl()
	{
		return this.imageUrl;
	}
	
	
}
