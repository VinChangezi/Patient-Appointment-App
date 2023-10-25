package com.example.aman.hospitalappointy.home;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aman.hospitalappointy.R;
import com.example.aman.hospitalappointy.model.QrModel;

import java.util.ArrayList;
import java.util.List;

public class QRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);

        RecyclerView recyclerView = findViewById(R.id.rv_scanner);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<QrModel> sampleData = new ArrayList<>();

        QrModel item1 = new QrModel();
        item1.setDoctorImage(getResources().getDrawable(R.drawable.img5)); // Replace yourDrawable1 with the actual Drawable
        item1.setDoctorName("Dr. John Smith");
        item1.setDoctorSpeciality("Cardiologist");
        item1.setAppointmentTime("10:00 AM");
        sampleData.add(item1);

        QrModel item2 = new QrModel();
        item2.setDoctorImage(getResources().getDrawable(R.drawable.img5)); // Replace yourDrawable2 with the actual Drawable
        item2.setDoctorName("Dr. Sarah Johnson");
        item2.setDoctorSpeciality("Dermatologist");
        item2.setAppointmentTime("2:30 PM");
        sampleData.add(item2);

        QrModel item3 = new QrModel();
        item3.setDoctorImage(getResources().getDrawable(R.drawable.img5)); // Replace yourDrawable3 with the actual Drawable
        item3.setDoctorName("Dr. Robert Lee");
        item3.setDoctorSpeciality("Orthopedic Surgeon");
        item3.setAppointmentTime("3:15 PM");
        sampleData.add(item3);

        QrModel item4 = new QrModel();
        item4.setDoctorImage(getResources().getDrawable(R.drawable.img5)); // Replace yourDrawable4 with the actual Drawable
        item4.setDoctorName("Dr. Emily White");
        item4.setDoctorSpeciality("Pediatrician");
        item4.setAppointmentTime("9:45 AM");
        sampleData.add(item4);

        QrModel item5 = new QrModel();
        item5.setDoctorImage(getResources().getDrawable(R.drawable.img5)); // Replace yourDrawable5 with the actual Drawable
        item5.setDoctorName("Dr. Michael Brown");
        item5.setDoctorSpeciality("Ophthalmologist");
        item5.setAppointmentTime("4:00 PM");
        sampleData.add(item5);


        MyAdapter adapter = new MyAdapter(sampleData); // Replace with your data
        recyclerView.setAdapter(adapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private List<QrModel> data;
//
        public MyAdapter(List<QrModel> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singel_qrcode_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            String item = data.get(position);
//            holder.textViewName.setText(item);
            holder.doctorName.setText(data.get(position).getDoctorName().toString());
            holder.doctorSpeciality.setText(data.get(position).getDoctorSpeciality().toString());
            holder.ivDoctor.setImageDrawable(data.get(position).getDoctorImage());
            holder.time.setText(data.get(position).getAppointmentTime().toString());


            holder.btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(QRCodeActivity.this, ConsultancyDetailActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            //            TextView textViewName;
            Button btnDetails;
            ImageView ivDoctor;
            TextView doctorName;
            TextView doctorSpeciality;
            TextView time;

            public ViewHolder(View itemView) {
                super(itemView);
                btnDetails = itemView.findViewById(R.id.btn_details);
                ivDoctor = itemView.findViewById(R.id.iv_doctor);
                doctorName = itemView.findViewById(R.id.single_doctorName);
                time = itemView.findViewById(R.id.single_time);
                doctorSpeciality = itemView.findViewById(R.id.single_doctorSpeciality);

            }
        }
    }
}