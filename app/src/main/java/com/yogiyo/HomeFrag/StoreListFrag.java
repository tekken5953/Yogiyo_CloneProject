package com.yogiyo.HomeFrag;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yogiyo.MainActivity;
import com.yogiyo.R;

public class StoreListFrag extends Fragment {

    ImageView back_press;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.store_list, container, false);
        back_press = v.findViewById(R.id.store_backpress);
        back_press.setOnClickListener(view1 -> {
            ((MainActivity) getActivity()).replaceFragment(HomeFrag.newInstance());
        });
        return v;
    }

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static StoreListFrag newInstance() {
        return new StoreListFrag();
    }
}