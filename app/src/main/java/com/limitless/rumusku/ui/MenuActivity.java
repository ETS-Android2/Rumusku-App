package com.limitless.rumusku.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.kekstudio.dachshundtablayout.DachshundTabLayout;
import com.limitless.rumusku.BuildConfig;
import com.limitless.rumusku.HomeAdapter;
import com.limitless.rumusku.R;
import com.limitless.rumusku.model.DatarModel;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private DachshundTabLayout tabLayout;
    private TextView tvVer;
    private ArrayList<DatarModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(new HomeAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        tvVer = findViewById(R.id.textView13);
        tvVer.setText(BuildConfig.VERSION_NAME);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher)
                .setTitle(R.string.exitTitle)
                .setMessage(R.string.exitMessage)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .setNeutralButton(R.string.later, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).show();
    }

}