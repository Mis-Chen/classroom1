package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.myapplication.activity.HomeActivity;
import com.example.myapplication.fragment.Fragment1;
import com.example.myapplication.fragment.Fragment2;
import com.example.myapplication.fragment.Fragment3;
import com.example.myapplication.fragment.Fragment4;
import com.example.myapplication.fragment.Fragment5;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<Fragment> fragments;
    private Button tiyan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //我们的fragment的话主要是我们的碎片使用我们的碎片化的管理方式
        /*
         * 第一步的话就是找到我们的viewpager控件
         * */
        //创建一个容器这个容器的话就是我们的Arraylist将我们的所有的图片都添加进去,然后的话转化成我们的成员变量
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());
        ViewPager viewPager = (ViewPager) findViewById(R.id.Viewpager);
        /*
         * 第二步就是添加我们的适配器
         * */
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());
        //设定我们的适配器
        viewPager.setAdapter(adapter);


    }
    public class FragAdapter extends FragmentPagerAdapter{

        public FragAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            //通过我们的一个position到我们的集合当中获取对应的数据
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            //返回数据集合中的fragment的size
            return fragments.size();
        }
    }
}
