# backend-todolist

## Requerimientos

Para correr este proyecto debe tener instalado:

- Java 11
- Maven 3.8.4

## Para compilar el proyecto
Asegurese de estar en la carpeta del pom.xml

```
mvn clean install
```

## Ejecución

```
mvn spring-boot:run
```

## Instalación de la Base de Datos

1. Hacer correr una instancia Postgres en docker

```
docker run --name todolistdb -e POSTGRES_PASSWORD=123456 -p 5432:5432 -d postgres:16
```

2. Me conecto a la DB database:"todolistdb" password:"123456"

   Conexion mediante DataGrip
```
Host: localhost
Posrt: 5432
Authenticacion: User & Password
User: postgres
Password: 123456
Database: postgres
```
Se hace "Test Connection con esas credenciales y se conecta con Datagrip"

3. Creamos la Base de Datos de la todolistdb

```
CREATE DATABASE todolistdb;
```

4. Creamos la Base de Datos de la todolistdb.

```
 \c todolistdb;
```

5. Ejecutan el script "init.sql" de la carpeta "database".

---

Nota: Una vez hecho el paso 1, para volver a correr el contenedor de docker(que tiene la base de datos)

```
docker start todolistdb
```