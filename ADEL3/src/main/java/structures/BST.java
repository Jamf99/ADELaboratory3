package structures;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class BST<K extends Comparable, V> implements IBST<K, V>, Serializable{

	protected BSTNode<K, V> raiz;
	public BSTNode<K, V> nil;

	public BST() {
		nil = null;
		raiz = nil;
	}

	protected void insert(BSTNode<K, V> z) {
		BSTNode<K, V> y = null;
		if (nil != null)
			y = (BSTNode<K, V>) nil;
		BSTNode<K, V> x = raiz;
		while (x != nil) {
			y = x;
			if (x.compareTo(z) > 0) {           
				BSTNode<K, V> padre = x;
				x = x.getIzquierdo();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getDerecho() == nil && x == nil) {
					padre.altura++;
				}
			} else if (x.compareTo(z) < 0) {
				BSTNode<K, V> padre = x;
				x = x.getDerecho();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getIzquierdo() == nil && x == nil) {
					padre.altura++;
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
				z.setDerecho(p);
				z.setIzquierdo(p);
				z.setPadre(p);
				return;
			}
		}
		z.setPadre(y);
		if (y == nil) {
			raiz = z;
		} else if (y.compareTo(z) > 0) {
			y.setIzquierdo(z);
		} else {
			y.setDerecho(z);
		}
		BSTNode<K, V> p = null;
		if (nil != null)
			p = (BSTNode<K, V>) nil;
		z.setDerecho(p);
		z.setIzquierdo(p);
	}

	public BSTNode<K, V> consultar(K key) {
		if(key==null) {
			return null;
		}
		if (nil != null) {
		}
		BSTNode<K, V> x = raiz;
		while (x != nil) {
			if (x.getKey().compareTo(key) > 0) {
				x = x.getIzquierdo();
			} else if (x.getKey().compareTo(key) < 0) {
				x = x.getDerecho();
			} else {
				return x;
			}
		}
		return null;
	}

	protected void leftRotate(BSTNode<K, V> x) {
		BSTNode<K, V> y = x.getDerecho();
		x.setDerecho(y.getIzquierdo());
		if (y.getIzquierdo() != nil) {
			y.getIzquierdo().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if (x.getPadre() == nil) {
			raiz = y;
		} else if (x == x.getPadre().getIzquierdo()) {
			x.getPadre().setIzquierdo(y);
		} else {
			x.getPadre().setDerecho(y);
		}
		y.setIzquierdo(x);
		x.setPadre(y);
		x.actualizarAltura();
		y.actualizarAltura();
	}

	protected void rightRotate(BSTNode<K, V> x) {
		BSTNode<K, V> y = x.getIzquierdo();
		x.setIzquierdo(y.getDerecho());
		if (y.getDerecho() != nil) {
			y.getDerecho().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if (x.getPadre() == nil) {
			raiz = y;
		} else if (x == x.getPadre().getIzquierdo()) {
			x.getPadre().setIzquierdo(y);
		} else {
			x.getPadre().setDerecho(y);
		}
		y.setDerecho(x);
		x.setPadre(y);
		x.actualizarAltura();
		y.actualizarAltura();
	}

	public boolean estaVacio() {
		if (raiz == null)
			return true;
		return false;
	}

	public BSTNode<K, V> getRaiz() {
		return raiz;
	}

	public void setRaiz(BSTNode<K, V> raiz) {
		this.raiz = raiz;
	}
	
	public abstract void insert(K key, V value);
	
	public abstract BSTNode<K,V> delete(K key);

	private BSTNode<K, V> sucesor(BSTNode<K,V> x) {
		if(x.getDerecho()!=nil) {
			return minimo(x.getDerecho());
		}
		BSTNode<K,V> y=x.getPadre();
		while(y!=nil && x==y.getDerecho()) {
			x=y;
			y=y.getPadre();
		}
		return y;
	}

	private BSTNode<K, V> minimo(BSTNode<K, V> d) {
		BSTNode<K,V>actual=d;
		while(actual.getIzquierdo()!=nil) {
			actual=actual.getIzquierdo();
		}
		return actual;
	}
	protected BSTNode[] delete(BSTNode<K, V> z) {
		BSTNode<K,V> y=nil;
		if (z.getDerecho()==nil || z.getIzquierdo()==nil) {
			y=z;
		}else{
			y=sucesor(z);
		}
		BSTNode<K,V> x=nil;
		if(y.getIzquierdo()!=nil) {
			x=y.getIzquierdo();
		}else {
			x=y.getDerecho();
		}
		
		if(x!=null) {
			x.setPadre(y.getPadre());	
		}
		if(y.getPadre()==nil) {
			raiz=x;
		}else {
			if(y==y.getPadre().getIzquierdo()) {
				y.getPadre().setIzquierdo(x);
			}else {
				y.getPadre().setDerecho(x);
			}
		}
		if(nil==null && x==null) {
			x=y.getPadre();
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
