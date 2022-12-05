package com.capstone.c22018.buangin.ui.riwayat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone.c22018.buangin.database.BankSampahModel
import com.capstone.c22018.buangin.databinding.HistoryItemBinding

class RiwayatAdapter(modelInputList: MutableList<BankSampahModel>) :
    RecyclerView.Adapter<RiwayatAdapter.MyViewHolder>() {

    var modelList : MutableList<BankSampahModel>

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
                    modelList.removeAt(adapterPosition)
                    notifyItemRemoved(adapterPosition)
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
        TODO("kayanya harus ditambahin set item click listener")

    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    init {
        modelList = modelInputList
    }
    interface RiwayatAdapterCallback {
        fun onDelete(modelDatabase: BankSampahModel?){
            TODO("Opisional kalo misalnya yg image delete di klik gabisa dihapus")
        }

    }
}