package ph.stacktrek.novare.ecommercenovare.chapoco.christian

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.databinding.ProductDetailsBinding
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.model.Product

class ProductDetails : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val product = intent.getSerializableExtra("product") as Product

        val productDetailsBinding: ProductDetailsBinding = ProductDetailsBinding.inflate(layoutInflater)
        productDetailsBinding.productName.text = product.name
        productDetailsBinding.productDescription.text = product.description
        setContentView(productDetailsBinding.root)
    }
}