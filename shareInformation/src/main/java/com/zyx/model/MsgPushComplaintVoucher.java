package com.zyx.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 投诉凭证记录表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-30
 */
@TableName("msg_push_complaint_voucher")
public class MsgPushComplaintVoucher implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 投诉凭证编号
     */
    @TableId("complaint_voucher_id")
    private String complaintVoucherId;
    /**
     * 投诉凭证图片
     */
    @TableField("complaint_voucher_picture")
    @NotBlank(message="图片不能为空")
    private String complaintVoucherPicture;
    /**
     * 投诉编号
     */
    @TableId("complaint_id")
    private String complaintId;
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


    public String getComplaintVoucherId() {
        return complaintVoucherId;
    }

    public void setComplaintVoucherId(String complaintVoucherId) {
        this.complaintVoucherId = complaintVoucherId;
    }

    public String getComplaintVoucherPicture() {
        return complaintVoucherPicture;
    }

    public void setComplaintVoucherPicture(String complaintVoucherPicture) {
        this.complaintVoucherPicture = complaintVoucherPicture;
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

    public String getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	@Override
    public String toString() {
        return "MsgPushComplaintVoucher{" +
        "complaintVoucherId=" + complaintVoucherId +
        ", complaintVoucherPicture=" + complaintVoucherPicture +
        "complaintId=" + complaintId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
