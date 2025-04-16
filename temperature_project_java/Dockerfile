FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# 复制pom.xml文件
COPY pom.xml .
# 复制源代码
COPY src ./src

# 构建应用
RUN mvn clean package -DskipTests

# 运行阶段
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# 复制构建的JAR文件
COPY --from=build /app/target/*.jar app.jar

# 暴露应用端口
EXPOSE 8080

# 运行应用
ENTRYPOINT ["java", "-jar", "app.jar"] 