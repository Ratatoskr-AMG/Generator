package ru.ratatoskr.generator.grid

import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleCoroutineScope
import ru.ratatoskr.generator.R
import ru.ratatoskr.generator.databinding.ActivityMainBinding

class Grid() {

    companion object {

        fun install(lifecycleScope : LifecycleCoroutineScope, activity: AppCompatActivity, binding: ActivityMainBinding?): GridView {

            val grid: GridView = activity.findViewById(R.id.grid)
            val provider = binding!!.provider
            val adapter = GridAdapter(lifecycleScope, activity, binding)

            grid.isNestedScrollingEnabled = true
            grid!!.setOnScrollListener(GridScrollListener(adapter, grid, provider!!))
            grid!!.adapter = adapter

            return grid

        }
    }
}