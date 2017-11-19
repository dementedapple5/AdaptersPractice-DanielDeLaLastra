package com.example.alumne.adapterspractice.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Alumne on 15/11/2017.
 */

class Producto(val name: String, val stock: Int, val img: Int): Parcelable {


    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(stock)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Producto> {
        override fun createFromParcel(parcel: Parcel): Producto {
            return Producto(parcel)
        }

        override fun newArray(size: Int): Array<Producto?> {
            return arrayOfNulls(size)
        }
    }


}
