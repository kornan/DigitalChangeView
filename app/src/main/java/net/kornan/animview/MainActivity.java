package net.kornan.animview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.kornan.animview.beans.DataNumber;
import net.kornan.animview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    TextView number;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        number = (TextView) findViewById(R.id.number);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        DataNumber datas = new DataNumber(""+88,""+0);
        binding.setData(datas);
        datas.setStartNum("90");
    }
}
