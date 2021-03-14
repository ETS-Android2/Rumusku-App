package com.limitless.rumusku;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.limitless.rumusku.ui.ShapeDatarPrePlaceholder;
import com.limitless.rumusku.ui.ShapeDatarPrePlaceholder2;

public class ViewDatarAdapter {
    private static final String ISI[] = {"Keliling", "Luas"};

    public static class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0:
                    fragment = new ShapeDatarPrePlaceholder();
                    break;
                case 1:
                    fragment = new ShapeDatarPrePlaceholder2();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return ISI.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return ISI[position];
        }

    }
}
