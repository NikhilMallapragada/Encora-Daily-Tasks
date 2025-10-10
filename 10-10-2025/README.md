#  Employee–Order Microservices System  
A microservices-based system demonstrating **synchronous communication** between services using **Spring Boot** and **REST APIs**.

---

##  Project Overview  
This project showcases a **simple and modern microservices architecture** where two independent services — **Employee Service** and **Order Service** — communicate **synchronously** using **RESTful APIs**.  

The **Order Service** provides product/order information, and the **Employee Service** fetches that information via HTTP calls using Spring’s `RestTemplate`.  
This setup is ideal for understanding how one service can directly interact with another in a **request–response** manner.

---

##  Architecture  

The system follows a **two-service microservices architecture** pattern with **synchronous communication**:

- **Order Service** → Manages order information (ID, name, price)  
- **Employee Service** → Requests order data from Order Service and provides combined responses  

 **System Flow**
Client → Employee Service → Order Service → Employee Service → Response

---

##  Features  

-  **Order Management:** Fetch order details by ID  
-  **Employee Service:** Retrieves and processes order info  
-  **Synchronous REST Communication:** Real-time request–response between services  
-  **Inter-service Call Using RestTemplate**  
-  **Scalable & Modular:** Each service runs independently  

---

##  Technology Stack  

| Component | Technology |
|------------|-------------|
|  Backend Framework | Spring Boot |
|  Communication | REST API (HTTP) |
|  Inter-Service Call | RestTemplate |
|  Build Tool | Maven |
|  Data Format | JSON |
|  Annotation Support | Lombok |

---

##  Project Modules  

###  **Order Service**
- Manages and returns product/order data  
- Provides REST endpoint to retrieve orders by ID  

**Package Structure:**

com.ordertest.Emp_Order_Service
│
├── Model/
│ └── Order.java
│
├── Controller/
│ └── OrderController.java
│
└── EmpOrderServiceApplication.java


---

###  **Employee Service**
- Calls Order Service using `RestTemplate`  
- Merges the response with additional messages  

**Package Structure:**
com.employeetest.Emp_Employee_Service
│
├── model/
│ └── Employee.java
│
├── controller/
│ └── EmployeeController.java
│
└── EmpEmployeeServiceApplication.java


---

##  Prerequisites  

- **Java 21+**  
- **Maven 3.8+**  
- **Spring Boot 3.0+**  
- Any IDE (IntelliJ / Eclipse / VS Code)  

---

##  Setup Instructions  

###  Run **Order Service**

cd Emp_Order_Service
mvn spring-boot:run
Runs on port 8081

##  Communication Flow

1. The **client** sends a request to **Employee Service** → `/employee/getOrder/{id}`
2. **Employee Service** calls **Order Service** → `/Order/{id}` using **RestTemplate**
3. **Order Service** returns the **order data**
4. **Employee Service** adds a **success message** and returns a **combined response**

---

##  Key Learnings

- Understand **synchronous inter-service communication**
- Use **RestTemplate** for calling other microservices
- Learn **microservice separation** and **modular design**
- Observe how one service depends on another **in real time**

---

##  Future Enhancements

-  Integrate **Swagger UI** for API documentation  
-  Replace **RestTemplate** with **Feign Client** for cleaner code  
-  Add **Service Discovery (Eureka)** for dynamic service lookup  
-  Add **centralized logging and monitoring**  
-  Implement **Asynchronous Communication** with **Kafka** or **RabbitMQ**

---

##  Contributors

- **Mallapragada Naga Sai Srinivasa Nikhil**

---

## 📬 Contact

 **Email:** nikhil.m@encora.com  
 **Date Created:** October 10, 2025  
 **Last Updated:** October 10, 2025
