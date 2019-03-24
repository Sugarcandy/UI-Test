package com.example.lab3;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.EditText;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final EditText editText=(EditText) findViewById(R.id.editText3);
        switch(item.getItemId()){
            case R.id.big:
                editText.setTextSize(20);
                break;
            case R.id.middle:
                editText.setTextSize(16);
                break;
            case R.id.small:
                editText.setTextSize(10);
                break;
            case R.id.normal:
                Toast.makeText(this,"You clicked normal menu item!",Toast.LENGTH_SHORT).show();
                break;
            case R.id.red:
                editText.setTextColor(Color.RED);
                break;
            case R.id.black:
                editText.setTextColor(Color.BLACK);
                break;
            default:
        }
        return true;
    }
}
