package com.zyx.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */

@TableName("msg_push_user")
@Component
public class MsgPushUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;
    /**
     * 手机号
     */
    @TableField("phone_num")
    private String phoneNum;
    /**
     * 性别
     */
    @TableField("user_sex")
    private String userSex;
    /**
     * 邮箱
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 收货地址
     */
    @TableField("user_address")
    private String userAddress;
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
     * 是否删除
     */
    private Integer isDelete;
    //微信openId
    private String openId;
    
    //会员等级名称
    private String membershipLevelName;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getMembershipLevelName() {
		return membershipLevelName;
	}

	public void setMembershipLevelName(String membershipLevelName) {
		this.membershipLevelName = membershipLevelName;
	}

	@Override
    public String toString() {
        return "MsgPushUser{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userPwd=" + userPwd +
        ", phoneNum=" + phoneNum +
        ", userSex=" + userSex +
        ", userEmail=" + userEmail +
        ", userAddress=" + userAddress +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDelete=" + isDelete +
        ", openId=" + openId +
        ", membershipLevelName=" + membershipLevelName +
        "}";
    }
}
