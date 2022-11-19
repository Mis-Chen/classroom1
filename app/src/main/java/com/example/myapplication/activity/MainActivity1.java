package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.Calendar;

public class MainActivity1 extends AppCompatActivity {
    // 实例化控件
    private Button dateButton;
    private Button timeButton;
    private EditText editText;
    private DatePickerDialog dateDialog;
    private TimePickerDialog timeDialog;
    private int year, monthOfYear, dayOfMonth, hourOfDay, minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // 通过findViewById找到控件
        dateButton = (Button) findViewById(R.id.button1);
        timeButton = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.edit);
        // 通过Calendar对象来获取年、月、日、时、分的信息
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        monthOfYear = calendar.get(calendar.MONTH);
        dayOfMonth = calendar.get(calendar.DAY_OF_MONTH);
        hourOfDay = calendar.get(calendar.HOUR_OF_DAY);
        minute = calendar.get(calendar.MINUTE);
        /*
         * 实例化DatePickerDialog
         */
        dateDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker arg0, int year, int monthOfYear,
                                  int dayOfMonth) {
                // 把获取的日期显示在文本框内，月份从0开始计数，所以要加1
                String text = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                editText.setText(text);
            }
        }, year, monthOfYear, dayOfMonth); // 后面的三个参数对应于上面的年、月、日

        /*
         * 实例化TimePickerDialog
         */
        timeDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity1.this, hourOfDay + ":" + minute,
                        Toast.LENGTH_LONG).show();
            }
        }, hourOfDay, minute, true); // 最后一个参数设置是否为24小时制
        /**
         * 对时间选择器按钮设置监听事件
         */
        timeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // 点击时间选择器按钮时显示出时间对话框
                timeDialog.show();
            }
        });
        /**
         * 对日期选择器按钮设置监听事件
         */
        dateButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // 点击日期选择器按钮时显示出日期对话框
                dateDialog.show();
                timeDialog.show();
            }
        });
    }

}