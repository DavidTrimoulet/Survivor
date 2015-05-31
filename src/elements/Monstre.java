package elements;

import Plateau.Position;
import Programme.GameController;
import Programme.Jeu;

public class Monstre extends Personnage implements IsMovable, IsMortel, gotEye{
	
	private Element target;
	
	public Monstre(int posX, int posY)
	{
		super();
		this.imageUrl = "src/Images/monstre.jpg";
		this.direction = Direction.BOTTOM;
		this.position.setPosX(posX);
		this.position.setPosY(posY);
		this.nom = "A";
		this.range = new Range(2,2);
		this.vision =  new Element[(this.range.getRangeX()*2)+1][(this.range.getRangeY()*2)+1];
		this.target = null;
	}

	public Position moveTo(Position position) {
		
		this.oldPosition.setPosX(this.position.getPosX());
		this.oldPosition.setPosY(this.position.getPosY());
		
		
		int x= 0;
		int y= 0;
		this.target = null;
		
		if(this.target == null)
		{
		for(int i=0; i < ( this.range.getRangeX()*2)+1 ; i++)
		{
			for(int j = 0 ; j <( this.range.getRangeY()*2)+1; j++)
			{
		
				if(this.vision[i][j] instanceof IsEatable && target == null)
				{
					this.target = this.vision[i][j];
					//System.out.println(this.target);
				}
			}
		}
		}
		
		if(this.target != null)
	 	{
			if(this.target.getPosition().getPosX() < this.position.getPosX() && (vision[range.getRangeX()-1][range.getRangeY()] instanceof Sol || vision[range.getRangeX()-1][range.getRangeY()] instanceof IsEatable))
			{
				x = position.getPosX()-1;
		 		y = position.getPosY();
			}
			else if(this.target.getPosition().getPosX() > this.position.getPosX() && (vision[range.getRangeX()+1][range.getRangeY()] instanceof Sol || vision[range.getRangeX()+1][range.getRangeY()] instanceof IsEatable))
			{
				x = position.getPosX()+1;
		 		y = position.getPosY();
			}
			else
			{
				if(this.target.getPosition().getPosY() < this.position.getPosY() && (vision[range.getRangeX()][range.getRangeY()-1] instanceof Sol || vision[range.getRangeX()-1][range.getRangeY()-1] instanceof IsEatable))
				{
					x = position.getPosX();
			 		y = position.getPosY()-1;
				}
				else if(this.target.getPosition().getPosY() > this.position.getPosY() && (vision[range.getRangeX()][range.getRangeY()+1] instanceof Sol || vision[range.getRangeX()][range.getRangeY()+1] instanceof IsEatable))
				{
					x = position.getPosX();
			 		y = position.getPosY()+1;
				}
				else
				{
					x = position.getPosX();
			 		y = position.getPosY();
						
				}
			}
			
			if(target.getPosition().getPosX() == x && target.getPosition().getPosY() == y )
			{
				//System.out.println("Croc");
				this.target = null;
				//((IsEatable)this.target).beEaten();
			}
	 	}
		else
		{
			x = position.getPosX();
	 		y = position.getPosY();
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
	 	
	 	//System.out.println(this.target);
		return this.position;
	}

	@Override
	public void kill(Personnage personnage) {
		
		
	}

	@Override
	public void getVision() {
		
		
	}

	@Override
	public Range getVisionRange() {
		
		return range;
	}

	@Override
	public void setVision(Element[][] caseVision) {
		this.vision = caseVision;
		
	}

}
