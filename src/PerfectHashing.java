public class PerfectHashing {
    public static void main(String[] args) {
        UniversalMatrix universalMatrix = new UniversalMatrix(16);
        System.out.println(universalMatrix.getValueOfKey(32));
        System.out.println(universalMatrix.getValueOfKey(16));
        System.out.println(universalMatrix.getValueOfKey(8));
        System.out.println(universalMatrix.getValueOfKey(4));
        System.out.println(universalMatrix.getValueOfKey(2));
        System.out.println(universalMatrix.getValueOfKey(1));
    }
}
