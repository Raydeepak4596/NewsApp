package com.example.news_app_youtube;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter( FragmentManager fm, int tabcount) {
        super(fm, tabcount);
        this.tabcount = tabcount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
//        return null;
        switch (position)
        {
            case 0:
                return new HomeFragment();

            case 1:
                return new SportsFragment();
            case 2:
                return new HealthFragment();

            case 3:
                return new ScienceFragment();

            case 4:
                return new EntertainmentFragment();

            case 5:
                return new TechFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
