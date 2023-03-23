package com.example.secondapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private String TAG = "Жизненный цикл продукта";

    private Locale currentLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLocale = getResources().getConfiguration().locale;
        Toast.makeText(this, "Вызван метод OnCreate(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplication(), "Вызван метод OnDestroy(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy()");
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Toast.makeText(getApplication(), "Вызван метод onSaveInstanceState(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    public void onRestoreInstanceState(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Toast.makeText(getApplication(), "Вызван метод onRestoreInstanceState(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Вызван метод OnPause(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Вызван метод OnStart(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Вызван метод OnStop(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Вызван метод OnResume(). Запись в лог.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume()");
    }

    public void Language(View view){
        if (currentLocale.toString().equals("en")){
            setLocale(new Locale("ru"));
        }
        else{
            setLocale(new Locale("en"));
        }
    }

    private void setLocale(Locale locale) {
        // Обновляем конфигурацию ресурсов приложения
        Resources res = getResources();
        Configuration config = res.getConfiguration();
        config.locale = locale;
        res.updateConfiguration(config, res.getDisplayMetrics());

        // Перезапускаем активность
        recreate();
    }

    public void goToActivity(View view){
        Intent intent = new Intent(this, Second.class);
        Bundle bundle = new Bundle();
        String s = "Русский";
        if (currentLocale.toString().equals("en")){
            s = "Английский";
        }
        bundle.putString("lang", s);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void ChangeLanguage(View view){
        TextView txt = findViewById(R.id.txt);
        int ver = Build.VERSION.SDK_INT;
        if (ver >= 27){
            txt.setText("Версия SDK выше чем 27!\nВаша версия : " + Integer.toString(ver));
        }
        else{
            txt.setText("Ваша версия SDK меньше 27, на котором оно было протестировано.\nВаша версия : " + Integer.toString(ver));
        }
    }
}