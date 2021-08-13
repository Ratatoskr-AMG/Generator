package ru.ratatoskr.generator.grid

import android.widget.AbsListView
import android.widget.GridView
import ru.ratatoskr.generator.service.Provider

class GridScrollListener (adapter : GridAdapter, grid: GridView, provider : Provider) : AbsListView.OnScrollListener {

    var grid = grid
    var provider = provider
    var adapter = adapter

    override fun onScrollStateChanged(absListView: AbsListView, scrollState: Int) {
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
           provider.update(grid,adapter)
        }

    }
    override fun onScroll(absListView: AbsListView, i: Int, i1: Int, i2: Int) {

    }
}