package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户账号微信关联表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@TableName("msg_push_user_wx_relationship")
public class MsgPushUserWxRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * 用户openId
     */
    private String openId;
    /**
     * 微信昵称
     */
    @TableField("msg_push_user_nick")
    private String msgPushUserNick;
    /**
     * 微信头像url
     */
    @TableField("msg_push_head_url")
    private String msgPushHeadUrl;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新日期
     */
    @TableField("update_time")
    private Date updateTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getMsgPushUserNick() {
        return msgPushUserNick;
    }

    public void setMsgPushUserNick(String msgPushUserNick) {
        this.msgPushUserNick = msgPushUserNick;
    }

    public String getMsgPushHeadUrl() {
        return msgPushHeadUrl;
    }

    public void setMsgPushHeadUrl(String msgPushHeadUrl) {
        this.msgPushHeadUrl = msgPushHeadUrl;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "MsgPushUserWxRelationship{" +
        "userId=" + userId +
        ", openId=" + openId +
        ", msgPushUserNick=" + msgPushUserNick +
        ", msgPushHeadUrl=" + msgPushHeadUrl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
