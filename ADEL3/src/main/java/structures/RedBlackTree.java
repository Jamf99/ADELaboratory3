package structures;

import java.io.Serializable;
import java.util.ArrayList;


public class RedBlackTree<K extends Comparable,V> extends BST<K,V> implements Serializable{
	
	public RedBlackTree(){
		super();
		nil=new RBTNode<>(null,null);
		nil.setFather(nil);
		nil.setRight(nil);
		nil.setLeft(nil);
		((RBTNode<K, V>) nil).setColor(Color.BLACK);
		root=nil;
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
		while(((RBTNode<K, V>) z.getFather()).getColor()==Color.RED){
			if(z.getFather()==z.getFather().getFather().getLeft()){
				RBTNode<K,V> y =(RBTNode<K, V>) z.getFather().getFather().getRight();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getFather()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getFather().getFather()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getFather().getFather();
				}else if(z==z.getFather().getRight()){
					z=(RBTNode<K, V>) z.getFather();
					LeftRotate(z);
				}else{
					((RBTNode<K, V>) z.getFather()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getFather().getFather()).setColor(Color.RED);
					rightRotate(z.getFather().getFather());
				}
			}else{
				RBTNode<K,V> y =(RBTNode<K, V>) z.getFather().getFather().getLeft();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getFather()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getFather().getFather()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getFather().getFather();
				}else if(z==z.getFather().getLeft()){
					z=(RBTNode<K, V>) z.getFather();
					rightRotate(z);
				}else{
					((RBTNode<K, V>) z.getFather()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getFather().getFather()).setColor(Color.RED);
					LeftRotate(z.getFather().getFather());
				}
			}
		}
		((RBTNode<K, V>) root).setColor(Color.BLACK);
	}
	
	private void deleteFixeUp(RBTNode<K,V> x) {
		while(x!=root && x.getColor()==Color.BLACK) {
			if(x==x.getFather().getLeft()) {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getFather().getRight();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getFather()).setColor(Color.RED);
					LeftRotate(x.getFather());
					w=((RBTNode<K,V>)x.getFather().getRight());
				}
				if(((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getRight()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getFather();
				}else{
					if(((RBTNode<K,V>)w.getRight()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getLeft()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						rightRotate(w);
						w=(RBTNode<K, V>) x.getFather().getRight();
					}
					w.setColor(((RBTNode<K, V>)x.getFather()).getColor());
					((RBTNode<K, V>)x.getFather()).setColor(Color.BLACK);
					((RBTNode<K, V>)w.getRight()).setColor(Color.BLACK);
					LeftRotate(x.getFather());
					x=(RBTNode<K, V>) root;
				}
			}else {
				RBTNode<K, V> w=(RBTNode<K, V>)x.getFather().getLeft();
				if(w.getColor()==Color.RED) {
					w.setColor(Color.BLACK);
					((RBTNode<K,V>)x.getFather()).setColor(Color.RED);
					rightRotate(x.getFather());
					w=((RBTNode<K,V>)x.getFather().getLeft());
				}
				if(((RBTNode<K,V>)w.getRight()).getColor()==Color.BLACK &&
						((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK) {
					w.setColor(Color.RED);
					x=(RBTNode<K,V>)x.getFather();
				}else {
					if(((RBTNode<K,V>)w.getLeft()).getColor()==Color.BLACK) {
						((RBTNode<K,V>)w.getRight()).setColor(Color.BLACK);
						w.setColor(Color.RED);
						LeftRotate(w);
						w=(RBTNode<K, V>) x.getFather().getLeft();
					}
					w.setColor(((RBTNode<K, V>)x.getFather()).getColor());
					((RBTNode<K, V>)x.getFather()).setColor(Color.BLACK);
					((RBTNode<K, V>) w.getLeft()).setColor(Color.BLACK);
					rightRotate(x.getFather());
					x=(RBTNode<K, V>) root;
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
		if(root == null) {
			return null;
		}else {
			ArrayList<V> elements = new ArrayList<V>();
			root.Preorder(elements);
			return elements;
		}
	}

}