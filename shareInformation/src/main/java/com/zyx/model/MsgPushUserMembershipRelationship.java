package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户会员关联表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_user_membership_relationship")
public class MsgPushUserMembershipRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * 会员等级编号
     */
    @TableField("membership_level_id")
    private String membershipLevelId;
    /**
     * 累计充值金额
     */
    @TableField("recharge_amount_total")
    private String rechargeAmountTotal;
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

    public String getMembershipLevelId() {
        return membershipLevelId;
    }

    public void setMembershipLevelId(String membershipLevelId) {
        this.membershipLevelId = membershipLevelId;
    }

    public String getRechargeAmountTotal() {
        return rechargeAmountTotal;
    }

    public void setRechargeAmountTotal(String rechargeAmountTotal) {
        this.rechargeAmountTotal = rechargeAmountTotal;
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
        return "MsgPushUserMembershipRelationship{" +
        "userId=" + userId +
        ", membershipLevelId=" + membershipLevelId +
        ", rechargeAmountTotal=" + rechargeAmountTotal +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
