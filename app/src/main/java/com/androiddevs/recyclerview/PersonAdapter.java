package com.androiddevs.recyclerview;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> implements View.OnClickListener {

    private ArrayList<Person> persons;
    private OnItemClickListener listener;

    public PersonAdapter(ArrayList<Person> persons) {
        this.persons = persons;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = persons.get(position);

        holder.ivImage.setImageResource(person.getImageResource());
        holder.tvName.setText("Name: " + person.getName());
        holder.tvAge.setText("Age: " + person.getAge());
        if(person.getSelected() == false){
            holder.like.setImageResource(R.drawable.ic_unlike);
        }
        if (person.getSelected() == true)
            holder.like.setImageResource(R.drawable.ic_android_black_24dp);

    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    @Override
    public void onClick(View view) {

    }
    public interface OnItemClickListener{
        void OnLikeClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivImage,like;
        TextView tvName, tvAge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivImage = itemView.findViewById(R.id.ivImage);
            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            like = itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){

                        }
                    }
                }
            });
            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.OnLikeClick(position);
                            notifyDataSetChanged();
                        }
                    }

                }
            });


        }

    }
}
