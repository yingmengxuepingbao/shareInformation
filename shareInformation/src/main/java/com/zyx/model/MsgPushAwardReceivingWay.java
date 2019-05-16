package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 奖励领取方式表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-16
 */
@TableName("msg_push_award_receiving_way")
public class MsgPushAwardReceivingWay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 奖励领取方式编号
     */
    @TableId("receiving_way_id")
    private String receivingWayId;
    /**
     * 奖励发放方式
     */
    @TableField("receiving_way_name")
    private String receivingWayName;
    /**
     * 创建人员ID
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 有效起始时间
     */
    @TableField("start_time")
    private String startTime;
    /**
     * 有效截止时间
     */
    @TableField("end_time")
    private String endTime;
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


    public String getReceivingWayId() {
        return receivingWayId;
    }

    public void setReceivingWayId(String receivingWayId) {
        this.receivingWayId = receivingWayId;
    }

    public String getReceivingWayName() {
        return receivingWayName;
    }

    public void setReceivingWayName(String receivingWayName) {
        this.receivingWayName = receivingWayName;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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

    @Override
    public String toString() {
        return "MsgPushAwardReceivingWay{" +
        "receivingWayId=" + receivingWayId +
        ", receivingWayName=" + receivingWayName +
        ", createUserId=" + createUserId +
        ", startTime=" + startTime +
        ", endTime=" + endTime +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
