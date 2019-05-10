package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 推广途径字典表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_extend_way")
public class MsgPushExtendWay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 推广途径编号
     */
    @TableField("extend_way_id")
    private String extendWayId;
    /**
     * 推广途径名称
     */
    @TableField("extend_way_name")
    private String extendWayName;
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
    private String isEnable;


    public String getExtendWayId() {
        return extendWayId;
    }

    public void setExtendWayId(String extendWayId) {
        this.extendWayId = extendWayId;
    }

    public String getExtendWayName() {
        return extendWayName;
    }

    public void setExtendWayName(String extendWayName) {
        this.extendWayName = extendWayName;
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

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    @Override
    public String toString() {
        return "MsgPushExtendWay{" +
        "extendWayId=" + extendWayId +
        ", extendWayName=" + extendWayName +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
