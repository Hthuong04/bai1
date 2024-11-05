package com.example.bt_contentprovider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnContact, btnMessage, btnCallLog;

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
        btnCallLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyMoManHinhLichSuCuocGoi();
            }
        });
    }

    private void xuLyMoManHinhDanhBa(){
        Intent intent = new Intent(MainActivity.this, ContactAct.class);
        startActivity(intent);
    }

    private void xuLyMoManHinhTinNhan() {
        Intent intent = new Intent(MainActivity.this, MessageAct.class);
        startActivity(intent);
    }

    private void xuLyMoManHinhLichSuCuocGoi() {
        Intent intent = new Intent(MainActivity.this, Call_log_Act.class);
        startActivity(intent);
    }

    private void addControl(){
        btnContact = findViewById(R.id.btncontact);
        btnMessage = findViewById(R.id.btnmessage);
        btnCallLog = findViewById(R.id.btnCall_log); // Thêm ánh xạ cho btnCallLog
    }
}
