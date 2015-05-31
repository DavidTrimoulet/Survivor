package Affichage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

import Plateau.Plateau;

public class DessinBot extends Canvas {

	private int colonne;
	private int ligne;
	private Plateau monPlateau;

	public void InitJeuPan(int hauteur, int largeur, Plateau monPlateau) {
		
		this.monPlateau = monPlateau;
		this.colonne = largeur;
		this.ligne = hauteur;
			
	}
	
	public void paint(Graphics g)
	{
	
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
			g.drawString(((IsAffichable)this.monPlateau.getCases()[i][j].getContent()).getImageUrl(), i*(this.getWidth()/colonne), j*(this.getHeight()/ligne));
			g.setColor(Color.black);
			}
		}
	}

	public void repaint(Graphics g)
	{
	
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
			g.drawString(((IsAffichable)this.monPlateau.getCases()[i][j].getContent()).getImageUrl(), i*(this.getWidth()/colonne), j*(this.getHeight()/ligne));
			g.setColor(Color.black);
			}
		}
	}
}
