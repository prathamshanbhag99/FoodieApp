# FoodieAPP-TEAM A
## Overview

### **FoodieApp API Project**
This project is the backend API for the **FoodieApp** platform. It allows users to:
- Create, update, retrieve, and delete restaurant and order details.
- Handle user management (create, retrieve, and update user information).
- The API is developed using **Spring Boot** and connected to a **MongoDB** database.

#### **Key Features**:
- **User Management**: APIs for user registration, updating user details, and fetching user information.
- **Restaurant Management**: Create, retrieve, and manage restaurants and their details.
- **Order Management**: Create and track orders associated with users and restaurants.

### **Test Automation Project (FoodieApp Rest-Assured)**
This project automates the API testing for the **FoodieApp API** using the **Rest-Assured** and **Cucumber** frameworks. It ensures that the API endpoints function as expected and returns the correct responses.

#### **Key Features**:
- **Cucumber BDD Scenarios**: Test scenarios are written in Gherkin syntax, making them easily readable and maintainable.
- **Rest-Assured**: Used to send API requests and validate responses for the FoodieApp API.
- **Extent Reports**: Provides detailed, interactive reports for each test run, showing the pass/fail status of individual test cases.


## **Setup Instructions**

### **1. FoodieApp API Project**
1. Clone or download the **FoodieApp API Project** repository.
2. Set up the **MongoDB** database (locally or on MongoDB Atlas) and update the \`application.properties\` with the database credentials.
3. Run the application:
   - In your IDE, run the \`FoodieAppApplication\` class (or use the following Maven command):
     \`\`\`bash
     mvn spring-boot:run
     \`\`\`

### **2. FoodieApp Test Automation Project**
1. Clone or download the **FoodieApp Test Automation Project** repository.
2. Install the necessary dependencies:
3. Ensure that the **FoodieApp API Project** is running, as the test automation project interacts with it.

---

## **Running the Tests**


### **Using IntelliJ IDEA**
1. Navigate to the \`TestRunner\` class.
2. Right-click and select **Run** to execute the tests.

---

## **Reports**

- **Extent Report**: \`target/extent-report/spark.html\`

---

## **Dependencies**

### **FoodieApp API Project**
- **Spring Boot**: For building the REST API.
- **Spring Data MongoDB**: For interacting with MongoDB.
- **Spring Security**: For handling user authentication and authorization.

### **FoodieApp Test Automation Project**
- **Rest-Assured**: For making API requests and validating responses.
- **Cucumber**: For writing BDD-style test scenarios.
- **JUnit**: For running the tests.
- **Extent Reports**: For generating detailed test execution reports.

---




