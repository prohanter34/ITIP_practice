public class Pair implements Comparable<Pair> {

    public Integer key;
    public Character value;
    public Pair(Integer key, Character value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Pair o) {
        return key.compareTo(o.key);
    }
}
