package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户投诉记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
@TableName("msg_push_complaint_record")
public class MsgPushComplaintRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投诉编号
     */
    @TableId("complaint_id")
    private String complaintId;
    /**
     * 投诉用户编号
     */
    @TableField("complaint_user_id")
    private String complaintUserId;
    /**
     * 活动id
     */
    @TableField("activity_id")
    private String activityId;
    /**
     * 投诉理由
     */
    @TableField("complaint_reason")
    private String complaintReason;
    /**
     * 投诉凭证编号
     */
    @TableField("complaint_voucher_id")
    private String complaintVoucherId;
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


    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }

    public String getComplaintUserId() {
        return complaintUserId;
    }

    public void setComplaintUserId(String complaintUserId) {
        this.complaintUserId = complaintUserId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getComplaintReason() {
        return complaintReason;
    }

    public void setComplaintReason(String complaintReason) {
        this.complaintReason = complaintReason;
    }

    public String getComplaintVoucherId() {
        return complaintVoucherId;
    }

    public void setComplaintVoucherId(String complaintVoucherId) {
        this.complaintVoucherId = complaintVoucherId;
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
        return "MsgPushComplaintRecord{" +
        "complaintId=" + complaintId +
        ", complaintUserId=" + complaintUserId +
        ", activityId=" + activityId +
        ", complaintReason=" + complaintReason +
        ", complaintVoucherId=" + complaintVoucherId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
