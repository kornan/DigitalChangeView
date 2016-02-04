package net.kornan.animview;

/**
 * Created by KORNAN on 2016/2/4.
 */
public interface IDigitalChange {
    void start();

    void setNumber(float number);

    void setNumber(int number);

    void setDuration(long duration);

    boolean isRunning();
}
