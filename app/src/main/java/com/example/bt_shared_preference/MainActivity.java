package com.example.bt_shared_preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn;
    EditText editTextUser;
    EditText editTextPass;
    CheckBox cbRemember;
    TextView textShow;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Ánh xạ các View
        AnhXa();

        // Thiết lập SharedPreferences
        sharedPreferences = getSharedPreferences("dataShared", Context.MODE_PRIVATE);
        String savedName = sharedPreferences.getString("name", "");
        String savedMsv = sharedPreferences.getString("msv", "");

        // Hiển thị dữ liệu đã lưu nếu có
        if (!savedName.isEmpty() || !savedMsv.isEmpty()) {
            textShow.setText("Xin chào " + savedName + " " + savedMsv);
        }

        // Điền dữ liệu vào EditText
        editTextUser.setText(savedName);
        editTextPass.setText(savedMsv);

        // Cài đặt lắng nghe thay đổi cho insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý sự kiện đăng nhập
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUser.getText().toString().trim();
                String password = editTextPass.getText().toString().trim();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", username);
                editor.putString("msv", password);
                editor.apply();  // Lưu không đồng bộ, an toàn khi làm việc trên UI thread

                // Cập nhật TextView với giá trị mới
                textShow.setText("Xin chào " + username + " " + password);

                if (username.equals("huyenthuong") && password.equals("1234")) {
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void AnhXa() {
        btnSignIn = findViewById(R.id.btnSignIn);
        editTextUser = findViewById(R.id.editTextUser);
        editTextPass = findViewById(R.id.editTextPass);
        cbRemember = findViewById(R.id.cbRemember);
        textShow = findViewById(R.id.textShow);  // Ánh xạ textShow
    }
}
