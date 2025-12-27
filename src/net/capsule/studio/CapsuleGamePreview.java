package net.capsule.studio;

import java.awt.Canvas;

import javax.swing.JInternalFrame;

public class CapsuleGamePreview extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	public CapsuleGamePreview(String gamePath) {
		setTitle("Game Preview - " + gamePath);
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setBounds(50, 50, 800, 600);
		
		Canvas canvas = new Canvas();
		
		getContentPane().add(canvas);
	}
	
	public void startPreview() {
		;
	}
	
	public void stopPreview() {
		;
	}

}
