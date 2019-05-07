package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色资源关联表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@TableName("msg_push_role_resource_relationship")
public class MsgPushRoleResourceRelationship implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;
    /**
     * 角色编号
     */
    @TableField("msg_push_role_id")
    private String msgPushRoleId;
    /**
     * 资源编号
     */
    @TableField("msg_push_resource_id")
    private String msgPushResourceId;
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
     * 创建人
     */
    @TableField("create_user_id")
    private String createUserId;
    /**
     * 更新人
     */
    @TableField("update_user_id")
    private String updateUserId;
    /**
     * 是否禁用
     */
    private Integer isEnable;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsgPushRoleId() {
        return msgPushRoleId;
    }

    public void setMsgPushRoleId(String msgPushRoleId) {
        this.msgPushRoleId = msgPushRoleId;
    }

    public String getMsgPushResourceId() {
        return msgPushResourceId;
    }

    public void setMsgPushResourceId(String msgPushResourceId) {
        this.msgPushResourceId = msgPushResourceId;
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

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
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

    @Override
    public String toString() {
        return "MsgPushRoleResourceRelationship{" +
        "id=" + id +
        ", msgPushRoleId=" + msgPushRoleId +
        ", msgPushResourceId=" + msgPushResourceId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", createUserId=" + createUserId +
        ", updateUserId=" + updateUserId +
        ", isEnable=" + isEnable +
        "}";
    }
}
