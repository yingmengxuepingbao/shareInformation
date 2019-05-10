package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Component
@TableName("msg_push_role")
public class MsgPushRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    @TableField("msg_push_role_id")
    private String msgPushRoleId;
    /**
     * 角色名称
     */
    @TableField("msg_push_role_name")
    private String msgPushRoleName;
    /**
     * 创建人
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


    public String getMsgPushRoleId() {
        return msgPushRoleId;
    }

    public void setMsgPushRoleId(String msgPushRoleId) {
        this.msgPushRoleId = msgPushRoleId;
    }

    public String getMsgPushRoleName() {
        return msgPushRoleName;
    }

    public void setMsgPushRoleName(String msgPushRoleName) {
        this.msgPushRoleName = msgPushRoleName;
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

    @Override
    public String toString() {
        return "MsgPushRole{" +
        "msgPushRoleId=" + msgPushRoleId +
        ", msgPushRoleName=" + msgPushRoleName +
        ", createUserId=" + createUserId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
