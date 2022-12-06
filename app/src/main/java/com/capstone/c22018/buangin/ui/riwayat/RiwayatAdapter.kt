package com.capstone.c22018.buangin.ui.riwayat

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.c22018.buangin.database.BankSampahModel
import com.capstone.c22018.buangin.databinding.HistoryItemBinding

class RiwayatAdapter(context: Context, modelInputList: MutableList<BankSampahModel>, adapterCallback: RiwayatAdapterCallback) :
    RecyclerView.Adapter<RiwayatAdapter.MyViewHolder>() {

    var modelList : MutableList<BankSampahModel>
    var mAdapterCallback: RiwayatAdapterCallback

    fun setUpData (modelList : List<BankSampahModel>) {
        this.modelList.clear()
        this.modelList.addAll(modelList)
    }

    inner class MyViewHolder (private var binding: HistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: BankSampahModel) {
            binding.apply {
                tvNama.text = model.userName
                tvDate.text = model.date
                tvKategori.text = model.wasteType
                tvBerat.text = model.weight.toString()
                tvSaldo.text = model.price.toString()

                if (tvBerat.text.toString().toInt() < 5) {
                    tvStatus.text = "Masih dalam proses"
                } else {
                    tvStatus.text = "Sudah di konfirmasi"
                }

                imageDelete.setOnClickListener {
                    val modelLaundry: BankSampahModel = modelList[adapterPosition]
                    mAdapterCallback.onDelete(modelLaundry)
                }
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = HistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(modelList[position])

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    init {
        modelList = modelInputList
        mAdapterCallback = adapterCallback
    }

    interface RiwayatAdapterCallback {
        fun onDelete(modelDatabase: BankSampahModel?)
    }
}