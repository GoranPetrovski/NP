package edu.finki.np.av9;

public class AdapterDemoAfter {
	public static void main(String[] args) {
		Shape[] shapes = { new Line(), new Rectangle() };
		// A begin and end point from a graphical editor
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (int i = 0; i < shapes.length; ++i)
			shapes[i].draw(x1, y1, x2, y2);
	}
}

interface Shape {
	void draw(int x1, int y1, int x2, int y2);
}

class Line implements Shape {
	private LegacyLine adaptee = new LegacyLine();

	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(x1, y1, x2, y2);
	}
}

class Rectangle implements Shape {
	private LegacyRectangle adaptee = new LegacyRectangle();

	public void draw(int x1, int y1, int x2, int y2) {
		adaptee.draw(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1),
				Math.abs(y2 - y1));
	}
}
