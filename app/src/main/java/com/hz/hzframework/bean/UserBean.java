package com.hz.hzframework.bean;

/**
 * Created by Administrator on 2016/7/22 0022.
 */
public class UserBean {


    /**
     * code : 1
     * msg : 登陆成功！
     * data : {"state":0,"sex":0,"member_id":"2","member_name":"访客_934393","group_id":0,"reg_time":"2016-07-22 11:32:13","last_time":"2016-07-22 11:37:15","pay_points":0,"cellphone":"18623227461","has_default_consignee":0,"branch_bank_name":"","bank_account_name":"","bank_account_no":"","has_set_pay_password":0,"designer_id":0,"true_name":""}
     */

    private String code;
    private String msg;
    /**
     * state : 0
     * sex : 0
     * member_id : 2
     * member_name : 访客_934393
     * group_id : 0
     * reg_time : 2016-07-22 11:32:13
     * last_time : 2016-07-22 11:37:15
     * pay_points : 0
     * cellphone : 18623227461
     * has_default_consignee : 0
     * branch_bank_name :
     * bank_account_name :
     * bank_account_no :
     * has_set_pay_password : 0
     * designer_id : 0
     * true_name :
     */

    private DataEntity data;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataEntity getData() {
        return data;
    }

    public static class DataEntity {
        private int state;
        private int sex;
        private String member_id;
        private String member_name;
        private int group_id;
        private String reg_time;
        private String last_time;
        private int pay_points;
        private String cellphone;
        private int has_default_consignee;
        private String branch_bank_name;
        private String bank_account_name;
        private String bank_account_no;
        private int has_set_pay_password;
        private int designer_id;
        private String true_name;

        public void setState(int state) {
            this.state = state;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public void setMember_id(String member_id) {
            this.member_id = member_id;
        }

        public void setMember_name(String member_name) {
            this.member_name = member_name;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public void setLast_time(String last_time) {
            this.last_time = last_time;
        }

        public void setPay_points(int pay_points) {
            this.pay_points = pay_points;
        }

        public void setCellphone(String cellphone) {
            this.cellphone = cellphone;
        }

        public void setHas_default_consignee(int has_default_consignee) {
            this.has_default_consignee = has_default_consignee;
        }

        public void setBranch_bank_name(String branch_bank_name) {
            this.branch_bank_name = branch_bank_name;
        }

        public void setBank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
        }

        public void setBank_account_no(String bank_account_no) {
            this.bank_account_no = bank_account_no;
        }

        public void setHas_set_pay_password(int has_set_pay_password) {
            this.has_set_pay_password = has_set_pay_password;
        }

        public void setDesigner_id(int designer_id) {
            this.designer_id = designer_id;
        }

        public void setTrue_name(String true_name) {
            this.true_name = true_name;
        }

        public int getState() {
            return state;
        }

        public int getSex() {
            return sex;
        }

        public String getMember_id() {
            return member_id;
        }

        public String getMember_name() {
            return member_name;
        }

        public int getGroup_id() {
            return group_id;
        }

        public String getReg_time() {
            return reg_time;
        }

        public String getLast_time() {
            return last_time;
        }

        public int getPay_points() {
            return pay_points;
        }

        public String getCellphone() {
            return cellphone;
        }

        public int getHas_default_consignee() {
            return has_default_consignee;
        }

        public String getBranch_bank_name() {
            return branch_bank_name;
        }

        public String getBank_account_name() {
            return bank_account_name;
        }

        public String getBank_account_no() {
            return bank_account_no;
        }

        public int getHas_set_pay_password() {
            return has_set_pay_password;
        }

        public int getDesigner_id() {
            return designer_id;
        }

        public String getTrue_name() {
            return true_name;
        }
    }
}
