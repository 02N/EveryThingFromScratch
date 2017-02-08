package com.pplab.ds.hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	protected AbstractMap() {

	}

	public int size() {
		return entrySet().size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean containsValue(Object value) {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (value == null) {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (e.getValue() == null) {
					return true;
				}
			}
		} else {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (value.equals(e.getValue())) {
					return true;
				}
			}

		}
		return false;
	}

	public boolean containsKey(Object key) {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (key == null) {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (e.getKey() == null) {
					return true;
				}
			}
		} else {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (key.equals(e.getKey())) {
					return true;
				}
			}

		}
		return false;
	}

	public V get(Object key) {

		Iterator<Entry<K, V>> i = entrySet().iterator();
		if (key == null) {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (e.getKey() == null) {
					return e.getValue();
				}
			}
		} else {
			while (i.hasNext()) {
				Entry<K, V> e = i.next();
				if (key.equals(e.getKey())) {
					return e.getValue();
				}
			}

		}
		return null;

	}

	public V put(K key, V value) {
		throw new UnsupportedOperationException();
	}

	public V remove(Object key) {
		Iterator<Entry<K, V>> i = entrySet().iterator();
		Entry<K, V> correctEntry = null;

		if (key == null) {
			while (correctEntry == null && i.hasNext()) {
				Entry<K, V> e = i.next();
				if (e.getKey() == null) {
					correctEntry = e;
				}
			}
		} else {
			while (correctEntry == null && i.hasNext()) {
				Entry<K, V> e = i.next();
				if (e.getKey() == key) {
					correctEntry = e;
				}
			}
		}
		V oldValue = null;
		if (correctEntry != null) {
			oldValue = correctEntry.getValue();
			i.remove();
		}
		return oldValue;
	}
	public void putAll(Map<? extends K,? extends V> m){
		for(Map.Entry<? extends K, ? extends V> e :m.entrySet()){
			put(e.getKey(),e.getValue());
		}
	}
	
	public void clear(){
		entrySet().clear();
	}
	transient volatile Set<K> keySet = null;
	transient volatile Collection<V> values = null;
}
