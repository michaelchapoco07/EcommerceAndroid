package ph.stacktrek.novare.ecommercenovare.chapoco.christian.dao

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.SQLException
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.model.Product

interface ProductDAO {
    fun addProduct(product: Product)
    fun getProducts(): ArrayList<Product>
    fun updateProduct(product: Product)
    fun deleteProduct(product: Product)
}

class ProductDAOStubImplementation(applicationContext: Context) : ProductDAO{
    private var productList: ArrayList<Product> = ArrayList()

    init{
        productList.add(Product("Corned Beef", "HAHA"))
        productList.add(Product("Canned Tuna", "HAHA"))
        productList.add(Product("Canned Carrots and Corn", "HAHA"))
        productList.add(Product("Powdered Milk", "HAHA"))
        productList.add(Product("Coffee", "HAHA"))
        productList.add(Product("Canned Beer", "HAHA"))
        productList.add(Product("Canned Soda", "HAHA"))
        productList.add(Product("Creamer", "HAHA"))
        productList.add(Product("Bottled Water", "HAHA"))
        productList.add(Product("Bottled Soda", "HAHA"))
        productList.add(Product("Bottled Tea", "HAHA"))
        productList.add(Product("Bottled Milk Tea", "HAHA"))
    }

    override fun addProduct(product: Product) {
        productList.add(product)
    }

    override fun getProducts(): ArrayList<Product> = productList

    //TODO("Not yet implemented")
    override fun updateProduct(product: Product) {

    }

    //TODO("Not yet implemented")
    override fun deleteProduct(product: Product) {

    }

}

class ProductDAOSQLLiteImplementation(var context: Context): ProductDAO{
    override fun addProduct(product: Product) {
        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.writableDatabase

        val contentValues = ContentValues()
        contentValues.put(DatabaseHandler.TABLE_PRODUCT_NAME, product.name)

        var status = db.insert(DatabaseHandler.TABLE_PRODUCT,
            null,
            contentValues)
        db.close()
    }

    override fun getProducts(): ArrayList<Product> {
        val databaseHandler = DatabaseHandler(context)
        val db = databaseHandler.readableDatabase
        var result = ArrayList<Product>()
        var cursor: Cursor? = null

        val columns =  arrayOf(DatabaseHandler.TABLE_PRODUCT_ID,
            DatabaseHandler.TABLE_PRODUCT_NAME)

        try {
            cursor = db.query(DatabaseHandler.TABLE_PRODUCT,
                columns,
                null,
                null,
                null,
                null,
                null)

        }catch (sqlException: SQLException){
            db.close()
            return result
        }

        var product: Product
        if(cursor.moveToFirst()){
            do{
                product = Product("","")
                product.name = cursor.getString(1)
                product.id = cursor.getInt(0).toString()
                result.add(product)
            }while(cursor.moveToNext())
        }
        return result
    }

    override fun updateProduct(product: Product) {
        TODO("Not yet implemented")
    }

    override fun deleteProduct(product: Product) {
        val databaseHandler=DatabaseHandler(context)
        val db =databaseHandler.writableDatabase
        val values = arrayOf("${product.id}")

        db.delete(DatabaseHandler.TABLE_PRODUCT, "${DatabaseHandler.TABLE_PRODUCT_ID}=?", values)
        db.close()
    }

}