package Affichage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elements.IsMovable;
import Plateau.Plateau;

public class JeuPan extends JPanel {
	
	private JLabel[][] cases;
	private int colonne;
	private int ligne;
	private Plateau monPlateau;
	
	public JeuPan()
	{
	
	}
	
	public void InitJeuPan(int ligne, int colonne,Plateau monPlateau)
	{
		this.colonne = colonne;
		this.ligne = ligne;
		this.monPlateau = monPlateau;
		cases = new JLabel[ligne][colonne];
		
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
				this.cases[i][j] = new JLabel();
				this.cases[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				this.cases[i][j].setSize(new Dimension(this.getHeight()/colonne, this.getWidth()/colonne));
				this.cases[i][j].setText(((IsAffichable)monPlateau.getCases()[i][j].getContent()).getImageUrl());
				//this.cases[i][j].setText("  ");
				this.cases[i][j].setOpaque(true);
				
				this.add(cases[i][j]);
			}
		}
	}

	public void updatePan() {
		
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
			
					this.cases[i][j].setText(((IsAffichable)monPlateau.getCases()[i][j].getContent()).getImageUrl());
					this.cases[i][j].setBackground(((IsAffichable)monPlateau.getCases()[i][j].getContent()).getColor());
					
								
			}
		}
	}
}

