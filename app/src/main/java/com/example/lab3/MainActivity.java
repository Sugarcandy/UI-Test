package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String[] animals={
            "Lion",
            "Tiger",
            "Monkey",
            "Dog",
            "Cat",
            "Elephant"
    };

    final int[] picId={
            R.drawable.lion,
            R.drawable.tiger,
            R.drawable.monkey,
            R.drawable.dog,
            R.drawable.cat,
            R.drawable.elephant
    };
    //sampleAdapter实例，也可用自己定义一个AnimalAdapter实现，效果相同
    private List<Map<String,Object>> lists=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i=0;i<animals.length;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name",animals[i]);
            map.put("image",picId[i]);
            lists.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                MainActivity.this,
                lists,
                R.layout.simplelayout,
                new String[] {"name","image"},
                new int[]{R.id.animal_text,R.id.animal_image}
                );
        final ListView listView = (ListView) findViewById(R.id.listview);
        if(listView!=null)
            listView.setAdapter(adapter);
        else
            Toast.makeText(this,
                    "空的listview",
                    Toast.LENGTH_SHORT).show();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setSelected(true);
                        Toast.makeText(MainActivity.this,
                                animals[position],
                                Toast.LENGTH_SHORT
                        ).show();
            }
        });
    }
}
