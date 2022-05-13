import java.util.Random;

public class HashFunction {

    private final Random r;
    private final int m;
    private int p = Integer.MIN_VALUE;
    private int a;
    private int b;

    public HashFunction(int size, Integer[] keys) {
        this.m = size;
        r = new Random();
        a = getA();
        b = getB();
        p = getP(keys);
    }

    public int getFunctionValue(int k) {
        int v = ((a * k + b) % p) % m;
        return (v + m) % m;
    }

    private int getB() {
        return b = r.nextInt(p - 1);
    }

    private int getA() {
        a = 1 + r.nextInt(p - 1);
        if (a > p - 1)
            a -= 1;
        return a;
    }

    private int getP(Integer[] keys) {
        int maxKey = getMaxKey(keys);
        int i = maxKey + 1;
        while (true) {
            if (isPrime(i)) {
                return i;
            }
            i++;
        }
    }

    private boolean isPrime(int n) {
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= (int) (Math.sqrt(n) + 1); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private int getMaxKey(Integer[] keys) {
        int n = Integer.MIN_VALUE;
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] >= n) {
                n = keys[i];
            }
        }
        return n;
    }

    public void secondFunction() {
        this.a = getA();
        this.b = getB();
    }
}