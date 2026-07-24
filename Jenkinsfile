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
        stage('Login to Amazon ECR') {
            environment {
                AWS_REGION = 'ap-south-1'
                AWS_ACCOUNT_ID = '188217590021'
            }

            steps {
                sh '''
                    aws ecr get-login-password --region $AWS_REGION | \
                    docker login \
                    --username AWS \
                    --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com
                '''
            }
        }

        stage('Tag Docker Image') {
            environment {
                AWS_REGION = 'ap-south-1'
                AWS_ACCOUNT_ID = '188217590021'
                ECR_REPOSITORY = 'employee-service'
            }

            steps {
                sh '''
                    docker tag employee-service:${BUILD_NUMBER} \
                    ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPOSITORY}:${BUILD_NUMBER}
                '''
            }
        }

    }
}