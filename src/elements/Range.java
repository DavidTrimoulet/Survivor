
package elements;

public class Range {

	private int rangeX;
	private int rangeY;
	
	public int getRangeX() {
		return rangeX;
	}
	public void setRangeX(int rangeX) {
		this.rangeX = rangeX;
	}

	public int getRangeY() {
		return rangeY;
	}
	public void setRangeY(int rangeY) {
		this.rangeY = rangeY;
	}
	
	public Range(int x, int y)
	{
		this.rangeX = x;
		this.rangeY = y;
	}
	
	
}