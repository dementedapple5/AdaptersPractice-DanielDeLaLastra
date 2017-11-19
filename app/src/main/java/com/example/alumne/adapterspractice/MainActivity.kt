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

        loadData()

        items_list.adapter = ItemAdapter(productos,this.applicationContext)
        items_list.onItemClickListener = this

    }

    private fun loadData() {
        val titles = this.resources.getStringArray(R.array.titles)
        val stocks = this.resources.getIntArray(R.array.stocks)

        var prod: Producto
        for (i in titles.indices) {
            prod = Producto(titles[i], stocks[i], R.drawable.iphonex)
            productos.add(prod)
        }

    }
}
