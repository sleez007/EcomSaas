package com.novacore.ecomsaas.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.novacore.ecomsaas.databinding.ItemProductHrBinding
import com.novacore.ecomsaas.models.ListProduct
import javax.inject.Inject

class ProductHrAdapter @Inject constructor() : ListAdapter<ListProduct,ListProductHrVh >(ProductDiffUtilCb()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductHrVh {
        return ListProductHrVh.from(parent)
    }

    override fun onBindViewHolder(holder: ListProductHrVh, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class ListProductHrVh(val binding : ItemProductHrBinding ) : RecyclerView.ViewHolder(binding.root){
    companion object{
        fun from(parent : ViewGroup) : ListProductHrVh{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemProductHrBinding.inflate(layoutInflater,parent,false)
            return ListProductHrVh(binding)
        }
    }

    fun bind(item: ListProduct ){
        binding.item = item
        //binding.vm = viewModel as HomeViewModel
        binding.executePendingBindings()
    }
}

class ProductDiffUtilCb : DiffUtil.ItemCallback<ListProduct>(){
    override fun areItemsTheSame(oldItem: ListProduct, newItem: ListProduct): Boolean = oldItem.productId == newItem.productId

    override fun areContentsTheSame(oldItem: ListProduct, newItem: ListProduct): Boolean = oldItem == newItem

}