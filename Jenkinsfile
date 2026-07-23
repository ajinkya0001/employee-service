pipeline {
    agent any

    stages {

        stage('Checkout Source') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-creds',
                    url: 'https://github.com/ajinkya0001/employee-service.git'
            }
        }

    }
}