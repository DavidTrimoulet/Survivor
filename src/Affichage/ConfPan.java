package Affichage;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Programme.UiController;

public class ConfPan extends JPanel {
	
	private JLabel menuLabel;
	private JLabel tailleTab;
	private JTextField tailleTabText;
	private JLabel nbHero;
	private JTextField nbHeroText;
	private JLabel nbMonstre;
	private JTextField nbMonstreText;
	private JButton butonStart;

	public ConfPan(UiController uiControl)
	{
		
		menuLabel = new JLabel();
		this.menuLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.menuLabel.setPreferredSize(new Dimension(100,20));
		this.menuLabel.setSize(100, 20);
		this.menuLabel.setText("Configuration du Jeu");
		this.add(menuLabel);
		
		tailleTab = new JLabel();
		this.tailleTab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.menuLabel.setPreferredSize(new Dimension(100,20));
		this.tailleTab.setSize(20, 20);
		this.tailleTab.setText("Taille du Tableau (10 - 100) ? ");
		this.add(tailleTab);
		
		tailleTabText = new JTextField();
		this.tailleTabText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.menuLabel.setPreferredSize(new Dimension(100,20));
		this.tailleTabText.setSize(20, 20);
		this.tailleTabText.setText("50");
		this.add(tailleTabText);
		
		nbHero = new JLabel();
		this.nbHero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.menuLabel.setPreferredSize(new Dimension(100,20));
		this.nbHero.setSize(20, 20);
		this.nbHero.setText("Nombre de bot ? ");
		this.add(nbHero);
		
		nbHeroText = new JTextField();
		this.nbHeroText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.menuLabel.setPreferredSize(new Dimension(100,20));
		this.nbHeroText.setSize(20, 20);
		this.nbHeroText.setText("10");
		this.add(nbHeroText);
		
		nbMonstre = new JLabel();
		this.nbMonstre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.nbMonstre.setPreferredSize(new Dimension(100,20));
		this.nbMonstre.setSize(100, 20);
		this.nbMonstre.setText("Nombre de bot ? ");
		this.add(nbMonstre);
		
		nbMonstreText = new JTextField();
		this.nbMonstreText.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.nbMonstreText.setPreferredSize(new Dimension(100,20));
		this.nbMonstreText.setSize(100, 20);
		this.nbMonstreText.setText("2");
		this.add(nbMonstreText);
		
		this.butonStart = new JButton("Start");
		this.butonStart.addActionListener(uiControl);
		this.add(butonStart);
		
	}

	public int[] getConfig() {
		
		int[] config = { Integer.parseInt(tailleTabText.getText()) , Integer.parseInt(nbHeroText.getText()) , Integer.parseInt(nbMonstreText.getText()) };
		return config;
	}
}
