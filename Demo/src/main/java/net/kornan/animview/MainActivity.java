package net.kornan.animview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import net.kornan.animview.beans.DataNumber;
import net.kornan.animview.databinding.ActivityMainBinding;
import net.kornan.view.DigitalChangeView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DataNumber datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        datas = new DataNumber("" + 88, "" + 0);
        binding.setData(datas);
        binding.textNumber.setOnEndListener(new DigitalChangeView.EndListener() {
            @Override
            public void onEndFinish() {
                datas.setStartNum("" + binding.textNumber.getText(), false);
            }
        });
    }

    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                binding.textNumber.setNumber(Float.parseFloat(binding.editInput.getText().toString()));
                binding.textNumber.setDuration(500);
                binding.textNumber.start();
                Log.i("number", datas.getStartNum());
                break;
        }
    }

}
