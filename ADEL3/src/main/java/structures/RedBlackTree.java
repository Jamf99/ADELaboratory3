package structures;

import java.io.Serializable;
import java.util.ArrayList;

//import java.util.ArrayList;

public class RedBlackTree<K extends Comparable,V> extends BST<K,V> implements Serializable{
	
	public RedBlackTree(){
		super();
		nil=new RBTNode<>(null,null);
		nil.setPadre(nil);
		nil.setDerecho(nil);
		nil.setIzquierdo(nil);
		((RBTNode<K, V>) nil).setColor(Color.BLACK);
		raiz=nil;
	}
	
	@Override
	public void insert(K key, V value) {
		if(key!=null && value!=null) {
			RBTNode<K,V> z =new RBTNode<K,V>(key,value);
			insert(z);
			insertFixeUp(z);
		}
	}
	
	private void insertFixeUp(RBTNode<K, V> z) {
		while(((RBTNode<K, V>) z.getPadre()).getColor()==Color.RED){
			if(z.getPadre()==z.getPadre().getPadre().getIzquierdo()){
				RBTNode<K,V> y =(RBTNode<K, V>) z.getPadre().getPadre().getDerecho();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getPadre().getPadre();
				}else if(z==z.getPadre().getDerecho()){
					z=(RBTNode<K, V>) z.getPadre();
					leftRotate(z);
				}else{
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					rightRotate(z.getPadre().getPadre());
				}
			}else{
				RBTNode<K,V> y =(RBTNode<K, V>) z.getPadre().getPadre().getIzquierdo();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getPadre().getPadre();
				}else if(z==z.getPadre().getIzquierdo()){
					z=(RBTNode<K, V>) z.getPadre();
					rightRotate(z);
				}else{
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					leftRotate(z.getPadre().getPadre());
				}
			}
		}
		((RBTNode<K, V>) raiz).setColor(Color.BLACK);
	}
	
	private void deleteFixeUp(RBTNode<K,V> x) {
		while(x!=raiz && x.getColor()==Color.BLACK) {
			if(x==x.getPadre().getIzquierdo()) {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getPadre().getDerecho();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getPadre()).setColor(Color.RED);
					leftRotate(x.getPadre());
					w=((RBTNode<K,V>)x.getPadre().getDerecho());
				}
				if(((RBTNode<K,V>)w.getIzquierdo()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getDerecho()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getPadre();
				}else{
					if(((RBTNode<K,V>)w.getDerecho()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getIzquierdo()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w=(RBTNode<K, V>) x.getPadre().getDerecho();
					}
					w.setColor(((RBTNode<K, V>)x.getPadre()).getColor());
					((RBTNode<K, V>)x.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>)w.getDerecho()).setColor(Color.BLACK);
					leftRotate(x.getPadre());
					x=(RBTNode<K, V>) raiz;
				}
			}else {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getPadre().getIzquierdo();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getPadre()).setColor(Color.RED);
					rightRotate(x.getPadre());
					w=((RBTNode<K,V>)x.getPadre().getIzquierdo());
				}
				if(((RBTNode<K,V>)w.getDerecho()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getIzquierdo()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getPadre();
				}else {
					if(((RBTNode<K,V>)w.getIzquierdo()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getDerecho()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						leftRotate(w);
						w=(RBTNode<K, V>) x.getPadre().getIzquierdo();
					}
					w.setColor(((RBTNode<K, V>)x.getPadre()).getColor());
					((RBTNode<K, V>)x.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>)w.getIzquierdo()).setColor(Color.BLACK);
					rightRotate(x.getPadre());
					x=(RBTNode<K, V>) raiz;
				}
			}
		}
		x.setColor(Color.BLACK);
	}
	@Override
	public BSTNode<K, V> delete(K key) {
		BSTNode<K,V>z=consultar(key);
		BSTNode[] params=null;
		if(z!=null) {
			params=delete(z);
		}else {
			return null;
		}
		if(((RBTNode)params[1]).getColor()==Color.BLACK) {
			deleteFixeUp((RBTNode)params[0]);
		}
		return params[1];
	}

	public ArrayList<V> getElements() {
		if(raiz == null) {
			return null;
		}else {
			ArrayList<V> elements = new ArrayList<V>();
			raiz.ordenarPreorden(elements);
			return elements;
		}
	}

}