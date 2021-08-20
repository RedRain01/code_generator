package com.ys.code;

import com.ys.code.generator.GeneratorFacade;

/**
 * 生成文件.
 * <p>
 */
public class GeneratorMain {

	/**
	 * 请直接修改以下代码调用不同的方法以执行相关生成任务.
	 */
	public static void main(String[] args) throws Exception {

		GeneratorFacade g = new GeneratorFacade();
		// 打印数据库中的表名称
		// g.printAllTableNames();

		// 删除生成器的输出目录
		g.deleteOutRootDir();
		// 通过数据库表生成文件,template为模板的根目录
		//g.generateByTable(new String[] { "T_CATEGORY", "T_DIVISORINFO", "T_DIVISOR_INSTANCE", "T_INDEX", "T_RULE", "T_RULE_DIVISORINFO_INDEX", "T_RULE_INSTANCE", "T_RULE_INSTANCE_SUBJECT" }, "template/mybatis");
		// g.generateByTable(new String[] { "t_bwg_list", "T_RULE_INSTANCE_SUBJECT" },
		// "template/mybatis");
		// 生成数据库所有表对应的mapper
		// g.generateByAllTable("template/mybatis");

		// g.generateByTable(new String[] { "T_LOAN_APPLY_LIST", "T_CREDIT_USER_INFO" },
		// "template/mybatis");
		// g.generateByTable(new String[] { "T_LOAN_ORDER_LIST", "T_REPAY_PLAN_LIST",
		// "T_CREDIT_PRODUCT_LIST" },
		// "template/mybatis");
		g.generateByTable(new String[] { "event_user" },
				"template/mybatis");

	}
}
