package com.limitless.rumusku.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.limitless.rumusku.R;
import com.limitless.rumusku.ViewRuangAdapter;

public class ShapeRuangPreActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DachshundTabLayout tabLayout;
    private TextView tvBangun;
    private ImageView img_shpe;
    private int posisi;
    private SharedPreferences preferences;
    private Button btnBack;
    private int valid = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_pre);

        tvBangun = findViewById(R.id.tv_tittle);
        img_shpe = findViewById(R.id.img_shape);

        preferences = getSharedPreferences("datar", 0);
        posisi = preferences.getInt("posisi", 0);

        btnBack = findViewById(R.id.btn_back);

        viewPager = findViewById(R.id.view_pager_shape);
        viewPager.setAdapter(new ViewRuangAdapter.PagerAdapter(getSupportFragmentManager()));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        valid = 1;
                        break;
                    case 1:
                        valid = 2;
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tabLayout = findViewById(R.id.tab_content);
        tabLayout.setupWithViewPager(viewPager);
        tvBangun.setText(preferences.getString("datar", null));
        img_shpe.setImageResource(preferences.getInt("gambarRuang", 0));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
