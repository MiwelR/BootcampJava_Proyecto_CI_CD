pipeline {
    agent any
    tools {
        maven "maven3.8.1"
        jdk "jdk16"
    }
    stages {
        stage("Env Variables") {
            steps {
                sh "printenv"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }
        }
        stage('Site') {
            steps {
                sh 'mvn site'
            }
        }
        stage('Sonar') {
           steps {
               sh 'mvn verify sonar:sonar -Dsonar.projectKey=MiwelR_BootcampJava_Proyecto_CI_CD -Dsonar.organization=miwelr -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=99e1527946264df57788909cf6212ca2a52f767a'
           }
        }
    }
}