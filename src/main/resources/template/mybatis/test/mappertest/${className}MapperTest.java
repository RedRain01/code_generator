<#include "/include/java_copyright.include">

<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign propertyName = classNameLower+"Mapper">
package ${basepackage}.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.ys.credit.backed.protocol.entity.${className};
import com.ys.credit.backed.protocol.mapper.${className}Mapper;


<#include "/include/java_classMapper.include">


@RunWith(SpringJUnit4ClassRunner.class)
@EnableDiscoveryClient(autoRegister = false)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class ${className}MapperTest {

	@Autowired
	private ${className}Mapper ${propertyName};
	

<#if table.hasPk>

    /**
     * 清除数据
     * @throws ParseException
     * @author WillYang
     * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
     */
	@Before
	public void clearData() throws ParseException {
		${className} entity = buildEntity();
		${propertyName}.deleteByPk(<#if table.pkColumns?size=1>entity.get${table.pkColumn.columnName}()<#else>entity</#if>);
	}

	/**
	 * 测试根据主键查询
	 * @throws ParseException
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@Test
	public void testQueryByPk() throws ParseException {
		testCreate();
		${className} entity = buildEntity();
		${className} result = ${propertyName}.queryByPk(<#if table.pkColumns?size=1>entity.get${table.pkColumn.columnName}()<#else>entity</#if>);
		Assert.assertNotNull(result);
	}
	
	/**
	 * 测试根据主键修改数据
	 * @throws ParseException
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@Test
	public void testUpdateByPk() throws ParseException {
		testCreate();
		${className} entity = buildEntity();
		int result = ${propertyName}.updateByPk(entity);
		Assert.assertEquals(1, result);
	}
	
	/**
	 * 测试根据主键删除数据
	 * @throws ParseException
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@Test
	public void testDeleteByPk() throws ParseException {
		testCreate();
		${className} entity = buildEntity();
		int result = ${propertyName}.deleteByPk(<#if table.pkColumns?size=1>entity.get${table.pkColumn.columnName}()<#else>entity</#if>);
		Assert.assertEquals(1, result);
	}
	
</#if>

	/**
	 * 测试根据实体查询数据
	 * @throws ParseException
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@Test
    public void testQueryBy${className}() throws ParseException {
    	testCreate();
		${className} entity = buildEntity();
		java.util.List<${className}> result = ${propertyName}.queryBy${className}(entity);
		Assert.assertEquals(1, result.size());
    }
    
    /**
	 * 分页查询数据
	 * @throws ParseException
	 * @author WillYang
	 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
	 */
	@Test
    public void testQueryByPage() throws ParseException {
    	testCreate();
		${className} entity = buildEntity();
		java.util.Map<String, Object> queryCondtion = entity2Map(entity);
		queryCondtion.put("pageNum", 1);
		queryCondtion.put("pageSize", 10);
		java.util.List<${className}> result = ${propertyName}.queryByPage(queryCondtion);
		Assert.assertEquals(1, result.size());
    }
	
	  /**
		 * 根据条件查询总数
		 * @throws ParseException
		 * @author WillYang
		 * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
		 */
		@Test
	public void countByCondtion() throws ParseException {
	   	testCreate();
		${className} entity = buildEntity();
		java.util.Map<String, Object> queryCondtion = entity2Map(entity);
		queryCondtion.put("pageNum", 1);
		queryCondtion.put("pageSize", 10);
		long result = ${propertyName}.countByCondtion(queryCondtion);
		Assert.assertTrue(result >= 1);
	}
	
    /**
     * 测试创建对象
     * @throws ParseException
     * @author WillYang
     * @since ${.now?string("yyyy-MM-dd HH:mm:ss")}
     */
	@Test
	public void testCreate() throws ParseException {
		${className} entity = buildEntity();		
		int result = ${propertyName}.create(entity);
		Assert.assertEquals(1, result);
	}

	private java.util.Map<String, Object> entity2Map(${className} entity) {
		java.util.Map<String, Object> result = new java.util.HashMap<String, Object>();
	<#list table.columns as column>
	    result.put("${column.columnNameFirstLower}", entity.get${column.columnName}());
	</#list>
		return result;
	}
	
	private ${className} buildEntity() throws ParseException {
		String dateTimeString = "${.now?string("yyyy-MM-dd HH:mm:ss")}";
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date dateTime = dateFormat.parse(dateTimeString);
		${className} entity = new ${className}();		
	<#list table.columns as column>		
		<#if column.possibleShortJavaType == "Long">
		entity.set${column.columnName}(1L);
		<#elseif column.possibleShortJavaType == "long">
		entity.set${column.columnName}(1L);
		<#elseif column.possibleShortJavaType == "Integer">
		entity.set${column.columnName}(2);
		<#elseif column.possibleShortJavaType == "int">
		entity.set${column.columnName}(2);
		<#elseif column.possibleShortJavaType == "java.util.Date">
		entity.set${column.columnName}(dateTime);
		<#elseif column.possibleShortJavaType == "java.math.BigDecimal">
		entity.set${column.columnName}(new java.math.BigDecimal(10));
		<#else>
		<#if column.size == 1>
		entity.set${column.columnName}("0"); 
		<#elseif column.size == 2>
		entity.set${column.columnName}("00");
		<#else>
		entity.set${column.columnName}("Test");
		</#if>
	    </#if>
	</#list>
		return entity;
	}
}
