import com.employee.models.{Employee, S, SearchParameters, ServiceResponse}
import org.scalatest.funsuite.AnyFunSuiteLike
import com.employees.services.EmployeeService

class EmployeeServiceTest extends AnyFunSuiteLike {

  private def assertResults(results: ServiceResponse): Unit = {
    assert(results !== null)
    assert(results.success)
  }

  private def createEmployee(firstName: String, lastName: String): Employee = {
    new Employee(firstName, lastName)
  }

  private def createSearchParameters(firstName: String, lastName: String, roleName: String, departmentName: String): SearchParameters = {
    var obj = new SearchParameters()
    obj.firstName = firstName
    obj.lastName = firstName
    obj.roleName = firstName
    obj.departmentName = firstName

    obj
  }

  test("Save Role") {
    var results = EmployeeService.SaveRole("Web Developer")

    assertResults(results)
  }

  test("Delete Role") {
    var results = EmployeeService.DeleteRole("Web Developer")

    assertResults(results)
  }

  test("Save Department") {
    var results = EmployeeService.SaveDepartment("IT")

    assertResults(results)
  }

  test("Delete Department") {
    var results = EmployeeService.DeleteDepartment("IT")

    assertResults(results)
  }

  test("Save Employee") {
    var results = EmployeeService.SaveEmployee(createEmployee("Joe", "Bloggs"))

    assertResults(results)
  }

  test("Delete Employee") {
    var results = EmployeeService.DeleteEmployee(createEmployee("Joe", "Bloggs"))

    assertResults(results)
  }

  test("Search Employees") {
    var results = EmployeeService.SearchEmployees(createSearchParameters("Joe", "Bloggs", "", ""))

    assertResults(results)
  }

  test("Search Departments") {
    var results = EmployeeService.SearchDepartments(createEmployee("Joe", "Bloggs"))

    assertResults(results)
  }

  test("Search Roles") {
    var results = EmployeeService.SearchRoles("Brand Manager")

    assertResults(results)
  }

}
