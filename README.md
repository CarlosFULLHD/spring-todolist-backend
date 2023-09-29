# backend-todolist

## Requerimientos

Para correr este proyecto debe tener instalado:

- Java 17
- Maven 3.8.7

PD: Asegurese tener instalado Java correctamente con la version indicada, tener JAVA_HOME configurado
```
java -version
```
Tambien tener maven instalado correctamente

```
mvn -version
```

## Para compilar el proyecto
Asegurese de estar en la carpeta del pom.xml

Es decir ejecutar el proyecto desde su IDE preferido en la carpeta 'spring-todolist-backend'


### Para limpiar el proyecto e instalar dependencias con maven
```
mvn clean install
```

## Ejecución

PD: antes Instale la base de datos por primera vez o vuelva a iniciar al base de datos con docker "docker start todolistdb"
Tambien puedes instalarla desde postgres en local si es lo que deseas.
```
mvn spring-boot:run
```

## Instalación de la Base de Datos

1. Hacer correr una instancia Postgres en docker:

Este codigo nombra el contenedor: "todolistdb", con contraseña: "123456"

Para conectarse desde nuestro puerto: "5432" hacia el puerto "5432"(NO CAMBIAR ESTE, viene por defecto para conectarse a postgres correctamente)

Descargando como imagen postgres de la version "16"(ultima version octubre-2023)


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


3. Ejecutan el script "init.sql" de la carpeta "database".

4. Para datos de prueba ejecuten "dataexample.sql" dentro de postgres
---

Nota: Una vez hecho el paso 1, para volver a correr el contenedor de docker(que tiene la base de datos)

```
docker start todolistdb
```