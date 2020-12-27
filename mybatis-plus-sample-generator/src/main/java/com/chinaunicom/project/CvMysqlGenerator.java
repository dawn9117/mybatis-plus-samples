package com.chinaunicom.project;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * mysql 代码生成器, 配置详解参考: https://mybatis.plus/config/generator-config.html
 */
public class CvMysqlGenerator {

	/**
	 * RUN THIS
	 * 配置项参考: https://mybatis.plus/config/generator-config.html
	 */
	public static void main(String[] args) {
		// ======= 定制化参数开始 ======== //
		// 自动生成的表
		String[] tableNames = {"sv_diagnosis_partition"};
		// 基础包
		String basePackage = "com.chinaunicom.diagnosis";
		// mapper.xml存储路径
		String mapperXmlPath = "";
		// 数据库连接
		String dbUrl = "jdbc:mysql://30.1.1.143:3306/vision_service_video?useUnicode=true&serverTimezone=GMT&useSSL=false&characterEncoding=utf8";
		// 数据库驱动
		String dbDriverName = "com.mysql.jdbc.Driver";
		// 数据库用户名
		String dbUsername = "root";
		// 数据库密码
		String dbPassword = "ro!8F6S3hr^qQ%KJ";
		// 基础实体类
//		String superEntityClass = basePackage + ".common.BaseEntity";
		String superEntityClass = null;
		// 基础类的属性
		String[] superEntityColumns = null;
//		String[] superEntityColumns = {"id"};
		// 基础controller
		String superControllerClass = basePackage + ".common.BaseController";
//		String superControllerClass = null;
		// 乐观锁字段名
		String versionFiledName = null;
//		String versionFiledName = "version";
		// 逻辑删除字段名
//		String delFlag = "delFlag";
		String delFlag = null;
		// 表前缀
		String[] tablePrefix = {"sv_"};
//		String[] tablePrefix = {basePackage + "_"};
		// ======= 定制化参数结束 ======== //


		// 代码生成器
		AutoGenerator mpg = new AutoGenerator();

		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/mybatis-plus-sample-generator/src/main/java"); // 生成的文件输出路径
		gc.setAuthor("dawn");// 作者
		gc.setOpen(false);// 是否打开生成的目录
		gc.setFileOverride(true);// 当文件存在时是否覆盖
		gc.setSwagger2(true);// 是否开启 swagger2
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(dbUrl);// 数据库连接
		// dsc.setSchemaName("public");
		dsc.setDriverName(dbDriverName);// 数据库驱动
		dsc.setUsername(dbUsername);// 数据库用户名
		dsc.setPassword(dbPassword);// 数据库密码
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		pc.setParent(basePackage);// 基础包路径
		mpg.setPackageInfo(pc);

		// 自定义配置
		InjectionConfig cfg = new InjectionConfig() {
			@Override
			public void initMap() {
				// to do nothing
			}
		};
		List<FileOutConfig> focList = new ArrayList<>();
		focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
			@Override
			public String outputFile(TableInfo tableInfo) {
				// 自定义输入文件名称
				return projectPath + "/mybatis-plus-sample-generator/src/main/resources/mapper/" + mapperXmlPath
						+ "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
			}
		});
		cfg.setFileOutConfigList(focList);// 文件输出列表
		mpg.setCfg(cfg);
		mpg.setTemplate(new TemplateConfig().setXml(null));

		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);// 名称策略: 下划线转驼峰
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 名称策略: 下划线转驼峰
		strategy.setSuperEntityClass(superEntityClass);// 基础实体类
		strategy.setEntityLombokModel(true);// 是否开启实体类lombok
		strategy.setSuperControllerClass(superControllerClass);// 基础controller
		strategy.setInclude(tableNames);// 指定自动生成代码的表
		strategy.setRestControllerStyle(true);// 是否 rest controller
		strategy.setControllerMappingHyphenStyle(true);// 是否拼接
		strategy.setEntityTableFieldAnnotationEnable(true);// 是否生成字段注释
		strategy.setVersionFieldName(versionFiledName);// 乐观锁字段名
		strategy.setLogicDeleteFieldName(delFlag);// 逻辑删除字段名
		strategy.setSuperEntityColumns(superEntityColumns);// 基础实体类字段列表
		strategy.setTablePrefix(tablePrefix);// 表前缀列表
		mpg.setStrategy(strategy);
		// 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}

}
