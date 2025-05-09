# 温度监控系统

这是一个基于Spring Boot和前端技术栈构建的温度监控系统，采用前后端分离架构。

## 项目结构

- `temperature_project_java/`: 后端服务 (Spring Boot)
  - 提供温度数据API
  - 处理温度传感器数据
  - 存储温度历史记录
  
- `temperature-frontend/`: 前端应用 (HTML/CSS/JavaScript + Nginx)
  - 实时显示温度数据
  - 可视化温度变化趋势
  - 响应式设计，适配不同设备

## 快速开始

### 使用Docker Compose启动整个系统

1. 确保您已安装Docker和Docker Compose

2. 在项目根目录下运行:

```bash
docker-compose up -d
```

3. 访问应用:
   - 前端界面: http://localhost:80
   - 后端API: http://localhost:8080/api/temperature

### 单独构建和运行

#### 后端服务

```bash
cd temperature_project_java
mvn clean package
java -jar target/*.jar
```

#### 前端应用

```bash
cd temperature-frontend
# 使用nginx或其他静态文件服务器
# 示例: 使用Docker
docker build -t temperature-frontend .
docker run -d -p 80:80 temperature-frontend
```

## API文档

### 获取当前温度

- URL: `/api/temperature`
- 方法: GET
- 响应示例:
  ```json
  {
    "temperature": 24.5,
    "timestamp": "2023-06-15T14:30:45.123"
  }
  ```

### 获取温度历史记录

- URL: `/api/temperature/history`
- 方法: GET
- 响应示例:
  ```json
  [
    {
      "temperature": 24.5,
      "timestamp": "2023-06-15T14:30:45.123"
    },
    {
      "temperature": 24.2,
      "timestamp": "2023-06-15T14:25:45.123"
    }
  ]
  ```
