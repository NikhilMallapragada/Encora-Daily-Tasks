pipeline {
    agent any

    tools {
        jdk 'JDK11'
        maven 'Maven3'
    }

    environment {
        APP_NAME = 'SBSecurity'
        JAR_NAME = 'SBSecurity.jar'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }

        stage('Package') {
            steps {
                script {
                    sh 'mvn package'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    sh 'java -jar target/${JAR_NAME} &'
                }
            }
        }
    }

    post {
        success {
            echo 'Build and Deployment Successful!'
        }
        failure {
            echo 'Build or Deployment Failed.'
        }
    }
}
