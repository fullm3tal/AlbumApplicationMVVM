package com.example.devtrainee.albumapplicationmvvm;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.devtrainee.albumapplicationmvvm.pojo.People;

import java.util.Collections;
import java.util.List;

public class CustomPeopleAdapter extends RecyclerView.Adapter<CustomPeopleAdapter.ItemPeopleViewHolder> {


    public List<People> peopleList;
    Context context;

    public CustomPeopleAdapter(List<People> peopleList, Context context) {
        this.peopleList = Collections.EMPTY_LIST;
    }


    @NonNull
    @Override
    public ItemPeopleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_people, viewGroup, false);
        return new ItemPeopleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPeopleViewHolder itemPeopleViewHolder, int i) {

        itemPeopleViewHolder.tvNamePeople.setText(peopleList.get(i).getName().toString());
        itemPeopleViewHolder.tvEmailPeople.setText(peopleList.get(i).getEmail());
        itemPeopleViewHolder.tvNumberPeople.setText(peopleList.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }


    public static class ItemPeopleViewHolder extends RecyclerView.ViewHolder {
       TextView tvNamePeople,tvEmailPeople, tvNumberPeople;

        public ItemPeopleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamePeople= itemView.findViewById(R.id.tv_name_person);
            tvEmailPeople=itemView.findViewById(R.id.tv_number_person);
            tvNumberPeople=itemView.findViewById(R.id.tv_email_person);
        }



    }

}
