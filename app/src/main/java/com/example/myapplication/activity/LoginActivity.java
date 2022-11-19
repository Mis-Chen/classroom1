package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    ListView list_item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        list_item = findViewById(R.id.list_item);
        //定义数据
        String []name = {"出发地点","出发时间","目标地点","返程时间"};
        int img[] = {R.drawable.jia,R.drawable.start_time,R.drawable.gongsi,R.drawable.end_time};
        List<Map<String,Object>> data  = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> items = new HashMap<>();
            items.put("name", name[i]);
            items.put("images", img[i]);
            data.add(items);
        }
        //实例化适配器
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,data,R.layout.mylist_items,new String[]{"images","name"},new int[]{R.id.iv_mylistIteam,R.id.tv_mylistItem});
        list_item.setAdapter(simpleAdapter);
        list_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               /* new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        if (year >= 1910 && year <= 2014) {
                            int temp = monthOfYear + 1;
                            String monthStr = temp < 10 ? "0" + temp : "" + temp;
                            etBirthday.setText(year + "-" + monthStr + "-" + dayOfMonth);
                        } else {
                            AppMsg.makeText(PersonalEditActivity.this, "超出可设置范围");
                        }
                    }
                }, 1990, 0, 1).show();*/
            }
        });
    }
}