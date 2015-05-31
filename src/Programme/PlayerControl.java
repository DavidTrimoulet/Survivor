package Programme;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerControl implements KeyListener {

	private KeyEvent lastHitKey;
	private GameController gameController;
	
	public PlayerControl(GameController gameController)
	{
		this.gameController = gameController;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == 32 && !this.gameController.isPasapas())
		{
			this.gameController.setPasapas(true);
		}
		else if(e.getKeyCode() == 32 && this.gameController.isPasapas())
		{
			this.gameController.updateGame();
		}
		
		if(e.getKeyCode() == 10 && this.gameController.isPasapas())
		{
			this.gameController.setPasapas(false);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key realeased = " + KeyEvent.getKeyText(e.getKeyCode()) + e.getKeyCode() );
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key typed? = " + KeyEvent.getKeyText(e.getKeyCode()) );
	}

}
