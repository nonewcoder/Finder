package com.example.android.finder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class resultListAdapter extends  RecyclerView.Adapter<resultListAdapter.resultListViewHolder> {

    Context context;
    ArrayList<objectData> resultList;

    public resultListAdapter(Context context, ArrayList<objectData> resultList) {
        this.context = context;
        this.resultList = resultList;
    }

    @NonNull
    @Override
    public resultListAdapter.resultListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.obejct_layout, null, false);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layout_view.setLayoutParams(layoutParams);

        resultListAdapter.resultListViewHolder rcv = new resultListAdapter.resultListViewHolder(layout_view);

        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull resultListAdapter.resultListViewHolder holder, int position) {

        holder.centerName.setText(resultList.get(position).getCenterName());
        holder.date.setText(resultList.get(position).getDate());
        holder.address.setText(resultList.get(position).getAddress()+"\n"+resultList.get(position).getPincode()+", "+resultList.get(position).getDistrictName()+", "+resultList.get(position).getStateName());
        holder.ageLimit.setText(resultList.get(position).getAgeLimit()+"+");
        holder.availableCapacity.setText("Total: "+resultList.get(position).getAvailableCapacity()+"\nDose 1: "+resultList.get(position).getDose1()+"\nDose 2: "+resultList.get(position).getDose2());
        holder.feeType.setText(resultList.get(position).getFeeType());
        holder.fee.setText("Rs."+resultList.get(position).getFee());
        holder.vaccine.setText(resultList.get(position).getVaccine());
        holder.timing.setText(resultList.get(position).getTimingFrom()+" - "+resultList.get(position).getTimingTo());
        holder.slots.setText(resultList.get(position).getSlots());

    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    public static class resultListViewHolder extends RecyclerView.ViewHolder
    {

        TextView centerName,date,address,ageLimit,availableCapacity,feeType,fee,vaccine,timing,slots;

        public resultListViewHolder(View itemView) {
            super(itemView);

            centerName=itemView.findViewById(R.id.centerNameBox);
            date=itemView.findViewById(R.id.dateBox);
            address=itemView.findViewById(R.id.addressBox);
            ageLimit=itemView.findViewById(R.id.ageLimitBox);
            availableCapacity=itemView.findViewById(R.id.availableCapacityBox);
            feeType=itemView.findViewById(R.id.feeTypeBox);
            fee=itemView.findViewById(R.id.feeBox);
            vaccine=itemView.findViewById(R.id.vaccineBox);
            timing=itemView.findViewById(R.id.timingBox);
            slots=itemView.findViewById(R.id.slotsBox);



        }
    }

}
