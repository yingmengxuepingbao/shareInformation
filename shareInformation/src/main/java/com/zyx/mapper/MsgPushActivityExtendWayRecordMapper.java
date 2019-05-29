package com.zyx.mapper;

import com.zyx.model.MsgPushActivityExtendWay;
import com.zyx.model.MsgPushActivityExtendWayRecord;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 用户活动推广途径历史记录表 Mapper 接口
 * </p>
 *
 * @author yixin123
 * @since 2019-05-05
 */
@Mapper
public interface MsgPushActivityExtendWayRecordMapper extends BaseMapper<MsgPushActivityExtendWayRecord> {

	/**
	 * 根据用户openId,用户活动推广途径历史记录，关联查询用户表，活动推广途径关联表（活动表/推广途径字典表）
	 * @param openId 用户openId
	 * @return
	 */
	List<MsgPushActivityExtendWay> getRecordList(String openId);
}
