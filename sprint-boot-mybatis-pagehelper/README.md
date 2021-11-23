## 1. 数据源配置

### 1.1 单数据源

1. 通过 application.yml 配置
   * application.yml
       ```yaml
       spring:
         datasource:
           driver-class-name: com.mysql.cj.jdbc.Driver
           username: xiaoxin
           password: 123456
           url: jdbc:mysql://222.195.87.224:3306/mybatis_demo?       useUnicode=true&characterEncoding=utf8&useSSL=false&       serverTimezone=UTC
       
       mybatis:
         type-aliases-package: com.olivine.mybatis.entity.domain
         mapper-locations:
           - classpath:mybatis/mapper/**Mapper.xml
         config-location: classpath:mybatis/mybatis-config.xml
       ```
    * mybatis-config.xml
        ```xml
        <plugins>
            <plugin interceptor="com.github.pagehelper.PageInterceptor">
                <property name="helperDialect" value="mysql" />
                <property name="reasonable" value="true"/>
                <property name="supportMethodsArguments" value="true" />
                <property name="params" value="pageNum=pageNumKey;pageSize=pageSizeKey" />
            </plugin>
        </plugins>
        ```   
2. 配置类
    * application.yml
        ```yml
        spring:
          datasource:
            driver-class-name: com.mysql.cj.jdbc.Driver
            username: xiaoxin
            password: 123456
            hikari:
              jdbc-url: jdbc:mysql://222.195.87.224:3306/mybatis_demo?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC
              connection-timeout: 30000
              idle-timeout: 180000
              max-lifetime: 1800000
              maximum-pool-size: 10
        ```

    * DBConfig.java
        ```java
        @Configuration
        public class DBConfig {
            @Bean
            @ConfigurationProperties(prefix = "spring.datasource.hikari")
            public HikariDataSource dataSource(){
                return DataSourceBuilder.create().type(HikariDataSource.class).build();
            }
        }
        ```

    * MyBatisConfig.java
        ```java
        @Configuration
        @MapperScan("com.olivine.mybatis.mapper")
        public class MybatisConfig {
            @Bean
            public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
                SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
                sqlSessionFactory.setDataSource(dataSource);
                sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().
                        getResources("classpath*:mapper/**Mapper.xml"));
                sqlSessionFactory.setTypeAliasesPackage("com.olivine.mybatis.domain");

                // 分页插件 pagehelper
                PageInterceptor pageInterceptor = new PageInterceptor();
                Properties properties = new Properties();
                properties.setProperty("helperDialect", "mysql");
                properties.setProperty("reasonable", "true");
                properties.setProperty("params", "pageNum=pageNum;pageSize=pageSize");
                pageInterceptor.setProperties(properties);

                sqlSessionFactory.setPlugins(new Interceptor[]{pageInterceptor});
                return sqlSessionFactory.getObject();
            }

            @Bean
            public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
                return new SqlSessionTemplate(sqlSessionFactory);
            }
        }
        ```

3. 配置类另一种写法
    * application.yml
        ```yaml
        spring:
          datasource:
            driver-class-name: com.mysql.cj.jdbc.Driver
            username: xiaoxin
            password: 123456
            url: jdbc:mysql://222.195.87.224:3306/mybatis_demo?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC
            hikari:
              connection-timeout: 30000
              idle-timeout: 180000
              max-lifetime: 1800000
              maximum-pool-size: 10
        ```
    * DBConfig.java
        ```java
        @Configuration
        public class DBConfig {
      
            @Bean
            @Primary
            @ConfigurationProperties("spring.datasource")
            public DataSourceProperties dataSourceProperties() {
                return new DataSourceProperties();
            }
      
            @Bean
            @ConfigurationProperties("spring.datasource.hikari")
            public HikariDataSource dataSource(DataSourceProperties properties) {
                return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
            }
        }
        ```
  * MybatisConfig.java: 同上


### 1.2 双数据源