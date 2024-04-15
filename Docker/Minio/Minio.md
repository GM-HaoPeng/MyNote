### 拉取镜像

```cmd
docker pull minio/minio:RELEASE.2024-04-06T05-26-02Z
```





### 启动镜像

```cmd
docker run -d --name minio -p 9000:9000 -p 9001:9001 -e "MINIO_ROOT_USER=zhongrunsafe" -e "MINIO_ROOT_PASSWORD=zhongrunsafe" -v E:/ProgramData/DockerData/minio/conf:/root/.minio -v E:/ProgramData/DockerData/minio/data:/data minio/minio:RELEASE.2024-04-06T05-26-02Z server /data --console-address ":9001"
```

```cmd
docker run -d --name minio -p 9002:9000 -p 9003:9003 -e "MINIO_ROOT_USER=minioadmin" -e "MINIO_ROOT_PASSWORD=minioadmin" -v E:/ProgramData/DockerData/minio_repl/conf:/root/.minio -v E:/ProgramData/DockerData/minio_repl/data:/data minio/minio:RELEASE.2024-04-06T05-26-02Z server /data --console-address ":9003"

```



```cmd
docker run -d --name minio -p 9002:9000 -p 9003:9003 -e "MINIO_ROOT_USER=zhongrunsafe" -e "MINIO_ROOT_PASSWORD=zhongrunsafe" -v minio_conf:/root/.minio -v minio_data:/data minio/minio:RELEASE.2024-04-06T05-26-02Z server /data --console-address ":9003"
```





```cmd
docker run -d --name minio_mc minio/mc -it --entrypoint=/bin/sh minio/mc
```

