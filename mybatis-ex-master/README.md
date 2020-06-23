* start up mysql server
* include `mybatisconfig.xml` file into `src/main/resources/`
the example of config
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/lib?useSSL=false"/>
                <property name="username" value="uname"/>
                <property name="password" value="upass"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="mappers/author_mapper.xml"/>
        <mapper resource="mappers/category_mapper.xml"/>
        <mapper resource="mappers/item_mapper.xml"/>
    </mappers>
</configuration>
```

* run `mvn clean test -Dsuite=basic_tests`
