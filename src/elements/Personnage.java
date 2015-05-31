package elements;

import Affichage.IsAffichable;
import Plateau.Position;

public abstract class Personnage extends Element implements IsAffichable {

	protected Direction direction;
	protected int life;
	protected boolean vivant;
	protected int nbDeplacement;
	protected Element[][] vision;	
	protected Range range;
		
	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public int getNbDeplacement() {
		return nbDeplacement;
	}

	public void setNbDeplacement(int nbDeplacement) {
		this.nbDeplacement = nbDeplacement;
	}

	public Personnage()
	{
		this.position = new Position();
		this.oldPosition = new Position();
		this.nbDeplacement = 0;
	}

	public String getImageUrl()
	{
		return this.imageUrl;
	}
	
	
	
}
