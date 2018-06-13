package com.bawei.myyikezhong.Tuijian.ui.bean;

import java.util.List;

public class SuijiBean {

    /**
     * msg : 请求成功
     * code : 1
     * data : [{"age":null,"appkey":"cb1f6fadfee21907","appsecret":"BDC6B9BB321A782AC453802D28B95F62","createtime":"2017-12-23T10:47:51","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13930106157","money":null,"nickname":null,"password":"31297D6C339BD8D7464849885AC39636","praiseNum":null,"token":null,"uid":6093,"userId":null,"username":"13930106157"},{"age":null,"appkey":"69bea027a60e06c5","appsecret":"7E0471701FA98C330F3F95B5A85E22E6","createtime":"2017-12-23T10:47:51","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13974555197","money":null,"nickname":null,"password":"DF0B3ED9186DDE5931F7486C3BA6A437","praiseNum":null,"token":null,"uid":6094,"userId":null,"username":"13974555197"},{"age":null,"appkey":"390a4c357313fca2","appsecret":"A2477AFDAFCA785D8CEFDD32D219D2F1","createtime":"2017-12-23T10:47:51","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13913450331","money":null,"nickname":null,"password":"48CFB2B2D37AE1609BD0D3F5D60FEA4F","praiseNum":null,"token":null,"uid":6095,"userId":null,"username":"13913450331"},{"age":null,"appkey":"f394755c11f85360","appsecret":"BBC8F6B50F807F6FD33F897E9B51487E","createtime":"2017-12-23T10:47:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13934631005","money":null,"nickname":null,"password":"2935B77BEF36D67522D101936B73B758","praiseNum":null,"token":null,"uid":6096,"userId":null,"username":"13934631005"},{"age":null,"appkey":"e5cd9762572a0080","appsecret":"BD9F9DEA0769CD09C89C801F0E8F363E","createtime":"2017-12-23T10:47:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13956577299","money":null,"nickname":null,"password":"4EEF39B2E8458E6D8B553310F87C0936","praiseNum":null,"token":null,"uid":6097,"userId":null,"username":"13956577299"},{"age":null,"appkey":"e47d96669897a455","appsecret":"013B3C8668C80211AF7AD6848EF2B3A8","createtime":"2017-12-23T10:47:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13934789910","money":null,"nickname":null,"password":"8A073791AD42D7ED634FC39EA6B24F9E","praiseNum":null,"token":null,"uid":6098,"userId":null,"username":"13934789910"},{"age":null,"appkey":"457441901351e4ab","appsecret":"E3B4313F8FF5ED44612441D87AD526AC","createtime":"2017-12-23T10:47:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13929429369","money":null,"nickname":null,"password":"9AC3711D7DC8690396ED0D43ABA786A0","praiseNum":null,"token":null,"uid":6099,"userId":null,"username":"13929429369"},{"age":null,"appkey":"efb36391dfa8f199","appsecret":"8D43A8BBD863A6016CBD71668DD8AD27","createtime":"2017-12-23T10:47:52","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13932011749","money":null,"nickname":null,"password":"FFAFA4B11D49AA04E51818AED6E4CDB8","praiseNum":null,"token":null,"uid":6100,"userId":null,"username":"13932011749"},{"age":null,"appkey":"5809ea0496bbf9aa","appsecret":"14401DB3D6647CE753A293FF85D9E2C7","createtime":"2017-12-23T10:47:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13990996574","money":null,"nickname":null,"password":"7473FC000BA4662921553E3441834027","praiseNum":null,"token":null,"uid":6101,"userId":null,"username":"13990996574"},{"age":null,"appkey":"a493e2d61891b1e4","appsecret":"561AD2B9AB04F05014E0D00D695B1607","createtime":"2017-12-23T10:47:53","email":null,"fans":null,"follow":null,"gender":null,"icon":null,"latitude":null,"longitude":null,"mobile":"13942217241","money":null,"nickname":null,"password":"C5189F6D3723068381CD4E79AF31441F","praiseNum":null,"token":null,"uid":6102,"userId":null,"username":"13942217241"}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : cb1f6fadfee21907
         * appsecret : BDC6B9BB321A782AC453802D28B95F62
         * createtime : 2017-12-23T10:47:51
         * email : null
         * fans : null
         * follow : null
         * gender : null
         * icon : null
         * latitude : null
         * longitude : null
         * mobile : 13930106157
         * money : null
         * nickname : null
         * password : 31297D6C339BD8D7464849885AC39636
         * praiseNum : null
         * token : null
         * uid : 6093
         * userId : null
         * username : 13930106157
         */

        private Object age;
        private String appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private Object gender;
        private Object icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private Object money;
        private Object nickname;
        private String password;
        private Object praiseNum;
        private Object token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public String getAppkey() {
            return appkey;
        }

        public void setAppkey(String appkey) {
            this.appkey = appkey;
        }

        public String getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(String appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getFans() {
            return fans;
        }

        public void setFans(Object fans) {
            this.fans = fans;
        }

        public Object getFollow() {
            return follow;
        }

        public void setFollow(Object follow) {
            this.follow = follow;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public Object getMoney() {
            return money;
        }

        public void setMoney(Object money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getToken() {
            return token;
        }

        public void setToken(Object token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public Object getUserId() {
            return userId;
        }

        public void setUserId(Object userId) {
            this.userId = userId;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
