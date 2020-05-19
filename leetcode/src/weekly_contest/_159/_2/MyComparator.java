package weekly_contest._159._2;

import java.util.Comparator;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-10-22 11:34
 **/
public class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String s1 = (String) o1;
        String s2 = (String) o2;
        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? 1 : -1;
        }
        return 0;
    }
}
