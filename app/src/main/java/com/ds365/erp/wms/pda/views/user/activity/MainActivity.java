package com.ds365.erp.wms.pda.views.user.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.ds365.erp.wms.pda.R;
import com.ds365.erp.wms.pda.views.user.adapter.ViewPagerFragmentAdapter;
import com.ds365.erp.wms.pda.views.user.fragment.EnterFragment;
import com.ds365.erp.wms.pda.views.user.fragment.MessageFragment;
import com.ds365.erp.wms.pda.views.user.fragment.OutterFragment;
import com.ds365.erp.wms.pda.views.user.fragment.QueryFragment;
import com.ds365.erp.wms.pda.views.user.fragment.StockFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/31 0026.
 * 主页面
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    public LinearLayout enterTab;
    public LinearLayout outterTab;
    public LinearLayout stockTab;
    public LinearLayout queryTab;
    public LinearLayout messageTab;
    ViewPager mViewPager;
    ViewPagerFragmentAdapter mViewPagerFragmentAdapter;
    FragmentManager mFragmentManager;
    int[] titleName = new int[]{
            R.string.enter, R.string.outter, R.string.stock, R.string.query, R.string.message
    };
    List<Fragment> mFragmentList = new ArrayList<Fragment>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFragmentManager = getSupportFragmentManager();
        setContentView(R.layout.activity_main);

        initFragmetList();
        mViewPagerFragmentAdapter = new ViewPagerFragmentAdapter(mFragmentManager, mFragmentList);
        initView();
        initViewPager();

        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        navigationView = (NavigationView) findViewById(R.id.main_navigationView);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToolbar.setTitle(R.string.enter);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

        navigationView.setCheckedItem(R.id.nav_modify_password);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    public void initViewPager() {
        mViewPager.addOnPageChangeListener(new ViewPagetOnPagerChangedLisenter());
        mViewPager.setAdapter(mViewPagerFragmentAdapter);
        //默认选中第一张viewPager
        mViewPager.setCurrentItem(0);
        //默认为第一个按钮配色
        switchTabImage(0);
    }

    public void initFragmetList() {
        Fragment enterFragment = new EnterFragment();
        Fragment outterFragment = new OutterFragment();
        Fragment stockFragment = new StockFragment();
        Fragment queryFragment = new QueryFragment();
        Fragment messageFragment = new MessageFragment();
        mFragmentList.add(enterFragment);
        mFragmentList.add(outterFragment);
        mFragmentList.add(stockFragment);
        mFragmentList.add(queryFragment);
        mFragmentList.add(messageFragment);
    }

    public void initView() {
        mViewPager = (ViewPager) findViewById(R.id.ViewPagerLayout);
        enterTab = (LinearLayout) findViewById(R.id.mainActivity_tab_enter);
        enterTab.setOnClickListener(this);
        outterTab = (LinearLayout) findViewById(R.id.mainActivity_tab_outter);
        outterTab.setOnClickListener(this);
        stockTab = (LinearLayout) findViewById(R.id.mainActivity_tab_stock);
        stockTab.setOnClickListener(this);
        queryTab = (LinearLayout) findViewById(R.id.mainActivity_tab_query);
        queryTab.setOnClickListener(this);
        messageTab = (LinearLayout) findViewById(R.id.mainActivity_tab_message);
        messageTab.setOnClickListener(this);
    }

    /**
     * 对toolbar的操作.
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mainActivity_tab_enter:
                mViewPager.setCurrentItem(0);
                break;
            case R.id.mainActivity_tab_outter:
                mViewPager.setCurrentItem(1);
                break;
            case R.id.mainActivity_tab_stock:
                mViewPager.setCurrentItem(2);
                break;
            case R.id.mainActivity_tab_query:
                mViewPager.setCurrentItem(3);
                break;
            case R.id.mainActivity_tab_message:
                mViewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }

    /**
     * 底部按钮颜色的切换
     * @param i
     */
    private void switchTabImage(int i) {
        switch (i){
            case 0:
                enterTab.setBackgroundColor(Color.blue(android.R.color.holo_blue_light));
                outterTab.setBackgroundColor(Color.WHITE);
                stockTab.setBackgroundColor(Color.WHITE);
                queryTab.setBackgroundColor(Color.WHITE);
                messageTab.setBackgroundColor(Color.WHITE);

                break;
            case 1:
                enterTab.setBackgroundColor(Color.WHITE);
                outterTab.setBackgroundColor(Color.blue(android.R.color.holo_blue_light));
                stockTab.setBackgroundColor(Color.WHITE);
                queryTab.setBackgroundColor(Color.WHITE);
                messageTab.setBackgroundColor(Color.WHITE);
                break;
            case 2:
                enterTab.setBackgroundColor(Color.WHITE);
                outterTab.setBackgroundColor(Color.WHITE);
                stockTab.setBackgroundColor(Color.blue(android.R.color.holo_blue_light));
                queryTab.setBackgroundColor(Color.WHITE);
                messageTab.setBackgroundColor(Color.WHITE);
                break;
            case 3:
                enterTab.setBackgroundColor(Color.WHITE);
                outterTab.setBackgroundColor(Color.WHITE);
                stockTab.setBackgroundColor(Color.WHITE);
                queryTab.setBackgroundColor(Color.blue(android.R.color.holo_blue_light));
                messageTab.setBackgroundColor(Color.WHITE);
                break;
            case 4:
                enterTab.setBackgroundColor(Color.WHITE);
                outterTab.setBackgroundColor(Color.WHITE);
                stockTab.setBackgroundColor(Color.WHITE);
                queryTab.setBackgroundColor(Color.WHITE);
                messageTab.setBackgroundColor(Color.blue(android.R.color.holo_blue_light));
                break;
        }
    }

    class ViewPagetOnPagerChangedLisenter implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switchTabImage(position);
            boolean[] state = new boolean[titleName.length];
            state[position] = true;
            mToolbar.setTitle(titleName[position]);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
