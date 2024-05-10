### （1）快速启动命令

```cmd
docker run -d -u root -p 8080:8080 -p 50000:50000 -v E:/ProgramData/DockerData/jenkins:/var/jenkins_home -e PLUGINS_FORCE_UPGRADE=true  -e TRY_UPGRADE_IF_NO_MARKER=true -e JAVA_OPTS=-Duser.timezone=Asia/Shanghai --name jenkins --restart=on-failure jenkins/jenkins:2.440.1-lts

docker run -d -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home -e PLUGINS_FORCE_UPGRADE=true  -e TRY_UPGRADE_IF_NO_MARKER=true -e JAVA_OPTS=-Duser.timezone=Asia/Shanghai --name jenkins --restart=on-failure jenkins/jenkins:lts-jdk11

docker pull jenkins/jenkins:2.440.1-lts
```

### （2）注意事项

- 启动时如果需要自己指定宿主机目录，对目录的权限更改或使用 -u root参数以root方式启动容器，更改权限使用一下命令

  ```cmd
  # 权限不足的解决办法
  （1）chown -R 1000:1000 jenkins_home
  （2）docker run -u root -p 8080:8080 （后面省略）
  ```

- 安装完直接重启，不然会出现部分中文部分英文的情况

- 构建node项目需要python环境，参考一下命令安装，其他依赖环境也可参考

  ```cmd
  #进入容器内部
  docker exec -u 0 -it jenkins bash
  sudo cp /etc/apt/sources.list /etc/apt/sources.list_bak
  
  #中国科技大学
  sudo sed -i 's/deb.debian.org/mirrors.ustc.edu.cn/g' /etc/apt/sources.list
  #网易云163
  sudo sed -i 's/deb.debian.org/mirrors.163.com/g' /etc/apt/sources.list
  #阿里云
  sudo sed -i 's/deb.debian.org/mirrors.aliyun.com/g' /etc/apt/sources.list
  #清华同方
  sudo sed -i 's/deb.debian.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apt/sources.list
  
  apt-get update
  rm /var/lib/apt/lists/* -vf
  apt-get install vim
  apt-get install python3
  apt-get install python3-pip
  ```

- 使用 publish over ssh 执行 nohup 命令时切记不要勾选在后台运行，同时也要同步环境变量，不然启动不成功，命令参考如下

  ```cmd
  source /etc/profile
  nohup java -jar $project.jar > $log_file.out 2>&1 &
  ```

  
