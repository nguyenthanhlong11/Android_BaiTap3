package com.example.app;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.app.Adapter.PopularAdapter;
import com.example.app.Object.cart;
import com.example.app.SQL.SQL;
import com.example.app.frament.OrderFragment;
import com.example.app.frament.ViewPageAdapter;
import com.example.app.model.Popular;
import com.example.app.model.Recommended;
import com.example.app.retrofit.ApiInterface;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class tabnavi extends AppCompatActivity {

    public static List<Popular> std=new ArrayList<>();
    public static List<Recommended> recoment=new ArrayList<>();
    public static List<cart> cart=new ArrayList<>();
    public static SQL sql,sql1;

    ApiInterface apiInterface;

    RecyclerView popularRecyclerView, recommendedRecyclerView, allMenuRecyclerView;

    PopularAdapter popularAdapter;
//    RecommendedAdapter recommendedAdapter;
//    AllmenuAdapter allmenuAdapter;



    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }
        setContentView(R.layout.activity_tabnavi);

        viewPager =findViewById(R.id.view_pager);
        bottomNavigationView =findViewById(R.id.btnavi);

        ViewPageAdapter adapter=new ViewPageAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                sql1=new SQL(tabnavi.this);
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.menu_news).setChecked(true);
                        break;
                    case 1:
                        OrderFragment orderFragment=new OrderFragment();

                        bottomNavigationView.getMenu().findItem(R.id.menu_order).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_account).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                sql1=new SQL(tabnavi.this);
                switch (item.getItemId()){
                    case R.id.menu_news:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_order:
                        sql1.getCart();
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_account:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });

        sql=new SQL(tabnavi.this);


    }
}