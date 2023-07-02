package com.example.listadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.CatItemBinding

class CatListAdapter : ListAdapter<CatDataModel, CatListAdapter.CatViewHolder>(DiffCallback)

{

    companion object {
        private val DiffCallback = object  : DiffUtil.ItemCallback<CatDataModel>(){
            override fun areItemsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 고유값 비교
                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 내용 비교
                return oldItem == newItem
            }

        }
    }

    class CatViewHolder(private val binding : CatItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : CatDataModel){
            binding.catId.text = item.catId.toString()
            binding.catName.text = item.catName
            binding.catAge.text = item.catAge.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}