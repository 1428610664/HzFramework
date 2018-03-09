package com.hz.hzframework.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hz.hzframework.R;
import com.hz.hzframework.utils.ViewStateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zh on 16/6/21.
 */
public class RootView extends RelativeLayout implements View.OnClickListener {
    private Context mContext;
    private ImageView backImage, rightIcon; // 返回键
    private TextView titleText, rightText; // 标题
    private RootViewListener rootViewListener;
    private RelativeLayout rootView; // 内容根目录
    private View loadingView; // 加载view
    private View contentView; // 主要内容view
    private LinearLayout headBar;
    private String noDataStr = "暂无数据";
    private ViewState viewState = ViewState.SUCCESS;
    private AnimationDrawable frameAnim;
    private NoWifiListener noWifiListener;

    public TextView getRightText() {
        return rightText;
    }

    public void setNoWifiListener(NoWifiListener noWifiListener) {
        this.noWifiListener = noWifiListener;
    }

    public void setRootViewListener(RootViewListener rootViewListener) {
        this.rootViewListener = rootViewListener;
    }

    public RootView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public RootView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public RootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    /**
     * 是否隐藏头部栏
     *
     * @param isHint
     */
    public void isHintHeadBar(boolean isHint) {
        if (isHint) {
            headBar.setVisibility(View.GONE);
        } else {
            headBar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * 初始化界面
     */
    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.root_head, this, true);
        initView();
    }

    private void initView() {
        backImage = (ImageView) findViewById(R.id.root_head_back);
        titleText = (TextView) findViewById(R.id.root_head_title);
        rootView = (RelativeLayout) findViewById(R.id.root_view);
        headBar = (LinearLayout) findViewById(R.id.head_bar);
        rightText = (TextView) findViewById(R.id.root_head_right_text);
        rightIcon = (ImageView) findViewById(R.id.root_head_right_icon);
        backImage.setOnClickListener(this);
        rootView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewState == ViewState.NONETWORK) {
                    if (noWifiListener != null) {
                        noWifiListener.onNoWifiLister(v);
                    }
                }
            }
        });
    }



    public void setRightText(String str, boolean isClick) {
        rightText.setText(str);
        rightText.setVisibility(View.VISIBLE);
        if (isClick) {
            rightText.setOnClickListener(this);
        }
    }

    public View getRightIcon(boolean isVisible) {
        if (isVisible == true) {
            rightIcon.setVisibility(VISIBLE);
        }

        return rightIcon;
    }

    public void hintBackView(boolean isHint) {
        if (isHint) {
            backImage.setVisibility(View.GONE);
        } else {
            backImage.setVisibility(View.VISIBLE);
        }
    }


    /**
     * 添加内容界面
     *
     * @param view
     */
    public void addContentView(View view) {
        contentView = view;
        if (contentView != null && contentView.getLayoutParams() == null) {
            contentView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }
        if (viewState == ViewState.SUCCESS) {
            rootView.addView(view);
        } else {
            rootView.addView(view, 0);
        }
    }

    public void changeRootViewState(ViewState state) {
        if (frameAnim != null) {
            frameAnim.stop();
        }
        if (state == ViewState.LOADING) { // 加载中
            removeOtherView();
            if (loadingView == null) {
                loadingView = ViewStateUtil.getLoadingView(mContext);
            }
            rootView.addView(loadingView);
            ImageView image = (ImageView) ((RelativeLayout) loadingView).getChildAt(0);
            frameAnim = (AnimationDrawable) image.getDrawable();
            frameAnim.start();
        } else if (state == ViewState.ONELOADING) {// 首次加载中
            rootView.removeAllViews();
            View view = ViewStateUtil.getInitLoadingView(mContext, Color.parseColor("#ffffff"));
            rootView.addView(view);
            RelativeLayout relativeLayout = (RelativeLayout) ((RelativeLayout) view).getChildAt(0);
            ImageView image = (ImageView) relativeLayout.getChildAt(0);
            frameAnim = (AnimationDrawable) image.getDrawable();
            frameAnim.start();
        } else if (state == ViewState.NODATA) {// 无数据
            rootView.removeAllViews();
            rootView.addView(ViewStateUtil.getNoDataView(mContext, noDataStr, Color.parseColor("#ffffff")));
        } else if (state == ViewState.NONETWORK) { // 无网络
            rootView.removeAllViews();
            rootView.addView(ViewStateUtil.getNoNetView(mContext, Color.parseColor("#ffffff")));
        } else if (state == ViewState.SUCCESS) { // 加载成功
            removeOtherView();
            if (contentView != null && contentView.getParent() == null) {
                rootView.addView(contentView);
            }
        }
        viewState = state;
    }


    /**
     * 删除除内容以外的其他view
     */
    private void removeOtherView() {
        if (contentView != null) {
            List<View> removeViews = new ArrayList<>();
            for (int i = 0; i < rootView.getChildCount(); i++) {
                if (rootView.getChildAt(i) != contentView) {
                    removeViews.add(rootView.getChildAt(i));
                }
            }
            if (removeViews.size() > 0) {
                for (View view : removeViews) {
                    rootView.removeView(view);
                }
            }
        } else {
            rootView.removeAllViews();
        }
    }


    public void setHeadTitle(String str) {
        if (str != null) {
            titleText.setText(str);
        }
    }

    @Override
    public void onClick(View v) {
        if (rootViewListener != null) {
            rootViewListener.onRootViewClick(v);
        }
    }


    public interface RootViewListener {
        void onRootViewClick(View v);
    }

    public interface NoWifiListener {
        void onNoWifiLister(View v);
    }

    public enum ViewState {
        ONELOADING,//首次加载中
        LOADING,// 普通加载
        SUCCESS,//加载成功
        NODATA, // 无数据
        NONETWORK; // 无网络
    }
}
