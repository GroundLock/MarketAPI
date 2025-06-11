# 🛒 MarketAPI

A simple REST API for stores, built with Spring Boot.  
You can **add**, **delete**, **update**, and **view products** from your store — all locally and easily via Swagger UI.

---

## 🚀 Features

- Add new products to your store
- View a list of all products
- View product details by ID
- Update existing product information
- Delete products
- Interactive API documentation with Swagger UI

---

## 📦 API Endpoints

All endpoints are prefixed with `/products`:

| Method | Endpoint         | Description                           |
|--------|------------------|---------------------------------------|
| GET    | `/products`      | Retrieve all products                 |
| GET    | `/products/{id}` | Retrieve a product by ID              |
| POST   | `/products`      | Create a new product                  |
| PUT    | `/products/{id}` | Update an existing product by ID      |
| DELETE | `/products/{id}` | Delete a product by ID                |

> Error handling is included for not-found resources on GET, PUT, and DELETE.

---

## 🧰 Tech Stack

- **Java 17**
- **Spring Boot 3.5.0**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Swagger (springdoc-openapi)**
- **dotenv-java** for loading environment variables

---

## ⚙️ Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/your-username/marketapi.git
cd marketapi

2. Configure Environment Variables

Create a .env file in the root directory with your database credentials:

DB_URL=jdbc:postgresql://localhost:5432/yourdbname
DB_USERNAME=yourusername
DB_PASSWORD=yourpassword

    Make sure .env is in your .gitignore!

3. Create the PostgreSQL Database

Create a new database manually using your preferred tool or with:

createdb yourdbname

4. Run the API

./mvnw spring-boot:run

The app will start on http://localhost:8080
📘 API Documentation

Once the app is running, visit the Swagger UI:

🔗 http://localhost:8080/swagger-ui/index.html
🔐 Authentication

This API does not use authentication — it's meant for learning and local development.
🧪 Testing

Unit and integration tests are located in src/test/java/.

Run all tests with:

./mvnw test

🛠 Deployment

This project is designed for local use only.
No production deployment or cloud support is set up.
📄 License

This project is for personal use and learning.
No license is currently applied.
👨‍💻 Author

Made by GroundLock.
Feel free to fork, modify, and learn from it!
