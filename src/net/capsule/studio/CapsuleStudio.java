package net.capsule.studio;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JDesktopPane;

public class CapsuleStudio extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CapsuleStudio() {
		this.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		this.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mnıtmNewCapsuleproject = new JMenuItem("New Capsule Project");
		mnFile.add(mnıtmNewCapsuleproject);
		
		JMenuItem mnıtmOpenCapsuleProject = new JMenuItem("Open Capsule Project");
		mnFile.add(mnıtmOpenCapsuleProject);
		
		JDesktopPane desktopPane = new JDesktopPane();
		add(desktopPane, BorderLayout.CENTER);
		
		CapsuleGamePreview gamePreview = new CapsuleGamePreview("ExampleGame.capsule");
		desktopPane.add(gamePreview);
		gamePreview.setVisible(true);
		gamePreview.startPreview();
	}
}
