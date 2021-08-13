package ru.ratatoskr.generator.grid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.lifecycle.LifecycleCoroutineScope
import ru.ratatoskr.generator.R
import ru.ratatoskr.generator.databinding.ActivityMainBinding

class GridAdapter(
    private val lifecycleScope : LifecycleCoroutineScope,
    private val context: Context,
    private val binding: ActivityMainBinding?,
) : BaseAdapter() {

    override fun getCount(): Int {
        return binding!!.provider!!.getGenerator().getSequence().size
    }

    override fun getItem(position: Int): Any {
        return binding!!.provider!!.getGenerator().getSequence()[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val element = binding!!.provider!!.getGenerator().getSequence()[position]
        var item = LayoutInflater.from(context).inflate(R.layout.item, parent, false)
        var content = item.findViewById(R.id.value) as TextView

        content.setText(element.toString())

        return item
    }

}