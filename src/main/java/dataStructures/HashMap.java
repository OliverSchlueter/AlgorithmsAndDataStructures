package dataStructures;

public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 5;
    private static final float RESIZE_FACTOR = 1.5f;

    private LinkedList<KeyValue<K, V>>[] hashMap;
    private int size;

    public HashMap() {
        this.hashMap = new LinkedList[DEFAULT_SIZE];
        this.size = 0;
    }

    public void put(K key, V value){
        if(size >= hashMap.length){
            grow();
        }

        KeyValue<K, V> keyValue = new KeyValue<>(key, value);

        int index = Math.abs(keyValue.getKeyHash()) % hashMap.length;

        if(hashMap[index] == null){ // first element at index
            hashMap[index] = new LinkedList<>();
        } else { // possible collision or same key -> replace element
            List<KeyValue<K, V>> entries = hashMap[index].toList();
            for (int i = 0; i < entries.getSize(); i++) {
                KeyValue<K, V> entry = entries.get(i);
                if(entry.getKeyHash() == keyValue.getKeyHash()){
                    hashMap[index].replace(entry, keyValue);
                    return;
                }
            }
        }

        hashMap[index].pushEnd(keyValue);
        size++;
    }

    public V get(K key){
        int index = Math.abs(key.hashCode()) % hashMap.length;

        if(hashMap[index] == null || hashMap[index].getFirst() == null){
            throw new NullPointerException();
        }

        if(hashMap[index].getFirst().getNext() == null){
            if(hashMap[index].getFirst().getData().getKeyHash() == key.hashCode()) {
                return hashMap[index].getFirst().getData().getValue();
            } else {
                throw new NullPointerException();
            }
        } else {
            List<KeyValue<K, V>> entries = hashMap[index].toList();
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
        for (int i = 0; i < hashMap.length; i++) {
            if(hashMap[i] == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap[i].toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allEntries.pushEnd(entries.get(j));
            }
        }

        return allEntries;
    }

    public List<K> getKeys(){
        List<K> allKeys = new List<>();
        for (int i = 0; i < hashMap.length; i++) {
            if(hashMap[i] == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap[i].toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allKeys.pushEnd(entries.get(j).getKey());
            }
        }

        return allKeys;
    }

    public List<V> getValues(){
        List<V> allValues = new List<>();
        for (int i = 0; i < hashMap.length; i++) {
            if(hashMap[i] == null){
                continue;
            }
            List<KeyValue<K, V>> entries = hashMap[i].toList();
            for (int j = 0; j < entries.getSize(); j++) {
                allValues.pushEnd(entries.get(j).getValue());
            }
        }

        return allValues;
    }

    public void remove(K key){
        int index = Math.abs(key.hashCode()) % hashMap.length;

        if(hashMap[index] == null){
            throw new NullPointerException();
        }

        List<KeyValue<K, V>> entries = hashMap[index].toList();
        for (int i = 0; i < entries.getSize(); i++) {
            KeyValue<K, V> entry = entries.get(i);
            if(entry.getKeyHash() == key.hashCode()){
                hashMap[index].remove(entry);
                return;
            }
        }

        throw new NullPointerException();
    }

    private void grow(){
        LinkedList<KeyValue<K, V>>[] oldHashMap = hashMap.clone();
        hashMap = new LinkedList[(int) (hashMap.length * RESIZE_FACTOR)];

        for (int i = 0; i < oldHashMap.length; i++) {
            if(oldHashMap[i] == null){
                continue;
            }
            List<KeyValue<K, V>> entries = oldHashMap[i].toList();
            for (int j = 0; j < entries.getSize(); j++) {
                KeyValue<K, V> entry = entries.get(j);
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < hashMap.length; i++) {
            if(hashMap[i] == null){
                continue;
            }

            List<KeyValue<K, V>> entries = hashMap[i].toList();
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
