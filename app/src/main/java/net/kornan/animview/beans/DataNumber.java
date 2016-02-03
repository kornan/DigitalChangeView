package net.kornan.animview.beans;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by KORNAN on 2016/2/1.
 */
public class DataNumber extends BaseObservable {
    private String startNum;
    private String endNum;

    public DataNumber(String firstName, String lastName) {
        this.startNum = firstName;
        this.endNum = lastName;
    }

    @Bindable
    public String getStartNum() {
        return startNum;
    }


    public void setStartNum(String startNum) {
        this.startNum = startNum;
        notifyPropertyChanged(net.kornan.animview.BR.startNum);
    }

    @Bindable
    public String getEndNum() {
        return endNum;
    }

    public void setEndNum(String endNum) {
        this.endNum = endNum;
        notifyPropertyChanged(net.kornan.animview.BR.endNum);
    }
}
