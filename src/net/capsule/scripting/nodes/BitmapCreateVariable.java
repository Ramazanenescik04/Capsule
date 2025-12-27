package net.capsule.scripting.nodes;

import java.util.ArrayList;

import com.jvisualscripting.Node;
import com.jvisualscripting.Pin.PinMode;

import me.ramazanenescik04.diken.resource.Bitmap;
import net.capsule.scripting.pins.BitmapPin;

public class BitmapCreateVariable extends Node {
	
	private Bitmap bitmap;

	public BitmapCreateVariable() {
		super("bitmap");
		this.bitmap = new Bitmap(64, 64);
		this.outputs = new ArrayList<>(1);
        this.outputs.add(new BitmapPin(this, "", PinMode.OUTPUT));
	}

	public BitmapCreateVariable(Bitmap bitmap) {
		this();
		this.bitmap = bitmap;
	}
	
	public Bitmap getValue() {
		return bitmap;
	}
	
	public void setValue(Bitmap value) {
        this.bitmap = value;

        
    }

	@Override
	public boolean execute() {
		return true;
	}

	@Override
	public boolean canBeExecuted() {
		return true;
	}

}
