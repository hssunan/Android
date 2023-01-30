package com.example.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        List<String> dataList = new ArrayList<String>();

        dataList.add("listTest");
        dataList.add("hsan");
        dataList.add("helloWorld");

        list = (ListView)findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();






    }
}