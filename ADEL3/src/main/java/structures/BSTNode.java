package structures;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BSTNode <K extends Comparable, V> implements Comparable, Serializable{

	protected K key;
	protected V value;
	protected int altura;
	protected BSTNode<K,V> padre;
	protected BSTNode<K,V> derecho;
	protected BSTNode<K,V> izquierdo;
	protected BSTNode<K,V> clon;
	
	public BSTNode (K llave, V value) {
		this.key = llave;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public BSTNode<K, V> getPadre() {
		return padre;
	}

	public void setPadre(BSTNode<K, V> padre) {
		this.padre = padre;
	}

	public BSTNode<K, V> getDerecho() {
		return derecho;
	}

	public void setDerecho(BSTNode<K, V> derecho) {
		this.derecho = derecho;
	}

	public BSTNode<K, V> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(BSTNode<K, V> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public BSTNode<K, V> getClon() {
		return clon;
	}

	public void setClon(BSTNode<K, V> clon) {
		this.clon = clon;
	}
	public void actualizarAltura() {
		if(derecho==null && izquierdo==null) {
			altura=-1;
		}else if(derecho==null) {
			altura=izquierdo.altura;
		}else if(izquierdo==null) {
			altura=derecho.altura;
		}else {
			altura=Math.max(derecho.altura,izquierdo.altura);
		}
		altura++;
	}
	
	public void mostrarPreorden(ArrayList<V> e) {
		e.add(getValue());
		if(izquierdo != null) {
			izquierdo.mostrarPreorden(e);
		}
		if(derecho != null) {
			derecho.mostrarPreorden(e); 
		}
	}
		
	@Override
	public int compareTo(Object o) {
		return key.compareTo(((BSTNode)o).key);
	}
	
}