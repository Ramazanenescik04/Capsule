package net.capsule.scripting.pins;

import com.jvisualscripting.DataPin;
import com.jvisualscripting.Node;
import com.jvisualscripting.Pin;

import net.capsule.scripting.nodes.BitmapCreateVariable;

public class BitmapPin extends DataPin {

	public BitmapPin() {
	}

	public BitmapPin(Node node, String name, PinMode mode) {
		super(node, name, mode);
	}
	
	public boolean canConnectPin(Pin pin) {
		boolean b = super.canConnectPin(pin);
		if (!b) {
			return false;
		}
		return pin instanceof BitmapPin;
	}

	@Override
	public Node createCompatibleVariableNode() {
		return new BitmapCreateVariable();
	}

}
