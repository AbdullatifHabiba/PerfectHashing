public class PerfectHashing {
    public static void main(String[] args) {
//        UniversalMatrix universalMatrix = new UniversalMatrix(8);
//        System.out.println(universalMatrix.getValueOfKey(128));
//        System.out.println(universalMatrix.getValueOfKey(64));
//        System.out.println(universalMatrix.getValueOfKey(32));
//        System.out.println(universalMatrix.getValueOfKey(16));
//        System.out.println(universalMatrix.getValueOfKey(8));
//        System.out.println(universalMatrix.getValueOfKey(4));
//        System.out.println(universalMatrix.getValueOfKey(2));
//        System.out.println(universalMatrix.getValueOfKey(1));
        Integer[] a = {100,200,300};
       // HashMatrixMethod hashMatrixMethod = new HashMatrixMethod(a);
        HTable2 hTable2=new HTable2(3);
        hTable2.build( a);
    }
}
