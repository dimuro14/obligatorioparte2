/**
 * 
 */
package uy.edu.um.adt.hash;

import uy.edu.um.adt.linkedlist.MyList;

public interface MyHash<Key, Value> {
	void put(Key key, Value value);

	Value get(Key key);

	boolean contains(Key key);

	void remove(Key key);
	
	MyList<Key> keys();

	MyList<Value> values();

	int size();
	
}
