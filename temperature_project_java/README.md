# 温度传感器监控系统

这是一个基于Spring Boot的温度传感器监控系统，包含后端API和前端可视化界面。

## 功能特点

- 模拟温度传感器实时数据
- REST API提供温度数据访问
- 定时任务采集温度数据
- 存储最近100条温度记录
- 实时图表展示温度变化
- 温度状态可视化

## 技术栈

- 后端：Spring Boot 3.4
- 前端：HTML, CSS, JavaScript, Chart.js, Bootstrap 5
- 容器化：Docker

## 快速开始

### 方法一：直接运行

```bash
# 克隆仓库
git clone <repository-url>
cd temperature_project_java

# 使用Maven构建项目
./mvnw clean package

# 运行应用
java -jar target/temperature_project_java-0.0.1-SNAPSHOT.jar
```

### 方法二：使用Docker运行

```bash
# 构建Docker镜像
docker build -t temperature-monitor .

# 运行容器
docker run -p 8080:8080 temperature-monitor
```

## 访问应用

浏览器访问：http://localhost:8080

## API接口

- `GET /api/temperature` - 获取当前温度
- `GET /api/temperature/history` - 获取历史温度记录

## 许可证

MIT 