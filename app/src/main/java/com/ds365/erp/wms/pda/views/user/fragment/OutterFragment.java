package com.ds365.erp.wms.pda.views.user.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ds365.erp.wms.pda.R;
import com.ds365.erp.wms.pda.views.common.LazyLoadFragment;

/**
 * Created by Administrator on 2017/7/31 0027.
 */

public class OutterFragment extends LazyLoadFragment{

    private TextView mTextView;

    /*@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main_enter, null);
        }
//        ((TextView) mView.findViewById(R.id.mTextView)).setText("出库");
        return mView;
    }*/

    @Override
    protected int setContentView() {
        return R.layout.fragment_main_outter;
    }

    @Override
    protected void lazyLoad() {
        Toast.makeText(getActivity(), "加载出库", Toast.LENGTH_SHORT).show();
        mTextView = findViewById(R.id.mTextView);
        mTextView.setText("出库");
    }
}