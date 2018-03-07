package com.jiao.mmvp.ui;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.MenuItem;

import com.jiao.mmvp.R;
import com.jiao.mmvp.ui.book.BookFragment;
import com.jiao.mmvp.ui.home.HomeFragment;
import com.jiao.mmvp.ui.movie.MovieFragment;
import com.jiao.mvplib.base.activity.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    @BindView(R.id.nv_menu)
    NavigationView nvMenu;
    @BindView(R.id.dl_root)
    DrawerLayout dlRoot;
    @BindView(R.id.bviv_bar)
    BottomNavigationView bottomNavigationView;

    private Fragment[] fragments = new Fragment[3];
    private FragmentManager fragmentManager;


    @Override
    protected void initView(Bundle savedInstanceState) {
        fragments[FIRST] = HomeFragment.newInstance();
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fl_container, fragments[FIRST]);
        fragmentTransaction.commit();
        showFragment(FIRST);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item_home:
                        showFragment(FIRST);
                        break;
                    case R.id.menu_item_movie:
                        if (fragments[SECOND] == null) {
                            fragments[SECOND] = MovieFragment.newInstance();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.fl_container, fragments[SECOND]);
                            fragmentTransaction.commit();
                        }
                        showFragment(SECOND);
                        break;
                    case R.id.menu_item_book:
                        if (fragments[THIRD] == null) {
                            fragments[THIRD] = BookFragment.newInstance();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.add(R.id.fl_container, fragments[THIRD]);
                            fragmentTransaction.commit();
                        }
                        showFragment(THIRD);
                        break;
                }
                return true;
            }
        });
    }

    private void showFragment(int position) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (int i = 0; i < fragments.length; i++) {
            if (fragments[i] == null)
                continue;
            if (i == position) {
                fragmentTransaction.show(fragments[i]);
            } else {
                fragmentTransaction.hide(fragments[i]);
            }
        }
        fragmentTransaction.commit();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
