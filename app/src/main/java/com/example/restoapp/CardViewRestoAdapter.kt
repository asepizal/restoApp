package com.example.restoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewRestoAdapter(private val listResto: ArrayList<Resto>): RecyclerView.Adapter<CardViewRestoAdapter.CardViewViewHolder>() {

    class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRating: TextView = itemView.findViewById(R.id.tv_item_rating)
        var tvCity: TextView = itemView.findViewById(R.id.tv_item_city)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        // menghubungkan ViewHolder dengan View
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_resto, parent, false)
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val resto = listResto[position]
        Glide.with(holder.itemView.context)
            .load(resto.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)


        holder.tvName.text = resto.name
        holder.tvRating.text = resto.rating.toString()
        holder.tvCity.text = resto.city
        holder.btnDetail.setOnClickListener{
            val bundle = Bundle()
            bundle.putStringArray("menuFoods", resto.menuFoods)
            bundle.putString("restoName", resto.name)
            bundle.putInt("restoImage", resto.photo)
            bundle.putString("restoCity", resto.city)

            val moveIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            moveIntent.putExtras(bundle)
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int {
        return listResto.size
    }


}