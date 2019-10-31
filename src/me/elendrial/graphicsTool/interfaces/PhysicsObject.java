package me.elendrial.graphicsTool.interfaces;

import me.elendrial.graphicsTool.types.Vector;

public interface PhysicsObject extends GraphicsObject{

	public void translate(Vector amount);
	public void rotate(Vector about, double radians);
	
}
