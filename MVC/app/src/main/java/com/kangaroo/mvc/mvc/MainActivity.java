package com.kangaroo.mvc.mvc;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText input;

    private Button compress;

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        input = findViewById(R.id.editText);
        output = findViewById(R.id.show);
        findViewById(R.id.compress).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String in = input.getText().toString();
        char[] chars = in.toCharArray();
        output.setText(CompressString(chars));
    }

    private String CompressString(char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        int sum = 0, index = 0;
        while (index < chars.length) {
            char current = chars[index];
            int num = 0;
            while (index < chars.length && chars[index] == current) {
                index++;
                num++;
            }
            chars[sum++] = current;
            if (num != 1) {
                for (char c : (num + "").toCharArray()) {
                    chars[sum++] = c;
                }
            }
        }
        for (int i = 0; i < sum; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
