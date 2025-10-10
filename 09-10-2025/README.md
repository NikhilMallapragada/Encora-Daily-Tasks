#  Spring Boot Security with JWT Role-Based Access System

A **Spring Boot** application implementing **JWT authentication** and **role-based access control (RBAC)** for **Admin**, **User**, and **Developer** dashboards with token validation and UI pages using **Thymeleaf**.

---

##  Overview

This project demonstrates how to build a secure login system using **Spring Security** and **JWT (JSON Web Token)** where:
- Each user role (Admin, User, Developer) gets a dedicated dashboard.
- On successful login, a JWT token is generated and shown to the user.
- The token can be validated through a custom UI.
- Admins can assign and view developer tasks dynamically.
- All pages are protected with proper authorization rules.

---

##  Features

 **JWT Token Generation and Validation**  
 **Custom Login Page using Thymeleaf**  
 **Role-Based Dashboards (Admin, User, Developer)**  
 **Admin can assign and view developer tasks**  
 **Secure API endpoints with Spring Security**  
 **Beautiful UI using HTML + CSS (gradient backgrounds, responsive design)**  

---

##  Project Structure

src/
├── main/
│ ├── java/com/example/
│ │ ├── controller/
│ │ │ ├── AdminController.java
│ │ │ ├── Controller.java
│ │ │ ├── PageController.java
│ │ ├── model/
│ │ │ ├── DeveloperTask.java
│ │ ├── model/bean/
│ │ │ ├── CustomLoginSuccessHandler.java
│ │ │ ├── SecurityConfig.java
│ │ ├── model/config/
│ │ │ ├── JwtConfig.java
│ │ ├── model/filter/
│ │ │ ├── JwtFilter.java
│ │ ├── token/
│ │ │ ├── JwtUtil.java
│ │ ├── SbSecurityApplication.java
│ ├── resources/
│ │ ├── static/css/style.css
│ │ ├── templates/
│ │ │ ├── index.html
│ │ │ ├── login.html
│ │ │ ├── admin.html
│ │ │ ├── user.html
│ │ │ ├── developer.html
│ │ │ ├── validateToken.html
│ │ │ ├── welcome.html



---

##  How It Works (Communication Flow)

1. **Login Phase**
   - User visits `/login` and logs in using valid credentials.
   - `CustomLoginSuccessHandler` triggers upon successful authentication.
   - A **JWT token** is generated and displayed on a styled validation page.

2. **Token Validation**
   - User pastes their JWT token into `/validateTokenPage`.
   - `Controller.validateToken()` validates the token using `JwtUtil`.
   - Depending on the role, user is redirected to:
     - `/admin` → Admin Dashboard  
     - `/user` → User Dashboard  
     - `/developer` → Developer Dashboard

3. **Role Dashboards**
   - **Admin**: Can assign tasks and view all developer tasks (`/admin/tasks`).
   - **User**: Sees a welcome dashboard.
   - **Developer**: Views assigned tasks and updates progress dynamically.

4. **JWT Lifecycle**
   - Token is valid for **5 minutes**.
   - After expiration, users must log in again for a new token.

---

##  Technologies Used

| Layer | Technology |
|-------|-------------|
| Backend | Spring Boot 3.x |
| Security | Spring Security, JWT |
| Frontend | Thymeleaf, HTML, CSS |
| Build Tool | Maven |
| Java Version | 17+ |
| Token Handling | JJWT (io.jsonwebtoken) |

---

##  Key Learnings

- Implementing **JWT-based authentication** with expiration logic.  
- Handling **role-based redirection** securely using Spring Security.  
- Creating **custom login success handlers** for post-login logic.  
- Building **responsive, aesthetic UIs** for multiple dashboards.  
- Managing **synchronous flow between token generation and validation**.

---

##  Future Enhancements

-  Add **Swagger UI** for REST API documentation.  
-  Integrate a **database (MySQL / PostgreSQL)** for persistent user and task storage.  
-  Implement **role-based microservices communication**.  
-  Add **asynchronous event handling (Kafka / RabbitMQ)** for task updates.  
-  Include **email-based token sharing** and **audit logging**.  
-  Integrate **frontend frameworks** like React or Angular.

---

##  Sample Credentials

| Role | Username | Password |
|------|-----------|-----------|
| Admin | `admin` | `admin123` |
| User | `user` | `password` |
| Developer | `developer` | `developer123` |

---

##  API Endpoints Summary

| Endpoint | Method | Description |
|-----------|--------|-------------|
| `/login` | POST | Login using form credentials |
| `/validateToken` | GET | Validate the provided JWT token |
| `/admin/assignTask` | POST | Assign a new developer task |
| `/admin/tasks` | GET | View all developer tasks |
| `/user` | GET | Load user dashboard |
| `/developer` | GET | Load developer workspace |

---

##  Contributors

- **Mallapragada Naga Sai Srinivasa Nikhil**

---

##  Contact

 **Email:** nikhil.m@encora.com 

 ---
 **Date Created:** October 10, 2025  
 **Last Updated:** October 10, 2025  

---

 **If you like this project, give it a star on GitHub!** 

