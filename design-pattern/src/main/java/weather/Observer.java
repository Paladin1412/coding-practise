package main.java.weather;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 20:01
 **/
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
