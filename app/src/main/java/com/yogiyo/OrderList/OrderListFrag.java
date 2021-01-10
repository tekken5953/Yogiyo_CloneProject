package com.yogiyo.OrderList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yogiyo.R;

import java.util.ArrayList;
import java.util.Objects;

public class OrderListFrag extends Fragment {
    OrderListAdapter mAdapter;
    ArrayList<OrderListItem> mItem = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.order_list_frag,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = Objects.requireNonNull(getActivity()).findViewById(R.id.order_list_recyclerView);
        mAdapter = new OrderListAdapter(mItem);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        //아이템 추가
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.lottelia, null), "2021-01-09 17:10", "배달완료",
                "롯데리아-대동점", "불고기버거세트 + 아이스크림");
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.bbq, null), "2021-01-11 13:10", "배달완료",
                "BBQ 치킨-용운점", "황금올리브치킨 + 콜라1.2L");
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.dujjim, null), "2021-01-15 19:25", "배달완료",
                "두찜-용운점", "찜닭1인분");
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.gs25, null), "2021-01-17 14:47", "배달완료",
                "GS25-용운점", "컵라면 + 만두 + 삼각김밥");
        addItem(ResourcesCompat.getDrawable(getResources(), R.drawable.starbucks, null), "2021-01-19 18:06", "배달완료",
                "스타벅스-중앙로점", "아이스아메리카노(R) + 허니브레드");

        mAdapter.setOnItemClickListener((v, position) -> {
            Intent intent = new Intent(getActivity(), OrderResultActivity.class);
            startActivity(intent);
        });
    }

    public void addItem(Drawable img, String time, String complete, String name, String menu) {
        OrderListItem item = new OrderListItem(img, time, complete, name, menu);
        item.setImg(img);
        item.setTime(time);
        item.setComplete(complete);
        item.setName(name);
        item.setMenu(menu);
        Log.e("OrderList","Add View Complete!");
        mItem.add(item);
        mAdapter.notifyDataSetChanged();
    }

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static OrderListFrag newInstance() {
        return new OrderListFrag();
    }

}