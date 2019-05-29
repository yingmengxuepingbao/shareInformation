package com.zyx.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 活动推广途径关联表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */

@TableName("msg_push_activity_extend_way")
@Component
public class MsgPushActivityExtendWay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 活动编号
     */
    @TableField("activity_id")
    @NotNull(message="活动编号不能为空")
    private String activityId;
    /**
     * 推广途径编号
     */
    @TableField("extend_way_id")
    private String extendWayId;
    /**
     * 创建人员
     */
    @TableField("create_user_id")
    private String createUserId;
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
     * 更新人员
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
    private Integer isVeritified;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public Integer getIsVeritified() {
        return isVeritified;
    }

    public void setIsVeritified(Integer isVeritified) {
        this.isVeritified = isVeritified;
    }

    @Override
    public String toString() {
        return "MsgPushActivityExtendWay{" +
        "id=" + id +
        ", activityId=" + activityId +
        ", extendWayId=" + extendWayId +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", updateUserId=" + updateUserId +
        ", isEnable=" + isEnable +
        ", isVeritified=" + isVeritified +
        "}";
    }
}
