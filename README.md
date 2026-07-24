# 🚀 Employee Service - AWS ECS Fargate + Jenkins CI/CD

Enterprise-style deployment of a Spring Boot REST API using **Docker, Amazon ECR, AWS ECS (Fargate), Jenkins Pipeline, GitHub Webhooks, Application Load Balancer, and CloudWatch** with **Zero Downtime Rolling Deployment**.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-brightgreen)
![Docker](https://img.shields.io/badge/Docker-Latest-blue)
![Jenkins](https://img.shields.io/badge/Jenkins-CI-red)
![AWS ECS](https://img.shields.io/badge/AWS-ECS-orange)
![Fargate](https://img.shields.io/badge/Fargate-Enabled-blue)

---

# 📖 Project Overview

This project demonstrates a complete **CI/CD pipeline** for deploying a Spring Boot REST API to **AWS ECS Fargate**.

The application is:

- Developed using Spring Boot
- Containerized using Docker
- Built automatically using Jenkins
- Stored in Amazon ECR
- Automatically deployed to ECS Fargate
- Triggered using GitHub Webhooks
- Exposed through an Application Load Balancer
- Monitored using CloudWatch
- Updated using Zero Downtime Rolling Deployment

---

# ✨ Features

- ✅ Spring Boot REST API
- ✅ Dockerized Application
- ✅ Amazon Elastic Container Registry (ECR)
- ✅ AWS ECS Fargate Deployment
- ✅ Application Load Balancer
- ✅ CloudWatch Logs
- ✅ Jenkins CI/CD Pipeline
- ✅ GitHub Webhooks
- ✅ Automatic Build on Git Push
- ✅ Automatic Docker Build
- ✅ Automatic Docker Push to ECR
- ✅ Automatic ECS Task Definition Revision
- ✅ Automatic ECS Service Update
- ✅ Rolling Deployment
- ✅ Zero Downtime Deployment

---

# 🛠 Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.x |
| Gradle | Latest |
| Docker | Latest |
| Jenkins | Latest |
| GitHub | Webhooks |
| Amazon ECS | Fargate |
| Amazon ECR | Private Repository |
| CloudWatch | Monitoring |
| Application Load Balancer | AWS |

---

# ☁ AWS Services Used

- Amazon ECS
- AWS Fargate
- Amazon ECR
- Application Load Balancer
- Target Group
- CloudWatch
- IAM
- VPC
- Security Groups

---

# 🏗 CI/CD Architecture

```text
Developer
     │
     ▼
Git Push
     │
     ▼
GitHub Repository
     │
     ▼
GitHub Webhook
     │
     ▼
Jenkins Pipeline
     │
     ▼
Gradle Build
     │
     ▼
Docker Build
     │
     ▼
Amazon ECR
     │
     ▼
Register New ECS Task Definition
     │
     ▼
Update ECS Service
     │
     ▼
Launch New ECS Task
     │
     ▼
ALB Health Check
     │
     ▼
Old Task Stops
     │
     ▼
Zero Downtime Deployment
```

---

# 🔄 Jenkins Pipeline

The Jenkins Pipeline consists of the following stages:

- ✅ Checkout Source
- ✅ Build Spring Boot
- ✅ Build Docker Image
- ✅ Login to Amazon ECR
- ✅ Tag Docker Image
- ✅ Push Docker Image
- ✅ Register Task Definition
- ✅ Update ECS Service
- ✅ Wait for ECS Stability
- ✅ Cleanup

---

# 🔄 Rolling Deployment Workflow

```text
Developer Changes Code
          │
          ▼
      Git Commit
          │
          ▼
       Git Push
          │
          ▼
 GitHub Webhook Trigger
          │
          ▼
   Jenkins Pipeline Starts
          │
          ▼
     Build Spring Boot
          │
          ▼
      Docker Build
          │
          ▼
     Push Image to ECR
          │
          ▼
 Register Task Definition
          │
          ▼
    Update ECS Service
          │
          ▼
 Launch New ECS Task
          │
          ▼
 Target Group Health Check
          │
          ▼
ALB Routes Traffic to New Task
          │
          ▼
   Old Task Stops
          │
          ▼
 Zero Downtime Deployment
```

---

# 📂 Project Structure

```text
employee-service
│
├── src/
├── Jenkinsfile
├── Dockerfile
├── build.gradle
├── gradlew
├── settings.gradle
└── README.md
```

---

# 🌐 Live API

```
GET http://employee-alb-2004854171.ap-south-1.elb.amazonaws.com/api/employees
```

> **Note:** The endpoint is available only while the AWS ECS infrastructure is running.

---

# 📸 Project Screenshots

Create a folder named **screenshots** and place your screenshots there.

```text
screenshots/
│
├── jenkins-pipeline.png
├── github-webhook.png
├── ecr-images.png
├── ecs-service.png
├── task-definition.png
├── rolling-deployment.png
├── cloudwatch.png
└── api-response.png
```

Then display them like this:

## Jenkins Pipeline

<img width="1919" height="1105" alt="image" src="https://github.com/user-attachments/assets/c9c1f063-a2ed-4ad4-936d-92d8cdf824b8" />


---

## GitHub Webhook

<img width="1919" height="1199" alt="image" src="https://github.com/user-attachments/assets/64874bd2-4534-4e66-8f27-16b1ad15a799" />


---

## Amazon ECR

<img width="1919" height="1100" alt="image" src="https://github.com/user-attachments/assets/397e6547-5309-407e-92f7-40c1c1469dd8" />



---

## ECS Service

<img width="1919" height="1199" alt="image" src="https://github.com/user-attachments/assets/0785db09-b024-4f57-b498-fa83e9711f4d" />


---

## ECS Task Definition

<img width="1919" height="1108" alt="image" src="https://github.com/user-attachments/assets/fac5d46e-1906-405d-aeca-19ecd95444b1" />


---

## CloudWatch Logs

<img width="1919" height="1104" alt="image" src="https://github.com/user-attachments/assets/1d15b42e-df1e-420d-99e8-d9f7adb23f39" />


---

## API Response

<img width="1919" height="606" alt="image" src="https://github.com/user-attachments/assets/d1291264-a050-4484-8635-1ff16bae7eca" />


---

# 📊 Deployment Highlights

- ✅ GitHub Webhook Trigger
- ✅ Automatic Jenkins Build
- ✅ Spring Boot Build
- ✅ Docker Image Build
- ✅ Amazon ECR Push
- ✅ ECS Task Definition Revision
- ✅ ECS Service Update
- ✅ AWS Fargate Deployment
- ✅ Application Load Balancer
- ✅ Target Group Health Checks
- ✅ CloudWatch Monitoring
- ✅ Rolling Deployment
- ✅ Zero Downtime Release

---

# 📚 What I Learned

- Spring Boot REST API Development
- Docker Containerization
- Amazon Elastic Container Registry (ECR)
- AWS ECS Fargate
- Application Load Balancer
- CloudWatch Logging
- Jenkins Declarative Pipeline
- GitHub Webhook Integration
- Continuous Integration (CI)
- Continuous Deployment (CD)
- ECS Task Definition Revisions
- Rolling Deployment Strategy
- Zero Downtime Deployments
- Enterprise CI/CD Workflow

---

# 🚀 Future Improvements

- Infrastructure as Code using Terraform
- Multi-Environment Deployments (Dev, QA, Prod)
- Blue-Green Deployment
- Canary Deployment
- SonarQube Integration
- Trivy Image Scanning
- Slack Notifications
- HTTPS using ACM
- Route 53 Custom Domain
- Kubernetes (Amazon EKS)

---

# 👨‍💻 Author

**Ajinkya Jadkar**

- Java Developer
- Spring Boot Developer
- Docker
- Jenkins
- AWS Cloud
- DevOps Enthusiast

---

⭐ If you found this project useful, consider giving it a **Star** on GitHub!
