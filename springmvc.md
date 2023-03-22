# SpringMVC 复习整理

## 1、 搭建第一springmvc 框架结构

### 1.1 什么是SpringMVC？

​						它是基于MVC开发模式的框架,用来优化控制器.它是Spring家族的一员.它也具备IOC和AOP.

###  1.2 什么是MVC?

​						 它是一种开发模式,它是模型视图控制器的简称.所有的web应用都是基于MVC开发.

​						 M:模型层,包含实体类,业务逻辑层,数据访问层

​						V:视图层,html,javaScript,vue等都是视图层,用来显现数据

​						C:控制器,它是用来接收客户端的请求,并返回响应到客户端的组件,Servlet就是组件													

### 1.3 SpringMVC框架特点有什么？

  1)轻量级,基于MVC的框架
  2)易于上手,容易理解,功能强大
  3)它具备IOC和AOP
  4)完全基于注解开发

### 1.4 基于注解的SpringMVC框架开发的步骤

​				第一步new一个子模块,选择webapp模板.

​				![image-20230317225409665](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317225409665.png)

第二步：修改目录,添加缺失的test,java,resources(两套),并修改目录属性

![image-20230317230001176](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317230001176.png)

第三步：修改pom.xml文件,添加SpringMVC的依赖,添加Servlet的依赖

```xml
    <!--测试依赖-->
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <!--springmvc-->
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>5.2.12.RELEASE</version>
    </dependency>
    <!--servlet-->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
    </dependency>
  </dependencies>
```

第四步：在main下的Resource添加springmvc.xml(此处名字任意)配置文件,指定包扫描,添加视图解析器

![image-20230317230351215](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317230351215.png)

 

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
        <!--配置包扫描-->
        <context:component-scan base-package="edu.beihua"></context:component-scan>
        <!--配置视图解析器-->
        <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
            <property name="prefix" value="/admin/"/>
            <property name="suffix" value=".action"></property>
        </bean>
</beans>
```

第五步：删除web.xml文件,新建web.xml，原因约束文件太老

![image-20230317231313502](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317231313502.png)

![image-20230317231453305](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317231453305.png)

![image-20230317231538048](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317231538048.png)

![image-20230317231550622](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317231550622.png)

![image-20230317231638507](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317231638507.png)

改位web.xml

第六步：在web.xml文件中注册springMVC框架(所有的web请求都是基于servlet的)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    
    <!--注册框架-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        
        <!--初始化参数 读取配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc.xml</param-value>
        </init-param>
    </servlet>
    
    <!--配置拦截器规则-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <!--只要是*.active的请求才能通过核心控制器的检查-->
        <url-pattern>*.active</url-pattern>
    </servlet-mapping>
</web-app>
```

第八步：在webapp目录下新建admin目录,在admin目录下新建main.jsp页面,删除index.jsp页面,并新建,发送请求给服务器

index内容：

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/17
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/demo.active">点击跳转主页</a>
</body>
</html>
```

编写控制器类

```java
package edu.beihua;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//@Controller  //交给Spring去创建对象
@Controller
public class demo2 {
    @RequestMapping("/demo2")
    public String tomain(){
        return "main";
    }
}
```

最后添加tomcat测试

- 分析web请求

![image-20230317233423527](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230317233423527.png)

<font color='red'>DispatcherServlet要在web.xml文件中注册才可用.</font>

@RequestMapping注解详解
  此注解就是来映射服务器访问的路径.
  1)此注解可加在方法上,是为此方法注册一个可以访问的名称(路径)
  @RequestMapping("/demo")

`<a href="${pageContext.request.contextPath}/demo.action">访问服务器</a>`

此注解可以加在类上,相当于是包名(虚拟路径),区分不同类中相同的action的名称

## 2、SpringMVC 注解@RequestMapping

它用于将HTTP请求映射到相应的处理程序方法上,		

具体来说，@RequestMapping注解用于将一个或多个URL路径（例如"/home"或"/home/{id}"）映射到一个特定的处理程序方法。在Spring MVC中，处理程序方法可以是一个控制器类中的任何公共方法。

```java
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/home/{id}")
    public String homeWithId(@PathVariable("id") int id) {
        // handle request with id parameter
        return "home";
    }
}

```

在上面的代码中，我们有一个名为HomeController的控制器类，它包含三个使用@RequestMapping注解的处理程序方法。第一个方法将根路径（"/"）映射到index视图，第二个方法将"/home"路径映射到home视图，第三个方法将"/home/{id}"路径映射到home视图，并将路径中的"id"参数作为方法参数。

当用户请求这些路径之一时，Spring MVC将查找匹配的@RequestMapping注解，并将请求转发到相应的处理程序方法。处理程序方法然后处理请求并返回相应的视图名称。在这个例子中，Spring MVC将找到HomeController类并将请求发送到适当的方法，该方法将返回相应的视图名称。

### 2.1 SpringMVC  优化的内容

![image-20230318190440161](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318190440161.png)

由客户端发送请求到one.action,然后经过springMVC优化处理后返回结果给客户端。

### 2.2 数据提交的5种方式

#### 2.2.1 单个数据提交方式

<font color='red'>注意此处表单种的name属性必须于controller中的形式参数名称一致</font>

- index.jsp GET 方式提交中文不会乱码，原因Tomcat8以后对GET请求能处理中文，其他请求如POST暂时会出现乱码。

​			

```jsp
<%@ page import="org.w3c.dom.css.CSSStyleRule" %><%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/18
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//获取项目根路径
String baseString = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=baseString%>">
    <title>首页</title>
</head>
<body>
<h2>五种数据提交方式</h2>
<hr>
<h3>单个数据提交</h3>
<form action="one.action" method="get">
    姓名：<input type="text" value="" name="name" placeholder="请输入用户名">
    年龄：<input type="text" name="age" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>
</body>
</html>

```



- 编写oneController

```java
package edu.beihua;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class oneController {
    @RequestMapping("/one")
    public String toOne(String name,int age){
        System.out.println(name+"\t"+(age+100));
        return "main";
    }
}

```



- 在webapp下新建admin文件夹，在其中建立main.jsp

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/18
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据请求方式</title>
</head>
<body>
<h3 style="color: red">主页main………………</h3>
</body>
</html>

```



- 结果

![image-20230318202957261](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318202957261.png)

![image-20230318203014772](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318203014772.png)

![image-20230318203025695](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318203025695.png)

#### 2.2.2 以对象方式传参数

<font color='red'>此时表单中的name属性必须与实体对象的属性名一致，springmvc才会自动封装存入对象中.</font>

- 编写controller类

```java
 @RequestMapping("/two")
    public String toOne(User user){
        System.out.println("姓名："+ user.getUname()+"\t年龄: "+(user.getUage()+100));
        return "main";
    }
```

- 编写index表单

```jsp
<hr>
<h3>单个数据提交</h3>
<form action="two.action" method="get">
    姓名：<input type="text" value="" name="uname" placeholder="请输入用户名">
    年龄：<input type="text" name="uage" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>
```

- 编写实体类User

```java
public class User {
    private String uname;
    private int uage;

    public User() {
    }
}

//省略构造方法 set/get方法
```

当控制器方法需要接收参数时，Spring MVC会根据参数类型和方法参数名字匹配请求参数，并将请求参数转换为方法参数类型。Spring MVC框架会根据Java Bean的属性名字匹配请求参数，并将请求参数转换为Java Bean属性的类型。Spring MVC框架使用Java Bean的Setter方法将请求参数的值设置到Java Bean的属性中。

#### 2.2.3 动态占位符提交数据

<font color='red'>仅限于超链接或地址拦提交数据.它是一杠一值,一杠一大括号,使用注解@PathVariable来解析</font>`@PathVariable` 是 Spring Framework 中的一种注解，用于将 RESTful web 服务请求的 URI 中的变量映射到控制器中处理请求的方法参数上。

这里，`@PathVariable` 注解用于 `toThree` 方法的 `id` 参数上，将 URI 中的 `{name}` 变量映射到方法参数上。`name` 参数将被实际从 URI 中提取的 ID 值填充。

- 编写index

```jsp
<hr>
<a href="/three/张撒旦/67.action">动态占位符传参</a>
```

- 编写controller

```java
 @RequestMapping("/three/{name}/{age}")
    //即使是路径中{}中的名字与形参名字一样，springmvc也不能封装入形参、
    //必须使用@@PathVariable()
    public String toThree(@PathVariable() String name,@PathVariable() int age){
        System.out.println("通过动态占位符传入参数");
        System.out.println("姓名："+ name+"\t年龄: "+(age+100));
        return "main";
    }
```

- 结果

![image-20230318210246921](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318210246921.png)

#### 2.2.4 请求参数映射

此处情况：网页中的参数与controller中的方法不一样时,使用@RequestParam来解析并装入参数。

- 编写index

```jsp
<hr>
<form action="two.action" method="get">
    姓名：<input type="text" value="" name="username" placeholder="请输入用户名">
    年龄：<input type="text" name="userage" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>
```



- 编写controller

```java
@RequestMapping("/four")
public String toFour(@RequestParam("username") String name, @RequestParam("userage") int age){
    System.out.println("使用RequestParam"+"传入参数");
    System.out.println("姓名："+ name+"\t年龄: "+(age+100));
    return "main";
}
```

- 结果

![image-20230318211639836](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318211639836.png)

#### 2.2.5  手工提取方式

通过HttpServletRequest获取请求参数

- 编写controller

```java
@RequestMapping("/five")
public String tofive(HttpServletRequest request){
    System.out.println("HttpServletRequest"+"获取传入参数");
    System.out.println("姓名："+request.getParameter("name")+"\t年龄: "+((Integer.parseInt(request.getParameter("age")))+100));
    return "main";
}
```

- 编写index

```jsp
<hr>
<form action="/five.action" method="get">
    姓名：<input type="text" value="" name="name" placeholder="请输入用户名">
    年龄：<input type="text" name="age" value="" placeholder="请输入用年龄">
    <button type="submit">提交</button>
</form>
```

- 结果

![image-20230318212335692](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230318212335692.png)

## 3、 中文编码设置

- 配置过滤器

在src/main/webapp/WEB-INF/web.xml加上字符编码过滤器

```xml
 <!--配置过滤器-->
    <filter>
        <filter-name>encoding</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <!--配置参数-->
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>

        <init-param>
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>

        <init-param>
            <param-name>forceResponseEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>

    <filter-mapping>
        <filter-name>encoding</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
```

## 4、 action方法返回值

- String：客户端资源地址，自动拼接前缀和后缀，可以屏蔽自动字符拼接，可以指定返回的路径。
- Object：返回json格式的对象。自动将对象或者集合转换成json，使用的Jackson工具进行转换，必须添加jackson的依赖，一般用于ajax请求。
- void：无返回值类型，一般用于ajax请求。
- 基本数据类型：用于ajax请求
- ModelAndView：返回数据和视图，现在不常见。

## 5、ajax请求应用

- 搭建项目（略），在pom添加jackson依赖

```xml
 <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.9.8</version>
    </dependency>
```

- 在webapp目录下新建js目录,添加jQuery函数库，https://code.jquery.com/jquery-3.6.4.js
- 在index.jsp页面上导入函数库

```html
 <script type="text/javascript" src="js/jquery-3.6.4.js"></script>
```

- index界面点击时间在jQuery入口函数中

```jsp
<%--
  Created by IntelliJ IDEA.
  User: 23705
  Date: 2023/3/20
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.6.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#senBtn").click(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/list.do",
                    type:"POST",
                    dataType:"json",
                    data:{
                        na:"我是来测试的"
                    },
                    success:function (res) {
                        var s = '';
                        $.each(res,function (i,stu) {
							//此处实际上调用了实体类Sudent的get方法，在实体类中必须实现，名字必须为
                            //一致
                            s += stu.name +"---" + stu.age + "<br>";
                        });

                        //回显数据
                        $("#show-box").html("<hr>"+s);
                    }
                })
            })
        });
    </script>
</head>
<body>
<a id="senBtn">点击访问服务器返回数据</a>
<div id="show-box"></div>
</body>
</html>

```

- 在action上添加注解@ResponseBody,用来处理ajax请求， //处理ajax请求,一定要加@ResponseBody
- 在springmvc.xml文件中添加注解驱动<mvc:annotationdriven/>,它用来解析@ResponseBody注解

> ​	` <mvc:annotation-driven></mvc:annotation-driven`>

## 6、请求转发与重定向的区别

![image-20230321213612451](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230321213612451.png)

- 四种跳转方式

​			从本质上来说只是两种请求，请求转发和重定向，只不过是他们两个的衍生出的请求方式。请求转发就是基于服务器的转发，客户端的地址不会改变，而重定向是基于客户端的请求，地址栏会做出相应的的改变。

- 请求转发：当一个请求发送到服务器时，<font color='red'>服务器</font>可以将这个<font color='red'>请求转发</font>给另外一个<font color='red'>资源（如Servlet、JSP等）</font>，并且把原始请求的参数等信息传递给这个资源进行处理。在这个过程中，浏览器并不知道服务器做了什么，**浏览器发送的URL地址不会改变**。**在服务器内部进行的，因此转发速度比较快**。
- 重定向：当一个**请求发送到服务器时**，**服务器可以告诉浏览器将请求的页面重定向到另一个页面**。这个过程中，**服务器会发送一个特殊的响应给浏览器，告诉浏览器访问新的URL地址**。因为浏览器需要重新向新的地址发送请求，所以重定向会导致页面跳转比较慢，同时也<font color='red'>会改变浏览器的地址栏的URL地址</font>。

```java
 @RequestMapping("/one")
    public String one(){
        System.out.println("默认的请求转发！");
        //使用视图解析器拼接前后缀进行页面跳转
        return "main";
    }

    @RequestMapping("/two")
    public String two(){
        System.out.println("请求转发action跳转");
        //forward:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        //不加上的话会拼接为：/admin/other.do.jsp
        return "forward:/other.do";
    }


    @RequestMapping("/three")
    public String three(){
        System.out.println("默认重定向跳转界面");
        //forward:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        //不加上的话会拼接为：/admin/other.do.jsp
        return "redirect:/other.do";
    }

    @RequestMapping("/four")
    public String four(){
        System.out.println("默认重定向跳转界面");
        //redirect:字符串可以屏蔽前缀和后缀的拼接.实现请求转发跳转
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/five")
    public String five(){
        System.out.println("这是随便跳.......");

        return "forward:/fore/login.jsp";
    }
```

## 7、SpringMVC的默认参数

​	也就是说在controller层的方法中隐含的参数，可以当作形式参数传入，直接使用不需要创建。

- HttpServletRequest 
- HttpServletResponse
- HttpSession
- Model
- Map
- ModelMap

<font color='red'>注意：Map，Model，ModelMap和request一样，都使用请求作用域进行数据传递，服务器必须是请求转发。</font>

## 8、springmvc的执行流程

![image-20230322211028418](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230322211028418.png)

## 9、日期处理方式

- 日期提交处理

  - 单个日期处理

    ```html
    <form action="/date.do" method="POST">
        时间: <input type="date" name="data">
        <button type="submit">提交</button>
    </form>
    ```

    控制其中使用<font color='red'>@DateTimeFormat()</font>注解格式化时间，只能放在形参前，记得在springmvc配置文件中配置注解支持

    `<mvc:annotation-driven></mvc:annotation-driven>`

    ```java
    @RequestMapping("/date")
    public String toShow(  @DateTimeFormat(pattern = "yyyy-MM-dd")  Date data){
            System.out.println(data);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(data));
            return "show";
        }
    ```

    

  - 类中全局日期处理(该方式不需要加任何的东西)

  ```java
  //注册java全局时间拦截
  @InitBinder
      public void initDate(WebDataBinder dataBinder){
          dataBinder.registerCustomEditor(Date.class,new CustomDateEditor(
                  new SimpleDateFormat("yyyy-MM-dd"),true
          ));
      }    
  
  
  @RequestMapping("/date")
      public String toShow(Date data){
          System.out.println(data);
          System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(data));
          return "show";
      }
  ```

- 日期现实处理

  - 在页面上显示好看的日期,必须使用JSTL.

    1. 添加依赖jstl

       ```xml
       <dependency>
             <groupId>jstl</groupId>
             <artifactId>jstl</artifactId>
             <version>1.2</version>
           </dependency>
       ```

       

    2. 在jsp页面上引入标签库

    ```jsp
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    ```

    jsp界面遍历

    ```jsp
    <table border="1" style="margin: auto;text-align: center;"  cellpadding="0" width="800" >
        <thead>
            <th>姓名</th>
            <th>年龄</th>
            <th>出生年月</th>
        </thead>
    
        <tbody>
            <c:forEach items="${list}" var="stu">
                <tr>
                    <td>${stu.name}</td>
                    <td>${stu.age}</td>
                    <%--没有进行时间格式化处理--%>
                    <%--<td>${stu.birthday}</td>--%>
                    <%--对时间进行转化格式--%>
                    <td><fmt:formatDate value="${stu.birthday}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    ```

    controller代码

    ```java
       private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        @RequestMapping("/student")
        public String getStudent(HttpServletRequest request) throws ParseException {
            Student stu0 = new Student("张三",78,sf.parse("2009-12-3"));
            Student stu1 = new Student("里斯",56,sf.parse("2003-2-23"));
            Student stu2 = new Student("王五",26,sf.parse("2013-2-4"));
    
            List<Student> students = new ArrayList<>();
            students.add(stu0);
            students.add(stu1);
            students.add(stu2);
    
            request.setAttribute("list",students);
    
            return "show";
    
    
        }
    ```

    













































































































## github 在idea中推拉代码过程中遇到的问题集合

1. ![image-20230321065639457](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230321065639457.png)

```sh
$ git config --global http.sslVerify 'true'

```

解决了一个但是又出现了一个登陆问题

![image-20230321072046559](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230321072046559.png)

```sh
取消全局代理：
git config --global --unset http.proxy
 
git config --global --unset https.proxy
```

![image-20230321073135282](C:\Users\23705\AppData\Roaming\Typora\typora-user-images\image-20230321073135282.png)

```sh
git config --global --unset http.proxy

git config --global --unset https.proxy

```

