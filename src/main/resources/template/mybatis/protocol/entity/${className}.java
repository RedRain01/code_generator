<#include "/include/java_copyright.include">

<#include "/include/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.entity;


<#include "/include/java_class.include">

public class ${className} {
	
	/** serialVersionUID */
    private static final long serialVersionUID = 1L;
	
    <#--属性-->
	<#list table.columns as column>
	/** ${column.remarks}. */
	private ${column.possibleShortJavaType} ${column.columnNameFirstLower} <#--${column.defaultFormatValue}-->;
	
	</#list>
	
<@generateJavaColumns/>
}

<#--get和set方法-->
<#macro generateJavaColumns>
	<#list table.columns as column>

    /** set ${column.remarks}. */
	public void set${column.columnName}(${column.possibleShortJavaType} ${column.columnNameFirstLower}) {
		this.${column.columnNameFirstLower} = ${column.columnNameFirstLower};
	}
	
	/** get ${column.remarks}. */
	public ${column.possibleShortJavaType} get${column.columnName}() {
		return this.${column.columnNameFirstLower};
	}
	
	</#list>
</#macro>

