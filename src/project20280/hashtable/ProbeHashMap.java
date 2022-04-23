package project20280.hashtable;

import project20280.interfaces.Entry;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V> [] table;
    private MapEntry<K,V> DEFUNCT = new MapEntry<>(null, null);
    public ProbeHashMap() {
        super();
    }

    /** Creates a hash table with given capacity and prime factor 109345121. */
    public ProbeHashMap(int cap) {
        super(cap);
    }

    /** Creates a hash table with the given capacity and prime factor. */
    public ProbeHashMap(int cap, int p) {
        super(cap, p);
    }
    @Override
    protected void createTable() {
        table = new MapEntry[capacity];
    }

    int findSlot(int h, K k) {
        int pos = h;
        // keep doing until you find a space
        // check the position h
        // if h is full, go to next position (mod N)
        // otherwise if table[pos].getKey == k then return index
        do {
            if (table[pos] == null) {
                break;
            } else if (table[pos].getKey().equals(k)) {
                return pos;
            }
            pos = (pos + 1) % capacity;
        } while(pos != h);
        return -1;
    }
    @Override
    protected V bucketGet(int h, K k) {
        int pos = findSlot(h, k);
        return pos < 0 ? null : table[pos].getValue();
    }

    @Override
    protected V bucketPut(int h, K k, V v) {
        int pos = findSlot(h, k);
        if (pos >= 0) {
            return table[pos].setValue(v);
        }
        table[pos] = new MapEntry<>(k, v);
        n++;
        return null;
    }

    @Override
    protected V bucketRemove(int h, K k) {
        int pos = findSlot(h, k);
        if(pos < 0) {
            return null;
        }
        V res = table[pos].getValue();
        table[pos] = DEFUNCT;
        n--;
        return res;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return null;
    }
}
