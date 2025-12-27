package net.capsule.game;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import me.ramazanenescik04.diken.game.World;
import me.ramazanenescik04.diken.gui.compoment.*;
import me.ramazanenescik04.diken.gui.screen.Screen;
import me.ramazanenescik04.diken.resource.Bitmap;
import net.capsule.Capsule;

public class GameScreen extends Screen {
	
	private Panel pausePanel;
	private TextField chatBar;
	private boolean chatBarEnabled, pauseMenuEnabled;
	
	public World theWorld;
	
	private List<String> chatMessageList;
	
	public void openScreen() {
		chatMessageList = new ArrayList<>();
		chatBar = new TextField(2, engine.getHeight() - 22, engine.getWidth() - 2, 20);
		pausePanel = new Panel(0, 0, engine.getWidth(), engine.getHeight());
		initPausePanel();
	}
	
	private void initPausePanel() {
		Button resumeButton = new Button("Resume The Game", 0, 0, 100, 20).setRunnable(() -> {
			this.pauseMenuEnabled = false;
			this.getContentPane().remove(pausePanel);
		}).setButtonColor(0xff005cff);
		pausePanel.add(resumeButton);
	}
	
	public void resized() {
		chatBar.setBounds(2, engine.getHeight() - 22, engine.getWidth() - 2, 20);
		pausePanel.setSize(engine.getWidth(), engine.getHeight());
	}
	
	@Override
	public void render(Bitmap bitmap) {
		super.render(bitmap);
		
		for (int i = 0; i < this.chatMessageList.size(); i++) {
			String text = this.chatMessageList.get(i);
			bitmap.drawText(text, 2, this.engine.getHeight() - (i * 9) - 35, false);
		}
	}

	@Override
	public void keyDown(char eventCharacter, int eventKey) {
		super.keyDown(eventCharacter, eventKey);
		
		if (!chatBarEnabled && !pauseMenuEnabled) {
			if (eventKey == Keyboard.KEY_DIVIDE) {
				this.getContentPane().add(chatBar);
				chatBarEnabled = true;
			} else if (eventKey == Keyboard.KEY_ESCAPE) {
				this.getContentPane().add(pausePanel);
				pauseMenuEnabled = true;
			}
		} else if (chatBarEnabled && !pauseMenuEnabled) {
			if (eventKey == Keyboard.KEY_ESCAPE || eventKey == Keyboard.KEY_RETURN) {
				if (eventKey == Keyboard.KEY_RETURN) {
					sendMessage(Capsule.instance.account.getUsername() + ": " + chatBar.text);
				}
				
				chatBarEnabled = false;
				chatBar.text = "";
				this.getContentPane().remove(chatBar);
			}
		} else if (!chatBarEnabled && pauseMenuEnabled) {
			if (eventKey == Keyboard.KEY_ESCAPE) {
				this.getContentPane().remove(pausePanel);
				pauseMenuEnabled = false;
			}
		}
	}
	
	public void sendMessage(String message) {
		this.chatMessageList.add(0, message);

		while(this.chatMessageList.size() > 50) {
			this.chatMessageList.remove(this.chatMessageList.size() - 1);
		}
	}

}
