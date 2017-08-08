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

import org.w3c.dom.Text;

/**
 * Created by Administrator on 2017/7/31 0027.
 */

public class EnterFragment extends Fragment {

private View mTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mTextView == null) {
            mTextView = inflater.inflate(R.layout.fragment_main_enter, null);
        }
        ((TextView) mTextView.findViewById(R.id.fff)).setText("入库");
        return mTextView;
    }
}