package com.anotherteam.kisahnabi.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.anotherteam.kisahnabi.DetailActivity
import com.anotherteam.kisahnabi.ResponseRasulNabiItem
import com.anotherteam.kisahnabi.databinding.ItemDatarecyclerBinding

class AdapterNabiRasul: RecyclerView.Adapter<AdapterNabiRasul.ViewHolder>() {

    private val listNabi : ArrayList<ResponseRasulNabiItem> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun addDataNabi(getData: List<ResponseRasulNabiItem>){
        listNabi.clear()
        listNabi.addAll(getData)
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemDatarecyclerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDatarecyclerBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataNabi= listNabi[position]

        holder.binding.txtNama.text = dataNabi.nama
        holder.binding.imageView.load(dataNabi.avatar!!){
            scale(Scale.FILL)
        }
        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.DATA, dataNabi)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount() = listNabi.size
}