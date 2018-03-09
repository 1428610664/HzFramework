package com.hz.hzframework.utils;


import com.hz.hzframework.bean.UserBean;

public class PersonMessagePreferencesUtils {

    public static String getUid() {
        return PreferencesUtils.getString("member_id");
    }

    /**
     * 保存用户信息
     *
     * @param user
     */
    public static void storeInfo(UserBean user) {
        PreferencesUtils.putString("member_id", user.getData().getMember_id());
        PreferencesUtils.putString("true_name", user.getData().getTrue_name());
        PreferencesUtils.putString("member_name", user.getData().getMember_name());
        PreferencesUtils.putInt("group_id", user.getData().getGroup_id());
        PreferencesUtils.putString("reg_time", user.getData().getReg_time());
        PreferencesUtils.putString("last_time", user.getData().getLast_time());
        PreferencesUtils
                .putInt("pay_points", user.getData().getPay_points());
        PreferencesUtils.putInt("state", user.getData().getState()); // 用户昵称，对应个人资料昵称
        PreferencesUtils.putInt("sex", user.getData().getSex());
        PreferencesUtils.putString("cellphone", user.getData().getCellphone());
        PreferencesUtils.putString("branch_bank_name", user.getData().getBranch_bank_name());
        PreferencesUtils.putString("bank_account_name", user.getData().getBank_account_name());
        PreferencesUtils.putString("bank_account_no", user.getData().getBank_account_no());
        PreferencesUtils.putInt("has_default_consignee", user.getData().getHas_default_consignee());
        PreferencesUtils.putInt("has_set_pay_password", user.getData().getHas_set_pay_password());
        PreferencesUtils.putInt("designer_id", user.getData().getDesigner_id());
    }

    /**
     * 保存用户信息
     *
     * @param user
     */
    public static void storeInfo() {
        PreferencesUtils.putString("member_id", "6");
        PreferencesUtils.putString("true_name", "啦哦");
        PreferencesUtils.putString("member_name", "啦哦");
        PreferencesUtils.putInt("group_id", 0);
        PreferencesUtils.putString("reg_time", "2016-08-08 19:05:41");
        PreferencesUtils.putString("last_time", "2016-08-08 19:05:41");
        PreferencesUtils
                .putInt("pay_points", 500);
        PreferencesUtils.putInt("state", 0); // 用户昵称，对应个人资料昵称
        PreferencesUtils.putInt("sex", 1);
        PreferencesUtils.putString("cellphone", "13430701886");
        PreferencesUtils.putString("branch_bank_name", "");
        PreferencesUtils.putString("bank_account_name", "");
        PreferencesUtils.putString("bank_account_no", "");
        PreferencesUtils.putInt("has_default_consignee", 1);
        PreferencesUtils.putInt("has_set_pay_password", 1);
        PreferencesUtils.putInt("designer_id", 0);
    }


    /**
     * 删除用户信息
     */
    public static void deleteInfo() {
        PreferencesUtils.putString("member_id", null);
        PreferencesUtils.putString("true_name", null);
        PreferencesUtils.putString("member_name", null);
        PreferencesUtils.putString("group_id", null);
        PreferencesUtils.putString("reg_time", null);
        PreferencesUtils.putString("last_time", null); // 用户昵称，对应个人资料昵称
        PreferencesUtils.putString("pay_points", null);
        PreferencesUtils.putString("state", null);
        PreferencesUtils.putString("sex", null);
        PreferencesUtils.putString("cellphone", null);
        PreferencesUtils.putString("branch_bank_name", null);
        PreferencesUtils.putString("bank_account_name", null);
        PreferencesUtils.putString("bank_account_no", null);
        PreferencesUtils.putInt("has_default_consignee", 0);
        PreferencesUtils.putInt("has_set_pay_password", 0);
        PreferencesUtils.putInt("designer_id", 0);

    }

}
