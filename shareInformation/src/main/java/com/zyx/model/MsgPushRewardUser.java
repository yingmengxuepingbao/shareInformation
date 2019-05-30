package com.zyx.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 用户活动推广奖励记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_reward_user")
public class MsgPushRewardUser implements Serializable {

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
     * 活动编号
     */
    @TableField("activity_id")
    private String activityId;
    /**
     * 活动推广途径编号
     */
    @TableField("extend_way_id")
    private String extendWayId;
    /**
     * 创建人
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private String createTime;
    //活动名称
    private String activityName;
	//举办人
	private String organizer;
	//奖励内容
	private String rewardContent;
	//领奖人
	private String prizeWinner;
	//微信openId
	private String openId;
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
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

	public String getRewardContent() {
		return rewardContent;
	}

	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
	}

	public String getPrizeWinner() {
		return prizeWinner;
	}

	public void setPrizeWinner(String prizeWinner) {
		this.prizeWinner = prizeWinner;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

    public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getCreateTime() {
		return createTime;
	}

	@Override
    public String toString() {
        return "MsgPushRewardUser{" +
        "id=" + id +
        ", userId=" + userId +
        ", extendWayId=" + extendWayId +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", activityName=" + activityName +
        ", organizer=" + organizer +
        ", rewardContent=" + rewardContent +
        ", prizeWinner=" + prizeWinner +
        ", openId=" + openId +
        "}";
    }
}
