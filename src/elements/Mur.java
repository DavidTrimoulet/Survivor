package elements;

import java.awt.Color;

import Affichage.IsAffichable;

public class Mur extends Decors implements IsAffichable{

	public Mur()
	{
		this.color = Color.BLACK;
		this.imageUrl = "src/Images/mur.png";
		this.nom = "M";
	}

	@Override
	public Color getColor() {
		return this.color;
	}
}
