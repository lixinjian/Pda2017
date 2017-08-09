package com.ds365.erp.wms.pda.views.user.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ds365.erp.wms.pda.R;

import java.util.List;

/**
 * Created by 57490 on 2017/8/9.
 */

public class CategoryAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    public CategoryAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.category_list, null);
            holder.text = view.findViewById(R.id.category_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.text.setText(list.get(i));
        return view;
    }

    private static class ViewHolder {
        private TextView text;
    }
}
