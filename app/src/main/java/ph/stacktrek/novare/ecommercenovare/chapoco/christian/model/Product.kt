package ph.stacktrek.novare.ecommercenovare.chapoco.christian.model

import java.io.Serializable
import java.math.BigDecimal

class Product(var name: String, var description: String) : Serializable {
    lateinit var id: String
    lateinit var price: BigDecimal
    lateinit var measurement: String
    lateinit var brand: String
    var measurementUnit: MeasurementUnit = MeasurementUnit.NOT_SET
    var quantity: Int = 0
}

enum class MeasurementUnit{
    KILOGRAMS,
    GRAMS,
    METER,
    TONS,
    NOT_SET
}