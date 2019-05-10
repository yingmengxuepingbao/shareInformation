package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 活动规则表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_activity_rule")
public class MsgPushActivityRule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动规则编号
     */
    @TableField("activity_rule_id")
    private String activityRuleId;
    /**
     * 活动规则名称
     */
    @TableField("activity_rule_name")
    private String activityRuleName;
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


    public String getActivityRuleId() {
        return activityRuleId;
    }

    public void setActivityRuleId(String activityRuleId) {
        this.activityRuleId = activityRuleId;
    }

    public String getActivityRuleName() {
        return activityRuleName;
    }

    public void setActivityRuleName(String activityRuleName) {
        this.activityRuleName = activityRuleName;
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
        return "MsgPushActivityRule{" +
        "activityRuleId=" + activityRuleId +
        ", activityRuleName=" + activityRuleName +
        ", createUserId=" + createUserId +
        ", updateUserId=" + updateUserId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
