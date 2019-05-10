package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 会员等级表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_membership_level")
public class MsgPushMembershipLevel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员等级编号
     */
    @TableField("membership_level_id")
    private String membershipLevelId;
    /**
     * 会员等级名称
     */
    @TableField("membership_level_name")
    private String membershipLevelName;
    /**
     * 需要累计充值金额
     */
    @TableField("recharge_amount")
    private String rechargeAmount;
    /**
     * 创建人
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 更新人
     */
    @TableField("update_user_id")
    private String updateUserId;
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
    /**
     * 是否禁用
     */
    private Integer isEnable;


    public String getMembershipLevelId() {
        return membershipLevelId;
    }

    public void setMembershipLevelId(String membershipLevelId) {
        this.membershipLevelId = membershipLevelId;
    }

    public String getMembershipLevelName() {
        return membershipLevelName;
    }

    public void setMembershipLevelName(String membershipLevelName) {
        this.membershipLevelName = membershipLevelName;
    }

    public String getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
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

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "MsgPushMembershipLevel{" +
        "membershipLevelId=" + membershipLevelId +
        ", membershipLevelName=" + membershipLevelName +
        ", rechargeAmount=" + rechargeAmount +
        ", createUserId=" + createUserId +
        ", updateUserId=" + updateUserId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
