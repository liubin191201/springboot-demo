package com.bin.liu.springboot.demo.springboot.repo.CodeGenerate;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;

/**
 * @program: springboot-parent
 * @description: mybatisPlus代码生成工具
 * @author: bin.liu
 * @create: 2019-03-14 10:50
 **/

public class MybatisPlusUtils {

    //作者
    private static final  String AUTHOR = "bin.liu";

    private static final DbType DB_TYPE = DbType.MYSQL;

    private static final String DB_DIRVER = "com.mysql.jdbc.Driver";

    private static final String DB_USER_NAME= "root";

    private static final String DB_USER_PASSWORD = "root";

    private static final String DB_CONNECT_URL = "jdbc:mysql://localhost:3306/bin_liu?characterEncoding=utf8";

    private static final String PACKAGE_PARENT = "com.bin.liu.springboot.demo";

    /**
     * 必填
     */
    private static final String[] GENERATE_TABLES = new String[]{"ts_user"};
    /**
     * 建议填写
     */
    private static final String BUS_MODEL_NAME = "";

    //模块名称
    private static final String MODEL_WEB_NAME= "springboot-web";
    private static final String MODEL_SERVICE_NAME = "springboot-service";
    private static final String MODEL_ENTITY_NAME = "springboot-entity";
    private static final String MODEL_MAPPER_NAME = "springboot-repo";

    public static void main(String[] args) {
        if (GENERATE_TABLES.length < 1){
            System.out.println("请填写要生成表的名称");
            return;
        }
        String[] models = {MODEL_MAPPER_NAME,MODEL_ENTITY_NAME,MODEL_SERVICE_NAME,MODEL_WEB_NAME};
        for (String model:models) {
            shell(model);
        }
    }

    /**
     * 生成方法
     * @param model
     */
    private static void shell(String model) {
        File file = new File(model);
        String path = file.getAbsolutePath();

        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = getGlobalConfig(path);
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        autoGenerator.setDataSource(dataSourceConfig);

        //数据库表配置
        StrategyConfig strategyConfig = getStrategyConfig();
        autoGenerator.setStrategy(strategyConfig);

        //包配置
        PackageConfig packageConfig = getPackageConfig();
        autoGenerator.setPackageInfo(packageConfig);

        //模板设置
        TemplateConfig templateConfig = getTemplateConfig(model);
        autoGenerator.setTemplate(templateConfig);

        //执行生成
        autoGenerator.execute();

        System.out.println("执行完成");


    }

    /**
     * 模板设置
     * @return
     */
    private static TemplateConfig getTemplateConfig(String model) {
        TemplateConfig templateConfig = new TemplateConfig();
        if (MODEL_MAPPER_NAME.equals(model)){
            templateConfig.setController(null);
            templateConfig.setEntity(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
        }else if (MODEL_ENTITY_NAME.equals(model)){
            templateConfig.setController(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setMapper(null);
            templateConfig.setXml(null);
        }else if (MODEL_SERVICE_NAME.equals(model)){
            templateConfig.setController(null);
            templateConfig.setEntity(null);
            templateConfig.setMapper(null);
            templateConfig.setXml(null);
        }else if (MODEL_WEB_NAME.equals(model)){
            templateConfig.setEntity(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setMapper(null);
            templateConfig.setXml(null);
        }
        return templateConfig;
    }

    /**
     * 包配置
     * @return
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        //父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
        packageConfig.setParent(PACKAGE_PARENT);
        //父包模块名
        packageConfig.setModuleName(BUS_MODEL_NAME);
        //Controller包名
        packageConfig.setController("controller");
        //Entity包名
        packageConfig.setEntity("entity");
        //Mapper包名
        packageConfig.setMapper("mapper");
        //Service包名
        packageConfig.setService("service");
        //Service Impl包名
        packageConfig.setServiceImpl("serviceimpl");
        return packageConfig;
    }


    /**
     * 数据库表配置
     * @return
     */
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategyConfig = new StrategyConfig();
        //是否大写命名
        strategyConfig.setCapitalMode(false);
        //表前缀 此处可以修改为您的表前缀
        //strategyConfig.setTablePrefix(new String[]{""});
        //数据库表映射到实体的命名策略
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        //需要包含的表名，允许正则表达式（与exclude二选一配置）
        strategyConfig.setInclude(GENERATE_TABLES);
        //需要排除的表名，允许正则表达式
        //strategyConfig.setExclude(new String[]{});
        //自定义继承的Entity类全称，带包名
        //strategyConfig.setSuperEntityClass("");
        //自定义基础的Entity类，公共字段
        //strategyConfig.setSuperEntityColumns(new String[]{});
        //自定义继承的Mapper类全称，带包名
        //strategyConfig.setSuperMapperClass("");
        //自定义继承的Service类全称，带包名
        //strategyConfig.setSuperServiceClass("");
        //自定义继承的ServiceImpl类全称，带包名
        //strategyConfig.setSuperServiceImplClass("");
        //自定义继承的Controller类全称，带包名
        //strategyConfig.setSuperControllerClass("");
        //【实体】是否生成字段常量（默认 false）
        strategyConfig.setEntityColumnConstant(false);
        //【实体】是否为构建者模型（默认 false）
        strategyConfig.setEntityBuilderModel(true);
        //是否生成实体时，生成字段注解
        return strategyConfig;
    }

    /**
     * 数据源配置
     * @return
     */
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型
        dataSourceConfig.setDbType(DB_TYPE);
        //类型转换
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });

        //驱动名称
        dataSourceConfig.setDriverName(DB_DIRVER);
        //数据库连接用户名
        dataSourceConfig.setUsername(DB_USER_NAME);
        //数据库连接密码
        dataSourceConfig.setPassword(DB_USER_PASSWORD);
        //驱动连接的URL
        dataSourceConfig.setUrl(DB_CONNECT_URL);
        return dataSourceConfig;

    }

    /**
     * 全局配置
     * @return
     */
    private static GlobalConfig getGlobalConfig(String path) {
        GlobalConfig globalConfig = new GlobalConfig();

        //生成文件的输出目录
        globalConfig.setOutputDir(path + "/src/main/java");
        //是否覆盖已有文件
        globalConfig.setFileOverride(true);
        //开启 ActiveRecord 模式
        globalConfig.setActiveRecord(true);
        //是否在xml中添加二级缓存配置
        globalConfig.setEnableCache(false);
        //开启 BaseResultMap
        globalConfig.setBaseResultMap(true);
        //开启 baseColumnList
        globalConfig.setBaseColumnList(true);
        globalConfig.setAuthor(AUTHOR);

        //自定义文件命名，注意%s 会自动填充表实体属性
        //mapper 命名方式
        globalConfig.setMapperName("%sDao");
        //Mapper xml 命名方式
        globalConfig.setXmlName("%sDao");
        //service 命名方式
        globalConfig.setServiceName("%sService");
        //service impl 命名方式
        globalConfig.setServiceImplName("%sServiceImpl");
        //controller 命名方式
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }


}
