package com.example.aman.hospitalappointy.home.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman.hospitalappointy.R;

public class MyMedicineFragment extends Fragment {

    private static final String TAG = MyMedicineFragment.class.getSimpleName();

    private View rootView;

    public MyMedicineFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my_medicine, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.medicine_recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext())); // Set the layout manager
        MyMedicineFragment.MedicineAdapter adapter = new MyMedicineFragment.MedicineAdapter(); // Replace with your data
        recyclerView.setAdapter(adapter);

    }

    public class MedicineAdapter extends RecyclerView.Adapter<MyMedicineFragment.MedicineAdapter.ViewHolder> {

//        private List<String> data;
//
//        public MyAdapter(List<String> data) {
//            this.data = data;
//        }

        @NonNull
        @Override
        public MyMedicineFragment.MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_medicine_list, parent, false);
            return new MyMedicineFragment.MedicineAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyMedicineFragment.MedicineAdapter.ViewHolder holder, int position) {
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