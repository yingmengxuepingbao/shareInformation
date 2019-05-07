package com.zyx.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 品类基础信息表
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@TableName("msg_push_product_base")
public class MsgPushProductBase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 品类编号
     */
    @TableField("product_id")
    private String productId;
    /**
     * 品类名称
     */
    @TableField("product_name")
    private String productName;
    /**
     * 品类信息
     */
    @TableField("product_place_info")
    private String productPlaceInfo;
    /**
     * 品类介绍信息
     */
    @TableField("product_introduce_info")
    private String productIntroduceInfo;
    /**
     * 品类介绍url
     */
    @TableField("product_introduce_url")
    private String productIntroduceUrl;
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


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPlaceInfo() {
        return productPlaceInfo;
    }

    public void setProductPlaceInfo(String productPlaceInfo) {
        this.productPlaceInfo = productPlaceInfo;
    }

    public String getProductIntroduceInfo() {
        return productIntroduceInfo;
    }

    public void setProductIntroduceInfo(String productIntroduceInfo) {
        this.productIntroduceInfo = productIntroduceInfo;
    }

    public String getProductIntroduceUrl() {
        return productIntroduceUrl;
    }

    public void setProductIntroduceUrl(String productIntroduceUrl) {
        this.productIntroduceUrl = productIntroduceUrl;
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
        return "MsgPushProductBase{" +
        "productId=" + productId +
        ", productName=" + productName +
        ", productPlaceInfo=" + productPlaceInfo +
        ", productIntroduceInfo=" + productIntroduceInfo +
        ", productIntroduceUrl=" + productIntroduceUrl +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isEnable=" + isEnable +
        "}";
    }
}
