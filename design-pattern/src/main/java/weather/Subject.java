package main.java.weather;

/**
 * @Author: wangyinghao_sx
 * @Date: 2019-09-24 20:00
 **/
public interface Subject {
    public void registerObserver(Observer observer);

    public void removerObserver(Observer observer);

    public void notifyObservers();
}
