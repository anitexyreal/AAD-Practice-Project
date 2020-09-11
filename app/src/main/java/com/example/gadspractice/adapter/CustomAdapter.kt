package com.example.gadspractice.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gadspractice.R
import com.example.gadspractice.models.UserInfo
import kotlinx.android.synthetic.main.items.view.*


class CustomAdapter(val userInfo: List<UserInfo>, val image: Int) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
        return userInfo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val p = userInfo[position]
        holder.itemView.apply {
            card_image.setImageResource(image)
            card_text_heading.text = userInfo[position].name
            card_text_body.text =
                if (p.hours != null) "${p.hours} learning hours, ${p.country}" else "${p.score} skill IQ Score, ${p.country}"

        }
        Log.d("", holder.itemView.card_text_body.text.toString())
    }

}