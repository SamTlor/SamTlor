package cmsc256;

import java.util.Iterator;

public class kims_HashTableQuadraticProbing<K, V> extends HashTableOpenAddressing<K, V>{

    @Override
    public V put(K key, V value) {
        if (key == null || value == null)
            throw new IllegalArgumentException();
        V oldValue = null;

        Entry newInput = new Entry(key, value);
        int index = super.getHashIndex(key);
        index = quadraticProbe(index, key);

        if (super.table[index] == null || super.table[index].isRemoved()) {
            super.table[index] = newInput;
            numEntries++;
        }

        else {
            oldValue = super.table[index].getValue();
            super.table[index].setValue(value);
        }

        if (isFull()){
            enlargeHashTable();
        }

        return oldValue;
    }

    @Override
    public V remove(K key) {
        if (!contains(key)){
            return null;
        }
        V removedValue = null;
        int index = getHashIndex(key);// calculate the initial index

        index = quadraticProbe(index, key); // find the location of the key using linear probing

        if (index != -1) { // if Key found
            table[index].setToRemoved(); //flag entry as removed
            removedValue = table[index].getValue(); //return its value
            numEntries--; // decrement the number of elements
        }
        else
            throw new IllegalArgumentException("The key is not in the table");

        return removedValue; // else key not found; return null
    }

    @Override
    public V getValue(K key) {
        int index = super.getHashIndex(key);
        index = quadraticProbe(index, key);

        Entry <K, V> item = table[index];

        if ((item  != null) && item.isIn())
            return item.getValue();

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    public int quadraticProbe(int index, K keyIn) {
        boolean found = false;

        int removedStateIndex = -1; // Index of first removed location

        int x = 1;
        int y = index;

        if(table[index] == null)    // The hash index is available

            return index;


        while (!found && (table[index] != null) && x < table.length){

            if (table[index].isIn()) {

                if (keyIn.equals(table[index].getKey()))

                    found = true;       // Key found


                else {                   // Follow probe sequence
                    index = (y + (x * x)) % table.length;
                }

            }

            else {                              // Skip entries that were removed

                // Save index of first location in removed state

                if (removedStateIndex == -1)

                    removedStateIndex = index;

                index = (y + (x * x)) % table.length;
            }
            x++;
        }



        if (found || (removedStateIndex == -1) )

            return index;             // Index of either key or null

        else

            return removedStateIndex; // Index of an available location

    }

    public static void main(String[] args){
        HashTableQuadraticProbing<String, Integer> purchases = new HashTableQuadraticProbing<>();

        String[] names = {"Pax", "Eleven", "Angel", "Abigail", "Jack"};
        purchases.put(names[0], 654);
        purchases.put(names[1], 341);
        purchases.put(names[2], 70);
        purchases.put(names[3], 867);
        purchases.put(names[4], 5309);

        System.out.println("Contents with linear probing:\n" + purchases.toString());

        System.out.println("Replaced old value was " + purchases.put(names[1], 170));
        System.out.println("Contents after changing Eleven to 170:\n" + purchases.toString());

        System.out.println("Calling getValue() on Pax, Eleven, & Angel:");
        System.out.println("\tPax: " + purchases.getValue(names[0]));
        System.out.println("\tEleven: " + purchases.getValue(names[1]));
        System.out.println("\tAngel: " + purchases.getValue(names[2]));

        purchases.remove(names[0]);
        purchases.remove(names[2]);
        System.out.println("Contents after removing Pax & Angel:\n" + purchases);

        purchases.put("Gino", 348);
        System.out.println("Contents after adding Gino:\n" + purchases);

        Iterator<String> keyIter = purchases.getKeyIterator();
        Iterator<Integer> valueIter = purchases.getValueIterator();
        System.out.println("Contents of the hash table:");
        while(keyIter.hasNext())
            System.out.println("Key-" + keyIter.next() + " : Value-" + valueIter.next());
    }

}
