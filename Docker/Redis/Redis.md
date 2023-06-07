### （1）快速启动命令

```cmd
docker run --name redis -p 6379:6379 -v /opt/redis/redis.conf:/etc/redis/redis.conf -v /opt/redis/data:/data  -d redis:6.2.7 redis-server /etc/redis/redis.conf
```



### （2）注意事项

暂无发现坑点