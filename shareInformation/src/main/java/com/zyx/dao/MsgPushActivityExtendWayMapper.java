package com.zyx.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyx.model.MsgPushActivityExtendWay;

/**
 * <p>
 * 活动推广途径关联表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushActivityExtendWayMapper extends BaseMapper<MsgPushActivityExtendWay> {

	MsgPushActivityExtendWay selectById(@Param("id") String id);
}
