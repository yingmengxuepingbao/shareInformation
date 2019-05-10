package com.zyx.mapper;

import org.apache.ibatis.annotations.Mapper;

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

	MsgPushActivityExtendWay selectById(String id);
}
