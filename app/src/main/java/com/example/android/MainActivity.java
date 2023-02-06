package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_id;
    Button btn_id;
    ImageView iv_id;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_id = findViewById(R.id.btn_id);
        iv_id = findViewById(R.id.iv_id);

        btn_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                et_id.setText("테스트문구");
                msg = et_id.getText().toString();
                
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtra("str", msg);
                startActivity(intent); // SubActivity로 이동
                
            }
        });

        iv_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
            }
        });
    }
}