package net.kornan.animview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import net.kornan.animview.beans.DataNumber;
import net.kornan.animview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataNumber datas;
    DigitalChangeView rnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        datas = new DataNumber("" + 88, "" + 0);
        binding.setData(datas);

        runAnim();

    }

    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.number:
                datas.setStartNum("90");
                Log.i("number", datas.getStartNum());
                rnTextView.setNumber(90.00f);
                rnTextView.setDuration(300);
                rnTextView.start();
                break;
        }
    }

    public void runAnim() {
        rnTextView = (DigitalChangeView) findViewById(R.id.text_number);
        rnTextView.setNumber(500.56f);
        rnTextView.setDuration(300);
        rnTextView.start();
    }
}
