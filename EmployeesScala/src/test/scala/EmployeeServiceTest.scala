import com.employee.models.ServiceResponse
import org.scalatest.funsuite.AnyFunSuiteLike
import com.employees.services.EmployeeService

class EmployeeServiceTest extends AnyFunSuiteLike {

  private def assertResults(results: ServiceResponse): Unit = {
    assert(results !== null)
    assert(results.success)
  }

  test("Save Role") {
    var results = EmployeeService.SaveRole()

    assertResults(results)
  }

  test("Save Department") {
    var results = EmployeeService.SaveDepartment()

    assertResults(results)
  }

  test("Delete Department") {
    var results = EmployeeService.SaveRole()

    assertResults(results)
  }

  test("Delete Employee") {
    var results = EmployeeService.SaveRole()

    assertResults(results)
  }

  test("Save Random") {
    var results = EmployeeService.SaveRole()

    assertResults(results)
  }

  test("Save Employee") {
    var results = EmployeeService.SaveRole()

    assertResults(results)
  }

  test("Delete Role") {

  }

}
