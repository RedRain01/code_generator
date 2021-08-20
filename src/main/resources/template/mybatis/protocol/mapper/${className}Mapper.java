<#include "/include/java_copyright.include">

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
package ${basepackage}.mapper;


import ${basepackage}.entity.${className};

import org.springframework.stereotype.Repository;

<#include "/include/java_classMapper.include">

@Repository
public interface ${className}Mapper {

	static String SEQUENCE = "SEQ_${table.suffixTableName}_ID";
	
	/**
	 * 创建对象
	 * @param ${classNameLower}
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	public int create(${className} ${classNameLower});
	
	<#if table.hasPk>
	
	/**
	 * 根据主键查询对象
	 * @param <#if table.pkColumns?size=1>${table.pkColumn.columnNameFirstLower}<#else>${classNameLower}</#if>
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	public ${className} queryByPk(<#if table.pkColumns?size=1>${table.pkColumn.javaType} ${table.pkColumn.columnNameFirstLower}<#else>${className} ${classNameLower}</#if>);
	
	/**
	 * 根据主键修改对象
	 * @param ${classNameLower}
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	public int updateByPk(${className} ${classNameLower});
	
	/**
	 * 根据主键删除对象
	 * @param <#if table.pkColumns?size=1>${table.pkColumn.columnNameFirstLower}<#else>${classNameLower}</#if>
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	public int deleteByPk(<#if table.pkColumns?size=1>${table.pkColumn.javaType} ${table.pkColumn.columnNameFirstLower}<#else>${className} ${classNameLower}</#if>);
	</#if>

	<#if table.hasIndex>
	
	/**
	 * 根据对象查询数据
	 * @param ${classNameLower}
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	public java.util.List<${className}> queryBy${className}(${className} ${classNameLower});
	</#if>
	
	/**
	 * 根据条件分页查询数据
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@SuppressWarnings({"rawtypes" })
	public java.util.List<${className}> queryByPage(java.util.Map paramMap);

	/**
	 * 根据条件查询数据总量
	 * @param paramMap
	 * @return
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@SuppressWarnings({"rawtypes" })
	public long countByCondtion(java.util.Map paramMap);
}
