package com.dicoding.submission

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import com.dicoding.submission.databinding.RowLayoutBinding

class RecyclerViewAdapter(private val items: List<NewsModel>):
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(item: NewsModel)
    }

    inner class MyViewHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsModel){
            binding.articleTitle.text = item.judul
            binding.articleDate.text = item.tanggal
            binding.articleDesc.text = item.artikel
            binding.articleImage.load(item.gambar){
                crossfade(400)
                crossfade(true)
                transformations(RoundedCornersTransformation(10f))
            }

            itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size
}