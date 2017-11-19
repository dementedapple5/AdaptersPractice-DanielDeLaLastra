package com.example.alumne.adapterspractice.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.alumne.adapterspractice.R
import com.example.alumne.adapterspractice.model.Producto


/**
 * Created by Alumne on 15/11/2017.
 */

/*
* Heredo de base adapter porque es la clase más completa y que más métodos me brinda, y a su vez he creado un adapter personalizado porque no existia ninguno que cumpliera con los tipos de datos que quiero mostrar*/
class ItemAdapter(private val productos: ArrayList<Producto>, context: Context) : BaseAdapter() {


    private val context = context
    private var tvTitle: TextView? = null
    private var tvStock: TextView? = null
    private var ivItem: ImageView? = null
    private var spQty: Spinner? = null
    private var dir: Producto? = null


    override fun getView(pos: Int, view: View?, viewGroup: ViewGroup?): View {

        val inflater: LayoutInflater = viewGroup?.context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var v = view

        if (v==null){
            v = inflater.inflate(R.layout.item_template,null)
        }


        tvTitle = v?.findViewById(R.id.tv_title)
        tvStock = v?.findViewById(R.id.tv_stock)
        ivItem = v?.findViewById(R.id.iv_icon)

        dir = productos[pos]
        spQty = v?.findViewById(R.id.sp_qty)

        val qtyAdapter: ArrayAdapter<Int> = ArrayAdapter(context,android.R.layout.simple_spinner_dropdown_item)

        for (i in 0 .. dir!!.stock){
            qtyAdapter.add(i)
        }

        spQty?.adapter = qtyAdapter

        ivItem?.setImageResource(dir!!.img)

        tvTitle?.text = dir?.name
        tvStock?.text = dir?.stock.toString()

        return v!!
    }

    override fun getItem(pos: Int): Any {
        return productos[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getCount(): Int {
        return productos.size
    }



}