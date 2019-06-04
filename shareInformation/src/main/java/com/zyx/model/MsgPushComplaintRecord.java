package com.zyx.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户投诉记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
@Component
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
    @NotBlank(message="投诉理由不能为空")
    private String complaintReason;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private String createTime;
    /**
     * 更新日期
     */
    @TableField("update_time")
    private String updateTime;
    
    //投诉凭证记录表
    private List<MsgPushComplaintVoucher> mpcvList;
    //微信openId
    private String openId;
    //用于接收前台传输的图片路径
    private String[] mpcvArr;
    //活动名称
    private String activityName;
    
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

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public List<MsgPushComplaintVoucher> getMpcvList() {
		return mpcvList;
	}

	public void setMpcvList(List<MsgPushComplaintVoucher> mpcvList) {
		this.mpcvList = mpcvList;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String[] getMpcvArr() {
		return mpcvArr;
	}

	public void setMpcvArr(String[] mpcvArr) {
		this.mpcvArr = mpcvArr;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
    public String toString() {
        return "MsgPushComplaintRecord{" +
        "complaintId=" + complaintId +
        ", complaintUserId=" + complaintUserId +
        ", activityId=" + activityId +
        ", complaintReason=" + complaintReason +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", mpcvList=" + mpcvList +
        ", openId=" + openId +
        ", mpcvArr=" + mpcvArr +
        ", activityName=" + activityName +
        "}";
    }
}
