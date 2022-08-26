# Week2-2
## 1. JPA + Mybatis
### JPA - /api/v1/ 
Reuse from https://github.com/phaptrinh/BackendWeek2-1
### Mybatis - /api/v2/
2 new APIs:
- GET /api/v2/departments/{id}
- GET /api/v2/employees/{id}
### Comparing 
#### Get department by id
##### Mybatis - GET /api/v2/departments/1
```json
{
  "status": "success",
  "data": {
    "departmentId": 1,
    "deptName": "Phong 1",
    "desciption": "Phong so 1",
    "employeeNum": 3
  },
  "message": null
}
```

##### JPA - GET /api/v1/departments/1
```json
{
  "status": "success",
  "data": {
    "departmentId": 1,
    "deptName": "Phong 1",
    "desciption": "Phong so 1",
    "employees": [
      {
        "employeeId": 4,
        "name": "Nhan vien 1",
        "birthDate": "2002-01-01",
        "gender": "Nu"
      },
      {
        "employeeId": 6,
        "name": "Nhan vien 3",
        "birthDate": "2004-01-01",
        "gender": "Nu"
      },
      {
        "employeeId": 5,
        "name": "Nhan vien 2",
        "birthDate": "2003-01-01",
        "gender": "Nam"
      }
    ]
  },
  "message": null
}
```
---
#### Get employee by id
##### Mybatis - GET /api/v2/employees/4
```json
{
    "status": "success",
    "data": {
        "employeeId": 4,
        "name": "Nhan vien 1",
        "birthDate": "2001-12-31T17:00:00.000+00:00",
        "gender": "Nu",
        "departmentId": 1,
        "deptName": "Phong 1",
        "desciption": "Phong so 1"
    },
    "message": null
}
```

##### JPA - GET /api/v1/employees/4
```json
{
  "status": "success",
  "data": {
    "employeeId": 4,
    "name": "Nhan vien 1",
    "birthDate": "2002-01-01",
    "gender": "Nu",
    "departmentId": 1
  },
  "message": null
}
```
---
## 2. Singleton + Factory Method
API:
- GET /factory-method/{type}
##### GET /factory-method/server

```json
{
  "singleton": {
    "computerFactory.toString()": "com.example.week22.designpattern.factoryclass.ComputerFactory@1da69096"
  },
  "factoryMethod": {
    "computer.getType()": "Server",
    "computer.getClass()": "class com.example.week22.designpattern.subclass.Server"
  }
}
```
---
##### GET /factory-method/pc
```json
{
  "singleton": {
    "computerFactory.toString()": "com.example.week22.designpattern.factoryclass.ComputerFactory@1da69096"
  },
  "factoryMethod": {
    "computer.getType()": "PC",
    "computer.getClass()": "class com.example.week22.designpattern.subclass.PC"
  }
}
```
