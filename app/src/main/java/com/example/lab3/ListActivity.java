package com.example.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListActivity extends AppCompatActivity {

    String []name=new String[]{
            "One",
            "Two",
            "Three",
            "Four",
            "Five"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        final List<Map<String,Object>> list=new ArrayList<>();
        for(int i=0;i<5;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("pic",R.drawable.ic_launcher);
            map.put("name",name[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.layout_list_menu,
                new String[] {"pic","name"},
                new int[]{R.id.image_list,R.id.text_list}
        );
        final ListView listView = (ListView) findViewById(R.id.view_list);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);//选项可以多选
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                listView.setSelection(position);
                mode.setTitle(listView.getCheckedItemCount()+" selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater=mode.getMenuInflater();
                inflater.inflate(R.menu.actionmode,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.delete:
                        Toast.makeText(ListActivity.this,"you want delete your selected!", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    case R.id.select:
                        Toast.makeText(ListActivity.this,"you want cancel your selected!", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
    }
}
