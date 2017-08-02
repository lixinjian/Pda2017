package com.ds365.erp.wms.pda.views.user.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ds365.erp.wms.pda.R;

/**
 * Created by Administrator on 2017/7/31 0027.
 */

public class OutterFragment extends Fragment {

    View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(R.layout.fragment_main_enter, null);
        }
//        ((TextView) mView.findViewById(R.id.mTextView)).setText("出库");
        return mView;
    }
}