package elements;

import Plateau.Position;
import Programme.GameController;
import Programme.Jeu;

public class Garde extends Personnage implements IsMovable {

	private int sensDePatrouille;
	
	public Garde(int posX, int posY)
	{
		super();
		this.imageUrl = "src/Images/keeper.jpg";
		this.direction = Direction.BOTTOM;
		this.position.setPosX(posX);
		this.position.setPosY(posY);
		this.nom = "G";
		this.sensDePatrouille = 1;
		
	}
	
	
	
	
	@Override
	public Position moveTo(Position position) {
		int x;
		
		
		
		if(this.oldPosition.getPosX() == position.getPosX())
		{
			this.sensDePatrouille = this.sensDePatrouille*(-1);
		}
		
		if(sensDePatrouille == 1)
		{
			x = position.getPosX()+1;
		}
		else
		{
			x = position.getPosX()-1;
		}
		if(x < 0)
	 	{
	 		x= 0;
	 	}
	 		 	
	 	if(x > GameController.grille-1)
	 	{
	 		x = GameController.grille-1;
	 	}
	 	
	 	
	 	this.oldPosition.setPosY(position.getPosY());
	 	this.oldPosition.setPosX(position.getPosX());
	 	this.position.setPosX(x);
	 	this.position.setPosY(position.getPosY());
		
		return this.position;
	}

}
