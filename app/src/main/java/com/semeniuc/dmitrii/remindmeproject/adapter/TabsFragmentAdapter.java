package com.semeniuc.dmitrii.remindmeproject.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.semeniuc.dmitrii.remindmeproject.dto.RemindDTO;
import com.semeniuc.dmitrii.remindmeproject.fragment.AbstractTabFragment;
import com.semeniuc.dmitrii.remindmeproject.fragment.BirthdaysFragment;
import com.semeniuc.dmitrii.remindmeproject.fragment.HistoryFragment;
import com.semeniuc.dmitrii.remindmeproject.fragment.IdeasFragment;
import com.semeniuc.dmitrii.remindmeproject.fragment.TodoFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabsFragmentAdapter extends FragmentPagerAdapter {

    private String title;

    private Map<Integer, AbstractTabFragment> tabs;
    private Context context;

    private List<RemindDTO> data;
    private HistoryFragment historyFragment;

    public TabsFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
        this.data = new ArrayList<>();
        initTabsMap();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return tabs.get(position);
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    private void initTabsMap() {
        tabs = new HashMap<>();
        historyFragment = HistoryFragment.getInstance(context, data);
        tabs.put(0, historyFragment);
        tabs.put(1, IdeasFragment.getInstance(context));
        tabs.put(2, TodoFragment.getInstance(context));
        tabs.put(3, BirthdaysFragment.getInstance(context));
    }

    public void setData(List<RemindDTO> data) {
        this.data = data;
        historyFragment.refreshData(data);
    }
}
