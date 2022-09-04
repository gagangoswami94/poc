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
        SONARSERVER =  'sonarscanner'
        SONARSCANNER = 'sonarscanner'
    }
    stages{
        stage("Build"){
            steps{
                sh "mvn -s settings.xml -Dskiptests install"
            }
            post {
                success {
                    echo "Archiving artifact"
                    archiveArtifacts artifacts: "**/*.war"
                }
            }

        }
        stage("Test"){
            steps{
                sh "mvn -s settings.xml test"
            }
        }

        stage("Checkstyle Analysis"){
            steps{
                sh "mvn -s settings.xml checkstyle:checkstyle"
            }
        }
        
        stage("Sonar Analysis"){
            environment {
                scannerHome = tool 'sonarscanner4'
            }
            steps{
                withSonarQubeEnv("${SONARSERVER}") {
                    sh '''${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=poc \
                    -Dsonar.projectName=poc-project \
                    -Dsonar.projectVersion=1.0 \
                    -Dsonar.sources=src/ \
                    -Dsonar.java.binaries=target/test-classes/com/poc/account/controllerTest/ \
                    -Dsonar.junit.reportsPath=target/surefire-reports/ \
                    -Dsonar.jacoco.reportsPath=target/jacoco.exec \
                    -Dsonar.java.checkstyle.reportPaths=target/checkstyle-result.xml'''

                }
            }

        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // It indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }        
    }
}