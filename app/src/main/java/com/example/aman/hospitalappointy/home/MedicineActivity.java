package com.example.aman.hospitalappointy.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman.hospitalappointy.R;
import com.example.aman.hospitalappointy.utils.KeyboardUtils;
import com.google.android.material.tabs.TabLayout;

public class MedicineActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MedicinePagerAdapter mMedicinePagerAdapter;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        //Toolbar
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Hospital Appointy");

        //TabLayout , SectionPagerAdapter & ViewPager
        mViewPager = findViewById(R.id.main_ViewPager);
        mMedicinePagerAdapter = new MedicinePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mMedicinePagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                hideKeyboard();
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                hideKeyboard();
            }
        });

        mTabLayout = findViewById(R.id.main_tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);



        /*RecyclerView recyclerView = findViewById(R.id.medicine_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set the layout manager
        MedicineActivity.MedicineAdapter adapter = new MedicineActivity.MedicineAdapter(); // Replace with your data
        recyclerView.setAdapter(adapter);*/
    }

    private void hideKeyboard() {
        KeyboardUtils.hideKeyboard(MedicineActivity.this);
    }


    public class MedicineAdapter extends RecyclerView.Adapter<MedicineActivity.MedicineAdapter.ViewHolder> {

        @NonNull
        @Override
        public MedicineActivity.MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_medicine_list, parent, false);
            return new MedicineActivity.MedicineAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MedicineActivity.MedicineAdapter.ViewHolder holder, int position) {
//            String item = data.get(position);
//            holder.textViewName.setText(item);

            /*holder.btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(getContext(), ConsultationDetailActivity.class));

                }
            });*/
        }

        @Override
        public int getItemCount() {
            return 7;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            //            TextView textViewName;
//            Button btnDetails;

            public ViewHolder(View itemView) {
                super(itemView);
//                btnDetails = itemView.findViewById(R.id.btn_details);
            }
        }
    }
}