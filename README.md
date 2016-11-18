# SpringLearnNotes

## 练习内容

[Spring官方文档](http://docs.spring.io/spring/docs)


### spring1 基于xml的ioc注入

* 创建spring配置文件，通过BeanFactory创建示例
* 配置spring，配置需要spring工厂管理的实体
* scope声明的单例（singleton）和多例（prototype）当实体属性发生改变事一定要使用多例
* 基于setting方法、构造方法的注入，以及自动注入中基于类型、属性名的注入，和全局自动注入的声明
* 值得注入，实体的注入，集合的注入
* 如果没有使用maven注意BeanFactory中spring配置文件的路径

### spring2 基于annotation的ioc注入

* 基于注解注入spring配置文件的配置，通过<context:component-scan base-package="..."/>声明需要扫描的注解类
* 通过注解声明spring管理的实体类@Component、以及实体间的依赖@Resource，单例多例模式@scope("prototype")

> @Component属于公用的声明实体bean的注解，在新的spring3的标准中，为了细致化管理bean工厂，建议使用@Repository用于注解DAO层，使用@Service注解Service层，使用@Controller注解MVC的控制层

### spring3 SPRING AOP 面向切面编程原理 

* OCP原则，对扩展开放，对修改关闭
* 静态代理添加日志功能(虽然实现了非侵入式的编程，但是并没有AOP高效)
    - 创建UserProxyDao类，实现IUserDao接口
    - 在UserProxyDao中编写日志方法
    - 在依赖UserDao的实体中，使用IUserDao接口指向新的UserProxyDao代理类
    
* 使用动态代理模式实现AOP编程， [InfoQ关于Java反射动态代理的讲解](http://www.infoq.com/cn/articles/cf-java-reflection-dynamic-proxy)
    - 编写LogProxy实现InvocationHandler接口，实现invoke方法
    - 使用Proxy.newProxyInstance方法创建代理对象
    - 在LogProxy的invoke中完成相关的业务代码
    - [关于Java动态代理模式看这篇博文](http://www.jianshu.com/p/6f6bb2f0ece9)
    - 关于Java动态代理，spring aop的理解，看这两篇博文： [AOP 那点事儿](https://my.oschina.net/huangyong/blog/161338)、 [AOP 那点事儿（续集）](https://my.oschina.net/huangyong/blog/161402)
    
### spring4 SPRING AOP 基于annotation的实现

**再次推荐看这两篇博文，spring aop的理解：** [AOP 那点事儿](https://my.oschina.net/huangyong/blog/161338)、 [AOP 那点事儿（续集）](https://my.oschina.net/huangyong/blog/161402)

* 通过<aop:aspectj-autoproxy/>打开注解支持
* 通过@Component("logAspect") @Aspect声明切面类
* 通过@Before@Alfred@Around注解声明切面方式，execution(\* zyr.learn.dao.\*.add\*(..))中声明需要代理的类
    - 第一个\*表示所有返回值
    - 第二个\*表示dao下的所有类
    - 第三个\*表示以add开头的所有方法
    - （..）表示任何类型的参数

### spring5 SPRING AOP 基于xml的实现

* 在spring配置文件中通过<aop:config>配置spring aop的支持，在spring5.中查看spring配置文件

### spring6->spring integration jdbc (dbcp)

* 根据选择的数据库连接池在spring配置文件中配置数据源信息
* 如果数据库连接信息写在properties文件中，记得使用<context:property-placeholder location="jdbc.properties"/>导入
* 在DAO层注入数据源`dataSource`，通过数据源得到JdbcTemplate对象，JdbcTemplate对象就可以实现对数据的CRUD（UserDao类有具体的CRUD例子）
    - [Spring JDBCTemplate](http://www.cnblogs.com/caoyc/p/5630622.html)
    - 使用JdbcTemplate更新数据时，如果要返回更新内容的主键id，需要通过`给JdbcTemplate.update(new PreparedStatementCreator...)`返回主键id，（GroupDao类有例子）
    - 查询时需要使用rowMapper做参数对应，灵活使用`jdbcTemplate.queryXXX`方法
    
### template-pattern 模板设计模式

* 基于继承
* 基于组合，spring JdbcTemplate的实现使用到了基于组合的模板设计模式

### spring7--》继承hibernate4

* 配置数据源，数据源配置信息
* 配置hibernate的sessionFactory，并且设置实体类路径，hibernate配置信息
* 为实体类添加hibernate注解，或者hbm文件
* 在DAO中注入sessionFactory，通过sessionFactory.getCurrentSession()打开session

> 除了要确定spring配置文件中，数据源，sessionFactory，事务的配置以外，还要注意查看pom文件中所依赖的包，以及包的版本

** 另外，spring集成hibernate3中(spring4之后貌似不再提供这种操作，只能通过session进行CRUD)，还可以使用hibernateTemplate和hibernateDaoSupport来进行CRUD操作，在使用这种操作的时候需要注意对sessionFactory的注入！例子参考`BaseDaoTemplate`和`BaseDaoHibernateDao`**

### spring8 --> ssh集成

* ssh继承需要注意的就是Struts配置中，action将由spring管理，不在需要指定详细的action路径
* web.xml中创建spring监听器，获取spring配置文件
* 注意配置文件的位置，有时候需要使用`classpath`指定配置文件的路径

> 注意： 1. [el表达式无效](http://www.iteye.com/topic/155354)的问题  
2. 不能使用重定向访问web-inf下的页面

### spring9 --> 基于ssh简单的用户管理系统

> spring4继承hibernate4，集成中遇到的问题  

1. `@Table(name="i_user")`当表名为`i_`开头的时候，报错`ERROR: Table 'spring_integration.i_user' doesn't exist`，其他名字不报错，我的天啦  
2. `jetty`配置详解，在pom文件中有注释
3. `no session`问题，使用`org.springframework.orm.hibernate4.support.OpenSessionInViewFilter`解决`no session`问题？`OpenSessionFilter`使我们自己实现的过滤器，思路是，在action打开时创建session，然后在dao中进行操作，在action访问结束后关闭session，其中
4. Struts2之后，使用通配符找不到action中方法的问题！`Message:There is no Action mapped for namespace [/] and action name [user_login] associated with context path [/shop].
`,[struts2.5框架使用通配符指定方法（常见错误）](http://www.cnblogs.com/gsy52300/archive/2016/08/17/5778754.html) 原因是在Struts2 2.3之后，使用通配符调用方法时，内部会验证是否允许访问该方法，所以要struts配置文件的action中加上<allowed-methods>action内部方法1，action内部方法2...</allowed-methods>，这就解释了为什么有的方法可以被找到，而有些方法找不到的原因，找的到的方法都是Struts内部存在的，而找不到的都是自己定义的
5. 注意实体类中关系的映射！！！
6. mysql delete from ...表中数据，不能使用别名！！！
7. 使用`ThreadLocal`和`page-taglib`实现的公共分页方法，注意在需要分页的页面将pageSize要传递给公共分页的jsp

> maven jetty 配置热部署时，如果使用的是intellij，由于没有自动编译，所以需要使用`command + shift + f9`先进行编译



