# 🚀 Employee Service - AWS ECS Fargate Deployment

> Enterprise-style deployment of a Spring Boot REST API using Docker, Amazon ECR, AWS ECS (Fargate), Application Load Balancer, and CloudWatch with **Zero Downtime Rolling Deployment**.

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=springboot)
![Docker](https://img.shields.io/badge/Docker-Container-blue?style=for-the-badge&logo=docker)
![AWS ECS](https://img.shields.io/badge/AWS-ECS-orange?style=for-the-badge&logo=amazonaws)
![Fargate](https://img.shields.io/badge/AWS-Fargate-orange?style=for-the-badge)
![CloudWatch](https://img.shields.io/badge/AWS-CloudWatch-yellow?style=for-the-badge)
![Gradle](https://img.shields.io/badge/Gradle-Build-darkgreen?style=for-the-badge&logo=gradle)

---

# 📖 Project Overview

This project demonstrates how to deploy a **Spring Boot Employee Management REST API** on **AWS ECS Fargate** using a production-style deployment pipeline.

The application is containerized using Docker, stored in Amazon ECR, deployed using ECS Fargate, exposed through an Application Load Balancer, monitored with CloudWatch, and upgraded using **Rolling Deployment** to achieve **Zero Downtime**.

---

# ✨ Features

- ✅ Employee CRUD REST APIs
- 🐳 Dockerized Spring Boot Application
- ☁ Amazon Elastic Container Registry (ECR)
- 🚀 AWS ECS Fargate Deployment
- ⚖ Application Load Balancer (ALB)
- 🎯 Target Group Health Checks
- 📋 ECS Task Definition & Service
- 📈 Amazon CloudWatch Logging
- 🔄 Rolling Deployment
- ✅ Zero Downtime Deployment

---

# 🛠 Tech Stack

| Technology | Version |
|------------|----------|
| Java | 21 |
| Spring Boot | 3.x |
| Gradle | Latest |
| Docker | Latest |
| AWS ECS | Fargate |
| Amazon ECR | Private Repository |
| Application Load Balancer | AWS |
| CloudWatch | Monitoring |
| Git | Version Control |

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

# 🏗 AWS Architecture

```
Developer
     │
     ▼
Spring Boot Application
     │
     ▼
Docker Build
     │
     ▼
Amazon ECR
     │
     ▼
Task Definition
     │
     ▼
ECS Service
     │
     ▼
ECS Tasks (Fargate)
     │
     ▼
Target Group
     │
     ▼
Application Load Balancer
     │
     ▼
Users
```

---

# 🔄 Rolling Deployment Workflow

```
Modify Code

      │

      ▼

Gradle Build

      │

      ▼

Docker Build (v2)

      │

      ▼

Push Image to Amazon ECR

      │

      ▼

Create Task Definition Revision

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

```
employee-service
│
├── src/
├── build.gradle
├── Dockerfile
├── gradlew
├── gradlew.bat
├── settings.gradle
└── README.md
```

---

# 🌐 Live API

### Get Employees

```http
GET http://employee-alb-2004854171.ap-south-1.elb.amazonaws.com/api/employees
```

> **Note:** This endpoint is hosted on an AWS ECS service behind an Application Load Balancer. It is available while the AWS infrastructure is running.

---

# 📊 Deployment Highlights

- Docker Image Build
- Amazon ECR Push
- ECS Task Definition
- ECS Service
- AWS Fargate
- Application Load Balancer
- Target Group Health Checks
- CloudWatch Monitoring
- Rolling Deployment
- Zero Downtime Release

---

# 📚 What I Learned

- Containerizing Spring Boot applications
- Working with Docker images
- Amazon ECR image management
- ECS Task Definitions
- ECS Services
- AWS Fargate deployment
- ALB & Target Groups
- CloudWatch logging
- Health Checks
- Rolling Deployments
- Zero Downtime deployments
- Enterprise deployment workflow

---

# 👨‍💻 Author

**Ajinkya Jadkar**

- Java Developer
- Spring Boot
- Docker
- AWS Cloud
- DevOps Enthusiast

---

# ⭐ Future Improvements

- CI/CD using GitHub Actions
- Terraform Infrastructure as Code
- Auto Scaling
- HTTPS with ACM
- Custom Domain (Route 53)
- AWS CodePipeline Integration

---

## 🙌 If you found this project useful, consider giving it a ⭐ on GitHub.