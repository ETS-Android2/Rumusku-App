package com.limitless.rumusku;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.limitless.rumusku.ui.FlatFragment;
import com.limitless.rumusku.ui.SolidFragment;

public class HomeAdapter extends FragmentStatePagerAdapter {
    private static final String ITEMS[] = {"Bangun Datar", "Bangun Ruang"};

    public HomeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i){
            case 0:
                fragment = new FlatFragment();

                break;
            case 1:
                fragment = new SolidFragment();

                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return ITEMS.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position ==2){
        }
        return ITEMS[position];
    }
}
