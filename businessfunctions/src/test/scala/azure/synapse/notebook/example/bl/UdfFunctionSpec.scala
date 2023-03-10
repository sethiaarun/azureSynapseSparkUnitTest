package azure.synapse.notebook.example.bl

import org.apache.spark.sql.{DataFrame, SparkSession}
import org.scalatest.funsuite.AnyFunSuite

/**
 * UDF Related Test cases
 */
class UdfFunctionSpec extends  AnyFunSuite  with SparkConfiguration {

  val spark: SparkSession = SparkSession.builder().appName(appName).master(master).getOrCreate()
  val sql: String => DataFrame = spark.sql _
  spark.udf.register("cleanseZipCode", UdfFunction.cleanseZipCode)
  test("zip code 7689 is invalid zipcode") {
    val assertValue = ""
    val inputValue= "7689"
    val x: DataFrame = sql(s"select cleanseZipCode('${inputValue}')")
    assert(getCleansedZipCode(inputValue) == assertValue)
  }
  test("zip code 76869 is valid") {
    val assertValue = "76869"
    assert(getCleansedZipCode("76869") == assertValue)
  }
  test("zip code 76869-8976 is valid") {
    val assertValue = "76869-8976"
    assert(getCleansedZipCode("76869-8976") == assertValue)
  }
  test("empty zip code is invalid") {
    val assertValue = ""
    val inputValue= ""
    assert(getCleansedZipCode(inputValue) == assertValue)
  }

  /**
   * get cleansed zipcode using udf
   * @param inputValue
   * @return
   */
  private def getCleansedZipCode(inputValue: String) = sql(s"select cleanseZipCode('${inputValue}')").head().getString(0)
}
