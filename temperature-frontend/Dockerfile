FROM nginx:alpine

# 删除默认的nginx静态资源
RUN rm -rf /usr/share/nginx/html/*

# 复制前端静态资源到nginx服务目录
COPY ./public /usr/share/nginx/html

# 复制自定义的nginx配置（用于处理SPA前端路由）
COPY ./nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"] 