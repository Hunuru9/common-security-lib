# 🔐 Generic Common Security Library

This library provides a centralized configuration 
for JWT-based authentication and authorization across all microservices in a distributed system. 
It enables **centralized authentication** (via Keycloak) and **decentralized authorization** 
(role-based access control within each microservice).


---

## 🧩 Features

- ✅ Configures Spring Security with OAuth2 JWT token validation.
- 🔐 Extracts and maps roles from Keycloak tokens (`realm_access.roles`).
- ♻️ Can be reused across multiple microservices via a shared dependency.
- 🧠 Supports `@PreAuthorize`, `@Secured`, and method-level security via `@EnableMethodSecurity`.

---

## 🛠️ Usage

Example how to use this library in this github repository:

[GitHub Repository: generic-user-service](https://github.com/Hunuru9/generic-user-service)

---

