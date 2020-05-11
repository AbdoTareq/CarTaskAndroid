package com.simplute.android.cartaskandroid.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simplute.android.cartaskandroid.databinding.CarItemBinding
import com.simplute.android.cartaskandroid.model.Car


class CarAdapter : ListAdapter<Car,
        CarAdapter.ViewHolder>(CarDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: CarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Car) {
            binding.id.text = item.id.toString()
            binding.brand.text = item.brand
            binding.year.text = item.constructionYear
            binding.used.text = item.isUsed.toString()

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CarItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

private class CarDiffCallback : DiffUtil.ItemCallback<Car>() {
    override fun areItemsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Car, newItem: Car): Boolean {
        return oldItem.equals(newItem)
    }
}
