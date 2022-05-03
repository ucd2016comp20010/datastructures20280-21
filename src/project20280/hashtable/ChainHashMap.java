package project20280.hashtable;

import project20280.interfaces.Entry;

import java.util.ArrayList;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
	// a fixed capacity array of UnsortedTableMap that serve as buckets
	private UnsortedTableMap<K, V>[] table; // initialized within createTable

	/** Creates a hash table with capacity 11 and prime factor 109345121. */
	public ChainHashMap() {
		super();
	}

	/** Creates a hash table with given capacity and prime factor 109345121. */
	public ChainHashMap(int cap) {
		super(cap);
	}

	/** Creates a hash table with the given capacity and prime factor. */
	public ChainHashMap(int cap, int p) {
		super(cap, p);
	}

	/** Creates an empty table having length equal to current capacity. */
	@Override
	@SuppressWarnings({ "unchecked" })
	protected void createTable() {
		table = new UnsortedTableMap[capacity];
	}

	/**
	 * Returns value associated with key k in bucket with hash value h. If no such
	 * entry exists, returns null.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return associate value (or null, if no such entry)
	 */
	@Override
	protected V bucketGet(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		return bucket == null? null : bucket.get(k);
	}

	/**
	 * Associates key k with value v in bucket with hash value h, returning the
	 * previously associated value, if any.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @param v the value to be associated
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketPut(int h, K k, V v) {
		UnsortedTableMap<K, V> bucket = table[h];
		if(bucket == null) {
			bucket = new UnsortedTableMap<K, V>();
			table[h] = bucket;
		}

		V res = bucket.put(k, v);
		if(res == null) n++;
		return res;
	}		


	/**
	 * Removes entry having key k from bucket with hash value h, returning the
	 * previously associated value, if found.
	 * 
	 * @param h the hash value of the relevant bucket
	 * @param k the key of interest
	 * @return previous value associated with k (or null, if no such entry)
	 */
	@Override
	protected V bucketRemove(int h, K k) {
		UnsortedTableMap<K, V> bucket = table[h];
		if(bucket == null) return null;
		V res = bucket.remove(k);
		if(res != null) n--;
		return res;
	}

	/**
	 * Returns an iterable collection of all key-value entries of the map.
	 *
	 * @return iterable collection of the map's entries
	 */
	@Override
	public Iterable<Entry<K, V>> entrySet() {
		/*
		for each element in (UnsortedTableMap []) table
			for each element in bucket:
				print element
		*/
		ArrayList<Entry<K, V>> entries = new ArrayList<>();
		for(UnsortedTableMap<K,V> tm: table) {
			if(tm != null) {
				for(Entry<K, V> e : tm.entrySet()) {
					entries.add(e);
				}
			}
		}
		return entries;
	}
	
	public String toString() {
		return entrySet().toString();
	}
	
	public static void main(String[] args) {
		//HashMap<Integer, String> m = new HashMap<Integer, String>();
		ChainHashMap<Integer, String> m = new ChainHashMap<Integer, String>();
//		System.out.println("size before: " + m.size());
//		String n = m.put(1, "One");
//		m.put(2, "Two");
//		//System.out.println("size before: " + m.size() + " -> " + n);
//		System.out.println(m);
//
////		System.out.println("m.get(1): " + m.get(1));		
////		m.remove(1);	
////		System.out.println("size after: " + m.size());

		
		
		m.put(1, "One");
		m.put(10, "Ten");
		m.put(11, "Eleven");
		m.put(20, "Twenty");
		
		System.out.println("m: " + m);
		
		m.remove(11);
		System.out.println("m: " + m);
		
//		ChainHashMap<String, Integer> counter = new ()//;
//		// Scanner from file
//		for(String word : scanner) {
//			Integer old_count = counter.get(word);
//			counter.put(old_count + 1);
//		}
	}
}
