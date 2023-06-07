### （1）快速启动命令

```cmd
docker run --name mysql -p 3306:3306 -p 33060:33060 -v /opt/mysql/conf:/etc/mysql/conf.d -v /opt/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=0c29b2051b7bff70 -d --privileged  mysql:8.0.21
```



### （2）注意事项

- 挂载的配置文件必须为只读，否则启动会宝world-writeable且不会加载配置文件

- --privileged Docker 应用容器 获取宿主机root权限（特殊权限）