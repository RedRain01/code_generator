/**
 * All rights reserved by XinGuoDu Inc.
 */
package ${basepackage}.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
/**
 * 序列生成Mapper
 * <p>
 * 
 * @author WillYang
 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
 * @since 1.0
 */
@Repository
public interface SequenceGenerateMapper {

	/**
	 * 获取当前序列号.
	 * 
	 * @param sequenceName
	 *            序列号名
	 * @return 序列号
	 */
	long currSequenceId(@Param(value = "sequenceName")String sequenceName);

	/**
	 * 获取下一个序列号.
	 * 
	 * @param sequenceName
	 *            序列号名
	 * @return 序列号
	 */
	long nextSequenceId(@Param(value = "sequenceName")String sequenceName);
}
