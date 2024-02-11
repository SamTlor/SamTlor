package cmsc256;


public class HashTableLinearProbing<K, V> extends HashTableOpenAddressing<K, V> {

    public int linearProbe(int index, K keyIn){
        boolean found = false;
        int removedStateIndex = -1;         //index of first removed location

        if(table[index] == null){
            return index;
        }

        while(!found && table[index] != null){
            if(table[index].isIn()){
                if(keyIn.equals(table[index].getKey())){
                    found = true;
                }
                else{
                    index = (index + 1) % table.length;
                }
            }
            else{
                if (removedStateIndex == -1){
                    removedStateIndex = index;
                }
                index = (index + 1) % table.length;
            }
        }

        if(found || (removedStateIndex == -1)){
            return index;
        }
        else{
            return removedStateIndex;
        }
    }

    public V put(K keyIn, V valueIn){
        if(keyIn == null || valueIn == null){
            throw new IllegalArgumentException();
        }
        V oldValue = null;

        Entry newInput = new Entry(keyIn, valueIn);
        int index = super.getHashIndex(keyIn);
        index = linearProbe(index, keyIn);

        if (table[index] == null || table[index].isRemoved()){
            table[index] = newInput;
            numEntries++;
        }
        else{
            oldValue = table[index].getValue();
            table[index].setValue(valueIn);
        }
    }

    public static void main(String[] args) {

        System.out.println("");
    }
}