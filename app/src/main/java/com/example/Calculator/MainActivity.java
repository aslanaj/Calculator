package com.example.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aslan_m2_hw_7.R;

public class MainActivity extends AppCompatActivity {

    String oldNumber;
    String operator = "";
    TextView textView;
    Boolean isNew = true;
    private  String text1 = "";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        Log.d("aslanaj","onCreate");
        findViewById(R.id.btn_second_activity).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            String text1 = ((TextView)findViewById(R.id.text_view)).getText().toString();
            intent.putExtra("key",text1);
            startActivity(intent);

        });
        Log.d("aslanaj", text1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("aslanaj","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aslanaj","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aslanaj","onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aslanaj","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aslanaj","onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("aslanaj","onRestart");
    }



    public void onNumberClick(View view) {


        if(isNew)
            textView.setText("");
        isNew = false;
        String number = textView.getText().toString();
        switch (view.getId()){
            case R.id.btn_one: number = number+"1"; break;
            case R.id.btn_two: number = number+"2"; break;
            case R.id.btn_3: number = number+"3"; break;
            case R.id.btn_4: number = number+"4"; break;
            case R.id.btn_5: number = number+"5"; break;
            case R.id.btn_6: number = number+"6"; break;
            case R.id.btn_seven: number = number+"7"; break;
            case R.id.btn_eight: number = number+"8"; break;
            case R.id.btn_nine: number = number+"9"; break;
            case R.id.btn_0: number = number+"0"; break;

            case R.id.btn_dot:
                if ( dotIsPresent(number)){
                } else {
                    number = number + ".";
                }
                break;

            case R.id.btn_p_m:

               if (minusPresent(number)){
                   number = number.substring(1);
               }else {
                   number = "-" + number;
               }
                   break;

        }
        textView.setText(number);
    }

    public boolean minusPresent(String number) {
        if(number.charAt(0) == '-'){
            return true;
        }else {
            return false;
        }
    }

    public void onOperationClick(View view) {
        isNew = true;
        oldNumber = textView.getText().toString();
        switch (view.getId()){
            case R.id.btn_mines: operator="-"; break;
            case R.id.btn_plus: operator="+"; break;
            case R.id.btn_multiply: operator="*"; break;
            case R.id.btn_divide:  operator="/"; break;


        }

    }

    public void onClickEqual(View view) {

        String newNumber = textView.getText().toString();
        Double result = 0.0;
        switch (operator) {
            case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber) ; break;
            case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber) ; break;
            case "*": result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) ; break;
            case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) ; break;
        }
        textView.setText(result+"");
    }

    public void acClick(View view) {
        textView.setText("0");
        isNew = true;
    }

    public boolean dotIsPresent(String number){
       if(number.indexOf(".") == -1){
           return false;
       } else {
           return  true;
       }
    }

    public void onClickPercent(View view) {


        if(operator == ""){
            String number = textView.getText().toString();
            double temp = Double.parseDouble(number) / 100;
            number = temp+"";
            textView.setText(number);
        } else {
            Double result = 0.0;
            String newNumber = textView.getText().toString();
            switch (operator) {
                case "+": result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100 ;
                break;
                case "-": result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100 ;
                break;
                case "*": result = Double.parseDouble(oldNumber)  * Double.parseDouble(newNumber) / 100 ;
                break;
                case "/": result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber) * 100 ;
                break;
            }

            textView.setText(result+"");
            operator = "";
        }


    }

}