package Affichage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Plateau.Plateau;

public class JeuCanvas extends JPanel{
	
	private int colonne;
	private int ligne;
	private Plateau monPlateau;
	private BufferedImage image;
	private FileInputStream file;
	private HashMap<String, BufferedImage> listeImage;
	

	public void InitJeuPan(int hauteur, int largeur, Plateau monPlateau) {
		
		this.monPlateau = monPlateau;
		this.colonne = largeur;
		this.ligne = hauteur;
		this.listeImage = new HashMap<String, BufferedImage>();
		
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
			
			try {
			
			//System.out.println(this.monPlateau.getCases()[i][j].getContent().getImageUrl());
			this.file = new FileInputStream(this.monPlateau.getCases()[i][j].getContent().getImageUrl());
			image = ImageIO.read(file);
			if(listeImage.containsKey(this.monPlateau.getCases()[i][j].getContent().getNom()))
			{
				
			}
			else
			{
				this.listeImage.put(this.monPlateau.getCases()[i][j].getContent().getNom(), image);
			}
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
	}
			
	
	
	public void paintComponent(Graphics g)
	{
		System.out.println(this.getWidth() +" "+ this.getHeight());
		for(int i = 0; i < colonne; i++)
		{
			for(int j = 0 ; j < ligne ; j++)
			{
			
			image = this.listeImage.get(this.monPlateau.getCases()[i][j].getContent().getNom());
			g.drawImage(image, i*(this.getWidth()/colonne), j*(this.getHeight()/ligne), this.getWidth()/colonne, this.getHeight()/ligne, null);
			}
		}
	}

	public void updatePan(Plateau monPlateau) {
		this.repaint();
	}
	

}
