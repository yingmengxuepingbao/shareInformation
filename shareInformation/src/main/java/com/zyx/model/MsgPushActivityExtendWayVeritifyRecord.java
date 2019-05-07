package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 活动推广途径审核记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@TableName("msg_push_activity_extend_way_veritify_record")
public class MsgPushActivityExtendWayVeritifyRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推广活动途径编号
     */
    @TableField("activity_extend_way_id")
    private String activityExtendWayId;
    /**
     * 审核人
     */
    @TableField("verfitied_user_id")
    private String verfitiedUserId;
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


    public String getActivityExtendWayId() {
        return activityExtendWayId;
    }

    public void setActivityExtendWayId(String activityExtendWayId) {
        this.activityExtendWayId = activityExtendWayId;
    }

    public String getVerfitiedUserId() {
        return verfitiedUserId;
    }

    public void setVerfitiedUserId(String verfitiedUserId) {
        this.verfitiedUserId = verfitiedUserId;
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

    @Override
    public String toString() {
        return "MsgPushActivityExtendWayVeritifyRecord{" +
        "activityExtendWayId=" + activityExtendWayId +
        ", verfitiedUserId=" + verfitiedUserId +
        ", updateUserId=" + updateUserId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
