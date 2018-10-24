package structures;

import java.io.Serializable;

public abstract class BST<K extends Comparable, V> implements IBST<K, V>, Serializable{

	protected BSTNode<K, V> root;
	public BSTNode<K, V> nil;

	public BST() {
		nil = null;
		root = nil;
	}

	protected void insert(BSTNode<K, V> z) {
		BSTNode<K, V> y = null;
		if (nil != null)
			y = (BSTNode<K, V>) nil;
		BSTNode<K, V> x = root;
		while (x != nil) {
			y = x;
			if (x.compareTo(z) > 0) {           
				BSTNode<K, V> Father = x;
				x = x.getLeft();
				if (x != nil && Father.hight == x.hight + 1)
					Father.hight++;
				if (Father.getRight() == nil && x == nil) {
					Father.hight++;
				}
			} else if (x.compareTo(z) < 0) {
				BSTNode<K, V> Father = x;
				x = x.getRight();
				if (x != nil && Father.hight == x.hight + 1)
					Father.hight++;
				if (Father.getLeft() == nil && x == nil) {
					Father.hight++;
				}
			} else {
				BSTNode<K, V> w = x.getClon();
				while (w != null) {
					x = w;
					w = w.getClon();
				}
				x.setClon(z);
				BSTNode<K, V> p = null;
				if (nil != null)
					p = (BSTNode<K, V>) nil;
				z.setRight(p);
				z.setLeft(p);
				z.setFather(p);
				return;
			}
		}
		z.setFather(y);
		if (y == nil) {
			root = z;
		} else if (y.compareTo(z) > 0) {
			y.setLeft(z);
		} else {
			y.setRight(z);
		}
		BSTNode<K, V> p = null;
		if (nil != null)
			p = (BSTNode<K, V>) nil;
		z.setRight(p);
		z.setLeft(p);
	}

	public BSTNode<K, V> consultar(K key) {
		if(key==null) {
			return null;
		}
		if (nil != null) {
		}
		BSTNode<K, V> x = root;
		while (x != nil) {
			if (x.getKey().compareTo(key) > 0) {
				x = x.getLeft();
			} else if (x.getKey().compareTo(key) < 0) {
				x = x.getRight();
			} else {
				return x;
			}
		}
		return null;
	}

	protected void LeftRotate(BSTNode<K, V> x) {
		BSTNode<K, V> y = x.getRight();
		x.setRight(y.getLeft());
		if (y.getLeft() != nil) {
			y.getLeft().setFather(x);
		}
		y.setFather(x.getFather());
		if (x.getFather() == nil) {
			root = y;
		} else if (x == x.getFather().getLeft()) {
			x.getFather().setLeft(y);
		} else {
			x.getFather().setRight(y);
		}
		y.setLeft(x);
		x.setFather(y);
		x.actualizarhight();
		y.actualizarhight();
	}

	protected void rightRotate(BSTNode<K, V> x) {
		BSTNode<K, V> y = x.getLeft();
		x.setLeft(y.getRight());
		if (y.getRight() != nil) {
			y.getRight().setFather(x);
		}
		y.setFather(x.getFather());
		if (x.getFather() == nil) {
			root = y;
		} else if (x == x.getFather().getLeft()) {
			x.getFather().setLeft(y);
		} else {
			x.getFather().setRight(y);
		}
		y.setRight(x);
		x.setFather(y);
		x.actualizarhight();
		y.actualizarhight();
	}

	public boolean estaVacio() {
		if (root == null)
			return true;
		return false;
	}

	public BSTNode<K, V> getroot() {
		return root;
	}

	public void setroot(BSTNode<K, V> root) {
		this.root = root;
	}
	
	public abstract void insert(K key, V value);
	
	public abstract BSTNode<K,V> delete(K key);

	private BSTNode<K, V> sucesor(BSTNode<K,V> x) {
		if(x.getRight()!=nil) {
			return minimum(x.getRight());
		}
		BSTNode<K,V> y=x.getFather();
		while(y!=nil && x==y.getRight()) {
			x=y;
			y=y.getFather();
		}
		return y;
	}

	private BSTNode<K, V> minimum(BSTNode<K, V> d) {
		BSTNode<K,V>actual=d;
		while(actual.getLeft()!=nil) {
			actual=actual.getLeft();
		}
		return actual;
	}
	protected BSTNode[] delete(BSTNode<K, V> z) {
		BSTNode<K,V> y=nil;
		if (z.getRight()==nil || z.getLeft()==nil) {
			y=z;
		}else{
			y=sucesor(z);
		}
		BSTNode<K,V> x=nil;
		if(y.getLeft()!=nil) {
			x=y.getLeft();
		}else {
			x=y.getRight();
		}
		
		if(x!=null) {
			x.setFather(y.getFather());	
		}
		if(y.getFather()==nil) {
			root=x;
		}else {
			if(y==y.getFather().getLeft()) {
				y.getFather().setLeft(x);
			}else {
				y.getFather().setRight(x);
			}
		}
		if(nil==null && x==null) {
			x=y.getFather();
		}
		
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
		BSTNode<K,V>[]ans=new BSTNode[2];
		ans[0]=x;
		ans[1]=y;
		return ans;
	}
	
}
