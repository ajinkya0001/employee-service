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
                sh '''
                    chmod +x gradlew
                    export GRADLE_OPTS="-Xms128m -Xmx256m"
                    ./gradlew clean build -x test --no-daemon
                '''
            }
        }
        stage('Build Docker Image') {
            steps {
                sh '''
                    docker build -t employee-service:${BUILD_NUMBER} .
                '''
            }
        }

    }
}