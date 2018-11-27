package com.jeff.umar.p101;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class Main2Activity extends AppCompatActivity {

    private ArrayAdapter<String>adapter;
    private ArrayList<String>arrayList;
    private EditText txtinput;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ListView listView=(ListView)findViewById(R.id.listvv);
        String[] list = {"Sixth form opening evening",
                "arranon lennon lecture","Parents evening YR10", "Sixth Form Assembly "};
        arrayList= new ArrayList<>(Arrays.asList(list));
        adapter= new ArrayAdapter<String>(this,R.layout.listv,R.id.txtitem,arrayList);
        listView.setAdapter(adapter);
        txtinput=(EditText)findViewById(R.id.editText);
        Button btnadd = (Button)findViewById(R.id.buttonfac);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = txtinput.getText().toString();
                arrayList.add(newItem);
                adapter.notifyDataSetChanged();
            }
        });


    }

}
