package com.example.secondapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Second extends AppCompatActivity {

    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras = getIntent().getExtras();
        txt = findViewById(R.id.txt2);
        String value = "";
        if (extras != null) {
            value = extras.getString("lang");
            txt.setText("На предыдущем активити был выбран язык - " + value);
        }
    }

    public void Back(View view){
        finish();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Toast.makeText(getApplication(), "Вызван метод onSaveInstanceState(). Запись в лог.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Toast.makeText(getApplication(), "Вызван метод onRestoreInstanceState(). Запись в лог.", Toast.LENGTH_SHORT).show();
    }
}