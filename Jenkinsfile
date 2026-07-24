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
        stage('Push Docker Image') {
            environment {
                AWS_REGION = 'ap-south-1'
                AWS_ACCOUNT_ID = '188217590021'
                ECR_REPOSITORY = 'employee-service'
            }

            steps {
                sh '''
                    docker push ${AWS_ACCOUNT_ID}.dkr.ecr.${AWS_REGION}.amazonaws.com/${ECR_REPOSITORY}:${BUILD_NUMBER}
                '''
            }
        }
        stage('Register Task Definition') {
            environment {
                AWS_REGION = 'ap-south-1'
                AWS_ACCOUNT_ID = '188217590021'
                ECR_REPOSITORY = 'employee-service'
                TASK_DEFINITION = 'employee-service-task'
            }

            steps {
                sh '''
                    echo "Fetching current task definition..."

                    aws ecs describe-task-definition \
                    --task-definition $TASK_DEFINITION \
                    --region $AWS_REGION \
                    --query taskDefinition > task-definition.json

                    echo "Updating image URI..."

                    jq --arg IMAGE "$AWS_ACCOUNT_ID.dkr.ecr.$AWS_REGION.amazonaws.com/$ECR_REPOSITORY:$BUILD_NUMBER" \
                    '
                    .containerDefinitions[0].image = $IMAGE
                    | del(
                        .taskDefinitionArn,
                        .revision,
                        .status,
                        .requiresAttributes,
                        .compatibilities,
                        .registeredAt,
                        .registeredBy
                    )
                    ' task-definition.json > new-task-definition.json

                    echo "Registering new task definition revision..."

                    aws ecs register-task-definition \
                        --region $AWS_REGION \
                        --cli-input-json file://new-task-definition.json
                '''
            }
        }

    }
}