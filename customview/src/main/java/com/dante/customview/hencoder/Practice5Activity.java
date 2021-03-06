package com.dante.customview.hencoder;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;

import com.dante.customview.R;
import com.dante.customview.hencoder.practice5.Page5Fragment;

import java.util.ArrayList;
import java.util.List;

public class Practice5Activity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.layout.sample5_after_on_draw, R.string.title5_after_on_draw, R.layout.practice5_after_on_draw));
        pageModels.add(new PageModel(R.layout.sample5_before_on_draw, R.string.title5_before_on_draw, R.layout.practice5_before_on_draw));
        pageModels.add(new PageModel(R.layout.sample5_on_draw_layout, R.string.title5_on_draw_layout, R.layout.practice5_on_draw_layout));
        pageModels.add(new PageModel(R.layout.sample5_dispatch_draw, R.string.title5_dispatch_draw, R.layout.practice5_dispatch_draw));
        pageModels.add(new PageModel(R.layout.sample5_after_on_draw_foreground, R.string.title5_after_on_draw_foreground, R.layout.practice5_after_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample5_before_on_draw_foreground, R.string.title5_before_on_draw_foreground, R.layout.practice5_before_on_draw_foreground));
        pageModels.add(new PageModel(R.layout.sample5_after_draw, R.string.title5_after_draw, R.layout.practice5_after_draw));
        pageModels.add(new PageModel(R.layout.sample5_before_draw, R.string.title5_before_draw, R.layout.practice5_before_draw));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice5);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return Page5Fragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    private class PageModel {
        @LayoutRes
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
