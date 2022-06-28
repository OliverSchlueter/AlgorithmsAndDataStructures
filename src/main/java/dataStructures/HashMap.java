package dataStructures;

public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 5;
    private static final float RESIZE_FACTOR = 1.5f;

    private Array<LinkedList<KeyValue<K, V>>> hashMap;
    private int size;

    public HashMap() {
        this.hashMap = new Array<>(DEFAULT_SIZE);
        this.size = 0;
    }

    public void put(K key, V value){
        if(size >= hashMap.getSize()){
            grow();
        }

        KeyValue<K, V> keyValue = new KeyValue<>(key, value);

        int index = Math.abs(keyValue.getKeyHash()) % hashMap.getSize();

        if(hashMap.get(index) == null){ // first element at index
            hashMap.set(index, new LinkedList<>());
        } else { // possible collision or same key -> replace element
            List<KeyValue<K, V>> entries = hashMap.get(index).toList();
            for (int i = 0; i < entries.getSize(); i++) {
                KeyValue<K, V> entry = entries.get(i);
                if(entry.getKeyHash() == keyValue.getKeyHash()){
                    hashMap.get(index).replace(entry, keyValue);
                    return;
                }
            }
        }

        hashMap.get(index).pushEnd(keyValue);
        size++;
    }

    public V get(K key){
        int index = Math.abs(key.hashCode()) % hashMap.getSize();

        if(hashMap.get(index) == null || hashMap.get(index).getFirst() == null){
            throw new NullPointerException();
        }

        if(hashMap.get(index).getFirst().getNext() == null){
            if(hashMap.get(index).getFirst().getData().getKeyHash() == key.hashCode()) {
                return hashMap.get(index).getFirst().getData().getValue();
            } else {
                throw new NullPointerException();
            }
        } else {
            List<KeyValue<K, V>> entries = hashMap.get(index).toList();
            for (int i = 0; i < entries.getSize(); i++) {
                KeyValue<K, V> entry = entries.get(i);

                if(entry.getKeyHash() == key.hashCode()){
                    return entry.getValue();
                }
            }

            throw new NullPointerException();
        }

    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    public List<KeyValue<K, V>> getEntries(){
        List<KeyValue<K, V>> allEntries = new List<>();
        for (int i = 0; i < hashMap.getSize(); i++) {
            if(hashMap.get(i) == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap.get(i).toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allEntries.pushEnd(entries.get(j));
            }
        }

        return allEntries;
    }

    public List<K> getKeys(){
        List<K> allKeys = new List<>();
        for (int i = 0; i < hashMap.getSize(); i++) {
            if(hashMap.get(i) == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap.get(i).toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allKeys.pushEnd(entries.get(j).getKey());
            }
        }

        return allKeys;
    }

    public List<V> getValues(){
        List<V> allValues = new List<>();
        for (int i = 0; i < hashMap.getSize(); i++) {
            if(hashMap.get(i) == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap.get(i).toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allValues.pushEnd(entries.get(j).getValue());
            }
        }

        return allValues;
    }

    public void remove(K key){
        int index = Math.abs(key.hashCode()) % hashMap.getSize();

        if(hashMap.get(index) == null){
            throw new NullPointerException();
        }

        List<KeyValue<K, V>> entries = hashMap.get(index).toList();
        for (int i = 0; i < entries.getSize(); i++) {
            KeyValue<K, V> entry = entries.get(i);
            if(entry.getKeyHash() == key.hashCode()){
                hashMap.get(index).remove(entry);
                return;
            }
        }

        throw new NullPointerException();
    }

    private void grow(){
        Array<LinkedList<KeyValue<K, V>>> oldHashMap = hashMap.clone();
        hashMap = new Array<>((int) (hashMap.getSize() * RESIZE_FACTOR));

        for (int i = 0; i < oldHashMap.getSize(); i++) {
            if(oldHashMap.get(i) == null){
                continue;
            }
            List<KeyValue<K, V>> entries = oldHashMap.get(i).toList();
            for (int j = 0; j < entries.getSize(); j++) {
                KeyValue<K, V> entry = entries.get(j);
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < hashMap.getSize(); i++) {
            if(hashMap.get(i) == null){
                continue;
            }

            List<KeyValue<K, V>> entries = hashMap.get(i).toList();
            for (int j = 0; j < entries.getSize(); j++) {
                str.append(entries.get(j).toString());
                str.append(", ");
            }
        }

        if(str.length() > 2){
            str = new StringBuilder(str.substring(0, str.length() - 2));
        }

        str.append("]");

        return str.toString();
    }
}
