package com.mp.collegefaction.collegefaction.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mp.collegefaction.collegefaction.EventDetailsActivity;
import com.mp.collegefaction.collegefaction.R;

/**
 * Created by pranjul on 24/4/18.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.EventViewHolder>{

    private final Context context;
    private int itemCount=4;

    public EventsAdapter(Context context) {
        this.context = context;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.list_item_event, parent,false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventViewHolder holder, int position) {
        holder.tv_not_interested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemCount--;
                Snackbar.make(view, "Event will be marked as not interested.", Snackbar.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        holder.event_banner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                context.startActivity(intent);
            }
        });

        holder.tv_event_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, EventDetailsActivity.class);
                context.startActivity(intent);
            }
        });

        holder.tv_interested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.tv_interested.getText().toString().toLowerCase().equals("interested")){
                    holder.tv_interested.setText("Going");
                    holder.tv_interested.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                    Snackbar.make(view, "Event will be marked as interested.", Snackbar.LENGTH_SHORT).show();
                    holder.tv_interested.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_done,0,0,0);
                } else {
                    holder.tv_interested.setText("Interested");
                    Snackbar.make(view, "Event will be unmarked as going.", Snackbar.LENGTH_SHORT).show();
                    holder.tv_interested.setTextColor(context.getResources().getColor(R.color.colorPrimaryText));
                    holder.tv_interested.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_interested,0,0,0);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder{

        public ImageView event_banner;
        public TextView tv_interested, tv_not_interested, tv_event_name;
        public EventViewHolder(View itemView) {
            super(itemView);
            event_banner = itemView.findViewById(R.id.event_banner);
            tv_event_name = itemView.findViewById(R.id.tv_event_name);
            tv_interested = itemView.findViewById(R.id.tv_interested);
            tv_not_interested = itemView.findViewById(R.id.tv_not_interested);
        }
    }
}
