package ph.stacktrek.novare.ecommercenovare.chapoco.christian.adapters

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.ProductDetails
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.dao.ProductDAOSQLLiteImplementation
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.databinding.DialogueProductBinding
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.databinding.ProductItemBinding
import ph.stacktrek.novare.ecommercenovare.chapoco.christian.model.Product

class ProductAdapter(private val context:Context,
                     private var productList:ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    fun deleteProduct(position: Int){
        productList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addProduct(product: Product){
        productList.add(0,product)
        notifyItemInserted(0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val productItemBinding = ProductItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(productItemBinding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bindItems(productList[position])

    }

    override fun getItemCount(): Int = productList.size


    inner class ViewHolder(private val productItemBinding: ProductItemBinding):
        RecyclerView.ViewHolder(productItemBinding.root){

        fun bindItems(product: Product){
            productItemBinding.productName.text = product.name
            productItemBinding.productDescription.text = product.description


            productItemBinding.viewProductButton.setOnClickListener {
                val intent = Intent(productItemBinding.root.context, ProductDetails::class.java)
                intent.putExtra("product", product)
                productItemBinding.root.context.startActivity(intent)
            }
        }


    }



}