package ru.ratatoskr.generator.service

import androidx.lifecycle.LifecycleCoroutineScope
import java.math.BigInteger

abstract class Sequence(lifecycleScope: LifecycleCoroutineScope) {

    private var sequence: ArrayList<BigInteger> = arrayListOf()
    private var lifecycleScope = lifecycleScope

    abstract fun getElement(position: Int): BigInteger

    fun getLifeScope(): LifecycleCoroutineScope {
        return lifecycleScope
    }

    fun getSequence(): ArrayList<BigInteger> {
        return sequence
    }

    fun getSequenceElement(position: Int) : BigInteger{
        return sequence[position]
    }

    fun extendSequence(start: Int, size: Int) {

        var old = sequence

        for (i in start..start+size) {
            old.add(getElement(i))
        }

        sequence = old

    }

}