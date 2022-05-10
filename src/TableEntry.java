import java.util.ArrayList;

public class TableEntry {
    private ArrayList<Integer> ChainElements;
    private HTable2 hashT2;

    public TableEntry() {
        this.ChainElements = new ArrayList<Integer>();
        this.hashT2 = new HTable2();
    }

    public ArrayList<Integer> getChainElements() {
        return ChainElements;
    }

    public void setChainElements(ArrayList<Integer> chainElements) {
        ChainElements = chainElements;
    }

    public HTable2 getHashT2() {
        return hashT2;
    }

    public void setHashT2(HTable2 hashT2) {
        this.hashT2 = hashT2;
    }

    public void setKey(int key) {
        this.ChainElements.add(key);
    }
}
