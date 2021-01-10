package com.yogiyo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yogiyo.HomeFrag.HomeFrag;
import com.yogiyo.OrderList.OrderListFrag;
import com.yogiyo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        BottomNavigationView mBottomNavigationView = binding.bottomNavigationView;

        //첫 화면 띄우기
        getSupportFragmentManager().beginTransaction().add(R.id.main_frame, new HomeFrag()).commit();

        //case 함수를 통해 클릭 받을 때마다 화면 변경하기
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HomeFrag()).commit();
                        break;
                    case R.id.bottom_nav_heart:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new HeartFrag()).commit();
                        break;
                    case R.id.bottom_nav_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new SearchFrag()).commit();
                        break;
                    case R.id.bottom_nav_order_list:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new OrderListFrag()).commit();
                        break;
                    case R.id.bottom_nav_mypage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, new MyPageFrag()).commit();
                        break;
                }
                return true;
            }
        });
    }

    //프레그먼트 간 이동
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}