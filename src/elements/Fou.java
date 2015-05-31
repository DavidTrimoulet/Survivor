package elements;

import Plateau.Position;
import Programme.GameController;
import Programme.Jeu;

public class Fou extends Personnage implements IsMovable , IsEatable{

	public Fou(int posX, int posY) {
		super();
		this.imageUrl = "src/Images/fou.jpg";
		this.position.setPosX(posX);
		this.position.setPosY(posY);
		this.nom = "F";
		this.direction = Direction.BOTTOM;
	}

	@Override
	public Position moveTo(Position position) {
		this.oldPosition.setPosX(this.position.getPosX());
		this.oldPosition.setPosY(this.position.getPosY());
		
		int alea = GameController.rand.nextInt(4);
		int x=0;
		int y=0;
		
	 	switch(alea)
	 	{
	 	case 1 :
	 		x=position.getPosX()-1;
	 		y=position.getPosY();
	 		break;
	 	case 2 :
	 		x=position.getPosX();
	 		y=position.getPosY()-1;
	 		break;
	 	case 3 :
	 		x=position.getPosX()+1;
	 		y=position.getPosY();
	 		break;
	 	case 0 :
	 		x=position.getPosX();
	 		y=position.getPosY()+1;
	 		break;
	 	}
	 	if(x < 0)
	 	{
	 		x= 0;
	 	}
	 	
	 	if(y < 0)
	 	{
	 		y= 0;
	 	}
	 	
	 	if(x > GameController.grille-1)
	 	{
	 		x = GameController.grille-1;
	 	}
	 	
	 	if(y > GameController.grille-1)
	 	{
	 		y = GameController.grille-1;
	 	}
	 	
	 	this.position.setPosX(x);
	 	this.position.setPosY(y);
	 	
	 	
		return this.position;
	}

	@Override
	public void beEaten() {
		this.vivant = false;
		
	}
	
	

}
