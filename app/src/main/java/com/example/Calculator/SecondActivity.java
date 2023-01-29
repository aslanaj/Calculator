package com.example.Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aslan_m2_hw_7.R;

import java.util.Locale;


public class SecondActivity extends AppCompatActivity {
    private Button buttonDestroy;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonDestroy = findViewById(R.id.btn_red);
        Log.d("aslanaj", "onCreate SecondActivity");
        Intent intent = getIntent();
        String result = intent.getStringExtra("key");
        ((TextView) findViewById(R.id.text_view_result)).setText(result);


        buttonDestroy.setOnClickListener(v -> {
            Intent intent1 = new Intent(Intent.ACTION_MAIN);
            intent1.addCategory( Intent.CATEGORY_HOME);
            intent1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            System.exit(1);
        });

    }


        @Override
    protected void onStart() {
        super.onStart();
        Log.d("aslanaj","onStart SecondActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("aslanaj","onResume SecondActivity");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("aslanaj","onPause SecondActivity");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("aslanaj","onStop SecondActivity");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("aslanaj","onDestroy SecondActivity");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("aslanaj","onRestart SecondActivity");
    }
}