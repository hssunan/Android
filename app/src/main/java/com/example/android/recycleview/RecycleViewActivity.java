package com.example.android.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.R;

import java.util.ArrayList;

public class RecycleViewActivity extends AppCompatActivity {

    private ArrayList<SampleData> list;
    private RvAdapter rvAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        list = new ArrayList<SampleData>();
        rvAdapter = new RvAdapter(list);
        recyclerView.setAdapter(rvAdapter);

        Button btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SampleData sampleData = new SampleData(R.mipmap.ic_launcher, "SampleTitle", "SampleContent");
                list.add(sampleData);
                rvAdapter.notifyDataSetChanged();
            }
        });

    }
}