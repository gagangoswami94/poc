pipeline{
    agent any

    tools {
        maven 'maven3'
        jdk 'jdk1.8'
        }

    environment {
        SNAP-REPO = 'poc1-snapshot'
        NEXUS-USER = 'admin'
        NEXUS-PASS = 'admin'
        RELEASE-REPO = 'poc1-maven-release'
        CENTRAL-REPO = 'poc1-maven-central'
        NEXUSIP = "172.31.83.222"
        NEXUSPORT = "8081"
	    NEXUS-GRP-REPO = "poc1-group"
        NEXUS-LOGIN = 'nexus'       
    }
    stages{
        stage("Build"){
            steps{
                sh "mvn -s settings.xml -Dskiptests install"
            }

        }
    }
}