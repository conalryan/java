# spring-boot

## Generate App
Starter:        https://start.spring.io/
Project:        Maven
Language:       Java
Spring Boot:    2.1.7
Packaging:      Jar
Java:           8
Dependencies:   None

## Build
```bash
./mvnw clean install
```

## Test
```bash
./mvnw test
```

## Run
```bash
./mvnw spring-boot:run
```

## Results
- Inheriting the parent Spring pom is stupid
- A BOM under `<dependencyManagement>` is fine
- Running `./mvnw spring-boot:run` starts then immediately stops because it's a standard Java main function
- To have it run as a JavaEE app use `spring-boot-starter-web`

## Dependency Tree
```bash
./mvnw dependency:tree -Doutput=dependency-tree.txt
```

```
16:04 $ ./mvnw dependency:tree
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.example:maven-java-jar >---------------------
[INFO] Building maven-java-jar 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ maven-java-jar ---
[INFO] com.example:maven-java-jar:jar:0.0.1-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot:jar:2.1.7.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-context:jar:5.1.9.RELEASE:compile
[INFO] |  |     +- org.springframework:spring-aop:jar:5.1.9.RELEASE:compile
[INFO] |  |     +- org.springframework:spring-beans:jar:5.1.9.RELEASE:compile
[INFO] |  |     \- org.springframework:spring-expression:jar:5.1.9.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-autoconfigure:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.11.2:compile
[INFO] |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.11.2:compile
[INFO] |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.26:compile
[INFO] |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] |  +- org.springframework:spring-core:jar:5.1.9.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-jcl:jar:5.1.9.RELEASE:compile
[INFO] |  \- org.yaml:snakeyaml:jar:1.23:runtime
[INFO] \- org.springframework.boot:spring-boot-starter-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:2.1.7.RELEASE:test
[INFO]    +- com.jayway.jsonpath:json-path:jar:2.4.0:test
[INFO]    |  +- net.minidev:json-smart:jar:2.3:test
[INFO]    |  |  \- net.minidev:accessors-smart:jar:1.2:test
[INFO]    |  |     \- org.ow2.asm:asm:jar:5.0.4:test
[INFO]    |  \- org.slf4j:slf4j-api:jar:1.7.25:compile
[INFO]    +- junit:junit:jar:4.12:test
[INFO]    +- org.assertj:assertj-core:jar:3.11.1:test
[INFO]    +- org.mockito:mockito-core:jar:2.23.4:test
[INFO]    |  +- net.bytebuddy:byte-buddy:jar:1.9.3:test
[INFO]    |  +- net.bytebuddy:byte-buddy-agent:jar:1.9.3:test
[INFO]    |  \- org.objenesis:objenesis:jar:2.6:test
[INFO]    +- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO]    +- org.hamcrest:hamcrest-library:jar:1.3:test
[INFO]    +- org.skyscreamer:jsonassert:jar:1.5.0:test
[INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO]    +- org.springframework:spring-test:jar:5.1.9.RELEASE:test
[INFO]    \- org.xmlunit:xmlunit-core:jar:2.6.3:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.201 s
[INFO] Finished at: 2019-08-24T16:04:44-04:00
[INFO] ------------------------------------------------------------------------
```

## Solution
- Add to pom.xml
```bash
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
  <version>${org.springframework.boot.version}</version>
</dependency>
```
- Application now runs and available at localhost:8080
- Expected results received:
```html
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Aug 23 22:10:27 EDT 2019
There was an unexpected error (type=Not Found, status=404).
No message available
```

## Dependency Tree
```bash
./mvnw dependency:tree -Doutput=depedency-tree-web.txt
```

```
16:08 $ ./mvnw dependency:tree
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.example:maven-java-jar >---------------------
[INFO] Building maven-java-jar 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ maven-java-jar ---
[INFO] com.example:maven-java-jar:jar:0.0.1-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot:jar:2.1.7.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-context:jar:5.1.9.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-autoconfigure:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.11.2:compile
[INFO] |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.11.2:compile
[INFO] |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.26:compile
[INFO] |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] |  +- org.springframework:spring-core:jar:5.1.9.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-jcl:jar:5.1.9.RELEASE:compile
[INFO] |  \- org.yaml:snakeyaml:jar:1.23:runtime
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.9.9:compile
[INFO] |  |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.9.9:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.9.9:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-tomcat:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.22:compile
[INFO] |  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:9.0.22:compile
[INFO] |  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.22:compile
[INFO] |  +- org.hibernate.validator:hibernate-validator:jar:6.0.17.Final:compile
[INFO] |  |  +- javax.validation:validation-api:jar:2.0.1.Final:compile
[INFO] |  |  +- org.jboss.logging:jboss-logging:jar:3.3.2.Final:compile
[INFO] |  |  \- com.fasterxml:classmate:jar:1.3.4:compile
[INFO] |  +- org.springframework:spring-web:jar:5.1.9.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-beans:jar:5.1.9.RELEASE:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:5.1.9.RELEASE:compile
[INFO] |     +- org.springframework:spring-aop:jar:5.1.9.RELEASE:compile
[INFO] |     \- org.springframework:spring-expression:jar:5.1.9.RELEASE:compile
[INFO] \- org.springframework.boot:spring-boot-starter-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:2.1.7.RELEASE:test
[INFO]    +- com.jayway.jsonpath:json-path:jar:2.4.0:test
[INFO]    |  +- net.minidev:json-smart:jar:2.3:test
[INFO]    |  |  \- net.minidev:accessors-smart:jar:1.2:test
[INFO]    |  |     \- org.ow2.asm:asm:jar:5.0.4:test
[INFO]    |  \- org.slf4j:slf4j-api:jar:1.7.25:compile
[INFO]    +- junit:junit:jar:4.12:test
[INFO]    +- org.assertj:assertj-core:jar:3.11.1:test
[INFO]    +- org.mockito:mockito-core:jar:2.23.4:test
[INFO]    |  +- net.bytebuddy:byte-buddy:jar:1.9.3:test
[INFO]    |  +- net.bytebuddy:byte-buddy-agent:jar:1.9.3:test
[INFO]    |  \- org.objenesis:objenesis:jar:2.6:test
[INFO]    +- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO]    +- org.hamcrest:hamcrest-library:jar:1.3:test
[INFO]    +- org.skyscreamer:jsonassert:jar:1.5.0:test
[INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO]    +- org.springframework:spring-test:jar:5.1.9.RELEASE:test
[INFO]    \- org.xmlunit:xmlunit-core:jar:2.6.3:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.458 s
[INFO] Finished at: 2019-08-24T16:08:56-04:00
[INFO] ------------------------------------------------------------------------
```
