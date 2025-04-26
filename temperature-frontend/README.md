# 温度监控系统前端

这是温度监控系统的前端部分，使用HTML、CSS和JavaScript构建，通过Nginx容器部署。

## 目录结构

- `public/`: 包含静态资源文件
  - `index.html`: 主页面
- `Dockerfile`: 用于构建Docker镜像
- `nginx.conf`: Nginx配置文件

## 功能

- 实时显示当前温度数据
- 根据温度范围显示不同的状态(低温、正常、高温等)
- 显示温度历史图表
- 定期自动刷新数据

## 如何构建

```bash
# 构建Docker镜像
docker build -t temperature-frontend .
```

## 如何运行

```bash
# 运行容器
docker run -d -p 80:80 --name temperature-frontend temperature-frontend
```

## 与后端集成

前端通过Nginx代理将API请求转发到后端服务。在`nginx.conf`中配置了代理规则，将所有`/api/*`的请求转发到后端服务。

确保在docker-compose或Kubernetes环境中，后端服务名称为`temperature-backend`，或根据实际部署环境修改`nginx.conf`中的代理目标。 