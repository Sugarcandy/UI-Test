package com.example.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ConsoleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console);
        Button sample=findViewById(R.id.button_sample);
        Button dialog=findViewById(R.id.button_dialog);
        Button menu=findViewById(R.id.button_menu);
        Button action=findViewById(R.id.button_actionmode);

        sample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ConsoleActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });

    }
}
