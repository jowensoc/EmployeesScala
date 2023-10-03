package com.employee.models

class ServiceResponse() {
  var success = false;
  var message = ""
  var listOfEmployees: List[Employee] = List[Employee]
  var listOfDepartments: List[String] = List[String]
  var listOfRoles: List[String] = List[String]
}


