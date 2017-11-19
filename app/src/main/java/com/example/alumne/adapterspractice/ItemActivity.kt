package com.example.alumne.adapterspractice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.alumne.adapterspractice.model.Producto
import kotlinx.android.synthetic.main.item_template.*

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_template)

        var b = intent.extras
        if (b!=null){
            val producto = b.getParcelable<Producto>("product")
            tv_title.text = producto.name
            tv_stock.text = producto.stock.toString()
            iv_icon.setImageResource(producto.img)

            val qtyAdapter: ArrayAdapter<Int> = ArrayAdapter(this.applicationContext,android.R.layout.simple_spinner_dropdown_item)

            for (i in 0 .. producto.stock){
                qtyAdapter.add(i)
            }

            sp_qty.adapter = qtyAdapter
            sp_qty.setSelection(b.getInt("index"))
        }
    }
}
