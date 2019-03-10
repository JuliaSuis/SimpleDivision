package com.example.simpledivision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Division division = new Division();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int parseEditText(EditText a){
        int int_a = Integer.parseInt(a.getText().toString());
        return int_a;
    }

    public void onClickDivide(View view){

        EditText a = (EditText) findViewById(R.id.first);
        EditText b = (EditText) findViewById(R.id.second);
        TextView result = (TextView) findViewById(R.id.results);
        try {
            double res = division.makeDivision(parseEditText(a), parseEditText(b));
            result.setText(String.format("%.2f", res));
        } catch (Exception e) {
            result.setText("Error! Enter both numbers.");
        }

    }
}
