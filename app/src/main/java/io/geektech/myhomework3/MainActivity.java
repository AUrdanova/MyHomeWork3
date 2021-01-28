package io.geektech.myhomework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private TextView textView;
    private Button buttonAddition;
    private int sum;
    private String s="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        sum = savedInstanceState.getInt("Result",1);
        editText1 = findViewById(R.id.edit_text_number1);
        editText2 = findViewById(R.id.edit_text_number2);
        editText3 = findViewById(R.id.edit_text_number3);
        textView = findViewById(R.id.text_view_result);
        buttonAddition = findViewById(R.id.btn_add);

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(editText1.getText().toString().length() == 0) {
                    editText1.setText("0");
                }
                if(editText2.getText().toString().length() == 0) {
                    editText2.setText("0");
                }
                if(editText3.getText().toString().length() == 0) {
                    editText3.setText("0");
                }*/
                if(editText1!=null&&editText2!=null&&editText3!=null) {
                    int num1 = Integer.parseInt(editText1.getText().toString());
                    int num2 = Integer.parseInt(editText2.getText().toString());
                    int num3 = Integer.parseInt(editText3.getText().toString());

                    sum = num1 + num2 + num3;
                    s=String.valueOf(sum);
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("Result",s);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        s = savedInstanceState.getString("Result");
        textView.setText(s);
    }
}