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
                    ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPOSITORY}:latest
                '''
            }
        }

        stage('Push Docker Image') {
            environment {
                AWS_REGION = 'ap-south-1'
                AWS_ACCOUNT_ID = '188217590021'
                ECR_REPOSITORY = 'employee-service'
            }

            steps {
                sh '''
                    docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPOSITORY}:latest
                '''
            }
        }

        stage('Update ECS Service') {
            environment {
                AWS_REGION = 'ap-south-1'
                ECS_CLUSTER = 'employee-cluster'
                ECS_SERVICE = 'employee-service-task-service-qskaepe9'
            }

            steps {
                sh '''
                    echo "Starting new deployment..."

                    aws ecs update-service \
                        --cluster $ECS_CLUSTER \
                        --service $ECS_SERVICE \
                        --force-new-deployment \
                        --region $AWS_REGION
                '''
            }
        }

        stage('Wait for ECS Stability') {
            environment {
                AWS_REGION = 'ap-south-1'
                ECS_CLUSTER = 'employee-cluster'
                ECS_SERVICE = 'employee-service-task-service-qskaepe9'
            }

            steps {
                sh '''
                    echo "Waiting for ECS deployment to complete..."

                    aws ecs wait services-stable \
                        --cluster $ECS_CLUSTER \
                        --services $ECS_SERVICE \
                        --region $AWS_REGION

                    echo "Deployment completed successfully."
                '''
            }
        }

        stage('Cleanup') {
            steps {
                sh '''
                    docker image prune -af
                '''
            }
        }

    }
}