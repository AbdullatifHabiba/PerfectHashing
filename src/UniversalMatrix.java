import java.util.Random;

public class UniversalMatrix {


    private int  [][] HashM ;
    private int [][] k;
    private int M;
    private Random random;
    //M=2^b
    private double b;

    public UniversalMatrix(int size) {
        M = size;
        b = 0;
        k = new int[32][1];
        random=new Random();
        buildHashMatrix();
    }
    private void buildHashMatrix() {
        b = Math.ceil(Math.log(M) / Math.log(2));
        HashM = new int[(int) b][32];

        for (int i = 0; i < b; i++){
            for (int j = 0; j < 32; j++){
                HashM[i][j] = (int) random.nextInt(2);
            }
        }

    }
    public int getValueOfKey(int x)
    {
        int hash=0;
        for (int i = 0; i < b; i++){
            for (int j = 0; j < 32; j++) {

                    hash = hash << 1;
                    hash = hash | parity(x & HashM[i][j]);
                }
            }
        return hash;
    }
    int parity(int p)
    {
        int flag=0;
        while(p!=0)
        {
            flag ^= 1;
            p &=(p-1);
        }
        return flag;
    }
}

