package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedPrefActivity extends AppCompatActivity {

    private EditText et_save;
    private String shared = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref);

        et_save = findViewById(R.id.et_save);

        // app 재실행 시 종료될 때 editor에 "test"로 저장한 String 값 get and set
        SharedPreferences sp = getSharedPreferences(shared, 0);
        String value = sp.getString("test", "");
        et_save.setText(value);

    }

    // activity 생명주기 종료
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sp = getSharedPreferences(shared, 0);
        // app 종료 시 임시로 저장할 String값 editor에 저장
        SharedPreferences.Editor editor = sp.edit();
        String value = et_save.getText().toString();
        editor.putString("test", value);
        editor.commit();

    }
}