package com.example.bt_contentprovider;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnContact, btnMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent(){
        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhDanhBa();
            }
        });
        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhTinNhan();
            }
        });
    }

    private void xuLyMoManHinhDanhBa(){
        Intent intent = new Intent(MainActivity.this, ContactAct.class); // Sửa đổi ở đây
        startActivity(intent);
    }

    private void xuLyMoManHinhTinNhan() {
        Intent intent = new Intent(MainActivity.this, MessageAct.class);
        startActivity(intent);
    }

    private void addControl(){
        btnContact = findViewById(R.id.btncontact);
        btnMessage = findViewById(R.id.btnmessage);
    }
}
