package Affichage;

import java.util.Scanner;

import Plateau.Plateau;

public class AfficheConsole {
	private Scanner sc;
	
	public void configuration(int[] config) {
		
		this.sc = new Scanner(System.in);
		System.out.println("Welcome to config");
		System.out.println("Taille du plateau?");
		config[0]=sc.nextInt();
		System.out.println("Nombre de Heros");
		config[1]=sc.nextInt();
		System.out.println("Nombre de Monstres");
		config[2]=sc.nextInt();
	}
	
	public void afficheTableau(Plateau plateau)
	{
		for(int i = 0 ;i<plateau.getHauteur();i++)
		{
			for(int j = 0; j<plateau.getLargeur();j++)
			{
				if(plateau.getCases()[i][j].getContent() instanceof IsAffichable)
				{
					System.out.print(((IsAffichable)plateau.getCases()[i][j].getContent()).getNom());
				}
			}
			System.out.print("\n");
		}
	}
	
	

}
