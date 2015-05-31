package Plateau;

import Programme.GameController;
import Programme.Jeu;
import elements.Element;
import elements.IsEatable;
import elements.IsMortel;
import elements.IsMovable;
import elements.Personnage;
import elements.Sol;
import elements.gotEye;

public class Plateau {
	
	private Case[][] cases;
	
	private int hauteur;
	private int largeur;
	private int nbTour = 0;

	private int monstreMax;
	private int heroMax;
	private int nbrGarde;
	private int nbrFou;
	
	
	public int getHauteur() {
		return hauteur;
	}


	public int getLargeur() {
		return largeur;
	}

		
	public Case[][] getCases() {
		return cases;
	}

	public Plateau(int hauteur, int largeur, int bot, int monstres)
	{
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.cases = new Case[hauteur][largeur];
		this.heroMax = bot;
		this.nbrGarde = bot;
		this.nbrFou = bot;
		this.monstreMax = monstres;
		//this.persos = new LinkedList<Personnage>();
	}
	
	
	public void InitPlateau()
	{
		int alea ;
		//Initialisation du plateau (Mur, sol, Rocher)
		for(int i = 0 ; i<this.hauteur ; i++)
		{
			for(int j = 0 ; j<this.largeur ; j++)
			{
				alea = GameController.rand.nextInt(10);
				
				
				switch (alea) {
				case 1:
					this.cases[i][j] = new Case("Mur" , i, j);
					break;
					
				case 2:
					this.cases[i][j] = new Case("Rocher" , i, j);
					break;

									
				default:
					this.cases[i][j] = new Case("Sol" , i, j);
					break;
				}
				
			}
		}
		//Positionement des héros sur la grille si c'est du sol
		int i = 0;
		int aleaH;
		int aleaL;
		
		
		do
		{
			aleaH = GameController.rand.nextInt(this.hauteur);
			aleaL = GameController.rand.nextInt(this.largeur);
			if(this.cases[aleaH][aleaL].getContent().getNom() == " " )
			{
				this.cases[aleaH][aleaL] = new Case("Hero", aleaH, aleaL);
				i++;
		}
			
		}while(i<heroMax);
		
		i = 0;
		
		do
		{
			aleaH = GameController.rand.nextInt(this.hauteur);
			aleaL = GameController.rand.nextInt(this.largeur);
			if(this.cases[aleaH][aleaL].getContent().getNom() == " " )
			{
				this.cases[aleaH][aleaL] = new Case("Monstre", aleaH, aleaL);
				i++;
			}
			
		}while(i<monstreMax);
		
		i = 0;
		do
		{
			aleaH = GameController.rand.nextInt(this.hauteur);
			aleaL = GameController.rand.nextInt(this.largeur);
			if(this.cases[aleaH][aleaL].getContent().getNom() == " " )
			{
				this.cases[aleaH][aleaL] = new Case("fou", aleaH, aleaL);
				i++;
			}
			
		}while(i<nbrFou);
		
		i = 0;
		do
		{
			aleaH = GameController.rand.nextInt(this.hauteur);
			aleaL = GameController.rand.nextInt(this.largeur);
			if(this.cases[aleaH][aleaL].getContent().getNom() == " " )
			{
				this.cases[aleaH][aleaL] = new Case("garde", aleaH, aleaL);
				i++;
			}
			
		}while(i<nbrGarde);
	}
	
	
	public void updatePlateau()
	{
		Position position = new Position();
		int toursuivant = this.nbTour + 1;
				
		for(int i = 0 ; i<this.hauteur ; i++)
		{
			for(int j = 0 ; j<this.largeur ; j++)
			{
				if(this.cases[i][j].getContent() instanceof gotEye )
				{
				int rangeX = ((gotEye)this.cases[i][j].getContent()).getVisionRange().getRangeX();
				int rangeY = ((gotEye)this.cases[i][j].getContent()).getVisionRange().getRangeY();
				Element[][] CasesVision = new Element[(rangeX*2)+1][(rangeY*2)+1];
				
				int curseurY=0;
				int curseurX=0;
				for(int k=rangeX*-1; k <= rangeX; k++)
				{
					curseurY=0;
					for(int m=rangeY*-1;m <= rangeY; m++)
					{
						
						if(i+k < 0| i+k > GameController.grille-1 | j+m < 0 | j+m > GameController.grille-1)
						{
							CasesVision[curseurX][curseurY] = null;
						}
						else
						{
							CasesVision[curseurX][curseurY] = cases[(i+k)][(j+m)].getContent();	
						}
						
					curseurY++;
					}
				curseurX++;
				}
				
					((gotEye)this.cases[i][j].getContent()).setVision(CasesVision);
				}
				
				position.setPosX(i);
				position.setPosY(j);
				
				if(this.cases[i][j].getContent() instanceof IsMovable && ((Personnage)this.cases[i][j].getContent()).getNbDeplacement() < nbTour)
				{
									
				 		position = ((IsMovable)this.cases[i][j].getContent()).moveTo(position);
				 				
						//Si on bouge de case
						if(this.cases[i][j] != this.cases[position.getPosX()][position.getPosY()])
						{
							//Si le contenu est bien du Sol.
							if(cases[position.getPosX()][position.getPosY()].getContent() instanceof Sol || ( cases[i][j].getContent() instanceof IsMortel && cases[position.getPosX()][position.getPosY()].getContent() instanceof IsEatable ))
							{
								((Personnage)this.cases[i][j].getContent()).setNbDeplacement(toursuivant);
								this.cases[position.getPosX()][position.getPosY()].setContent(this.cases[i][j].getContent());
								this.cases[i][j].setContent(new Sol());
							}
							
						}
				}
				
			}
				
		}
		this.nbTour = toursuivant;
	}
}
