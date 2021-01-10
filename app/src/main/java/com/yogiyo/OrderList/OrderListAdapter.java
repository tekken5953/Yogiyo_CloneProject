package com.yogiyo.OrderList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yogiyo.R;

import java.util.ArrayList;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {
    private ArrayList<OrderListItem> mData;

    OrderListAdapter(ArrayList<OrderListItem> list) {
        mData = list;
    }

    @NonNull
    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.order_list_item, parent, false);
        OrderListAdapter.ViewHolder vh = new OrderListAdapter.ViewHolder(view);
        return vh;
    }

    private OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderListAdapter.ViewHolder holder, int position) {
        OrderListItem item = mData.get(position);

        holder.img.setImageDrawable(item.getImg());
        holder.menu.setText(item.getMenu());
        holder.name.setText(item.getName());
        holder.time.setText(item.getTime());
        holder.complete.setText(item.getComplete());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView time;
        TextView complete;
        TextView name;
        TextView menu;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(view1 -> {
                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION) {
                    if (mListener != null)
                        mListener.onItemClick(view1, position);
                }
            });

            img = itemView.findViewById(R.id.order_list_image);
            menu = itemView.findViewById(R.id.order_list_menu);
            name = itemView.findViewById(R.id.order_list_name);
            time = itemView.findViewById(R.id.order_list_time);
            complete = itemView.findViewById(R.id.order_list_complete);

        }
    }
}
