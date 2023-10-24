package com.example.aman.hospitalappointy.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman.hospitalappointy.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        RecyclerView recyclerView = findViewById(R.id.test_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Set the layout manager
        MedicineAdapter adapter = new MedicineAdapter(); // Replace with your data
        recyclerView.setAdapter(adapter);
    }

    public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.ViewHolder> {

//        private List<String> data;
//
//        public MyAdapter(List<String> data) {
//            this.data = data;
//        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_test_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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