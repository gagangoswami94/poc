pipeline{
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk1.8'
        }

    environment {
        SNAP_REPO = 'poc1-snapshot'
        NEXUS_USER = 'admin'
        NEXUS_PASS = 'admin'
        RELEASE_REPO = 'poc1-maven-release'
        CENTRAL_REPO = 'poc1-maven-central'
        NEXUS_IP = "172.31.83.222"
        NEXUS_PORT = "8081"
	    NEXUS_GRP_REPO = "poc1-group"
        NEXUS_LOGIN = 'nexus'       
    }
    stages{
        stage("Build"){
            steps{
                sh "mvn -s settings.xml -Dskiptests install"
            }

        }
    }
}