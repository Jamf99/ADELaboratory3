package structures;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BSTNode <K extends Comparable, V> implements Comparable, Serializable{

	protected K key;
	protected V value;
	protected int hight;
	protected BSTNode<K,V> Father;
	protected BSTNode<K,V> right;
	protected BSTNode<K,V> Left;
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

	public BSTNode<K, V> getFather() {
		return Father;
	}

	public void setFather(BSTNode<K, V> Father) {
		this.Father = Father;
	}

	public BSTNode<K, V> getRight() {
		return right;
	}

	public void setRight(BSTNode<K, V> right) {
		this.right = right;
	}

	public BSTNode<K, V> getLeft() {
		return Left;
	}

	public void setLeft(BSTNode<K, V> Left) {
		this.Left = Left;
	}

	public BSTNode<K, V> getClon() {
		return clon;
	}

	public void setClon(BSTNode<K, V> clon) {
		this.clon = clon;
	}
	
	public void actualizarhight() {
		if(right==null && Left==null) {
			hight=-1;
		}else if(right==null) {
			hight=Left.hight;
		}else if(Left==null) {
			hight=right.hight;
		}else {
			hight=Math.max(right.hight,Left.hight);
		}
		hight++;
	}
	
	public void Preorder(ArrayList<V> e) {
		e.add(getValue());
		if(Left.getValue() != null) {
			Left.Preorder(e);
		}
		if(right.getValue() != null) {
			right.Preorder(e); 
		}
	}
		
	@Override
	public int compareTo(Object o) {
		return key.compareTo(((BSTNode)o).key);
	}
	
}