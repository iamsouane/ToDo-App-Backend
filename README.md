````md
# 🚀 ToDo App Backend API

API de gestion de tâches développée avec **Spring Boot**, sécurisée avec **Spring Security + JWT**, et déployée sur Render.

---

## 🌍 URL de l’API (en ligne)

👉 https://todo-app-backend-qd7x.onrender.com

---

## ⚙️ Technologies utilisées

- Java 17+
- Spring Boot
- Spring Web
- Spring Security
- JWT (JSON Web Token)
- Maven
- Render (déploiement)

---

## 🔐 Authentification (JWT)

Cette API utilise une authentification basée sur **JWT**.

### 👤 Utilisateur de test

```json
{
  "username": "user",
  "password": "user123"
}
````

---

## 🔑 Connexion (Login)

### ➤ Endpoint

```http
POST /auth/login
```

### ➤ URL (en ligne)

```text
https://todo-app-backend-qd7x.onrender.com/auth/login
```

### ➤ Body (JSON)

```json
{
  "username": "user",
  "password": "user123"
}
```

### ➤ Réponse

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

## 🔒 Utilisation du Token

Pour accéder aux routes protégées, ajouter ce header :

```http
Authorization: Bearer YOUR_TOKEN
```

---

## 📌 Endpoints API

### 📋 Récupérer toutes les tâches

```http
GET /tasks
```

---

### ➕ Créer une tâche

```http
POST /tasks
```

### Body

```json
{
  "title": "Apprendre Spring Boot",
  "description": "Projet ToDo API",
  "completed": false
}
```

---

### ✏️ Modifier une tâche

```http
PUT /tasks/{id}
```

### Body

```json
{
  "title": "Titre modifié",
  "description": "Description modifiée",
  "completed": true
}
```

---

### ❌ Supprimer une tâche

```http
DELETE /tasks/{id}
```

---

## 🧪 Guide de test avec Postman

### 1. Login

* Method: POST
* URL:

```
https://todo-app-backend-qd7x.onrender.com/auth/login
```

* Body → raw JSON :

```json
{
  "username": "user",
  "password": "user123"
}
```

👉 Copier le token retourné

---

### 2. Accès aux tâches

* Method: GET
* URL :

```
https://todo-app-backend-qd7x.onrender.com/tasks
```

* Headers :

```
Authorization: Bearer YOUR_TOKEN
```

---

## 🧪 Test en local

```text
http://localhost:8080
```

---

## 🧠 Architecture

```
Controller → Service → Repository → Database
                ↓
       Spring Security + JWT Filter
```

---

## 🚀 Déploiement

Déployé sur Render avec Docker.

---

## 👨‍💻 Auteur

Projet réalisé par Serigne Ismaila SOUANE pour apprentissage backend :

* Spring Boot REST API
* Spring Security
* JWT Authentication
* Docker & Render deployment

---

## 🎯 Améliorations futures

* [ ] Base de données MySQL
* [ ] Refresh Token
* [ ] Roles (USER / ADMIN)
* [ ] Pagination
* [ ] Frontend React

```
