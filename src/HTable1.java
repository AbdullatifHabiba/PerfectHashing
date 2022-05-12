import java.util.ArrayList;

public class HTable1 {

    private int size;
    private TableEntry[] entries;


    private HashFunction hashFunction;
    public HTable1(int size ){
       this.size=size;
        entries=new TableEntry[size];
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
            }
        }
    }

}

