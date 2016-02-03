package net.kornan.animview.beans;

/**
 * Created by KORNAN on 2016/2/1.
 */
public class DataNumber {
    private String startNum;
    private String endNum;

    public DataNumber(String firstName, String lastName) {
        this.startNum = firstName;
        this.endNum = lastName;
    }

    public String getStartNum() {
        return startNum;
    }

    public void setStartNum(String startNum) {
        this.startNum = startNum;
    }

    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
    }
}
