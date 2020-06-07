import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: wangyinghao
 * @Date: 2020-06-05 21:55
 **/
public class Test {
    public static void main(String[] args) {
        TreeMap<WordCount, Integer> map = new TreeMap<>((o1, o2) -> {
            if (o1.getWord().equals(o2.getWord())) {
                return 0;
            }
            int compare = Integer.compare(o1.count, o2.count);
            return compare == 0 ? (o1.getWord() - o2.getWord()) : -compare;
        });


        Iterator<WordCount> iterator = map.keySet().iterator();
        for (int i = 0; i < 2; i++) {
            iterator.next();
        }
    }
}

class WordCount {
    public Integer word;
    public Integer count;

    public Integer getWord() {
        return word;
    }

    public void setWord(Integer word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public WordCount(Integer word, Integer count) {
        this.word = word;
        this.count = count;
    }
}
