package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    EditText name ;
    Button button_continue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        button_continue = findViewById(R.id.button);

        button_continue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                EditText editText = (EditText) findViewById(R.id.name);
                String message = name.getText().toString();
                Context context = getApplicationContext();


                if (message.equals("")){
                    Toast toast = Toast.makeText(context, "PLEASE ENTER YOUR NAME TO CONTINUE", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    Intent intent = new Intent(v.getContext(), HomeActivity.class);
                    intent.putExtra("name", message);
                    startActivity(intent);
                }

            }
        });
    }



}