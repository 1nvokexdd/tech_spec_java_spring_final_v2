# Subscription Service API

 REST-сервис для управления пользователями и их подписками.

## 🚀 Запуск проекта

1. Склонируйте репозиторий:
  

2. Соберите и запустите проект:
   ```bash
   mvn clean package -DskipTests
   docker-compose up -d
   ```

Приложение будет доступно по адресу: [http://localhost:8080](http://localhost:8080)

---

## 📘 API Документация

### 👤 Пользователи

#### ➕ Создать пользователя  
**POST** `/users`  
**Пример запроса (raw JSON body):**
```json
{
  "name": "ivan",
  "email": "ivan@gmail.com"
}
```

#### 🔍 Получить информацию о пользователе  
**GET** `/users/{id}`  
Пример:  
```
http://localhost:8080/users/1
```

#### ✏️ Обновить пользователя  
**PUT** `/users/{id}`  
Пример:  
```
http://localhost:8080/users/1
```

**Пример запроса (raw JSON body):**
```json
{
  "name": "Ivan Updated",
  "email": "newemail@gmail.com"
}
```

#### ❌ Удалить пользователя  
**DELETE** `/users/{id}`  
Пример:  
```
http://localhost:8080/users/1
```

---

### 📦 Подписки

#### ➕ Добавить подписку пользователю  
**POST** `/users/{id}/subscriptions`  
Пример:  
```
http://localhost:8080/users/1/subscriptions
```

**Пример запроса (raw JSON body):**
```json
{
  "subscriptionType": "SPOTIFY",
  "startDate": "2025-06-01",
  "endDate": "2025-12-01",
  "monthlyPrice": 32.99
}
```

#### 📋 Получить подписки пользователя  
**GET** `/users/{id}/subscriptions`  
Пример:  
```
http://localhost:8080/users/1/subscriptions
```

#### ❌ Удалить подписку  
**DELETE** `/users/{id}/subscriptions/{sub_id}`  
Пример:  
```
http://localhost:8080/users/1/subscriptions/5
```

---

### 🏆 ТОП-3 популярных подписок  
**GET** `/subscriptions/top`  
Пример:  
```
http://localhost:8080/subscriptions/top
```

---

## 🛠️ Технологии
- Java + Spring Boot
- Maven
- Docker + Docker Compose

---

## 📫 Контакты
miskridevelop@gmail.com

