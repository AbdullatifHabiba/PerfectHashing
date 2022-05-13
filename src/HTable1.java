import java.util.ArrayList;

public class HTable1 {

    private int size;
    private TableEntry[] entries;
    int Rehashs;

    private HashFunction hashFunction;
    public HTable1(int size ){
       this.size=size;
        entries=new TableEntry[size];
        Rehashs=0;
    }

    public void build(Integer inputs[])
    {
        hashFunction=new HashFunction(size,inputs);
        for (int input:inputs) {
            int index=hashFunction.getFunctionValue(input);
            if(entries[index] == null) {
                entries[index] = new TableEntry();
            }

            entries[index].setKey(input);
        }
        fixCollisions(inputs);


    }
    private void fixCollisions(Integer[] input) {
        for (int i = 0; i < input.length; i++) {
            if (!(entries[i] == null)) {
                entries[i].getHashT2().build(entries[i].getChainElements().toArray(new Integer[0]));

                Rehashs+= entries[i].getHashT2().getNum_tries();
            }
        }
    }
    public int getRehash(){

        return Rehashs ;
    }
    public void printTable(){
        for (TableEntry T:entries) {
            if (T !=null)
            T.getHashT2().printTable();
        }
    }

    public boolean findKey(Integer key) {

            if (entries[hashFunction.getFunctionValue(key)]!=null&&!entries[hashFunction.getFunctionValue(key)].getChainElements().isEmpty()) {
                return entries[hashFunction.getFunctionValue(key)].getHashT2().findKey(key);
            }


        return false;
    }


}

