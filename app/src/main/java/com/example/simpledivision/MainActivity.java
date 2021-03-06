package com.example.simpledivision;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Operation operation = new Division();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int parseEditText(EditText a){

        return Integer.parseInt(a.getText().toString());
    }

    public void onClickDivide(View view){
        EditText a = findViewById(R.id.first);
        EditText b = findViewById(R.id.second);
        TextView result = findViewById(R.id.results);
        try {
            double res = operation.execute(parseEditText(a), parseEditText(b));
            if (Double.isNaN(res)) {
                result.setText(getString(R.string.nan_error));
            } else if (Double.isInfinite(res)) {
                result.setText(getString(R.string.inf_error));
            } else {
                result.setText(String.format("%.2f", res));
            }
        } catch (NumberFormatException e) {
            result.setText(getString(R.string.valid_error));
        } catch (Exception e) {
            result.setText(getString(R.string.error));
        }

    }
}
