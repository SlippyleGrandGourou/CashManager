package fr.postz.cashmanager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import fr.postz.cashmanager.ProductsFragment.OnListFragmentInteractionListener
import fr.postz.cashmanager.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_products.view.*
import org.w3c.dom.Text

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyProductsRecyclerViewAdapter(
    private val mValues: List<DummyItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyProductsRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem

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
        holder.mIdView.text = item.id
        holder.mContentView.text = item.content
        holder.mPrice.text = (item.price).toString()
        if (item.getCount() != "0")
            holder.mCount.text = item.getCount()

        with(holder.mView) {
            tag = item
            setOnClickListener { v ->

                val i = v.tag as DummyItem
                // Notify the active callbacks interface (the activity, if the fragment is attached to
                // one) that an item has been selected.
                i.increment()
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
