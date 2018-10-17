package structures;

public class AVLTree<K extends Comparable,V> extends BST<K,V> {
	
	@Override
	public void insert(K key, V value) {
		if(key!=null && value!=null) {
			AVLNode<K,V> z=new AVLNode<K,V>(key,value);
			insert(z);
			insertarFixeUp(z);
		}
	}
	private void insertarFixeUp(AVLNode<K, V> z) {
		AVLNode<K,V> N=z;
		AVLNode<K,V> P=(AVLNode<K, V>) z.getPadre();
		if(P!=null) {
			do {
				// P.balanceFactor() has not yet been updated!
				AVLNode<K,V> left=(AVLNode<K, V>) P.getIzquierdo();
				 if (left != null && N.compareTo(left)==0) { // the left subtree increases
					 if (P.balanceFactor() == 1) { // The left column in the picture
						 // ==> the temporary P.balanceFactor() == 2 ==> rebalancing is required.
						 if (N.balanceFactor() == -1) { // Left Right Case
							 leftRotate(N); // Reduce to Left Left Case
							 N.actualizarFactorBalance();
							 ((AVLNode)N.getPadre()).actualizarFactorBalance();
						 }
						 // Left Left Case
						 rightRotate(P);
						 P.actualizarFactorBalance();
						 ((AVLNode)P.getPadre()).actualizarFactorBalance();
						 break; // Leave the loop
					 }
					 if (P.balanceFactor() == -1) {
						 P.setBalanceFactor(0); // N’s height increase is absorbed at P.
						 break; // Leave the loop
					 }
					 P.setBalanceFactor(1); // Height increases at P
				 } else { // N == right_child(P), the child whose height increases by 1.
					 if (P.balanceFactor() == -1) { // The right column in the picture
						 // ==> the temporary P.balanceFactor() == -2 ==> rebalancing is required.
						 if (N.balanceFactor() == 1) { // Right Left Case
							 rightRotate(N); // Reduce to Right Right Case
							 N.actualizarFactorBalance();
							 ((AVLNode)N.getPadre()).actualizarFactorBalance();
						 }
						 // Right Right Case
						 leftRotate(P);
						 P.actualizarFactorBalance();
						 ((AVLNode)P.getPadre()).actualizarFactorBalance();
						 break; // Leave the loop
					 }
					 if (P.balanceFactor() == 1) {
						 P.setBalanceFactor(0); // N’s height increase is absorbed at P.
						 break; // Leave the loop
					 }
					 P.setBalanceFactor(-1); // Height increases at P
				 }
				 N = P;
				 P = (AVLNode<K, V>) N.getPadre();
			}while(P!=null);
		}
	}
	@Override
	public BSTNode<K, V> delete(K key) {
		if(key==null) {
			return null;
		}
		BSTNode<K,V>z=consultar(key);
		BSTNode[] params=null;
		if(z!=null) {
			params=delete(z);
		}else {
			return null;
		}
		System.out.println(params[0].getKey());
		deleteFixeUp((AVLNode)params[0]);
		return params[1];
	}
	private void deleteFixeUp(AVLNode N) {
		AVLNode G=null;
		for (AVLNode X = (AVLNode) N.getPadre(); X != null; X = G) { 
		    G = (AVLNode) X.getPadre(); 
		    if (N == X.getIzquierdo()) {
		        if (X.balanceFactor() < 0) { 
		        	AVLNode Z = (AVLNode) X.getDerecho();
		            int b = Z.balanceFactor();
		            if (b > 0) {
		            	rightRotate(Z);
		            	Z.actualizarFactorBalance();
		            	leftRotate(X);
		            	X.actualizarFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	leftRotate(X);
		            	X.actualizarFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		                X.setBalanceFactor(-1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    } else { 
		        if (X.balanceFactor() > 0) {
		            AVLNode Z = (AVLNode) X.getIzquierdo();
		            int b = Z.balanceFactor();
		            if (b < 0) {
		            	leftRotate(Z);
		            	Z.actualizarFactorBalance();
		            	rightRotate(X);
		            	X.actualizarFactorBalance();
		            }else {
		            	rightRotate(X);
		            	X.actualizarFactorBalance();
		            }
		        } else {
		            if (X.balanceFactor() == 0) {
		            	X.setBalanceFactor(1);
		                break; 
		            }
		            N = X;
		            N.setBalanceFactor(0);
		            continue;
		        }
		    }
		}
	}
}