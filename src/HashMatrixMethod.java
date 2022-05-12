import java.util.ArrayList;

public class HashMatrixMethod {
    int[] table;
    UniversalMatrix universalMatrix;
    ArrayList<Integer> hash = new ArrayList<>();
    int M;
    int N;
    int numberOfTries = 1;

    public HashMatrixMethod(int[] table) {
        this.table = table;
        N = table.length;
        M = N * N;
        universalMatrix = new UniversalMatrix(M);
        getFinalHashFunction();
        System.out.println("Try number: " + numberOfTries);
        System.out.println("The keys are: " + hash.toString());
    }

    void getFinalHashFunction() {
        hash.add(universalMatrix.getValueOfKey(table[0]));
        for (int i = 1; i < N; i++) {
            if (hash.contains(universalMatrix.getValueOfKey(table[i]))) {
                numberOfTries += 1;
                System.out.println("Try number: " + (numberOfTries - 1) + "\nA collision happened");
                System.out.println("Element " + table[hash.indexOf(universalMatrix.getValueOfKey(table[i]))] + " has the key " + universalMatrix.getValueOfKey(table[i]) + " which is the same key of element " + table[hash.size()]);
                universalMatrix = new UniversalMatrix(M);
                hash.clear();
                i = 0;
            }
            hash.add(universalMatrix.getValueOfKey(table[i]));
        }
    }
}
