package com.employee.models

class Employee(FirstName: String, LastName: String) {
  var roleName = ""
  var departmentName = ""

  def setRole(role : String): Unit = {
    this.roleName = role
  }

  def setDepartment(department: String): Unit = {
    this.departmentName = department
  }

  def getRole(): String = {
    return this.roleName;
  }

  def getDepartment(): String = {
    return this.departmentName;
  }

}
