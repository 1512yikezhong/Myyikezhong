package com.bawei.myyikezhong.Tuijian.ui.bean;

import java.util.List;

public class MyGuanzhuBean {


    /**
     * msg : 获取关注用户列表成功
     * code : 0
     * data : [{"age":null,"appkey":null,"appsecret":"B3F4F02FA7852C16B27E0FDA9A65886A","createtime":"2018-06-08T16:47:38","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15283634063661528363406241.png","latitude":null,"longitude":null,"mobile":"18612991023","money":0,"nickname":"qqq","password":"016AD198F61ADB3CEFA4E5ECD78604FA","praiseNum":null,"token":"5A4143DE8859115F3B4C510056C9B4A7","uid":71,"userId":null,"username":"18612991023"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-30T11:12:25","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/1512203571490dsf.jpg","latitude":null,"longitude":null,"mobile":"18339901531","money":0,"nickname":"若水","password":"123456","praiseNum":null,"token":"A315BB69D6F474CB1057185A8432A2B7","uid":77,"userId":null,"username":"18339901531"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-28T15:34:51","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/151444054654620171228055531.jpg","latitude":null,"longitude":null,"mobile":"15011217423","money":0,"nickname":"Mo","password":"971121","praiseNum":null,"token":"328E60FC7E24996E96A80D99F6311F01","uid":98,"userId":null,"username":"15011217423"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-12-30T11:47:53","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/151437149690320171227104217.jpg","latitude":null,"longitude":null,"mobile":"15011476366","money":0,"nickname":"祝又忠","password":"111111","praiseNum":null,"token":"60D2C38F25C4DF6503E771BA572D11D9","uid":99,"userId":null,"username":"15011476366"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-08T09:14:16","email":null,"fans":null,"follow":null,"gender":0,"icon":"https://www.zhaoapi.cn/images/15268946342412018_05_21_17_23_48.jpg","latitude":null,"longitude":null,"mobile":"15776320444","money":0,"nickname":null,"password":"12456456","praiseNum":null,"token":null,"uid":101,"userId":null,"username":"15776320444"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-10T20:07:14","email":null,"fans":null,"follow":null,"gender":0,"icon":null,"latitude":null,"longitude":null,"mobile":"13001205555","money":0,"nickname":null,"password":"123456","praiseNum":null,"token":null,"uid":158,"userId":null,"username":"13001205555"},{"age":null,"appkey":null,"appsecret":null,"createtime":"2017-10-14T00:00:00","email":null,"fans":null,"follow":null,"gender":0,"icon":"http://120.27.23.105/images/282.jpg","latitude":null,"longitude":null,"mobile":"13051162225","money":0,"nickname":null,"password":"123123","praiseNum":null,"token":null,"uid":282,"userId":null,"username":"13051162225"},{"age":null,"appkey":"8b5fd8cba6737326","appsecret":"6EF8DADB34375592441AB8D49D5417FE","createtime":"2018-05-11T07:57:09","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1523839244885crop_photo.jpg","latitude":null,"longitude":null,"mobile":"13910682155","money":null,"nickname":"%E5%BC%A0%E9%9C%B2","password":"8F669074CAF5513351A2DE5CC22AC04C","praiseNum":null,"token":"3D28B2D2A9544DCF0E159A5AFC6E16FC","uid":12509,"userId":null,"username":"13910682155"},{"age":null,"appkey":"679455a233086e26","appsecret":"F259D879B03CCA7C403B9A90A5B8F41A","createtime":"2018-05-28T10:05:45","email":null,"fans":null,"follow":null,"gender":null,"icon":"https://www.zhaoapi.cn/images/1517574153932AndroidFightingIphone3.png","latitude":null,"longitude":null,"mobile":"17600044511","money":null,"nickname":"我不是杨犊子","password":"7F14BAAF818358E25E2D9C5259AA47DD","praiseNum":null,"token":"2F8EBE49EE227C2017C470689C62E524","uid":3881,"userId":null,"username":"17600044511"}]
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
         * appkey : null
         * appsecret : B3F4F02FA7852C16B27E0FDA9A65886A
         * createtime : 2018-06-08T16:47:38
         * email : null
         * fans : null
         * follow : null
         * gender : 0
         * icon : https://www.zhaoapi.cn/images/15283634063661528363406241.png
         * latitude : null
         * longitude : null
         * mobile : 18612991023
         * money : 0
         * nickname : qqq
         * password : 016AD198F61ADB3CEFA4E5ECD78604FA
         * praiseNum : null
         * token : 5A4143DE8859115F3B4C510056C9B4A7
         * uid : 71
         * userId : null
         * username : 18612991023
         */

        private Object age;
        private Object appkey;
        private String appsecret;
        private String createtime;
        private Object email;
        private Object fans;
        private Object follow;
        private int gender;
        private String icon;
        private Object latitude;
        private Object longitude;
        private String mobile;
        private int money;
        private String nickname;
        private String password;
        private Object praiseNum;
        private String token;
        private int uid;
        private Object userId;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
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

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
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

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
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
