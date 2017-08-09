package com.ds365.erp.wms.pda.views.user.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ds365.erp.wms.pda.R;
import com.ds365.erp.wms.pda.views.common.LazyLoadFragment;
import com.ds365.erp.wms.pda.views.user.adapter.CategoryAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.ds365.erp.wms.pda.R.id.mTextView;


/**
 * Created by Administrator on 2017/7/31 0027.
 */

public class StockFragment extends Fragment {

    private View mView;
    private ListView mCategoryList;
    private CategoryAdapter categoryAdapter;
    private List<String> categorys;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main_enter, null);
            mCategoryList = mView.findViewById(R.id.enter_category_list);
        }
        categorys = new ArrayList<>();
        categorys.add("库存1");
        categorys.add("库存2");
        categorys.add("库存3");
        categoryAdapter = new CategoryAdapter(categorys, getActivity());
        mCategoryList.setAdapter(categoryAdapter);
        return mView;
    }
}