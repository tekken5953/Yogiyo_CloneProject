package com.yogiyo.HomeFrag;

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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryItem> mData;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    CategoryAdapter(ArrayList<CategoryItem> list) {
        mData = list;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.home_menu_category_item, parent, false);
        CategoryAdapter.ViewHolder vh = new CategoryAdapter.ViewHolder(view);

        return vh;
    }

    private OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder holder, int position) {

        CategoryItem item = mData.get(position);

        holder.img_top.setImageDrawable(item.getCategory_img_top());
        holder.img_bottom.setImageDrawable(item.getCategory_img_bottom());
        holder.content_top.setText(item.getCategory_content_top());
        holder.content_bottom.setText(item.getCategory_content_bottom());

    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_top;
        ImageView img_bottom;
        TextView content_top;
        TextView content_bottom;


        ViewHolder(final View itemView) {
            super(itemView);

            itemView.setOnClickListener(view1 -> {
                int position = getAdapterPosition();

                if (position != RecyclerView.NO_POSITION) {
                    if (mListener != null) {
                        mListener.onItemClick(view1, position);
                    }
                }
            });

            // 뷰 객체에 대한 참조. (hold strong reference)
            img_top = itemView.findViewById(R.id.home_category_img_top);
            img_bottom = itemView.findViewById(R.id.home_category_img_bottom);
            content_top = itemView.findViewById(R.id.home_category_content_top);
            content_bottom = itemView.findViewById(R.id.home_category_content_bottom);

        }
    }
}
