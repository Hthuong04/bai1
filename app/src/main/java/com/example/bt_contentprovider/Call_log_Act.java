package com.example.bt_contentprovider;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Call_log_Act extends AppCompatActivity {

    private final int REQUEST_CALL_LOG_PERMISSION = 1001;

    ListView lvCallLog;
    ArrayList<Call_log> listCallLog;
    ArrayAdapter<Call_log> callLogAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.call_log);  // Giao diện XML `call_log.xml` đã cung cấp

        // Ánh xạ TextView và ListView trong giao diện XML
        TextView tvTen = findViewById(R.id.tv_ten);
        lvCallLog = findViewById(R.id.lvCall_log);

        listCallLog = new ArrayList<>();
        callLogAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listCallLog);
        lvCallLog.setAdapter(callLogAdapter);

        // Kiểm tra quyền đọc nhật ký cuộc gọi
        if (checkSelfPermission(android.Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.READ_CALL_LOG}, REQUEST_CALL_LOG_PERMISSION);
        } else {
            showAllCallLogs();
        }
    }

    private void showAllCallLogs() {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                listCallLog.clear();
                while (cursor.moveToNext()) {
                    // Sử dụng getColumnIndexOrThrow() để lấy chỉ số của cột, hoặc mặc định giá trị nếu không tìm thấy
                    String phone = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.NUMBER));
                    String callType = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.TYPE));
                    String callDate = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DATE));
                    String callDuration = cursor.getString(cursor.getColumnIndexOrThrow(CallLog.Calls.DURATION));

                    // Kiểm tra và phân loại kiểu cuộc gọi
                    String type = null;
                    switch (Integer.parseInt(callType)) {
                        case CallLog.Calls.OUTGOING_TYPE:
                            type = "Cuộc gọi đi";
                            break;
                        case CallLog.Calls.INCOMING_TYPE:
                            type = "Cuộc gọi đến";
                            break;
                        case CallLog.Calls.MISSED_TYPE:
                            type = "Cuộc gọi nhỡ";
                            break;
                    }

                    // Định dạng ngày tháng
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
                    String date = dateFormat.format(new Date(Long.parseLong(callDate)));

                    // Tạo đối tượng Call_log và thêm vào danh sách
                    Call_log callLog = new Call_log(null, phone, type, date, callDuration + " giây");
                    listCallLog.add(callLog);
                }
                callLogAdapter.notifyDataSetChanged();
            }
        } catch (Exception e) {
            e.printStackTrace();  // Ghi lại lỗi nếu có
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_LOG_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                showAllCallLogs();
            } else {
                // Thông báo khi quyền bị từ chối
            }
        }
    }
}
