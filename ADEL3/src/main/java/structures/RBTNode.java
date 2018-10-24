package structures;

import java.io.Serializable;

enum Color{
	BLACK,RED
}

public class RBTNode<K extends Comparable,V> extends BSTNode implements Serializable{
	
	private Color color;
	public RBTNode(K llave, V valor){
		super(llave,valor);
		color=Color.RED;
	}
	public void recorrerSubArbol(String string, BSTNode<K,V> nil) {

		if(Left!=nil)
			((RBTNode)Left).recorrerSubArbol(string+"L",nil);
		if(right!=nil)
			((RBTNode)right).recorrerSubArbol(string+"R",nil);
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}