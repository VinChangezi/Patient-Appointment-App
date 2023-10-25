package com.example.aman.hospitalappointy.home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.aman.hospitalappointy.home.fragments.DoctorFragment;
import com.example.aman.hospitalappointy.home.fragments.MyMedicineFragment;
import com.example.aman.hospitalappointy.home.fragments.NewMedicineFragment;
import com.example.aman.hospitalappointy.home.fragments.SpecializationFragment;

public class MedicinePagerAdapter extends FragmentPagerAdapter {
    public MedicinePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
//                SpecializationFragment specializationFragment = new SpecializationFragment();
//                return specializationFragment;

                MyMedicineFragment myMedicineFragment1 = new MyMedicineFragment();
                return myMedicineFragment1;

            case 1:
                NewMedicineFragment myMedicineFragment2 = new NewMedicineFragment();
                return myMedicineFragment2;

            /*case 2:
                DateFragment dateFragment = new DateFragment();
                return dateFragment;*/

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
                return "MY MEDICINES";
            case 1:
                return "NEW MEDICINES";

            default:
                return null;
        }
    }
}

