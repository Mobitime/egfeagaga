package com.example.egfeagaga

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class WebSiteAdapter(private val context: Context, private val websites: List<WebSite>) :
    BaseAdapter() {

    override fun getCount(): Int = websites.size
    override fun getItem(position: Int): Any = websites[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.grid_item, parent, false)

        val website = websites[position]

        view.findViewById<ImageView>(R.id.imageView).setImageResource(website.imageResId)
        view.findViewById<TextView>(R.id.titleTextView).text = website.title

        return view
    }
}