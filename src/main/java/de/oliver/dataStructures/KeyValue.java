package de.oliver.dataStructures;

public class KeyValue<K, V> {

    private final K key;
    private final V value;
    private final int keyHash;

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
        this.keyHash = key.hashCode();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getKeyHash() {
        return keyHash;
    }

    @Override
    public String toString() {
        return "(" + key.toString() + ": " + value.toString() +")";
    }
}
