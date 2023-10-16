# Docker

## 1.安装配置（CentOS）

### <1>环境校验

```cmd
uname -r
```

使用以上命令检查内核版本，系统内核版本位3.10以上

### <2> 确保yum包最新

```cmd
sudo yum update
```

### <3>若有，则移除旧版本

```cmd
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

```cmd
sudo yum install -y yum-utils device-mapper-persistent-data lvm2

```

### <5>设置国内yum源

```cmd
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

### <6>安装Docker-ce

```cmd
sudo yum install docker-ce
```

### <7>启动东Docker后台服务

```cmd
sudo systemctl start docker
```

### <8>加入开机启动

```cmd
sudo systemctl enable docker
```

### <9>创建docker用户组

```cmd
sudo groupadd docker
```

### <10>普通用户加入docker用户组 

运行docker ，尽量使用普通用户，镜像中的目录挂在多为docker 用户组

```
sudo usermod -aG docker ${user}
```

### <11>重启docker服务

```cmd
sudo systemctl restart docker
```

### <12> windows 下vmmem占用内存过高的处理方法

```cmd
# 用户目录下创建 .wslconfig 文件 并编辑加入以下内容
#.wslconfig
[wsl2]
memory=3GB //分配给WSL内存3GB
swap=4GB   //设置交换分区4GB
localhostForwarding=true
# 之后运行 wsl --shutdown 命令
```

