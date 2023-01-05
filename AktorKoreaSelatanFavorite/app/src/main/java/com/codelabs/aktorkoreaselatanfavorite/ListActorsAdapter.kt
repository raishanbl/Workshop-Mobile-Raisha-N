package com.codelabs.aktorkoreaselatanfavorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codelabs.aktorkoreaselatanfavorite.databinding.ItemRowActorsBinding

class ListActorsAdapter(private val list : ArrayList<Actors>) :
    RecyclerView.Adapter<ListActorsAdapter.ListViewHolder>() {

    inner class ListViewHolder (private val binding : ItemRowActorsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(actors: Actors) {
            with(binding) {
                tvActorName.text = actors.name
                tvDetailActor.text = actors.detail
                Glide.with(itemView.context)
                    .load(actors.photo)
                    .apply(RequestOptions().override(260,260))
                    .into(ivActor)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DETAIL, actors)
                    itemView.context.startActivity(intent)

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowActorsBinding.inflate((LayoutInflater.from(parent.context)), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = list[position]

        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}