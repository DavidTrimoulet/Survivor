package Programme;

import java.util.Random;

import Affichage.AfficheConsole;
import Affichage.Fenetre;
import Plateau.Plateau;

public class GameController {

	
	public static boolean partie = true; 
	public static Random rand = new Random();
	public static int grille = 0;
	
	
	private int[] config;
	private Fenetre maFenetre ;
	private int speed;
	private long currentTime ;
	private long lastCurrentTime ;
	private AfficheConsole maConsole ;
	private PlayerControl playerControl;
	private UiController uiControl;
	private Plateau monPlateau;
	private boolean pasapas;
	
	public boolean isPasapas() {
		return pasapas;
	}

	public void setPasapas(boolean pasapas) {
		this.pasapas = pasapas;
	}

	public GameController()
	{
		this.config = new int[3];
		this.maFenetre = null;
		this.currentTime = 1000;
		this.speed = 16;
		this.lastCurrentTime = 0 ;
		this.playerControl = new PlayerControl(this);
		this.uiControl = new UiController(this);
		this.pasapas = false;
		
	}
	
	public void initUI()
	{
		if(maFenetre == null)
		{
			maFenetre = new Fenetre(playerControl,uiControl);
			maFenetre.setVisible(true);
		}
		
		
	}
	
	public void initGame()
	{
		this.config = this.maFenetre.getConfig();
		GameController.grille = config[0];
		this.monPlateau = new Plateau(config[0], config[0], config[1], config[2]);
		this.monPlateau.InitPlateau();
		this.maFenetre.addPlateau(monPlateau);
		
	}
	
	
	public void launchGame()
	{
		if(pasapas == false)
		{
			do
			{
				
				if(currentTime - lastCurrentTime > (1000/speed) && pasapas == false )
				{
					this.updateGame();
					
				}
				currentTime = System.currentTimeMillis();
				
			}while(partie==true && pasapas == false);

			//maFenetre.affichePersos(monPlateau);
		}
		
		
	}
	
	public void updateGame()
	{
		monPlateau.updatePlateau();
		//maConsole.afficheTableau(monPlateau);
		maFenetre.UpdateTab();
		lastCurrentTime = currentTime;
	}
	
	
	
	
}
