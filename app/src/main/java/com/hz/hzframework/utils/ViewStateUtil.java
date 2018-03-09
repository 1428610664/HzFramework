package com.hz.hzframework.utils;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hz.hzframework.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zh on 16/4/25.
 */
public class ViewStateUtil {
    /**
     * 初始化界面加载图
     *
     * @param context
     * @param background
     * @return
     */
    public static View getInitLoadingView(Context context, int background) {
        RelativeLayout view = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(background);
        view.addView(getLoadingView(context));
        return view;
    }

    /**
     * 界面加载图
     *
     * @return
     */
    public static View getLoadingView(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        SystemConfig.dynamicSetRelayoutViewWidthAndHeight(relativeLayout, 150, 150, 0, 0, 0, 0, map);
        relativeLayout.setBackgroundResource(R.drawable.bg_black);
        ImageView image = new ImageView(context);
        SystemConfig.dynamicSetRelayoutViewWidthAndHeight(image, 150, 150, 0, 0, 0, 0, map);
        image.setImageResource(R.drawable.loading2);
        relativeLayout.addView(image);
        return relativeLayout;
    }

    /**
     * 无网络状态
     */
    public static View getNoNetView(Context context, int background) {
        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setGravity(Gravity.CENTER);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(background);
        ImageView image = new ImageView(context);
        image.setImageResource(R.mipmap.error);
        view.addView(image);
        return view;
    }

    /**
     * 无数据状态
     */
    public static View getNoDataView(Context context, String str, int background) {
        LinearLayout view = new LinearLayout(context);
        view.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setGravity(Gravity.CENTER);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(background);
        TextView tv = new TextView(context);
        tv.setGravity(Gravity.CENTER);
        tv.setText(str);
        view.addView(tv);
        return view;
    }
}
