package com.example.navitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> list = new ArrayList<>();
    ViewPager mViewPager;
    BottomNavigationView mBnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager);
        mBnView = findViewById(R.id.bn_view);
        // 随便加了三个有内容的Fragment
        list.add(new FragmentTabFrag1());
        list.add(new FragmentEventBus());
        list.add(new FragmentEventBus2());

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), list);

        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mBnView.setSelectedItemId(R.id.first);
                        break;
                    case 1:
                        mBnView.setSelectedItemId(R.id.second);
                        break;
                    case 2:
                        mBnView.setSelectedItemId(R.id.third);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.first:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.second:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.third:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}