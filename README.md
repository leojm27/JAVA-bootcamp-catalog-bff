# 🎓 Proyecto Bootcamp - CATALOG-BFF

Este proyecto forma parte del **Bootcamp "Microservicios con Java"** dictado en la plataforma **Código Facilito**.  
Tiene como objetivo aplicar buenas prácticas en arquitecturas basadas en microservicios, utilizando un patrón Backend for Frontend (BFF) para consolidar y exponer información desde múltiples servicios.

---

# 📦 CATALOG-BFF - Backend for Frontend del Catálogo

## 📋 Descripción

**CATALOG-BFF** es un microservicio que actúa como orquestador entres los servicios `ms-product` y `ms-inventory`.
 Combina y formatea los datos provenientes de ambos para exponerlos de manera unificada y optimiza al cliente frontend.

#### ✅ Facilita el consumo de datos complejos
#### ✅ Reduce la lógica del cliente final
#### ✅ Promueve una arquitectura desacoplada

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Cloud OpenFeign
- Maven
- Spring Security
- Springdoc OpenAPI 3.0
- Lombok
- Docker

---

## 📦 Endpoints disponibles

### Catalogo de Productos

- `GET /api/catalogo/productos` -> Retorna una lista consolidada de productos con su información de inventario.
- `GET /api/catalogo/productos/{id}` -> Retorna el detalle de un producto específico, incluyendo su stock.
- `POST /api/catalogo/productos` -> Permite crear un nuevo producto y su inventario, enviando toda la información unificada en un solo DTO.

---

## 🔧 Variables de entorno requeridas

Este servicio depende de la conexión a otros dos microservicios. Asegurate de definir correctamente las URLs base de cada uno:

```env
PRODUCT_URL=http://host.docker.internal:8082
INVENTORY_URL=http://host.docker.internal:8081
```

Si estás ejecutando todo con Docker Compose y en una misma red, podés reemplazar con:
```env
PRODUCT_URL=http://ms-product:8082
INVENTORY_URL=http://ms-inventory:8081
```


Variables para Spring Security:
```env
SECURITY_USERNAME=auth_username
SECURITY_PASSWORD=auth_password
```

## 🐳 Cómo levantar el proyecto con Docker

### 1. Clonar el repositorio
- git clone https://github.com/leojm27/JAVA-bootcamp-catalog-bff.git
- cd JAVA-bootcamp-catalog-bff

### 2. Construir el JAR y la imagen Docker
- desde el IDE y a maven/gradle -> clean, -> package
- docker build -t catalog-bff:v1 .

### 3. Ejecutar con Docker Compose
- docker compose up -d

## 🌐 Acceso
Una vez levantado el contenedor, accedé al servicio CATALOG-BFF desde:
- http://localhost:8080

Si tenés habilitada la documentación Swagger:
- http://localhost:8080/swagger-ui.html




## 🐳 Cómo levantar el proyecto con Docker
### 1. Clonar el repositorio
- git clone https://github.com/leojm27/JAVA-bootcamp-catalog-bff.git
- cd JAVA-bootcamp-catalog-bff
### 2. Construir el JAR y la imagen Docker
- desde el IDE y a maven/gradle -> clean, -> package
- docker build -t catalog-bff:v1 .

### 3. Ejecutar con Docker Compose
- docker compose up -d

## 🌐 Acceso
Una vez levantado el contenedor, accedé al servicio BFF desde:
http://localhost:8080

Si tenés habilitada la documentación Swagger:
http://localhost:8080/swagger-ui.html
