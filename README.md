# TaskTrack
TaskTrack es un sistema de gestión de empleados y proyectos desarrollado con Java Spring Boot. Este sistema permite administrar empleados, departamentos, proyectos y asignaciones de manera eficiente. Ideal para pequeñas y medianas empresas que necesitan mantener un control sobre su personal y los proyectos en los que trabajan.
## Características
- Gestión de empleados: CRUD completo para gestionar el personal de la empresa.
- Gestión de departamentos: CRUD para organizar empleados en departamentos.
- Gestión de proyectos: CRUD para gestionar los proyectos activos y finalizados.
- Asignación de proyectos: Asignación de empleados a proyectos con roles específicos.
## Endpoints API
### Empleados
- `GET /employees`: Obtener la lista de empleados.
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
        }
    ],
    "code": 200,
    "message": "OK",
    "error": false
  }
```
- `GET /department`: Obtener la lista de departamentos.
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
            "description": "Recursos humanos",
            "status": true
        }
    ],
    "code": 200,
    "message": "OK",
    "error": false
}
```

- `GET /project`: Obtener la lista de proyectos.
  **Ejemplo de Respuesta:**
```json
  {
    "data": [
        {
            "id": 1,
            "name": "Rediseño del sitio web",
            "description": "Rediseño de la página web de la empresa",
            "startDate": "2023-01-01T06:00:00.000+00:00",
            "endDate": "2023-06-01T06:00:00.000+00:00",
            "budget": 20000.0,
            "status": true,
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
                        "status": true,
                        "department": {
                            "id": 1,
                            "name": "IT",
                            "description": "Tecnologías de la información",
                            "status": true
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
