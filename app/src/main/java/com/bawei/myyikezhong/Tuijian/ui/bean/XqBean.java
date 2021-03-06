package com.bawei.myyikezhong.Tuijian.ui.bean;

import java.util.List;

public class XqBean {

    /**
     * msg : 获取详情成功
     * code : 0
     * data : {"commentNum":5,"comments":[{"cid":320,"content":"%E5%A5%BD%E5%90%AC","createTime":"2018-04-02T15:56:57","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":321,"content":"%E9%98%BF%E7%8B%B8","createTime":"2018-04-02T15:58:03","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":324,"content":"%E6%88%91%E5%BC%80%E4%BC%9A","createTime":"2018-04-02T16:14:29","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":325,"content":"%E9%87%8C%E9%9D%A2","createTime":"2018-04-02T16:17:16","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":327,"content":"%E6%88%91%E7%9A%84","createTime":"2018-04-02T17:57:15","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264}],"cover":"https://www.zhaoapi.cn/images/quarter/1517016640785car.jpg","createTime":"2018-01-27T09:30:40","favoriteNum":3,"latitude":"39.95","localUri":null,"longitude":"116.30","playNum":171,"praiseNum":3,"uid":2322,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15192979549031526728353273.png","nickname":"小崔","praiseNum":"null"},"videoUrl":"https://www.zhaoapi.cn/images/quarter/1517016640785father.mp4","wid":264,"workDesc":"筷子兄弟\u2014父亲"}
     */

    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : 5
         * comments : [{"cid":320,"content":"%E5%A5%BD%E5%90%AC","createTime":"2018-04-02T15:56:57","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":321,"content":"%E9%98%BF%E7%8B%B8","createTime":"2018-04-02T15:58:03","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":324,"content":"%E6%88%91%E5%BC%80%E4%BC%9A","createTime":"2018-04-02T16:14:29","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":325,"content":"%E9%87%8C%E9%9D%A2","createTime":"2018-04-02T16:17:16","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264},{"cid":327,"content":"%E6%88%91%E7%9A%84","createTime":"2018-04-02T17:57:15","jid":null,"mvp":null,"nickname":"Meet","praiseNum":0,"uid":10792,"wid":264}]
         * cover : https://www.zhaoapi.cn/images/quarter/1517016640785car.jpg
         * createTime : 2018-01-27T09:30:40
         * favoriteNum : 3
         * latitude : 39.95
         * localUri : null
         * longitude : 116.30
         * playNum : 171
         * praiseNum : 3
         * uid : 2322
         * user : {"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15192979549031526728353273.png","nickname":"小崔","praiseNum":"null"}
         * videoUrl : https://www.zhaoapi.cn/images/quarter/1517016640785father.mp4
         * wid : 264
         * workDesc : 筷子兄弟—父亲
         */

        private int commentNum;
        private String cover;
        private String createTime;
        private int favoriteNum;
        private String latitude;
        private Object localUri;
        private String longitude;
        private int playNum;
        private int praiseNum;
        private int uid;
        private UserBean user;
        private String videoUrl;
        private int wid;
        private String workDesc;
        private List<CommentsBean> comments;

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getFavoriteNum() {
            return favoriteNum;
        }

        public void setFavoriteNum(int favoriteNum) {
            this.favoriteNum = favoriteNum;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Object getLocalUri() {
            return localUri;
        }

        public void setLocalUri(Object localUri) {
            this.localUri = localUri;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public int getPlayNum() {
            return playNum;
        }

        public void setPlayNum(int playNum) {
            this.playNum = playNum;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }

        public String getWorkDesc() {
            return workDesc;
        }

        public void setWorkDesc(String workDesc) {
            this.workDesc = workDesc;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : https://www.zhaoapi.cn/images/15192979549031526728353273.png
             * nickname : 小崔
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private String icon;
            private String nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }

        public static class CommentsBean {
            /**
             * cid : 320
             * content : %E5%A5%BD%E5%90%AC
             * createTime : 2018-04-02T15:56:57
             * jid : null
             * mvp : null
             * nickname : Meet
             * praiseNum : 0
             * uid : 10792
             * wid : 264
             */

            private int cid;
            private String content;
            private String createTime;
            private Object jid;
            private Object mvp;
            private String nickname;
            private int praiseNum;
            private int uid;
            private int wid;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getJid() {
                return jid;
            }

            public void setJid(Object jid) {
                this.jid = jid;
            }

            public Object getMvp() {
                return mvp;
            }

            public void setMvp(Object mvp) {
                this.mvp = mvp;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(int praiseNum) {
                this.praiseNum = praiseNum;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public int getWid() {
                return wid;
            }

            public void setWid(int wid) {
                this.wid = wid;
            }
        }
    }
}
