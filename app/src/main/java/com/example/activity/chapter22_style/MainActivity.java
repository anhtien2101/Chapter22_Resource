package com.example.activity.chapter22_style;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edtName);
        tvResult = (TextView) findViewById(R.id.tvResult);

    }

    public void applyFormat(View v){
        String format = getString(R.string.funky_format);
        String strEncode = TextUtils.htmlEncode(edtName.getText().toString());
        String simpleResult = String.format(format, strEncode);
        tvResult.setText(Html.fromHtml(simpleResult));
    }
}
