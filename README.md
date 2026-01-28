# AAIB_API_Automation-Task

---

# 🚀 API Automation Framework – ReqRes User Workflow

This project is a **REST API Automation Framework** built using **Java, Rest Assured, TestNG, Maven, and Allure Reporting**. It automates a complete **User Management Workflow** using the public API:

🔗 [https://reqres.in/](https://reqres.in/)

---

## 🎯 Project Objective

The goal of this project is to design and implement automated API tests that perform a full user lifecycle:

* Create a user
* Update the user
* Retrieve user details
* Delete the user
* Verify deletion

It demonstrates **API request chaining**, where data from one response is extracted and reused in subsequent requests.

---
---

## 📊 Allure Report


### Generate Report

```
mvn clean test

allure generate allure-results -o allure-report --clean

allure open allure-report
```

This will open a browser showing:

* Test execution status
* Pass/Fail summary
* Error details
* Test hierarchy

as below
<img width="1881" height="877" alt="image" src="https://github.com/user-attachments/assets/ed2f2fba-2d95-44f3-8b3d-8e85bf44e2fe" />
<img width="1859" height="867" alt="image" src="https://github.com/user-attachments/assets/153c835b-2f69-4878-88ca-964b38bc6f3d" />

---


## 🧰 Tech Stack

| Tool             | Purpose                       |
| ---------------- | ----------------------------- |
| **Java**         | Programming language          |
| **Rest Assured** | API automation                |
| **TestNG**       | Test framework                |
| **Maven**        | Build & dependency management |
| **Allure**       | Test reporting                |

---

## 🏗 Framework Structure

```
src
 └── test
     ├── java
     │   └── tests       → API test classes
     └── resources
         └── testng.xml  → Test suite configuration
```

---

## 🔄 Automated Test Workflow

| Step | API Endpoint           | Validation                       |
| ---- | ---------------------- | -------------------------------- |
| 1    | **POST /users**        | User created (201) & ID captured |
| 2    | **PUT /users/{id}**    | Job updated successfully (200)   |
| 3    | **GET /users/{id}**    | API response validated           |
| 4    | **DELETE /users/{id}** | User deleted (204)               |
| 5    | **GET /users/{id}**    | User not found (404)             |

> ⚠️ **Note:** ReqRes is a mock API and does not persist created users. Some GET validations rely on simulated responses.

---

## 🔗 Key Automation Concept

### Response Data Extraction & Reuse

```java
userId = response.jsonPath().getString("id");
```

The extracted **userId** is reused in PUT, GET, and DELETE requests.

---


## 🧠 What This Project Demonstrates

✔ API Automation using Rest Assured
✔ TestNG Framework Structure
✔ API Data Chaining
✔ Reporting with Allure
✔ Clean project architecture


## 👨‍💻 Author

**Omar**
SW Testing Engineer
