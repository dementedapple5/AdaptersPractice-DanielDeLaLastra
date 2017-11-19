package com.example.alumne.adapterspractice

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.alumne.adapterspractice.adapter.ItemAdapter
import com.example.alumne.adapterspractice.model.Producto
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_template.view.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    override fun onItemClick(adapterView: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        val i = Intent(this,ItemActivity::class.java)
        val prod = adapterView?.getItemAtPosition(pos) as Producto
        val b = Bundle()
        b.putParcelable("product",prod)
        b.putInt("index",view?.sp_qty!!.selectedItemPosition)
        i.putExtras(b)
        startActivity(i)
    }

    private val productos = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productos.add(Producto("Iphone x",12,R.drawable.iphonex))
        productos.add(Producto("Samsung s8",10,R.drawable.s8))
        productos.add(Producto("Huawei p10",20,R.drawable.p10))
        productos.add(Producto("Xiaomi mi6",27,R.drawable.mi6))
        productos.add(Producto("OnePlus 5",7,R.drawable.op5))
        productos.add(Producto("OnePlus 5T",30,R.drawable.op5t))
        productos.add(Producto("Sony Xperia Z",13,R.drawable.mi6))
        productos.add(Producto("Xiaomi miA1",17,R.drawable.mi6))
        productos.add(Producto("Google Pixel 2",4,R.drawable.mi6))

        items_list.adapter = ItemAdapter(productos,this.applicationContext)
        items_list.onItemClickListener = this

    }
}
