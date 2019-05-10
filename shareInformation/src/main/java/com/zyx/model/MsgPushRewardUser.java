package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户活动推广奖励记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_reward_user")
public class MsgPushRewardUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * 活动推广途径编号
     */
    @TableField("extend_way_id")
    private String extendWayId;
    /**
     * 创建人
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getExtendWayId() {
        return extendWayId;
    }

    public void setExtendWayId(String extendWayId) {
        this.extendWayId = extendWayId;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MsgPushRewardUser{" +
        "id=" + id +
        ", userId=" + userId +
        ", extendWayId=" + extendWayId +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        "}";
    }
}
