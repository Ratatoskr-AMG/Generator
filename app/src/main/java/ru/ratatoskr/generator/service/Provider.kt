package ru.ratatoskr.generator.service

import android.util.Log
import android.widget.GridView
import kotlinx.coroutines.*
import ru.ratatoskr.generator.grid.GridAdapter

class Provider(generator: Generator, size: Int) {

    private var generator = generator
    private val size = size;
    var handler = CoroutineExceptionHandler { _, exception ->
        Log.d(
            "happy",
            "Coroutine Prime e: " + exception.message
        )
    }

    init {
        generator.extendSequence(0, size)
    }

    fun getGenerator(): Generator {
        return generator
    }

    fun getSize(): Int {
        return size
    }

    fun update(grid: GridView, adapter: GridAdapter) {

        var loading = false

        if (!loading) {
            generator.getLifeScope().launch(SupervisorJob() + handler) {
                loading = true
                if (grid!!.count - grid!!.lastVisiblePosition < getSize()) {
                    try {
                        async {
                            generator.extendSequence(grid!!.count, getSize())
                            adapter.notifyDataSetChanged()
                        }
                        withContext(Dispatchers.Main) {
                            loading = false
                        }
                    } catch (e: Exception) {
                        Log.d("happy", "${e.message}")
                    }
                }
                loading = false
            }
        }
    }

}