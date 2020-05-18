package weekly_contest._164._3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2019-11-24 10:59
 **/
public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        List<String> productsList = new ArrayList<>(Arrays.asList(products));
        products = productsList.stream().sorted().toArray(String[]::new);
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String s = searchWord.substring(0, i+1);
            int nums = 0;
            for (String product : products) {
                if (nums < 3) {
                    if (product.indexOf(s) == 0) {
                        tmp.add(product);
                        nums++;
                    }
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] products = new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new Solution().suggestedProducts(products, searchWord));
    }
}
