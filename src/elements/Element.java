package elements;

import java.awt.Color;

import Affichage.IsAffichable;
import Plateau.Position;

public class Element implements IsAffichable {

	protected String imageUrl;
	protected Position position;
	protected Position oldPosition;
	protected Color color;
	protected String nom; 

	public String getImageUrl() {
		return this.imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Position getOldPosition() {
		return oldPosition;
	}
	public void setOldPosition(Position oldPosition) {
		this.oldPosition = oldPosition;
	}
	
	public String getNom() {
		
		return this.nom;
	}
	@Override
	public Color getColor() {
		
		return this.color;
	}
	

}
