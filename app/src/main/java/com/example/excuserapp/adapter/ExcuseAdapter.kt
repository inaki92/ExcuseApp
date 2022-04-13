package com.example.excuserapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.RecyclerView
import com.example.excuserapp.R
import com.example.excuserapp.databinding.ExcuseItemBinding
import com.example.excuserapp.model.Excuse
import com.example.excuserapp.utils.ExcuseCategory

class ExcuseAdapter(
    private val excuseData: MutableList<Excuse> = mutableListOf()
) : RecyclerView.Adapter<ExcuseViewHolder>() {

    fun updateData(newExcuseSet: List<Excuse>) {
        newExcuseSet.forEach {
            if (!excuseData.contains(it)) {
                excuseData.add(it)
            }
        }.also { notifyDataSetChanged() }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExcuseViewHolder =
        ExcuseViewHolder(
            ExcuseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ExcuseViewHolder, position: Int) =
        holder.bind(excuseData[position])

    override fun getItemCount(): Int = excuseData.size
}

class ExcuseViewHolder(
    private val binding: ExcuseItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(excuse: Excuse) {
        binding.apply {
            excuseId.text = excuse.id.toString()
            excuseText.text = excuse.excuse

            when(excuse.category) {
                ExcuseCategory.OFFICE -> {
                    excuseCatImage.setImageDrawable(getDrawable(binding.root.context, R.drawable.office_excuse))
                }
                ExcuseCategory.FAMILY -> {
                    excuseCatImage.setImageDrawable(getDrawable(binding.root.context, R.drawable.fam_excuse))
                }
                ExcuseCategory.COLLEGE -> {
                    excuseCatImage.setImageDrawable(getDrawable(binding.root.context, R.drawable.college_excuse))
                }
                ExcuseCategory.PARTY -> {
                    excuseCatImage.setImageDrawable(getDrawable(binding.root.context, R.drawable.party_excuse))
                }
                ExcuseCategory.CHILDREN -> {
                    excuseCatImage.setImageDrawable(getDrawable(binding.root.context, R.drawable.children_excuse))
                }
            }
        }
    }

}