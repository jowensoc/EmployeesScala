import com.employee.models.ServiceResponse
import com.employee.models.Employee
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

}
