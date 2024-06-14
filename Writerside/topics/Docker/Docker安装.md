# Docker

## 1.安装配置（CentOS）

### <1>环境校验

```Shell
uname -r
```

使用以上命令检查内核版本，系统内核版本位3.10以上

### <2> 确保yum包最新

```shell
sudo yum update
```

### <3>若有，则移除旧版本

```shell
$ sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-selinux \
                  docker-engine-selinux \
                  docker-engine

```

### <4> 安装必要的系统工具

```shell
sudo yum install -y yum-utils device-mapper-persistent-data lvm2

```

### <5>设置国内yum源

```shell
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

### <6>安装Docker-ce

```shell
sudo yum install docker-ce
```

### <7>启动东Docker后台服务

```shell
sudo systemctl start docker
```

### <8>加入开机启动

```shell
sudo systemctl enable docker
```

### <9>创建docker用户组

```shell
sudo groupadd docker
```

### <10>普通用户加入docker用户组 

运行docker ，尽量使用普通用户，镜像中的目录挂在多为docker 用户组

```
sudo usermod -aG docker ${user}
```

### <11>重启docker服务

```shell
sudo systemctl restart docker
```

### <12> windows 下vmmem占用内存过高的处理方法

```shell
# 用户目录下创建 .wslconfig 文件 并编辑加入以下内容
#.wslconfig
[wsl2]
memory=3GB //分配给WSL内存3GB
swap=4GB   //设置交换分区4GB
localhostForwarding=true
# 之后运行 wsl --shutdown 命令
```

### <13> 端口权限问题解决(可能由于winnat 引起)

```shell
### 关闭winnant
net stop winnat
### 执行docker 命令
### 打开winnat
net start winnat
```

