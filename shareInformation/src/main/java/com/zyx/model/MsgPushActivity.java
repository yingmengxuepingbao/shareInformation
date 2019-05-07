package com.zyx.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@TableName("msg_push_activity")
public class MsgPushActivity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动编号
     */
    @TableField("activity_id")
    private String activityId;
    /**
     * 活动名称
     */
    @TableField("activity_name")
    private String activityName;
    /**
     * 活动发起人
     */
    @TableField("activity_initiate_user_id")
    private String activityInitiateUserId;
    /**
     * 活动规则编号
     */
    @TableField("activity_rule_id")
    private String activityRuleId;
    /**
     * 奖励内容
     */
    @TableField("reward_content")
    private String rewardContent;
    /**
     * 奖励领取方式编号
     */
    @TableField("reward_receive_method_id")
    private String rewardReceiveMethodId;
    /**
     * 活动起始时间
     */
    @TableField("start_time")
    private Date startTime;
    /**
     * 活动截止时间
     */
    @TableField("end_time")
    private Date endTime;
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
     * 更新人
     */
    @TableField("update_user_id")
    private String updateUserId;
    /**
     * 是否禁用
     */
    private Integer isEnable;
    /**
     * 是否完成审核
     */
    private Integer isVerified;


    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityInitiateUserId() {
        return activityInitiateUserId;
    }

    public void setActivityInitiateUserId(String activityInitiateUserId) {
        this.activityInitiateUserId = activityInitiateUserId;
    }

    public String getActivityRuleId() {
        return activityRuleId;
    }

    public void setActivityRuleId(String activityRuleId) {
        this.activityRuleId = activityRuleId;
    }

    public String getRewardContent() {
        return rewardContent;
    }

    public void setRewardContent(String rewardContent) {
        this.rewardContent = rewardContent;
    }

    public String getRewardReceiveMethodId() {
        return rewardReceiveMethodId;
    }

    public void setRewardReceiveMethodId(String rewardReceiveMethodId) {
        this.rewardReceiveMethodId = rewardReceiveMethodId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public String toString() {
        return "MsgPushActivity{" +
        "activityId=" + activityId +
        ", activityName=" + activityName +
        ", activityInitiateUserId=" + activityInitiateUserId +
        ", activityRuleId=" + activityRuleId +
        ", rewardContent=" + rewardContent +
        ", rewardReceiveMethodId=" + rewardReceiveMethodId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", updateUserId=" + updateUserId +
        ", isEnable=" + isEnable +
        ", isVerified=" + isVerified +
        "}";
    }
}
