# Homework1 - Spring Boot Application

## Run
```bash
./mvnw spring-boot:run
```
Runs on **http://localhost:8081**

## Credentials

| Username | Password | Role | Access |
|----------|----------|------|--------|
| `admin` | `admin` | ADMIN | Full CRUD |
| `user` | `password` | USER | Read only |

## API Endpoints

**Login:**
```bash
POST /api/auth/login
Body: {"username":"admin","password":"admin"}
```

**Products (requires JWT token):**
```bash
GET    /api/products
GET    /api/products/{id}
POST   /api/products       # ADMIN only
PUT    /api/products/{id}  # ADMIN only
DELETE /api/products/{id}  # ADMIN only
```

**Actuator:**
```bash
GET /actuator/health
GET /actuator/prometheus
```

## Quick Test

1. Login and get token:
```bash
curl -X POST http://localhost:8081/api/auth/login ^
  -H "Content-Type: application/json" ^
  -d "{\"username\":\"admin\",\"password\":\"admin\"}"
```

2. Create product with token:
```bash
curl -X POST http://localhost:8081/api/products ^
  -H "Content-Type: application/json" ^
  -H "Authorization: Bearer YOUR_TOKEN" ^
  -d "{\"name\":\"Laptop\",\"description\":\"Gaming laptop\",\"price\":1500.00}"
```

3. Get products:
```bash
curl http://localhost:8081/api/products ^
  -H "Authorization: Bearer YOUR_TOKEN"
```
