pipeline {

    agent {
        label 'linux'
    }

    stages {

        stage('Checkout Source') {

            steps {

                git branch: 'main',
                    credentialsId: 'github-creds',
                    url: 'https://github.com/ajinkya0001/employee-service.git'
            }
        }

        stage('Build Spring Boot') {

            steps {

                sh 'chmod +x gradlew'

                sh './gradlew clean build'
            }
        }

    }
}