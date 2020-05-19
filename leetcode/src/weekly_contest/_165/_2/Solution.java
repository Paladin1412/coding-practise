package weekly_contest._165._2;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-12-01 10:53
 **/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices > 4 * cheeseSlices || tomatoSlices < 2 * cheeseSlices) {
            return res;
        } else {
            tomatoSlices = tomatoSlices - 2 * cheeseSlices;
            if(tomatoSlices%2==0){
                res.add(tomatoSlices / 2);
                res.add(cheeseSlices - tomatoSlices / 2);
            }
        }
        return res;
    }

}