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
import android.widget.TextView;

import com.example.aman.hospitalappointy.R;

import java.util.Arrays;
import java.util.List;

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


        // Dummy list of medicines
        List<String> medicines = Arrays.asList("Amoxicillin", "Ibuprofen", "Paracetamol", "Aspirin", "Metformin", "Lisinopril", "Atorvastatin", "Simvastatin", "Omeprazole", "Losartan");

        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext())); // Set the layout manager
        MyMedicineFragment.MedicineAdapter adapter = new MyMedicineFragment.MedicineAdapter(medicines); // Replace with your data
        recyclerView.setAdapter(adapter);

    }

    public class MedicineAdapter extends RecyclerView.Adapter<MyMedicineFragment.MedicineAdapter.ViewHolder> {

        private List<String> data;

        public MedicineAdapter(List<String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public MyMedicineFragment.MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_medicine_list, parent, false);
            return new MyMedicineFragment.MedicineAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyMedicineFragment.MedicineAdapter.ViewHolder holder, int position) {

            String item = data.get(position);
            holder.textViewName.setText(item);

            /*holder.btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(getContext(), ConsultationDetailActivity.class));

                }
            });*/
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textViewName;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewName = itemView.findViewById(R.id.tv_medicine);
            }
        }
    }
}