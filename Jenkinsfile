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
        NEXUSIP = "172.31.83.222"
        NEXUSPORT = "8081"
	    NEXUS_GRP_REPO = "poc1-group"
        NEXUS_LOGIN = 'nexus'       
    }
    stages{
        stage("Build"){
            steps{
                sh "mvn -s settings.xml -Dskiptests install"
            }
            post {
                success {
                    echo "Archiving artifact"
                    archiveArtifacts artificats: "**/*.war"
                }
            }

        }
        stage("Test"){
            steps{
                sh "mvn test"
            }
        }

        stage("Checkstyle Analysis"){
            steps{
                sh "mvn checkstyle:checkstyle"
            }
        }
    }
}