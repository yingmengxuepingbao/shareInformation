package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

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
    private String complaintVoucherPicture;
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

    @Override
    public String toString() {
        return "MsgPushComplaintVoucher{" +
        "complaintVoucherId=" + complaintVoucherId +
        ", complaintVoucherPicture=" + complaintVoucherPicture +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
