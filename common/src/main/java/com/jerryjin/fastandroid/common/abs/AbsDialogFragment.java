package com.jerryjin.fastandroid.common.abs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Author: Jerry
 * Generated at: 2019/1/31 17:49
 * WeChat: enGrave93
 * Description:
 */
public abstract class AbsDialogFragment extends DialogFragment {

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
        Bundle bundle = getArguments();
        if (bundle == null) {
            return;
        }
        initArgs(bundle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = getContentView(inflater, container, savedInstanceState);
        initWidgets(root);
        onViewsInitialized();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initFragmentWindow();
    }

    protected void initArgs(Bundle bundle) {

    }

    protected abstract View getContentView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    protected void initWidgets(View root){
        ButterKnife.bind(this, root);
    }

    /**
     * Initialize the data set.
     */
    protected void initData() {

    }

    protected abstract void initFragmentWindow();
    // example
    /*
        @SuppressWarnings("ConstantConditions")
        private void initFragmentWindow() {
                Window win = getDialog().getWindow();
                // 一定要设置Background，如果不设置，window属性设置无效
                win.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                DisplayMetrics dm = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

                WindowManager.LayoutParams params = win.getAttributes();
                params.gravity = Gravity.BOTTOM;
                // 使用ViewGroup.LayoutParams，以便Dialog 宽度充满整个屏幕
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                win.setAttributes(params);
        }
     */

    protected void onViewsInitialized(){

    }

    // Restored
}
