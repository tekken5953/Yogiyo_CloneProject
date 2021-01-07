package com.yogiyo.HomeFrag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yogiyo.R;
import java.util.ArrayList;

public class HashTagAdapter extends RecyclerView.Adapter<HashTagAdapter.ViewHolder> {
    private ArrayList<HashTagItem> mData;

    // 생성자에서 데이터 리스트 객체를 전달받음.
    HashTagAdapter(ArrayList<HashTagItem> list) {
        mData = list;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @NonNull
    @Override
    public HashTagAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.home_hashtag_item, parent, false);
        HashTagAdapter.ViewHolder vh = new HashTagAdapter.ViewHolder(view);

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
    public void onBindViewHolder(HashTagAdapter.ViewHolder holder, int position) {

        HashTagItem item = mData.get(position);

        holder.btn.setText(item.getHashtag_content());
        holder.btn.setBackground(item.getHashtag_background());

    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {

        Button btn;

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
            btn = itemView.findViewById(R.id.hashtag_btn);

        }
    }
}