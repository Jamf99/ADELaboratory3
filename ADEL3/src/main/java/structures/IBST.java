package structures;

public interface IBST <K extends Comparable, V> {

	public void insert(K key, V value);
	public BSTNode<K,V> delete(K key);
	
}