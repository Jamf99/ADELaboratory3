package structures;

public class AVLTree<K extends Comparable,V> extends BST<K,V> {
	
	@Override
	public void insert(K key, V value) {
		if(key!=null && value!=null) {
			AVLNode<K,V> z=new AVLNode<K,V>(key,value);
			insert(z);
			FixeUpInsert(z);
		}
	}
	private void FixeUpInsert(AVLNode<K, V> z) {
		AVLNode<K,V> N=z;
		AVLNode<K,V> P=(AVLNode<K, V>) z.getFather();
		if(P!=null) {
			do {
				
				AVLNode<K,V> left=(AVLNode<K, V>) P.getLeft();
				 if (left != null && N.compareTo(left)==0) {
					 if (P.balanceFactor() == 1) { 
						
						 if (N.balanceFactor() == -1) {
							 LeftRotate(N); 
							 N.UpdateFactorBalance();
							 ((AVLNode)N.getFather()).UpdateFactorBalance();
						 }
				
						 rightRotate(P);
						 P.UpdateFactorBalance();
						 ((AVLNode)P.getFather()).UpdateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == -1) {
						 P.setBalanceFactor(0); 
						 break;
					 }
					 P.setBalanceFactor(1); 
				 } else { .
					 if (P.balanceFactor() == -1) {
						
						 if (N.balanceFactor() == 1) { 
							 rightRotate(N);
							 N.UpdateFactorBalance();
							 ((AVLNode)N.getFather()).UpdateFactorBalance();
						 }
					
						 LeftRotate(P);
						 P.UpdateFactorBalance();
						 ((AVLNode)P.getFather()).UpdateFactorBalance();
						 break; 
					 }
					 if (P.balanceFactor() == 1) {
						 P.setBalanceFactor(0); 
						 break; 
					 }
					 P.setBalanceFactor(-1); 
				 }
				 N = P;
				 P = (AVLNode<K, V>) N.getFather();
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
		for (AVLNode X = (AVLNode) N.getFather(); X != null; X = G) { 
		    G = (AVLNode) X.getFather(); 
		    if (N == X.getLeft()) {
		        if (X.balanceFactor() < 0) { 
		        	AVLNode Z = (AVLNode) X.getRight();
		            int b = Z.balanceFactor();
		            if (b > 0) {
		            	rightRotate(Z);
		            	Z.UpdateFactorBalance();
		            	LeftRotate(X);
		            	X.UpdateFactorBalance();
		            }else {
		            	System.out.println("HERE");
		            	LeftRotate(X);
		            	X.UpdateFactorBalance();
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
		            AVLNode Z = (AVLNode) X.getLeft();
		            int b = Z.balanceFactor();
		            if (b < 0) {
		            	LeftRotate(Z);
		            	Z.UpdateFactorBalance();
		            	rightRotate(X);
		            	X.UpdateFactorBalance();
		            }else {
		            	rightRotate(X);
		            	X.UpdateFactorBalance();
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