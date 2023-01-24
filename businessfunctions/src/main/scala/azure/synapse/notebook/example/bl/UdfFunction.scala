package azure.synapse.notebook.example.bl

import org.apache.spark.sql.expressions.UserDefinedFunction
import org.apache.spark.sql.functions.udf

object UdfFunction {

    /**
     * zip code cleansing, valid format 78967-7689 or 78967, etc.
     * @param zipCode
     * @return
     */
    def cleanseZipCodeFn(zipCode:String): String = {
        val result="^\\d{5}(?:[-\\s]\\d{4})?$".r.findFirstMatchIn(zipCode).getOrElse("").toString
        result
    }

    /**
     * Spark UDF for zip code cleansing
     * @return
     */
    def cleanseZipCode: UserDefinedFunction = udf((zipCode)=>cleanseZipCodeFn(zipCode))

}
