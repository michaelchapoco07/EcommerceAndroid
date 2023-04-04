package ph.stacktrek.novare.ecommercenovare.chapoco.christian.model

open class Character(val name:String,) {
    var location:String = ""
    var race: String = ""
        get() = "Getting $field"
        set(value){
            field= "Setting $value"
        }

    companion object{
        private var objectCount = 0
        fun increaseCount(): Int {
            objectCount += 1
            return objectCount
        }
    }

    init{

    }

    constructor():this("")
    constructor(name: String, type: String):this(name){

    }
}