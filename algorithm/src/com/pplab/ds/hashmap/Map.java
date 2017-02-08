package com.pplab.ds.hashmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

public interface Map<K,V> {
	
	//query operations
	/*
	 * the return size is integer
	 */
	int size();
	/*
	 * the same as size() == 0
	 */
	boolean isEmpty();
	
	
	
	boolean containsKey(Object key);
	
	boolean containsValue(Object value);
	
	/*
	 * why Object not K,please consider List<Number> List<long>....so think more about equals..
	 */
	V get(Object key);
	
	//Modification op
	/*
	 * put we must add the correct type
	 */
	V put(K key,V value);
	
	V remove(Object key);
	
	void putAll(Map<? extends K,? extends V> m);
	
	void clear();
	
	//Views
	//the set and collection will be reflected if chagnes to the map
	Set<K> keySet();
	Collection<V> values(); 
	Set<Map.Entry<K,V>> entrySet();
	
	interface Entry<K,V>{
		K getKey();
		V getValue();
		V setValue(V value);
		boolean equals(Object o);
		int hashCode();
		//this is jdk8 new feature
		//public static <K extends Comparable<? super K>,V> Comparator<Map.Entry<K,V>> comparingByKey(){
			
		}
	//compare and hashing
	boolean equeals(Object o);
	int hashCode();
	
}
