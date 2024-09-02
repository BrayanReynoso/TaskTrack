# TaskTrack
TaskTrack es un sistema de gestión de empleados y proyectos desarrollado con Java Spring Boot. Este sistema permite administrar empleados, departamentos, proyectos y asignaciones de manera eficiente. Ideal para pequeñas y medianas empresas que necesitan mantener un control sobre su personal y los proyectos en los que trabajan.
## Características
- Gestión de empleados: CRUD completo para gestionar el personal de la empresa.
- Gestión de departamentos: CRUD para organizar empleados en departamentos.
- Gestión de proyectos: CRUD para gestionar los proyectos activos y finalizados.
- Asignación de proyectos: Asignación de empleados a proyectos con roles específicos.
## Requisitos del Sistema
- Java 17 
- Spring Boot v3.3.3
- Maven
- Base de datos MySQL
- IDE recomendado: IntelliJ IDEA o Eclipse
## Instalación y Configuración
### Requisitos Previos

Asegúrate de tener las siguientes herramientas instaladas en tu máquina:

- [Java JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

### Clonar el Repositorio

Clona el repositorio del proyecto usando Git:

```bash
git clone https://github.com/BrayanReynoso/TaskTrack.git
cd TaskTrack
```
### Configuración del archivo `application.properties`

Configura los detalles del entorno en el archivo `src/main/resources/application.properties`. A continuación, se muestra un ejemplo de configuración:

```properties
# Nombre de la aplicación
spring.application.name=api-tasktrack

# Configuración de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/TaskTrack?useSLL=false&serverTimeZone=UTC&useLegacyDateTimeCode=false&createDatabaseIfNotExist=true
spring.datasource.username=username
spring.datasource.password=password

# Configuración de JPA e Hibernate
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

# URL base de la API
API-URL=/api-TaskTrack
```
## Endpoints API
### Empleados
- `GET /employees/`: Obtener todos los empleados de la lista.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": [
        {
            "id": 1,
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@example.com",
            "salary": 60000.0,
            "hireDate": "2021-01-15T06:00:00.000+00:00",
            "status": true,
            "department": {
                "id": 1,
                "name": "IT",
                "description": "Tecnologías de la información",
                "status": true
            }
        },
        {
            "id": 2,
            "firstName": "Mike",
            "lastName": "Brown",
            "email": "mike.brown@example.com",
            "salary": 60000.0,
            "hireDate": "2022-03-10T00:00:00.000+00:00",
            "status": true,
            "department": {
                "id": 1,
                "name": "IT",
                "description": "Tecnologías de la información",
                "status": true
            }
        }
    ],
    "code": 200,
    "message": "OK",
    "error": false
  }
- `GET /employees/john.doe@example.com`: Obtener un solo empleado de la lista mediante el email.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": {
        "id": 1,
        "firstName": "John",
        "lastName": "Doe",
        "email": "john.doe@example.com",
        "salary": 60000.0,
        "hireDate": "2021-01-15T06:00:00.000+00:00",
        "status": false,
        "department": {
            "id": 1,
            "name": "IT",
            "description": "Tecnologías de la información",
            "status": true
        }
    },
    "code": 200,
    "message": "Employee found",
    "error": false
  }

- `POST /employees/register`: Registrar un nuevo empleado.
  **Ejemplo de body:**
  ```json
  {
    "firstName": "Mike",
    "lastName": "Brown",
    "email": "mike.brown@example.com",
    "salary": 50000.0,
    "hireDate": "2022-03-10",
    "status": true,
    "department": {
        "id": 1
    }
  }

- `PUT /employees/update`: Actualizar un nuevo empleado.
  **Ejemplo de body:**
  ```json
  {
    "id": 2,
    "firstName": "Mike",
    "lastName": "Brown",
    "email": "mike.brown@example.com",
    "salary": 50000.0,
    "hireDate": "2022-03-10",
    "status": true,
    "department": {
        "id": 1
    }
  }
 - `DELETE /employees/status/john.doe@example.com`: Cambiar el status de un empleado.
  **Ejemplo de Respuesta:**
  ```json
 {
     "data": {
         "id": 1,
         "firstName": "John",
         "lastName": "Doe",
         "email": "john.doe@example.com",
         "salary": 60000.0,
         "hireDate": "2021-01-15T06:00:00.000+00:00",
         "status": false,
         "department": {
             "id": 1,
             "name": "IT",
             "description": "Tecnologías de la información",
             "status": true
         }
     },
     "code": 200,
     "message": "The employee's status has been updated",
     "error": false
}
```

### Departamentos
- `GET /department/`: Obtener la lista de departamentos.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": [
      {
        "id": 1,
        "name": "IT",
        "description": "Tecnologías de la información",
        "status": true
      },
      {
        "id": 2,
        "name": "RH",
        "description": "Recursos Humanos",
        "status": true
      }
    ],
    "code": 200,
    "message": "OK",
    "error": false
  }
- `GET /department/id`: Obtener un departamento registrado mediante el id.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": {
        "id": 1,
        "name": "IT",
        "description": "Tecnologías de la información",
        "status": true
    },
    "code": 200,
    "message": "Department found",
    "error": false
  }
 - `POST /department/register`: Registrar un nuevo departamentos.
  **Ejemplo de Body:**
  ```json
  {
    "name": "HR",
    "description": "Recursos Humanos",
    "status": true
  }
```
- `PUT /department/update`: Actualizar un departamento.
  **Ejemplo de Body:**
  ```json
  {
    "id": 2,
    "name": "HR",
    "description": "Recursos Humanos",
    "status": false
  }
 - `DELETE /department/status/id`: Cambiar el status de un departamento mediante el id.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": {
        "id": 1,
        "name": "IT",
        "description": "Tecnologías de la información",
        "status": false
    },
    "code": 200,
    "message": "The department status has been changed successfully",
    "error": false
}
```
### Proyectos
- `GET /project/`: Obtener la lista de proyectos.
  **Ejemplo de Respuesta:**
```json
  {
    "data": [
        {
            "id": 1,
            "name": "Rediseño del sitio web",
            "description": "Rediseño de la página web de la empresa.",
            "startDate": "2023-01-01T06:00:00.000+00:00",
            "endDate": "2023-06-01T06:00:00.000+00:00",
            "budget": 20000.0,
            "status": false,
            "assignments": [
                {
                    "id": 1,
                    "role": "UI/UX Designer",
                    "assignmentDate": "2023-01-05T06:00:00.000+00:00",
                    "status": true,
                    "employee": {
                        "id": 1,
                        "firstName": "John",
                        "lastName": "Doe",
                        "email": "john.doe@example.com",
                        "salary": 60000.0,
                        "hireDate": "2021-01-15T06:00:00.000+00:00",
                        "status": false,
                        "department": {
                            "id": 1,
                            "name": "IT",
                            "description": "Tecnologías de la información",
                            "status": false
                        }
                    }
                }
            ]
        },
        {
            "id": 2,
            "name": "Aplicación móvil",
            "description": "Desarrollo de nueva aplicación móvil.",
            "startDate": "2022-05-01T06:00:00.000+00:00",
            "endDate": "2022-12-31T06:00:00.000+00:00",
            "budget": 40000.0,
            "status": false,
            "assignments": [
                {
                    "id": 2,
                    "role": "Cloud Engineer",
                    "assignmentDate": "2023-03-01T06:00:00.000+00:00",
                    "status": true,
                    "employee": {
                        "id": 2,
                        "firstName": "Mike",
                        "lastName": "Brown",
                        "email": "mike.brown@example.com",
                        "salary": 80000.0,
                        "hireDate": "2022-03-10T00:00:00.000+00:00",
                        "status": true,
                        "department": {
                            "id": 1,
                            "name": "IT",
                            "description": "Tecnologías de la información",
                            "status": false
                        }
                    }
                }
            ]
        }
    ],
    "code": 200,
    "message": "OK",
    "error": false
}

```
- `GET /project/id`: Obtener un proyecto de la lista.
  **Ejemplo de Respuesta:**
```json
   {
    "data": {
        "id": 1,
        "name": "Rediseño del sitio web",
        "description": "Rediseño de la página web de la empresa.",
        "startDate": "2023-01-01T06:00:00.000+00:00",
        "endDate": "2023-06-01T06:00:00.000+00:00",
        "budget": 20000.0,
        "status": false,
        "assignments": [
            {
                "id": 1,
                "role": "UI/UX Designer",
                "assignmentDate": "2023-01-05T06:00:00.000+00:00",
                "status": true,
                "employee": {
                    "id": 1,
                    "firstName": "John",
                    "lastName": "Doe",
                    "email": "john.doe@example.com",
                    "salary": 60000.0,
                    "hireDate": "2021-01-15T06:00:00.000+00:00",
                    "status": false,
                    "department": {
                        "id": 1,
                        "name": "IT",
                        "description": "Tecnologías de la información",
                        "status": false
                    }
                }
            }
        ]
    },
    "code": 200,
    "message": "Project found",
    "error": false
  }
```
- `POST /project/register`: Registrar un nuevo proyecto.
  **Ejemplo de Body:**
```json
   {
    "name": "Aplicación móvil",
    "description": "Desarrollo de nueva aplicación móvil.",
    "startDate": "2022-05-01T06:00:00.000+00:00",
    "endDate": "2022-12-31T06:00:00.000+00:00",
    "budget": 50000.00,
    "status": true
    
  }
```
- `PUT /project/update`: Actualizar un proyecto.
  **Ejemplo de Body:**
```json
    {
    "id": 2,
    "name": "Aplicación móvil",
    "description": "Desarrollo de nueva aplicación móvil.",
    "startDate": "2022-05-01T06:00:00.000+00:00",
    "endDate": "2022-12-31T06:00:00.000+00:00",
    "budget": 40000.00,
    "status": true
    }
```
- `DELETE /project/status/id`: Cambiar el status de un proyecto.
  **Ejemplo de Respuesta:**
```json
    {
    "data": {
        "id": 1,
        "name": "Rediseño del sitio web",
        "description": "Rediseño de la página web de la empresa.",
        "startDate": "2023-01-01T06:00:00.000+00:00",
        "endDate": "2023-06-01T06:00:00.000+00:00",
        "budget": 20000.0,
        "status": false,
        "assignments": [
            {
                "id": 1,
                "role": "UI/UX Designer",
                "assignmentDate": "2023-01-05T06:00:00.000+00:00",
                "status": true,
                "employee": {
                    "id": 1,
                    "firstName": "John",
                    "lastName": "Doe",
                    "email": "john.doe@example.com",
                    "salary": 60000.0,
                    "hireDate": "2021-01-15T06:00:00.000+00:00",
                    "status": false,
                    "department": {
                        "id": 1,
                        "name": "IT",
                        "description": "Tecnologías de la información",
                        "status": false
                    }
                }
            }
        ]
    },
    "code": 200,
    "message": "",
    "error": false
   }
```
### Asignaciones
- `GET /asigment/`: Obtener la lista de proyectos.
  **Ejemplo de Respuesta:**
```json
{
    "data": [
        {
            "id": 1,
            "name": "Rediseño del sitio web",
            "description": "Rediseño de la página web de la empresa.",
            "startDate": "2023-01-01T06:00:00.000+00:00",
            "endDate": "2023-06-01T06:00:00.000+00:00",
            "budget": 20000.0,
            "status": false,
            "assignments": [
                {
                    "id": 1,
                    "role": "UI/UX Designer",
                    "assignmentDate": "2023-01-05T06:00:00.000+00:00",
                    "status": true,
                    "employee": {
                        "id": 1,
                        "firstName": "John",
                        "lastName": "Doe",
                        "email": "john.doe@example.com",
                        "salary": 60000.0,
                        "hireDate": "2021-01-15T06:00:00.000+00:00",
                        "status": false,
                        "department": {
                            "id": 1,
                            "name": "IT",
                            "description": "Tecnologías de la información",
                            "status": false
                        }
                    }
                }
            ]
        },
        {
            "id": 2,
            "name": "Aplicación móvil",
            "description": "Desarrollo de nueva aplicación móvil.",
            "startDate": "2022-05-01T06:00:00.000+00:00",
            "endDate": "2022-12-31T06:00:00.000+00:00",
            "budget": 40000.0,
            "status": false,
            "assignments": [
                {
                    "id": 2,
                    "role": "Cloud Engineer",
                    "assignmentDate": "2023-03-01T06:00:00.000+00:00",
                    "status": true,
                    "employee": {
                        "id": 2,
                        "firstName": "Mike",
                        "lastName": "Brown",
                        "email": "mike.brown@example.com",
                        "salary": 80000.0,
                        "hireDate": "2022-03-10T00:00:00.000+00:00",
                        "status": true,
                        "department": {
                            "id": 1,
                            "name": "IT",
                            "description": "Tecnologías de la información",
                            "status": false
                        }
                    }
                }
            ]
        }
    ],
    "code": 200,
    "message": "OK",
    "error": false
}
```
- `GET /assignment/id`: Obtener una asignacion de la lista mediante id.
  **Ejemplo de Respuesta:**
```json
{
    "data": {
        "id": 1,
        "name": "Rediseño del sitio web",
        "description": "Rediseño de la página web de la empresa.",
        "startDate": "2023-01-01T06:00:00.000+00:00",
        "endDate": "2023-06-01T06:00:00.000+00:00",
        "budget": 20000.0,
        "status": false,
        "assignments": [
            {
                "id": 1,
                "role": "UI/UX Designer",
                "assignmentDate": "2023-01-05T06:00:00.000+00:00",
                "status": true,
                "employee": {
                    "id": 1,
                    "firstName": "John",
                    "lastName": "Doe",
                    "email": "john.doe@example.com",
                    "salary": 60000.0,
                    "hireDate": "2021-01-15T06:00:00.000+00:00",
                    "status": false,
                    "department": {
                        "id": 1,
                        "name": "IT",
                        "description": "Tecnologías de la información",
                        "status": false
                    }
                }
            }
        ]
    },
    "code": 200,
    "message": "Project found",
    "error": false
}
```
- `POST /assignment/register`: Registrar una nueva asignacion.
  **Ejemplo de Body:**
```json
   {
        "role": "Cloud Engineer",
        "assignmentDate": "2023-01-05T06:00:00.000+00:00",
        "status": true,
        "employee": {
            "id": 1
        },
        "department": {
            "id": 1
        }
    }
```
- `PUT /assignment/update`: Actualizar una asignacion.
  **Ejemplo de Body:**
```json
{
    "id": 2,
    "role": "Cloud Engineer",
    "assignmentDate": "2023-03-01T06:00:00.000+00:00",
    "status": true,
    "employee": {
        "id": 2   
    },
    "department": {
        "id": 1
    }
}
```
- `DELETE /assignment/status/id`: Cambiar el status de una asignacion.
  **Ejemplo de Respuesta:**
  ```json
  {
    "data": {
        "id": 1,
        "role": "UI/UX Designer",
        "assignmentDate": "2023-01-05T06:00:00.000+00:00",
        "status": false,
        "employee": {
            "id": 1,
            "firstName": "John",
            "lastName": "Doe",
            "email": "john.doe@example.com",
            "salary": 60000.0,
            "hireDate": "2021-01-15T06:00:00.000+00:00",
            "status": false,
            "department": {
                "id": 1,
                "name": "IT",
                "description": "Tecnologías de la información",
                "status": false
            }
        }
    },
    "code": 200,
    "message": "The status change has been carried out correctly",
    "error": false
  }
