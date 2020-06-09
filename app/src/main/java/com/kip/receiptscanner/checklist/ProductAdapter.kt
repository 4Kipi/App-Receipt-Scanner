package com.kip.receiptscanner.checklist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kip.receiptscanner.R
import kotlinx.android.synthetic.main.list_products.view.*

/*class ProductAdapter(private val list: ArrayList<ChecklistActivity.Product>) :
    RecyclerView.Adapter<ProductAdapter.CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_products, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class CustomViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(product: ChecklistActivity.Product) {
            view.tv_name.text = product.name
            view.tv_price.text = product.price.toString()
        }
    }

}*/


class ProductAdapter(private val context: Context, private val products: ArrayList<ChecklistActivity.Product>): BaseAdapter() {
    /*private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater*/

    // Creates a view to be used as a row in the list
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context)
        val rowMain = layoutInflater.inflate(R.layout.list_products,parent, false)

        val tvName = rowMain.findViewById<TextView>(R.id.tv_name)
        tvName.text = products[position].name

        val tvPrice = rowMain.findViewById<TextView>(R.id.tv_price)
        tvPrice.text = products[position].price.toString()

        return rowMain
    }

    // Returns an item to be placed in a given position from the products list
    override fun getItem(position: Int): Any {
        return products[position]
    }

    // This method defines a unique ID (we use the position of the item) for each row in the list
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Lets ListView know how many items has to display, returning size of the products list
    override fun getCount(): Int {
        return products.size
    }

}
