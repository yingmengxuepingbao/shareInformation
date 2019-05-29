package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户活动推广途径历史记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_activity_extend_way_record")
public class MsgPushActivityExtendWayRecord implements Serializable {

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
     * 创建日期
     */
    @TableField("create_time")
    private String createTime;

    //推广途径名称
    private String extendWayName;
    //活动名称
    private String activityName;
    //举办人
    private String organizer;
    //微信openId
    private String openId;
    //活动奖励
    private String activityReward;
    
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

    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getExtendWayName() {
		return extendWayName;
	}

	public void setExtendWayName(String extendWayName) {
		this.extendWayName = extendWayName;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getActivityReward() {
		return activityReward;
	}

	public void setActivityReward(String activityReward) {
		this.activityReward = activityReward;
	}

	@Override
    public String toString() {
        return "MsgPushActivityExtendWayRecord{" +
        "id=" + id +
        ", userId=" + userId +
        ", extendWayId=" + extendWayId +
        ", createTime=" + createTime +
        ", extendWayName=" + extendWayName +
        ", activityName=" + activityName +
        ", organizer=" + organizer +
        ", openId=" + openId +
        ", activityReward=" + activityReward +
        "}";
    }
}
