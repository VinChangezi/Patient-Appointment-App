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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewMedicineFragment extends Fragment {

    private static final String TAG = NewMedicineFragment.class.getSimpleName();

    private View rootView;

    public NewMedicineFragment() {
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


        // Dummy map of medicines and their prices
        Map<String, String> medicines = new HashMap<>();
        medicines.put("Amoxicillin", "$10");
        medicines.put("Ibuprofen", "$15");
        medicines.put("Paracetamol", "$20");
        medicines.put("Aspirin", "$25");
        medicines.put("Metformin", "$30");
        medicines.put("Lisinopril", "$35");
        medicines.put("Atorvastatin", "$40");
        medicines.put("Simvastatin", "$45");
        medicines.put("Omeprazole", "$50");
        medicines.put("Losartan", "$55");
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext())); // Set the layout manager
        NewMedicineFragment.MedicineAdapter adapter = new NewMedicineFragment.MedicineAdapter(medicines); // Replace with your data
        recyclerView.setAdapter(adapter);

    }

    public class MedicineAdapter extends RecyclerView.Adapter<NewMedicineFragment.MedicineAdapter.ViewHolder> {

        private Map<String, String> data;

        public MedicineAdapter(Map<String, String> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public NewMedicineFragment.MedicineAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_new_medicine_price_list, parent, false);
            return new NewMedicineFragment.MedicineAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewMedicineFragment.MedicineAdapter.ViewHolder holder, int position) {

            String medicineName = (String) data.keySet().toArray()[position];
            String price = data.get(medicineName);

            holder.textViewName.setText(medicineName);
            holder.textViewPrice.setText(price);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView textViewName;
            TextView textViewPrice;

            public ViewHolder(View itemView) {
                super(itemView);
                textViewName = itemView.findViewById(R.id.tv_medicine);
                textViewPrice = itemView.findViewById(R.id.special1_id_single_user);
            }
        }
    }
}