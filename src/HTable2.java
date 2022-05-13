public class HTable2 {
 private   Integer entries[];
 private HashFunction hashFunction;
 private int num_tries;
 private int size;
    public HTable2( ){
        entries=new Integer[size];
    }
    public void build(Integer inputs[])
    {
        size=inputs.length;
        hashFunction=new HashFunction(size*size,inputs);

        boolean collision;
        do
        {

            entries = new Integer[size*size];
            collision  = false ;

            for (int input:inputs) {
                int index=hashFunction.getFunctionValue(input);
                if(entries[index] != null&&entries[index] != input) {
                    num_tries++;
                    entries = new Integer[size*size];
                    hashFunction.secondFunction();
                    collision =true ;
                    break;
                }

                entries[index] = input;
            }

            collision  = false ;
            inputs = null;
        }while(collision);



    }

    public int getNum_tries() {
        return num_tries;
    }

    public void printTable()
    {
        System.out.print("[|");
        for (int i = 0; i < entries.length; i++) {
            if(entries[i]!=null)
                System.out.print(entries[i]+"|");

        }
        System.out.println("]");
    }
    public boolean findKey(Integer key) {
        if (entries[hashFunction.getFunctionValue(key)] == key) {
            return true;
        }
        return false;
    }

}
