**ACTIVITY_02**
================================

1.
Need to write an application with security login with usage spring 
          **spring-boot-starter-thymeleaf** 

(you can use dependencies
        
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
        <!-- security -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
        <!-- end security -->

)
for users "user"(role "USER") with password "password"

           **withUser("user").password("password").roles("USER");**

Use Cases
================================

2.
 Ordering pages:
   
             "home"->"login"->"hello" 

3.
For describing security configuration, please, **use java-file**. 

4.
Please use annotations for spring-boot for testing application.

Requirements for training
==========================================
Recovery, please, MvcConfig.java, WebSecurityConfig.java, Application.java
 for successful testing