package com.example.rideme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;


class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyViewHolder> {
    private Context context;
    private List<ProfileApi.Trips> tripsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView from,to,from_time,to_time,total,currency,travelTime;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            from = view.findViewById(R.id.from);
            to = view.findViewById(R.id.to);
            from_time = view.findViewById(R.id.fromTime);
            to_time=view.findViewById(R.id.toTime);
            total=view.findViewById(R.id.total);
            currency=view.findViewById(R.id.currency);
            travelTime=view.findViewById(R.id.travelTimeMin);
        }
    }


    public ProfileAdapter(Context context, List<ProfileApi.Trips> tripsList) {
        this.context = context;
        this.tripsList = tripsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rides_layout, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final ProfileApi.Trips movie = tripsList.get(position);
        holder.from.setText(movie.getFrom());
        holder.to.setText(movie.getTo());
        holder.from_time.setText(movie.getFrom_time());
        holder.to_time.setText(movie.getTo_time());
        holder.currency.setText(movie.getCurrency());
        holder.travelTime.setText(movie.getTrip_duration_in_mins());



    }

    @Override
    public int getItemCount() {
        return tripsList.size();
    }
}
