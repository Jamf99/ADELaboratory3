package structures;

import java.io.Serializable;

public class AVLNode<K,V> extends BSTNode implements Serializable{
	
	private int balanceFactor;
	
	public AVLNode(K llave, V valor){
		super((Comparable) llave,valor);
		balanceFactor=0;
	}
	public int balanceFactor() {
		if(derecho==null && izquierdo==null) {
			
		}
		return balanceFactor;
	}
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}
	public void actualizarFactorBalance() {
		if(derecho==null && izquierdo==null) {
			balanceFactor=0;
		}else if(derecho==null) {
			balanceFactor=izquierdo.altura;
		}else if(izquierdo==null) {
			balanceFactor=-derecho.altura;
		}else {
			balanceFactor=izquierdo.altura-derecho.altura;
		}
	}
	
	public void recorrerSubArbol(String string, AVLNode nil) {
		System.out.println(string+"color: "+getValue()+" "+key);
		if(izquierdo!=nil)
			((AVLNode)izquierdo).recorrerSubArbol(string+"L",nil);
		if(derecho!=nil)
			((AVLNode)derecho).recorrerSubArbol(string+"R",nil);
	}
}