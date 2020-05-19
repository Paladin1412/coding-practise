package weekly_contest._176._2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-16 11:00
 **/
public class ProductOfNumbers {
    private List<Integer> numList = new ArrayList<>();
    private int length = 0;

    public ProductOfNumbers() {
    }

    public void add(int num) {
        numList.add(num);
        length++;
    }

    public int getProduct(int k) {
        int res = 1;
        for (int i = length - k; i < length; i++) {
            res *= numList.get(i);
        }
        return res;
    }
}

