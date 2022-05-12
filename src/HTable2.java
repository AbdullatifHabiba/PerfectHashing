public class HTable2 {
 private   Integer entries[];
 private HashFunction hashFunction;
 private int num_tries;
 private int size;
    public HTable2(int size ){
        this.size=size;
        entries=new Integer[size];
    }
    public void build(Integer inputs[])
    {
        hashFunction=new HashFunction(size,inputs);

        boolean collision;
        do
        {

            entries = new Integer[size*size];
            collision  = false ;

            for (int input:inputs) {
                int index=hashFunction.getFunctionValue(input);
                if(entries[index] != null&&entries[index] != input) {
                    num_tries++;
                    collision =true ;
                    break;
                }

                entries[index] = input;
            }
            hashFunction.secondFunction();


        }while(collision);

        inputs = null;

    }
}
