package com.employees.services

import com.employee.services.IEmployeeService
import com.employee.models.{Employee, SearchParameters, ServiceResponse}

import scala.collection.mutable.ListBuffer

object EmployeeService {

  val listOfEmployees = ListBuffer[Employee]()
  val listOfDepartments = ListBuffer[String]()
  val listOfRoles = ListBuffer[String]()

  private def createServiceResponse(success: Boolean, message: String): ServiceResponse = {
    var serviceResponse = new ServiceResponse()
    serviceResponse.success = success
    serviceResponse.message = message

    serviceResponse
  }

  def SaveEmployee(employee: Employee): ServiceResponse = {
    val exists = listOfEmployees.exists(item => item.FirstName == employee.FirstName && item.LastName == employee.LastName)
    var success = false;
    var message = ""

    if (exists) {
      message = "Employee already exists"
    } else {
      listOfEmployees.addOne(employee)
      success = true
      message = "Saved Employee"
    }

    createServiceResponse(success, message)
  }

  def SaveRole(roleName: String): ServiceResponse = {
    val exists = listOfRoles.contains(roleName)
    var success = false;
    var message = ""

    if (exists) {
      message = "Role already exists"
    } else {
      listOfRoles.addOne(roleName)
      success = true
      message = "Saved Roles"
    }

    createServiceResponse(success, message)
  }

  def SaveDepartment(departmentName: String): ServiceResponse = {
    val exists = listOfDepartments.contains(departmentName)
    var success = false;
    var message = ""

    if (exists) {
      message = "Department already exists"
    } else {
      listOfDepartments.addOne(departmentName)
      success = true
      message = "Saved Department"
    }

    createServiceResponse(success, message)
  }

  def DeleteEmployee(employee: Employee): ServiceResponse = {
    val exists = listOfEmployees.exists(item => item.FirstName == employee.FirstName && item.LastName == employee.LastName)
    var success = false;
    var message = ""

    if (!exists) {
      message = "Employee does not exists"
    } else {
      var idx  = listOfEmployees.indexWhere(item => item.FirstName == employee.FirstName && item.LastName == employee.LastName)

      listOfEmployees.remove(idx)
      success = true
      message = "Deleted Employee"
    }

    createServiceResponse(success, message)
  }

  def DeleteDepartment(departmentName: String): ServiceResponse = {
    val exists = listOfDepartments.contains(departmentName)
    var success = false;
    var message = ""

    if (!exists) {
      message = "Department does not exists"
    } else {
      val idx = listOfDepartments.indexOf(departmentName)

      listOfDepartments.remove(idx)
      success = true
      message = "Deleted Department"
    }

    createServiceResponse(success, message)
  }

  def DeleteRole(roleName: String): ServiceResponse = {
    val exists = listOfRoles.contains(roleName)
    var success = false;
    var message = ""

    if (!exists) {
      message = "Role does not exists"
    } else {
      val idx = listOfRoles.indexOf(roleName)

      listOfRoles.remove(idx)
      success = true
      message = "Deleted Roles"
    }

    createServiceResponse(success, message)
  }

  def SearchEmployees(searchParameters: SearchParameters): ServiceResponse = {
    val searchResults = listOfEmployees.filter(item => item.FirstName == searchParameters.firstName && item.LastName == searchParameters.lastName)
    var success = false;
    var message = ""

    if (searchResults.isEmpty) {
      message = "Not Found"
    } else {
      success = true
      message = "Found Employees"
    }

    var serviceResponse = createServiceResponse(success, message)
    serviceResponse.listOfEmployees = searchResults.toList

    serviceResponse
  }

  def SearchRoles(searchParameters: SearchParameters): ServiceResponse = {
    val searchResults = listOfRoles.filter(item => item == searchParameters.roleName)
    var success = false;
    var message = ""

    if (searchResults.isEmpty) {
      message = "Not Found"
    } else {
      success = true
      message = "Found Roles"
    }

    var serviceResponse = createServiceResponse(success, message)
    serviceResponse.listOfRoles = searchResults.toList

    serviceResponse
  }

  def SearchDepartments(searchParameters: SearchParameters): ServiceResponse = {
    val searchResults = listOfDepartments.filter(item => item == searchParameters.departmentName)
    var success = false;
    var message = ""

    if (searchResults.isEmpty) {
      message = "Not Found"
    } else {
      success = true
      message = "Found Departments"
    }

    var serviceResponse = createServiceResponse(success, message)
    serviceResponse.listOfDepartments = searchResults.toList

    serviceResponse
  }

}
