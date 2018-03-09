package com.hz.hzframework.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.hz.hzframework.MyApplication;
import com.hz.hzframework.bean.BaseBean;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================================================
 * <p/>
 * 版 权 ： 百变美金 版权所有 (c) 2015
 * <p/>
 * 作 者 : 周章成
 * <p/>
 * 版 本 ： 3.7
 * <p/>
 * 创建日期 ： 2015-7-15 下午3:12:54
 * <p/>
 * 描 述 ：系统相关信息配置
 * <p/>
 * 修订历史 ： 1. 获取上下文 2. px转dp 3. dp装px 4. 获取app版本号 5. 全局定义Toast.makeText 6.
 * 获取屏幕高度和宽度 ============================================================
 **/
public class SystemConfig {

    /**
     * UI设计的基准宽度.
     */
    public static int UI_WIDTH = 720;

    /**
     * UI设计的基准高度.
     */
    public static int UI_HEIGHT = 1280;

    /**
     * UI设计的密度.
     */
    public static int UI_DENSITY = 2;

    /**
     * 比例 宽度 ：750
     */
    public static double SCALE = getScreenWidth() / 750.00;


    public static int getScale(double number) {
        return (int) (SCALE * number);
    }

    /**
     * 1.获取上下文
     *
     * @return
     */
    public static Context getContext() {
        return MyApplication.getContext();
    }

    /**
     * 2.根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 3.根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 4.获取app版本号
     *
     * @return
     */
    public static int getVersionCode() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext()
                    .getPackageName(), 0);
            return info.versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 获得屏幕宽度
     *
     * @return
     */
    public static int getWindowWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();

        return width;

    }

    /**
     * 5.全局定义Toast.makeText
     *
     * @return
     */
    public static void showToast(String name) {
        if (name != null) {
            Toast.makeText(getContext(), name, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 获得屏幕高度分辨率
     *
     * @return
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }

    /**
     * 获得屏幕宽度分辨率
     *
     * @return
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * 获取屏幕大小
     *
     * @param context
     * @return
     */
    public static int[] getScreenSize(Context context) {
        int[] screenSize = new int[2];
        int measuredWidth = 0;
        int measuredheight = 0;
        Point size = new Point();
        WindowManager w = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            w.getDefaultDisplay().getSize(size);
            measuredWidth = size.x;
            measuredheight = size.y;
        } else {
            Display d = w.getDefaultDisplay();
            measuredWidth = d.getWidth();
            measuredheight = d.getHeight();
        }
        screenSize[0] = measuredWidth;
        screenSize[1] = measuredheight;

        return screenSize;
    }

    public static boolean isPhone(String inputText) {

        if (inputText.isEmpty()) {
            Toast.makeText(getContext(), "账户输入不能为空", Toast.LENGTH_SHORT).show();
            return false;
        } else {

            Pattern p = Pattern
                    .compile("^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(inputText);

            if (m.matches()) {
                return true;
            } else {
                Toast.makeText(getContext(), "手机号码格式错误", Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        }
    }

    public static boolean isPassword(String inputText) {
        if (inputText == null || inputText.trim().equals("")) {
            SystemConfig.showToast("请输入密码");
            return false;
        } else {

            if (!Pattern.matches("^[\\s|\\S]{6,15}", inputText)) {
                Toast.makeText(getContext(), "密码格式错误,请输入6-15位字符密码", Toast.LENGTH_SHORT)
                        .show();
                return false;
            } else {
                return true;
            }

        }
    }

    public static int getDensityDpi(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        // width = metric.widthPixels; // 屏幕宽度（像素）
        // height = metric.heightPixels; // 屏幕高度（像素）
        int density = (int) metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
//		int densityDpi = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240）
        return density;

    }


    public static int getDensityDpi1(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        // width = metric.widthPixels; // 屏幕宽度（像素）
        // height = metric.heightPixels; // 屏幕高度（像素）
//		int density = (int) metric.density; // 屏幕密度（0.75 / 1.0 / 1.5）
        int densityDpi = metric.densityDpi; // 屏幕密度DPI（120 / 160 / 240）

        return densityDpi;

    }

    public static void KeyBoard(final EditText txtSearchKey, final String status) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager m = (InputMethodManager) txtSearchKey
                        .getContext().getSystemService(
                                Context.INPUT_METHOD_SERVICE);
                if (status.equals("open")) {
                    m.showSoftInput(txtSearchKey,
                            InputMethodManager.SHOW_FORCED);

                } else {
                    m.hideSoftInputFromWindow(txtSearchKey.getWindowToken(), 0);

                }
            }
        }, 300);
    }

    /**
     * 获取屏幕尺寸与密度.
     *
     * @param context the context
     * @return mDisplayMetrics
     */
    public static DisplayMetrics getDisplayMetrics(Context context) {
        Resources mResources;
        if (context == null) {
            mResources = Resources.getSystem();

        } else {
            mResources = context.getResources();
        }
        //DisplayMetrics{density=1.5, width=480, height=854, scaledDensity=1.5, xdpi=160.421, ydpi=159.497}
        //DisplayMetrics{density=2.0, width=720, height=1280, scaledDensity=2.0, xdpi=160.42105, ydpi=160.15764}
        DisplayMetrics mDisplayMetrics = mResources.getDisplayMetrics();
        return mDisplayMetrics;
    }


    /**
     * 动态设置宽高
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetListViewWidthAndHeight(View view, double width, double height) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        if (view.getLayoutParams() == null) {
            AbsListView.LayoutParams params = new AbsListView.LayoutParams((int) width, (int) height);
            view.setLayoutParams(params);
        } else {
            AbsListView.LayoutParams params = (AbsListView.LayoutParams) view.getLayoutParams();
            params.height = (int) height;
            params.width = (int) width;
        }
    }

    /**
     * 动态设置宽高
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetRelayoutViewWidthAndHeight(View view, double width, double height) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) width, (int) height);
        view.setLayoutParams(params);
    }

    /**
     * 动态设置宽高
     * 比列 宽度 ： 750
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetWidthAndHeight(View view, double width, double height) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        if (width == -3) {
            width = getScreenWidth();
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) width, (int) height);
        view.setLayoutParams(params);
    }

    /**
     * @param view
     */
    public static void dynamicSetWidthAndHeight(View view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(SystemConfig.getScreenWidth(), -1);
        view.setLayoutParams(params);
    }

    /**
     * 动态设置宽高
     * 比列 宽度 ： 750
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetFrameWidthAndHeight(View view, double width, double height) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams((int) width, (int) height);
        view.setLayoutParams(params);
    }

    /**
     * 动态设置宽高
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetWidthAndHeight(View view, double width, double height, int top, int bottom, int left, int right) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) width, (int) height);
        params.bottomMargin = getScale(bottom);
        params.topMargin = getScale(top);
        params.leftMargin = getScale(left);
        params.rightMargin = getScale(right);
        view.setLayoutParams(params);
    }

    /**
     * 动态设置宽高
     *
     * @param view
     * @param height
     * @param width
     */
    public static void dynamicSetWidthAndHeight(View view, double width, double height, int top, int bottom, int left, int right, int gravity) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) width, (int) height);
        params.bottomMargin = getScale(bottom);
        params.topMargin = getScale(top);
        params.leftMargin = getScale(left);
        params.rightMargin = getScale(right);
        params.gravity = gravity;
        view.setLayoutParams(params);
    }

    /* 动态设置宽高
    *
    * @param view
    * @param height
    * @param width
    */
    public static void dynamicSetRelayoutViewWidthAndHeight(View view, double width, double height, int top, int bottom, int left, int right) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        RelativeLayout.LayoutParams params = null;
        if (view.getLayoutParams() != null) {
            params = (RelativeLayout.LayoutParams) view.getLayoutParams();
            params.width = (int) width;
            params.height = (int) height;
        } else {
            params = new RelativeLayout.LayoutParams((int) width, (int) height);
        }
        params.bottomMargin = getScale(bottom);
        params.topMargin = getScale(top);
        params.leftMargin = getScale(left);
        params.rightMargin = getScale(right);
        view.setLayoutParams(params);
    }

    /* 动态设置宽高
    *
    * @param view
    * @param height
    * @param width
    */
    public static void dynamicSetRelayoutViewWidthAndHeight(View view, double width, double height, int top, int bottom, int left, int right, Map<Integer, Integer> map) {
        if (width >= 1) {
            width = getScale(width);
        } else if (width > 0) {
            width = getScreenWidth() * width;
        }
        if (height >= 1) {
            height = getScale(height);
        } else if (height > 0) {
            height = getScreenWidth() * height;
        }
        RelativeLayout.LayoutParams params = null;
        if (view.getLayoutParams() != null) {
            params = (RelativeLayout.LayoutParams) view.getLayoutParams();

        } else {
            params = new RelativeLayout.LayoutParams((int) width, (int) height);
            view.setLayoutParams(params);
        }
        params.height = (int) height;
        params.width = (int) width;
        params.bottomMargin = getScale(bottom);
        params.topMargin = getScale(top);
        params.leftMargin = getScale(left);
        params.rightMargin = getScale(right);
        if (map.size() > 0) {
            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                params.addRule(entry.getKey(), entry.getValue());
            }
        }

    }


    public static void systemOut(String log) {
        System.out.println("==============" + log);
    }


    public static String md5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String MD5Encode(String inStr) throws Exception {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        byte[] byteArray = inStr.getBytes("UTF-8");
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString().toUpperCase();
    }


    public static String getRawString(InputStream inputStream) {
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);
        StringBuffer sb = new StringBuffer("");
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    /**
     * 获取版本号
     *
     * @return 当前应用的版本号
     */
    public static String getVersion() {
        try {
            PackageManager manager = getContext().getPackageManager();
            PackageInfo info = manager.getPackageInfo(getContext().getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.0.0";
        }
    }


    /**
     * 判断是否安装目标应用
     *
     * @param packageName 目标应用安装后的包名
     * @return 是否已安装目标应用
     */
    public static boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    public static boolean isGetNetSuccess(BaseBean baseBean) {
        if ("1".equals(baseBean.getCode())) {
            return true;
        } else {
            showToast(baseBean.getMsg());
            return false;
        }
    }

    public static String moneymulti(String money) {
        try {
            if (money != null) {
                BigDecimal bigDecimal = new BigDecimal(money);
                BigDecimal newMoney = bigDecimal.multiply(new BigDecimal(50));
                return newMoney.toString();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return "0";
    }


}
