package com.simplute.android.cartaskandroid.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simplute.android.cartaskandroid.R
import com.simplute.android.cartaskandroid.model.Car


@BindingAdapter("carListData")
fun bindTicketRecyclerView(recyclerView: RecyclerView, data: List<Car>?) {
    val adapter = recyclerView.adapter as CarAdapter
    adapter.submitList(data)
}

@BindingAdapter("progressApiStatus")
fun bindProgress(statusProgress: View, statusType: ApiStatus?) {
    when (statusType) {
        ApiStatus.LOADING -> {
            statusProgress.visibility = View.VISIBLE
        }
        else -> {
            statusProgress.visibility = View.GONE
        }
    }
}

@BindingAdapter("apiStatus")
fun bindStatus(statusImageView: ImageView, status: ApiStatus?) {
    when (status) {
        ApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ApiStatus.EMPTY -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.empty_box)
        }
        else -> {
            statusImageView.visibility = View.GONE
        }
    }
}
