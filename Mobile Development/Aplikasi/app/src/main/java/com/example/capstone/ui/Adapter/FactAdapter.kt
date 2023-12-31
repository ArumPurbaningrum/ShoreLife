package com.example.capstone.ui.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.capstone.data.response.ItemResponse
import com.example.capstone.databinding.ListFactBinding
import com.example.capstone.ui.detail.DetailActivity
import com.example.capstone.ui.detailFact.DetailFactActivity

class FactAdapter : RecyclerView.Adapter<FactAdapter.ViewHolder>() {

    private var listItem: List<ItemResponse> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newList: List<ItemResponse>) {
        listItem = newList
        notifyDataSetChanged()
    }

    // lorem iopsumn ahdaikosjdhas asdkjashkdjahskjdbaskjbdjasbyd hagbdsa

    inner class ViewHolder(private val binding: ListFactBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(context: Context, item: ItemResponse) {
            binding.root.setOnClickListener {
                 val intent = Intent(context, DetailFactActivity::class.java)
                intent.putExtra("extra_id", item.id)
                context.startActivity(intent)
            }

            binding.apply {

//                TODO Ini buat foto
//                Glide.with(itemView)
//                    .load(item.photoUrl)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .centerCrop()
//                    .into(imageFact)

                titleFact.text = item.batikName
                descFact.text = item.content
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ListFactBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(holder.itemView.context, listItem[position])
    }

}