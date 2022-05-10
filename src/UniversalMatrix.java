import java.util.Random;

public class UniversalMatrix {
    private final int M;
    private final Random random;
    private int[][] HashM;
    private double b;

    public UniversalMatrix(int size) {
        M = size;
        b = 0;
        random = new Random();
        buildHashMatrix();
    }

    private void buildHashMatrix() {
        b = Math.ceil(Math.log(M) / Math.log(2));
        HashM = new int[(int) b][32];
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < 32; j++) {
                HashM[i][j] = random.nextInt(2);
            }
            System.out.println(java.util.Arrays.toString(HashM[i]));
        }
    }

    public int getValueOfKey(int x) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += multibly(HashM[i], x) << ((int) b - i - 1);
        }
        return result;
    }

//    int parity(int p) {
//        int flag = 0;
//        while (p != 0) {
//            flag ^= 1;
//            p &= (p - 1);
//        }
//        return flag;
//    }

    int multibly(int[] a, int b) {
        int result = 0;
        for (int i = 0; i < a.length; i++)
            result += a[i] * ((b & (1 << (31 - i))) / (1 << (31 - i)));
        return result % 2;
    }
}

