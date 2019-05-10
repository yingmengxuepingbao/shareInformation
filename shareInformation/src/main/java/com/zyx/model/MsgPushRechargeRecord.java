package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户充值历史记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_recharge_record")
public class MsgPushRechargeRecord implements Serializable {

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
     * 充值金额
     */
    @TableField("recharge_count")
    private String rechargeCount;
    /**
     * 创建时间
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

    public String getRechargeCount() {
        return rechargeCount;
    }

    public void setRechargeCount(String rechargeCount) {
        this.rechargeCount = rechargeCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MsgPushRechargeRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", rechargeCount=" + rechargeCount +
        ", createTime=" + createTime +
        "}";
    }
}
