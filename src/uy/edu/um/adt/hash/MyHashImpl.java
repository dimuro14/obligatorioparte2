package uy.edu.um.adt.hash;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.linkedlist.MyList;

import java.util.HashMap;

public class MyHashImpl<Key, Value> implements MyHash<Key, Value> {

	private HashMap<Key, Value> map = null;

	public MyHashImpl() {
		map = new HashMap<Key, Value>();
	}

	public MyHashImpl(int initialCapacity) {
		map = new HashMap<Key, Value>(initialCapacity);
	}


	@Override
	public MyList<Key> keys() {
		MyList<Key> toReturn = new MyLinkedListImpl<>();

		map.keySet().stream().forEach(s -> toReturn.add(s));

		return toReturn;
	}

	@Override
	public MyList<Value> values() {
		MyList<Value> toReturn = new MyLinkedListImpl<>();

		map.values().stream().forEach(s -> toReturn.add(s));

		return toReturn;
	}

    @Override
    public int size() {
        return map.size();
    }

    @Override
	public void put(Key key, Value value) {
		map.put(key, value);
	}

	@Override
	public Value get(Key key) {
		return map.get(key);
	}

    @Override
    public boolean contains(Key key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }


}
