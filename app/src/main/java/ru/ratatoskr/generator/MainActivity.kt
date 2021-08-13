package ru.ratatoskr.generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import ru.ratatoskr.generator.databinding.ActivityMainBinding
import ru.ratatoskr.generator.grid.Grid
import ru.ratatoskr.generator.service.Fibonacci
import ru.ratatoskr.generator.service.Generator
import ru.ratatoskr.generator.service.Prime
import ru.ratatoskr.generator.service.Provider

class MainActivity : AppCompatActivity() {

    private var activityBinding: ActivityMainBinding? = null
    private var scope = CoroutineScope(Dispatchers.IO)
    private var size = 30

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityBinding?.root)
        supportActionBar!!.hide()

        loadUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        activityBinding=null;
    }

    fun click(view: View) {
        loadUI(view.id)
    }

    fun loadUI(id: Int? = 0){

        scope.cancel()

        var generator : Generator

        when(id) {
            R.id.btn_fibonacci -> generator = Fibonacci(lifecycleScope);
            else -> generator = Prime(lifecycleScope);
        }

        activityBinding!!.provider = Provider(generator,size)
        Grid.install(lifecycleScope,this,activityBinding)
    }

}