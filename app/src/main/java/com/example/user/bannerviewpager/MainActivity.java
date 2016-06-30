package com.example.user.bannerviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BannerBean> listLocal = new ArrayList<>();
    private List<BannerBean>listAd = new ArrayList<>();
    private BannerViewPager viewPager ;
    private LinearLayout ovalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initLocalAd();
        initView();
    }

    private void initView() {
        ovalLayout = (LinearLayout)findViewById(R.id.ovalLayout);
        viewPager = (BannerViewPager)findViewById(R.id.viewpager);
        viewPager.setMyOnItemClickListener(new BannerViewPager.MyOnItemClickListener() {
            @Override
            public void onItemClick(int curIndex) {
                Toast.makeText(MainActivity.this, "click " + curIndex, Toast.LENGTH_SHORT).show();
            }
        });

        viewPager.start(this, listAd, listLocal, ovalLayout,
                R.drawable.point_white, R.drawable.point_wihte_transparent);
    }

    private void initLocalAd() {
        listLocal.add(new BannerBean("banner_1", R.mipmap.banner_1 + ""));
        listLocal.add(new BannerBean("banner_2", R.mipmap.banner_2 + ""));
        listLocal.add(new BannerBean("banner_3", R.mipmap.banner_3 + ""));
    }
}
