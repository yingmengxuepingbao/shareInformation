package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 资源表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_resource")
public class MsgPushResource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资源编号
     */
    @TableField("msg_push_resource_id")
    private String msgPushResourceId;
    /**
     * 资源名称
     */
    @TableField("msg_push_resource_name")
    private String msgPushResourceName;
    /**
     * 资源类型
     */
    @TableField("msg_push_resource_type")
    private String msgPushResourceType;
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


    public String getMsgPushResourceId() {
        return msgPushResourceId;
    }

    public void setMsgPushResourceId(String msgPushResourceId) {
        this.msgPushResourceId = msgPushResourceId;
    }

    public String getMsgPushResourceName() {
        return msgPushResourceName;
    }

    public void setMsgPushResourceName(String msgPushResourceName) {
        this.msgPushResourceName = msgPushResourceName;
    }

    public String getMsgPushResourceType() {
        return msgPushResourceType;
    }

    public void setMsgPushResourceType(String msgPushResourceType) {
        this.msgPushResourceType = msgPushResourceType;
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
        return "MsgPushResource{" +
        "msgPushResourceId=" + msgPushResourceId +
        ", msgPushResourceName=" + msgPushResourceName +
        ", msgPushResourceType=" + msgPushResourceType +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
