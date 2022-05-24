package com.gavin.pojo;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Evaluation {
    @Id
    private String _id; //id
    private String content; //评价内容
    private Date publishtime; //评价时间
    private String userid;   //谁评价的
    private String nickname; //网名
    private Integer visits;  //访问的次数
    private Integer thumbup; //点赞(是否有用) ---->只能一次
    private Integer comment; //回复数量
    private String state;   //是否可见
    private Integer recryitId; //评价的是哪一个岗位
    private String parentid; //上一级ID 如果没有评论 为null

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public Integer getThumbup() {
        return thumbup;
    }

    public void setThumbup(Integer thumbup) {
        this.thumbup = thumbup;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getRecryitId() {
        return recryitId;
    }

    public void setRecryitId(Integer recryitId) {
        this.recryitId = recryitId;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }
}
