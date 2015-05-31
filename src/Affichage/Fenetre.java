package Affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Plateau.Plateau;
import Programme.PlayerControl;
import Programme.UiController;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ConfPan confPan;
	private Plateau monPlateau;
	private JeuPan jeuPan;
	private JeuCanvas jeuCan;
	private JPanel container;
	
	public Fenetre(PlayerControl playerControl, UiController uiControl)
	{
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.monPlateau = monPlateau;
		this.setSize(new Dimension(800, 800));
		this.setTitle("Tuteur Survivor");
		container = new JPanel();
		//container.setBorder(BorderFactory.createLineBorder(Color.BLUE, 10));
		container.setSize(new Dimension(800, 800));
		container.setLayout(null);
		this.setFocusable(true);
		this.jeuCan = new JeuCanvas();
		this.confPan = new ConfPan(uiControl);
		this.jeuPan = new JeuPan();
		
		//this.playerControl = new PlayerControl();
		
		//Conf du panneau de conf
		this.confPan.setBounds(10, 10, 200, 150);
		this.confPan.setSize(new Dimension(200,150));
		this.confPan.setPreferredSize(new Dimension(200,150));
		this.confPan.setLayout(new BoxLayout(confPan, BoxLayout.Y_AXIS));
		
		this.jeuCan.setSize(new Dimension(this.getWidth()-this.confPan.getWidth()-30,this.getWidth()-this.confPan.getWidth()-30));
		this.jeuCan.setBounds(confPan.getWidth()+10, 10, (this.getWidth()-this.confPan.getWidth()-30), (this.getWidth()-this.confPan.getWidth()-30));
			
		//Ajout des controls utilisateurs
		this.getContentPane().add(container);
		this.container.add(confPan);
		this.addKeyListener(playerControl);
		
		
	}
	
	public void addPlateau(Plateau monPlateau)
	{
		//Conf du panneau de jeu
				this.monPlateau = monPlateau;
				this.jeuCan.setLayout(new GridLayout(monPlateau.getHauteur(), monPlateau.getLargeur()));
				this.jeuCan.InitJeuPan(monPlateau.getHauteur(), monPlateau.getLargeur(), monPlateau);
				this.jeuCan.setFocusable(true);
				this.container.add(jeuCan);
	}


	public void UpdateTab() {
		
		this.jeuCan.setBounds(confPan.getWidth()+10, 10, (this.getWidth()-this.confPan.getWidth()-30), (this.getWidth()-this.confPan.getWidth()-30));
		this.jeuCan.updatePan(monPlateau);
		//this.jeuPan.updatePan();
		//this.mesBots.repaint(NORMAL);
		
	}


	public int[] getConfig() {
		
		return this.confPan.getConfig();
	}
}
