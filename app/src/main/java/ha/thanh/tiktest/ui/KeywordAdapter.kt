package ha.thanh.tiktest.ui


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ha.thanh.tiktest.R
import kotlinx.android.synthetic.main.item_keyword.view.*


class KeywordAdapter(context: Context?) :
    RecyclerView.Adapter<KeywordAdapter.MyViewHolder>() {

    private var mKeywordList: List<String> = ArrayList()
    private val mContext = context

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    fun updateInfo(newItems: List<String>) {
        mKeywordList = newItems
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(mContext)
        return MyViewHolder(
            inflater.inflate(
                R.layout.item_keyword,
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // TODO set background random here
        holder.itemView.tv_keyword.text = mKeywordList[position]

    }

    override fun getItemCount(): Int {
        return mKeywordList.size
    }
}
