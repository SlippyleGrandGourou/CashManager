package fr.postz.cashmanager.ViewAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import fr.postz.cashmanager.Caddie
import fr.postz.cashmanager.ProductsFragment
import fr.postz.cashmanager.R
import fr.postz.cashmanager.dummy.DummyContent
import kotlinx.android.synthetic.main.fragment_products.view.*

class CaddieRecyclerViewAdapter (
private val mValues: List<DummyContent.DummyItem>,
private val mListener: Caddie.OnListFragmentInteractionListener?
) : RecyclerView.Adapter<CaddieRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyContent.DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_products, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = mValues[position]
        if (item.getCount() == "0")

            holder.mIdView.text = item.id
            holder.mContentView.text = item.content
            holder.mPrice.text = (item.price).toString()
            holder.mCount.text = item.getCount()

            with(holder.mView) {
                tag = item
                setOnClickListener { v ->

                    val i = v.tag as DummyContent.DummyItem
                    // Notify the active callbacks interface (the activity, if the fragment is attached to
                    // one) that an item has been selected.

                    i.decrement()
                    mListener?.onListFragmentInteraction(i)
                    holder.mCount.text = i.getCount()
                }

            }

    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mIdView: TextView = mView.item_number
        val mContentView: TextView = mView.content
        val mCount: TextView = mView.count
        val mPrice: TextView = mView.price

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
