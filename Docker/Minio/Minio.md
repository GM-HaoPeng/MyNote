### 拉取镜像

```cmd
docker pull minio/minio:RELEASE.2021-04-22T15-44-28Z
```





### 启动镜像

```cmd
docker run -p 9003:9000  --name video-minio  -d --restart=always -e "MINIO_ACCESS_KEY=minioadmin" -e "MINIO_SECRET_KEY=minioadmin"  -v video_attachments:/data    -v video_attachments_config:/root/.minio      minio/minio:RELEASE.2021-04-22T15-44-28Z server /data --console-address "0.0.0.0:9090" -address ":9003"

```



```cmd
docker run -p 9003:9000 -p 9001:9001 --name minio -d -e "MINIO_ACCESS_KEY=minioadmin" -e "MINIO_SECRET_KEY=minioadmin" -v video_attachments:/data  -v video_attachments_config:/root/.minio  minio/minio:RELEASE.2021-04-22T15-44-28Z server /data --console-address ":9001" -address ":9003"

```

```cmd
docker run -p 9000:9000 -p 9001:9001 --name minio1 -v D:\ProgramData\DockerData\minio:/data -e "MINIO_ROOT_USER=ROOTUSER" -e "MINIO_ROOT_PASSWORD=CHANGEME123" minio/minio:RELEASE.2021-04-22T15-44-28Z server /data --console-address ":9001"
```

```cmd
docker run -p 9000:9000 -p 9001:9001 --name minio1 -v D:\ProgramData\DockerData\minio:/data -e "MINIO_ROOT_USER=minioadmin" -e "MINIO_ROOT_PASSWORD=minioadmin" quay.io/minio/minio server /data --console-address ":9001"
```

```cmd
docker run -p 9000:9000 -p 9001:9001 --name minio1 -v D:\ProgramData\DockerData\minio:/data -e "MINIO_ROOT_USER=minioadmin" -e "MINIO_ROOT_PASSWORD=minioadmin" minio/minio:RELEASE.2024-04-06T05-26-02Z server /data --console-address ":9001"
```



```cmd
docker run -p 9003:9000 -p 9001:9001 --name minio1 -v D:\ProgramData\DockerData\minio:/data -e "MINIO_ROOT_USER=minioadmin" -e "MINIO_ROOT_PASSWORD=minioadmin" minio/minio:RELEASE.2024-04-06T05-26-02Z server /data --console-address ":9001"
```

