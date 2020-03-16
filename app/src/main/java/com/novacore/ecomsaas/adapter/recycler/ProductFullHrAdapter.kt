package com.novacore.ecomsaas.adapter.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.novacore.ecomsaas.databinding.ItemProductLongHrBinding
import com.novacore.ecomsaas.models.ListProduct
import javax.inject.Inject

class ProductFullHrAdapter @Inject constructor(): ListAdapter<ListProduct, ListProductFullHrVh>(ProductDiffUtilCb()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListProductFullHrVh {
        return ListProductFullHrVh.from(parent)
    }

    override fun onBindViewHolder(holder: ListProductFullHrVh, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class ListProductFullHrVh(val binding : ItemProductLongHrBinding) : RecyclerView.ViewHolder(binding.root){
    companion object{
        fun from(parent : ViewGroup) : ListProductFullHrVh{
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemProductLongHrBinding.inflate(layoutInflater,parent,false)
            return ListProductFullHrVh(binding)
        }
    }

    fun bind(item: ListProduct ){
        binding.item = item
        //binding.vm = viewModel as HomeViewModel
        binding.executePendingBindings()
    }
}