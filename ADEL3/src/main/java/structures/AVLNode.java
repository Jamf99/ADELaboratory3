package structures;

import java.io.Serializable;

public class AVLNode<K, V> extends BSTNode implements Serializable {

	private int balanceFactor;

	public AVLNode(K llave, V valor) {
		super((Comparable) llave, valor);
		balanceFactor = 0;	
	}

	public int balanceFactor() {
		if (right == null && Left == null) {

		}
		return balanceFactor;
	}

	public void setBalanceFactor(int t) {
		balanceFactor = t;
	}

	public void UpdateFactorBalance() {
		if (right == null && Left == null) {
			balanceFactor = 0;
		} else if (right == null) {
			balanceFactor = Left.hight;
			} else if (Left == null) {
			balanceFactor = -right.hight;
		} else {
			balanceFactor = Left.hight - right.hight;
		}
	}

	public void recorrerSubArbol(String string, AVLNode nil) {
		System.out.println(string + "color: " + getValue() + " " + key);
		if (Left != nil)
			((AVLNode) Left).recorrerSubArbol(string + "L", nil);
		if (right != nil)
			((AVLNode) right).recorrerSubArbol(string + "R", nil);
	}
}