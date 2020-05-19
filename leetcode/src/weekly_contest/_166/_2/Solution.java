package weekly_contest._166._2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-08 11:25
 **/
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> groupMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!groupMap.containsKey(groupSizes[i])) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                groupMap.put(groupSizes[i],tmp );
            } else {
                List<Integer> tmp = groupMap.get(groupSizes[i]);
                tmp.add(i);
                groupMap.put(groupSizes[i], tmp);
            }
        }
        for (Map.Entry<Integer, List<Integer>> integerListEntry : groupMap.entrySet()) {
            List<Integer> peo = integerListEntry.getValue();
            int groupSize = integerListEntry.getKey();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < peo.size(); i++) {
                tmp.add(peo.get(i));
                if ((i + 1) % groupSize == peo.size() % groupSize) {
                    result.add(tmp);
                    tmp = new ArrayList<>();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        new Solution().groupThePeople(groupSizes);
    }
}
