package net.kornan.animview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import net.kornan.view.DigitalChangeView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements DigitalChangeView.EndListener {

    DigitalChangeView textNumber;
    EditText editInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editInput = (EditText) findViewById(R.id.edit_input);
        textNumber = (DigitalChangeView) findViewById(R.id.text_number);
        textNumber.setOnEndListener(this);
    }

    public void onClickView(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                String strValue = editInput.getText().toString();
                if (isInteger(strValue)) {
                    textNumber.setNumber(Integer.parseInt(strValue));
                } else if (isDecimal(strValue)) {
                    textNumber.setNumber(Float.parseFloat(strValue),3);
                } else {
                    return;
                }
                textNumber.setDuration(500);
                textNumber.start();
                break;
        }
    }

    public static boolean isDecimal(String str) {
        if (str == null || "".equals(str))
            return false;
        java.util.regex.Pattern pattern = Pattern.compile("[0-9]*(\\.?)[0-9]*");
        return pattern.matcher(str).matches();
    }

    public static boolean isInteger(String str) {
        if (str == null)
            return false;
        Pattern pattern = Pattern.compile("[0-9]+");
        return pattern.matcher(str).matches();
    }

    @Override
    public void onEndFinish() {

    }
}
