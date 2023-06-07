### （1）快速启动命令

```cmd
docker run -d -v /opt/confluence:/var/atlassian/application-data/confluence -v /etc/localtime:/etc/localtime:ro --name="confluence" -p 8090:8090 -p 8091:8091 atlassian/confluence-server:6.15.2
```

### （2）注意事项

- 生产环境需要连接数据库，数据库可参考MySQL进行启动，并参考一下命令创建用户

  ```cmd
  create user confluence@localhost identified by 'confluence';
  create database confluence character set utf8 collate utf8_bin;
  grant all privileges on confluence.* to confluence@'localhost';
  ```

- 快速启动命令中的版本最好搭配mysql5.7使用,宿主机部署MySQL参考一下连接

  ```cmd
  jdbc:mysql://ip:端口/confluence?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true
  ```

  

- 如果使用docker启动mysql并想通过应用名访问，需要在启动mysql前使用  docker network 相关命令加入同一个网络,连接数据的url连接参考如下

  ```cmd
  jbdc:mysql://容器名:端口/confluence？useunicode=true&characterencoding=utf8&&allowMultiQueries=true&serverTimezone=GMT%2B8&useSSL=false&allowPublicKeyRetrieval=true
  ```

- MySQL要求的必要参数

  ```conf
  transaction-isolation=READ-COMMITTED
  innodb_log_file_size = 256M
  max_allowed_packet = 34M
  ```

  

- 需要将mysql驱动复制到容器内，参考以下命令

  ```cmd
  docker cp /tmp/mysql-connector-java-5.1.47.jar confluence:/opt/atlassian/confluence/confluence/WEB-INF/lib/
  ```

-  破解操作

  - 先将容器内容认证的文件拷贝出来

    ```cmd
    docker cp confluence:/opt/atlassian/confluence/confluence/WEB-INF/lib/atlassian-extras-decoder-v2-3.4.1.jar /tmp/atlassian-extras-2.4.jar
    ```

  - 使用破解工具抓包

  - 将破解的包重新放入容器

    ```cmd
    docker cp /tmp/atlassian-extras-2.4.jar confluence:/opt/atlassian/confluence/confluence/WEB-INF/lib/atlassian-extras-decoder-v2-3.4.1.jar
    ```

- 如果预览发现中文乱码，参考以下链接解决

  [预览中文乱码解决方案](https://confluence.atlassian.com/confkb/the-text-in-a-powerpoint-excel-or-word-document-looks-different-when-using-the-viewfile-macro-200213562.html)

