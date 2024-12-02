**PERSONAL PORTFOLIO WEBSITE WITH BACKEND USING SPRING BOOT**

Hi guys, Welcome back to another article. In this article, we will give you a project named PERSONAL PORTFOLIO WEBSITE WITH BACKEND USING SPRING BOOT. It is useful for you to use best practices. Let’s get started.


Project Content:-

Keep Eclipse IDE or STS integrated and Postman is used for testing the endpoints.
Create a Spring Boot Project using Spring Initializer for Eclipse or directly create a Spring Boot Project in the STS IDE.
Add Maven Dependency.
Define Database configuration in the application.properties file.
Create entity class.
Create a Repository for entity class.
Create a Service (Interface).
Create a Service Implementation.
Create a Controller class.
Run the Application.
Open a Postman Application then test endpoints.
above given the project content I will explain one by one. Move into the first one.

**1. Keep Eclipse IDE or STS and Postman:-**

Refer to this Link https://start.spring.io. To create a SpringBoot Project. In STS Users, directly create a Spring Boot Project in STS. and we will discuss it later about Postman.

**2. Create a Spring Boot Project using Spring Initializer for Eclipse or directly create a Spring Boot Project in the STS IDE:-**

Add the following dependencies:

Spring Web.
Spring Data JPA.
Devtools.
MySQL Driver.

Project Structure
**3. Add Maven Dependency.**

In pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
 <modelVersion>4.0.0</modelVersion>
 <parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.4.0</version>
  <relativePath /> <!-- lookup parent from repository -->
 </parent>
 <groupId>com.Personal.Portfolio</groupId>
 <artifactId>Personal-Portfolio-Website</artifactId>
 <version>0.0.1-SNAPSHOT</version>
 <name>Personal-Portfolio-Website</name>
 <description>Demo project for Spring Boot</description>
 <url />
 <licenses>
  <license />
 </licenses>
 <developers>
  <developer />
 </developers>
 <scm>
  <connection />
  <developerConnection />
  <tag />
  <url />
 </scm>
 <properties>
  <java.version>17</java.version>
 </properties>
 <dependencies>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-web</artifactId>
  </dependency>

  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-test</artifactId>
   <scope>test</scope>
  </dependency>
  <dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-devtools</artifactId>
  </dependency>
  <dependency>
   <groupId>com.mysql</groupId>
   <artifactId>mysql-connector-j</artifactId>
   <scope>runtime</scope>
  </dependency>
 </dependencies>

 <build>
  <plugins>
   <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
   </plugin>
  </plugins>
 </build>

</project>
****4. Define Database configuration in the application.properties file:-****

spring.application.name=Personal-Portfolio-Website

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3305/personalportfolio?useSSL=false&serverTimezone=UTC&useLegacyDatetimeCode=false
spring.datasource.username=root
spring.datasource.password=system

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

**5. Create entity class:-**

**This is Project.java Entity**

package com.Personal.Portfolio.Personal_Portfolio_Website.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Project {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String title;
 private String description;
 private String technologies;
 private String liveLink;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getTechnologies() {
  return technologies;
 }

 public void setTechnologies(String technologies) {
  this.technologies = technologies;
 }

 public String getLiveLink() {
  return liveLink;
 }

 public void setLiveLink(String liveLink) {
  this.liveLink = liveLink;
 }

}

**Next one is Blog.java Entity**

package com.Personal.Portfolio.Personal_Portfolio_Website.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Blog {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String title;
 private String content;
 private String author;
 private LocalDateTime createdate;
 private LocalDateTime updatedate;

 @PrePersist
 protected void onCreate() {
  this.createdate = LocalDateTime.now();
  this.updatedate = LocalDateTime.now();
 }

 @PreUpdate
 protected void onUpdate() {
  this.updatedate = LocalDateTime.now();
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getContent() {
  return content;
 }

 public void setContent(String content) {
  this.content = content;
 }

 public String getAuthor() {
  return author;
 }

 public void setAuthor(String author) {
  this.author = author;
 }

 public LocalDateTime getCreatedate() {
  return createdate;
 }

 public void setCreatedate(LocalDateTime createdate) {
  this.createdate = createdate;
 }

 public LocalDateTime getUpdatedate() {
  return updatedate;
 }

 public void setUpdatedate(LocalDateTime updatedate) {
  this.updatedate = updatedate;
 }

}
**and last one is Message.java Entity**

package com.Personal.Portfolio.Personal_Portfolio_Website.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Message {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String sender;
 private String recipient;
 private String content;
 private LocalDateTime sendAt;

 @PrePersist
 protected void onCreate() {
  this.sendAt = LocalDateTime.now();
 }

 @PreUpdate
 protected void onUpdate() {
  this.sendAt = LocalDateTime.now();
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getSender() {
  return sender;
 }

 public void setSender(String sender) {
  this.sender = sender;
 }

 public String getRecipient() {
  return recipient;
 }

 public void setRecipient(String recipient) {
  this.recipient = recipient;
 }

 public String getContent() {
  return content;
 }

 public void setContent(String content) {
  this.content = content;
 }

 public LocalDateTime getSendAt() {
  return sendAt;
 }

 public void setSendAt(LocalDateTime sendAt) {
  this.sendAt = sendAt;
 }

}
6. Create a Repository for entity class:-

Project Repository

package com.Personal.Portfolio.Personal_Portfolio_Website.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
Blog Repository

package com.Personal.Portfolio.Personal_Portfolio_Website.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

}
And last one is Massage Repository

package com.Personal.Portfolio.Personal_Portfolio_Website.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
7. Create a Service (Interface):-

Project Service

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;

public interface ProjectService {
 List<Project> getAllProjects();

 Project getProjectById(Long id);

 Project createProject(Project project);

 Project updateProject(Long id, Project project);

 void deleteProject(Long id);

}
Blog Service

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;

public interface BlogService {

 List<Blog> getAllBlogs();

 Blog getBlogById(Long id);

 Blog createBlog(Blog blog);

 Blog updateBlog(Long id, Blog blog);

 void deleteBlog(Long id);

}
and last one is Message Service

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;

public interface MessageService {
 List<Message> getAllMessages();

 Message getMessageById(Long id);

 Message createMessage(Message message);

 Message updateMessage(Long id, Message message);

 void deleteMessage(Long id);

}
8. Create a Service Implementation:-

ProjectServiceImpl.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

 @Autowired
 private ProjectRepository projectRepository;

 @Override
 public List<Project> getAllProjects() {
  return projectRepository.findAll();
 }

 @Override
 public Project getProjectById(Long id) {
  return projectRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
 }

 @Override
 public Project createProject(Project project) {
  return projectRepository.save(project);
 }

 @Override
 public Project updateProject(Long id, Project project) {
  Project existingProject = getProjectById(id);
  existingProject.setTitle(project.getTitle());
  existingProject.setDescription(project.getDescription());
  existingProject.setTechnologies(project.getTechnologies());
  existingProject.setLiveLink(project.getLiveLink());
  return projectRepository.save(existingProject);
 }

 @Override
 public void deleteProject(Long id) {
  if (!projectRepository.existsById(id)) {
   throw new RuntimeException("Project not found with id: " + id);
  }
  projectRepository.deleteById(id);

 }

}
BlogServiceImpl.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

 @Autowired
 private BlogRepository blogRepository;

 @Override
 public List<Blog> getAllBlogs() {
  return blogRepository.findAll();
 }

 @Override
 public Blog getBlogById(Long id) {
  return blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found with id: " + id));
 }

 @Override
 public Blog createBlog(Blog blog) {
  return blogRepository.save(blog);
 }

 @Override
 public Blog updateBlog(Long id, Blog blog) {
  Blog existingBlog = getBlogById(id);
  existingBlog.setTitle(blog.getTitle());
  existingBlog.setContent(blog.getContent());
  existingBlog.setAuthor(blog.getAuthor());
  existingBlog.setUpdatedate(LocalDateTime.now());
  return blogRepository.save(existingBlog);

 }

 @Override
 public void deleteBlog(Long id) {
  if (!blogRepository.existsById(id)) {
            throw new RuntimeException("Blog not found with id: " + id);
        }
        blogRepository.deleteById(id);
    }

}
and last one is MessageServiceImpl.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;
import com.Personal.Portfolio.Personal_Portfolio_Website.Repos.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService {

 @Autowired
 private MessageRepository messageRepository;

 @Override
 public List<Message> getAllMessages() {
  return messageRepository.findAll();
 }

 @Override
 public Message getMessageById(Long id) {
  return messageRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("Message not found with id: " + id));
 }

 @Override
 public Message createMessage(Message message) {
  return messageRepository.save(message);
 }

 @Override
 public Message updateMessage(Long id, Message message) {
  Message existingMessage = getMessageById(id);
  existingMessage.setSender(message.getSender());
  existingMessage.setRecipient(message.getRecipient());
  existingMessage.setContent(message.getContent());
  existingMessage.setSendAt(message.getSendAt());
  return messageRepository.save(existingMessage);
 }

 @Override
 public void deleteMessage(Long id) {
  if (!messageRepository.existsById(id)) {
   throw new RuntimeException("Message not found with id: " + id);
  }
  messageRepository.deleteById(id);
 }

}
9. Create a Controller class:-

ProjectController.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Project;
import com.Personal.Portfolio.Personal_Portfolio_Website.Service.ProjectService;

@Controller
@RequestMapping("/api/projects")
public class ProjectController {

 @Autowired
 private ProjectService projectService;

 @GetMapping
 public ResponseEntity<List<Project>> getAllProjects() {
  return ResponseEntity.ok(projectService.getAllProjects());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
  return ResponseEntity.ok(projectService.getProjectById(id));
 }

 @PostMapping
 public ResponseEntity<Project> createProject(@RequestBody Project project) {
  return ResponseEntity.ok(projectService.createProject(project));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project) {
  return ResponseEntity.ok(projectService.updateProject(id, project));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
  projectService.deleteProject(id);
  return ResponseEntity.noContent().build();
 }

}
BlogController.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Blog;
import com.Personal.Portfolio.Personal_Portfolio_Website.Service.BlogService;

@Controller
@RequestMapping("/api/blogs")
public class BlogController {
 @Autowired
 private BlogService blogService;

 @GetMapping
 public ResponseEntity<List<Blog>> getAllBlogs() {
  return ResponseEntity.ok(blogService.getAllBlogs());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
  return ResponseEntity.ok(blogService.getBlogById(id));
 }

 @PostMapping
 public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
  return ResponseEntity.ok(blogService.createBlog(blog));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
  return ResponseEntity.ok(blogService.updateBlog(id, blog));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteBlog(@PathVariable Long id) {
  blogService.deleteBlog(id);
  return ResponseEntity.noContent().build();
 }

}
and last one is MessageController.java

package com.Personal.Portfolio.Personal_Portfolio_Website.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Personal.Portfolio.Personal_Portfolio_Website.Model.Message;
import com.Personal.Portfolio.Personal_Portfolio_Website.Service.MessageService;

@Controller
@RequestMapping("/api/message")
public class MessageController {

 @Autowired
 private MessageService messageService;

 @GetMapping
 public ResponseEntity<List<Message>> getAllMessages() {
  return ResponseEntity.ok(messageService.getAllMessages());
 }

 @GetMapping("/{id}")
 public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
  return ResponseEntity.ok(messageService.getMessageById(id));
 }

 @PostMapping
 public ResponseEntity<Message> createMessage(@RequestBody Message message) {
  return ResponseEntity.ok(messageService.createMessage(message));
 }

 @PutMapping("/{id}")
 public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
  return ResponseEntity.ok(messageService.updateMessage(id, message));
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
  messageService.deleteMessage(id);
  return ResponseEntity.noContent().build();
 }

}
10. Run the Application:-

This is console


  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.4.0)

2024-12-02T10:46:27.034+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .P.P.PersonalPortfolioWebsiteApplication : Starting PersonalPortfolioWebsiteApplication using Java 19.0.2 with PID 24896 (C:\Users\ramak\Downloads\Personal-Portfolio-Website\Personal-Portfolio-Website\target\classes started by ramak in C:\Users\ramak\Downloads\Personal-Portfolio-Website\Personal-Portfolio-Website)
2024-12-02T10:46:27.038+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .P.P.PersonalPortfolioWebsiteApplication : No active profile set, falling back to 1 default profile: "default"
2024-12-02T10:46:27.245+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2024-12-02T10:46:27.245+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'
2024-12-02T10:46:29.158+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-12-02T10:46:29.292+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 110 ms. Found 3 JPA repository interfaces.
2024-12-02T10:46:31.187+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
2024-12-02T10:46:31.291+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2024-12-02T10:46:31.292+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.33]
2024-12-02T10:46:31.382+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2024-12-02T10:46:31.384+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 4138 ms
2024-12-02T10:46:31.857+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2024-12-02T10:46:32.018+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.6.2.Final
2024-12-02T10:46:32.089+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.h.c.internal.RegionFactoryInitiator    : HHH000026: Second-level cache disabled
2024-12-02T10:46:32.614+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.s.o.j.p.SpringPersistenceUnitInfo      : No LoadTimeWeaver setup: ignoring JPA class transformer
2024-12-02T10:46:32.676+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2024-12-02T10:46:33.237+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@7399ad95
2024-12-02T10:46:33.241+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2024-12-02T10:46:33.602+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] org.hibernate.orm.connections.pooling    : HHH10001005: Database info:
 Database JDBC URL [Connecting through datasource 'HikariDataSource (HikariPool-1)']
 Database driver: undefined/unknown
 Database version: 8.0.35
 Autocommit mode: undefined/unknown
 Isolation level: undefined/unknown
 Minimum pool size: undefined/unknown
 Maximum pool size: undefined/unknown
2024-12-02T10:46:35.246+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000489: No JTA platform available (set 'hibernate.transaction.jta.platform' to enable JTA platform integration)
2024-12-02T10:46:35.371+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2024-12-02T10:46:36.030+05:30  WARN 24896 --- [Personal-Portfolio-Website] [  restartedMain] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2024-12-02T10:46:37.381+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2024-12-02T10:46:37.483+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path '/'
2024-12-02T10:46:37.507+05:30  INFO 24896 --- [Personal-Portfolio-Website] [  restartedMain] .P.P.PersonalPortfolioWebsiteApplication : Started PersonalPortfolioWebsiteApplication in 11.343 seconds (process running for 12.538)
11. Open a Postman Application then test endpoints:-

Open the Postman Application and test all endpoints.


This is adding the projects in your Portfolio
This API is mainly used to add projects to your portfolio Application. Add the N number of projects.


This is updating the projects in your Portfolio
This API is mainly used to update the projects in your portfolio Application. update all projects.


This is getting the specific project in your Portfolio
This API is mainly used to fetch projects in your portfolio Application.


This is getting the specific project in your Portfolio
This API is mainly used to fetch all projects in your portfolio Application.


This is deleting the specific project in your Portfolio
This API is mainly used to delete the specific project in your portfolio Application.
And Test the Remaining Endpoints or APIs as possible.

Conclusion:-

For any Query contact me:

Linkedin: https://www.linkedin.com/in/k-ramakrishna-a9a9811ab/

Thanks for reading Please Follow Ram. we will meet in the next article bye bye…
