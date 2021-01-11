package com.yogiyo.YoFeed;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yogiyo.HomeFrag.HomeFrag;
import com.yogiyo.MainActivity;
import com.yogiyo.R;
import com.yogiyo.onBackPressedListener;

import java.util.Objects;


public class YoFeedFrag extends Fragment implements onBackPressedListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.yo_feed_frag, container, false);

        ImageView back = v.findViewById(R.id.yofeed_back_iv);
        back.setOnClickListener(view1 -> ((MainActivity) getActivity()).replaceFragment(HomeFrag.newInstance()));
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static YoFeedFrag newInstance() {
        return new YoFeedFrag();
    }

    @Override
    public void onBackPressed() {
        goToMain();
        ((MainActivity) getActivity()).replaceFragment(HomeFrag.newInstance());
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(YoFeedFrag.this).commit();
        fragmentManager.popBackStack();
    }
}