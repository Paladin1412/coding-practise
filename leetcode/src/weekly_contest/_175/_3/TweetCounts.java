package weekly_contest._175._3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: wangyinghao_sx
 * @Date: 2020-02-09 11:15
 **/
public class TweetCounts {

    private Map<String, List<Integer>> nameTimeMap = new HashMap<>();

    public TweetCounts() {
    }

    public void recordTweet(String tweetName, int time) {
        List<Integer> list = nameTimeMap.get(tweetName);
        if (list==null){
            list = new ArrayList<>();
        }
        list.add(time);
        nameTimeMap.put(tweetName, list);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList<>();
        List<Integer> tweeTimeList = nameTimeMap.get(tweetName);
        int delta = 0;
        switch (freq) {
            case "minute":
                delta = 60;
                break;
            case "hour":
                delta = 3600;
                break;
            case "day":
                delta = 86400;
                break;
        }
        int i = 0;
        while (startTime + delta * (i) < endTime + 1) {
            int sum = 0;
            for (Integer integer : tweeTimeList) {
                if (integer >= startTime + delta * (i) && integer < startTime + delta * (i + 1)) {
                    sum++;
                }
            }
            res.add(sum);
            i++;
        }
        return res;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
