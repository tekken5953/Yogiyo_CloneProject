package com.yogiyo.HomeFrag;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yogiyo.BannerFragment.Banner1;
import com.yogiyo.BannerFragment.Banner2;
import com.yogiyo.BannerFragment.Banner3;
import com.yogiyo.BannerFragment.Banner4;
import com.yogiyo.MainActivity;
import com.yogiyo.R;

import java.util.ArrayList;

public class HomeFrag extends Fragment {
    CategoryAdapter category_mAdapter;
    ArrayList<CategoryItem> category_mItem = new ArrayList<>();

    HashTagAdapter hashTag_mAdapter;
    ArrayList<HashTagItem> hashTag_mItem = new ArrayList<>();

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //배너 뷰페이저 생성
        viewPager = getActivity().findViewById(R.id.home_viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerAdapter.addItem(new Banner1());
        viewPagerAdapter.addItem(new Banner2());
        viewPagerAdapter.addItem(new Banner3());
        viewPagerAdapter.addItem(new Banner4());
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setClipToPadding(false);
        viewPager.setOffscreenPageLimit(0);
        viewPager.setCurrentItem(0);

        //카테고리 리사이클러뷰
        RecyclerView category_recyclerView = getActivity().findViewById(R.id.category_recyclerView);
        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        category_mAdapter = new CategoryAdapter(category_mItem);
        category_recyclerView.setAdapter(category_mAdapter);
        category_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //리사이클러뷰에 아이템 추가
        final int[] category_img = {R.drawable.viewall, R.drawable.takeout, R.drawable.jjajangmyun,
                R.drawable.chiken, R.drawable.bibimbab, R.drawable.pizza, R.drawable.jjim,
                R.drawable.cafe, R.drawable.bbogi, R.drawable.solo, R.drawable.donka, R.drawable.ramen,
                R.drawable.jokbal, R.drawable.prencha, R.drawable.conveny};
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[0], null),
                ResourcesCompat.getDrawable(getResources(), category_img[1], null),
                "전체보기", "테이크아웃");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[2], null),
                ResourcesCompat.getDrawable(getResources(), category_img[3], null),
                "중국집", "치킨");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[4], null),
                ResourcesCompat.getDrawable(getResources(), category_img[5], null),
                "한식", "피자/양식");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[6], null),
                ResourcesCompat.getDrawable(getResources(), category_img[7], null),
                "찜/탕", "카페/디저트");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[8], null),
                ResourcesCompat.getDrawable(getResources(), category_img[9], null),
                "분식", "1인분주문");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[10], null),
                ResourcesCompat.getDrawable(getResources(), category_img[11], null),
                "일식/돈까스", "야식");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[12], null),
                ResourcesCompat.getDrawable(getResources(), category_img[13], null),
                "족발/보쌈", "프랜차이즈");
        addCategoryItem(ResourcesCompat.getDrawable(getResources(), category_img[14], null),
                null,
                "편의점/마트", null);

        //카테고리 리사이클러뷰 클릭 시 음식점 리스트로 이동
        category_mAdapter.setOnItemClickListener((v1, position) -> {
            ((MainActivity) getActivity()).replaceFragment(StoreListFrag.newInstance());
        });

        //해시태그 리사이클러뷰
        RecyclerView hashtag_recyclerView = getActivity().findViewById(R.id.hashtag_recyclerView);
        // 리사이클러뷰에 SimpleTextAdapter 객체 지정
        hashTag_mAdapter = new HashTagAdapter(hashTag_mItem);
        hashtag_recyclerView.setAdapter(hashTag_mAdapter);
        hashtag_recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        //리사이클러뷰에 아이템 추가
        addHashTagItem("#곱창");
        addHashTagItem("#마라탕");
        addHashTagItem("#버거");
        addHashTagItem("#닭발");
        addHashTagItem("#죽");
        addHashTagItem("#찜닭");
        addHashTagItem("#떡볶이");
        addHashTagItem("#초밥");
        addHashTagItem("#회");
        addHashTagItem("#삼겹살");
        addHashTagItem("#냉면");
        addHashTagItem("#쌀국수");
        addHashTagItem("#김밥");
        addHashTagItem("#감자탕");
        addHashTagItem("#아구찜");
        addHashTagItem("#국밥");
        addHashTagItem("#도시락");
        addHashTagItem("#육회");


        category_mAdapter.notifyDataSetChanged();
        hashTag_mAdapter.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_frag, container, false);
        return v;
    }

    //카테고리RecyclerView 아이템 추가
    public void addCategoryItem(Drawable img_top, Drawable img_bottom, String content_top, String content_bottom) {
        CategoryItem item = new CategoryItem(img_top, img_bottom, content_top, content_bottom);
        item.setCategory_img_top(img_top);
        item.setCategory_img_bottom(img_bottom);
        item.setCategory_content_top(content_top);
        item.setCategory_content_bottom(content_bottom);
        category_mItem.add(item);
    }

    //해쉬태그RecyclerView 아이템 추가
    public void addHashTagItem(String content) {
        Drawable hashbg = ResourcesCompat.getDrawable(getResources(), R.drawable.home_hashtag_item, null);
        HashTagItem item = new HashTagItem(hashbg, content);
        item.setHashtag_background(hashbg);
        item.setHashtag_content(content);
        hashTag_mItem.add(item);
    }

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static HomeFrag newInstance() {
        return new HomeFrag();
    }

    //뷰페이저 어댑터클래스
    static class ViewPagerAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> items = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }
        public void addItem(Fragment item) {
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }
    }

}