package com.example.aman.hospitalappointy.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.aman.hospitalappointy.home.fragments.MyMedicineFragment;
import com.example.aman.hospitalappointy.home.fragments.MyTestFragment;

public class TestPagerAdapter extends FragmentPagerAdapter {
    public TestPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:

                MyTestFragment myTestFragment1 = new MyTestFragment();
                return myTestFragment1;

            case 1:
                MyTestFragment myTestFragment2 = new MyTestFragment();
                return myTestFragment2;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "MY TESTS";
            case 1:
                return "NEW TESTS";

            default:
                return null;
        }
    }
}
