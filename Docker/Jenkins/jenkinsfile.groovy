pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "MAVEN_3_6_3"
    }

    stages {
        stage('更新代码') {
            steps{
                git credentialsId: 'c001ece2-30ed-411f-8b7f-538a9016e6ef', url: 'git@github.com:GM-HaoPeng/hao_yan_java_boot.git'
            }

        }

        stage('质量检测') {
            steps{
                script {
                    // requires SonarQube Scanner 2.8+
                    //这里填写，在系统管理中配置的sonar服务器名称
                    scannerHome = tool 'SonarQubeScanner'
                }
                withSonarQubeEnv('SonarQubeScanner') {
                    configFileProvider([configFile(fileId: '8b35b288-e581-4100-9728-5b249c910284', variable: 'setting')]) {
                        sh "mvn -s ${setting} clean package -Dmaven.test.skip=true sonar:sonar -Dsonar.projectKey=HAO-YAN-WEB -Dsonar.projectName=HAO-YAN-WEB -Dsonar.projectVersion=1.0.0 -Dsonar.sourceEncoding=UTF-8 -Dsonar.exclusions=src/test/** -Dsonar.sources=src/ -Dsonar.java.binaries=target/classes -Dsonar.host.url=http://192.168.0.30:9000/ -Dsonar.login=sqa_c9aa7ea558600bed63ed9f769004fe5d08f9d323"
                    }

                }
            }
        }
    }

}
