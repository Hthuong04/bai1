package com.example.bt_layout_constraint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText editTextInput;
        EditText editTextInputPass;
        Button buttonShow;
        TextView textViewOutput;
        TextView textViewOutput1;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        editTextInput = findViewById(R.id.inputUsername);
        editTextInputPass = findViewById(R.id.inputEmail);
        buttonShow = findViewById(R.id.btn_login);
        textViewOutput = findViewById(R.id.textView7);
        textViewOutput1 = findViewById(R.id.textView8);// Kiểm tra ID trong layout

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString(); // Lấy nội dung từ EditText
                textViewOutput.setText(inputText); // Hiển thị nội dung trong TextView
                String inputText1 = editTextInputPass.getText().toString(); // Lấy nội dung từ EditText
                textViewOutput1.setText(inputText1);
            }
        });
        TextView btn = findViewById(R.id.textviewSignup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

    }
}