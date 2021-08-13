package ru.ratatoskr.generator.service

import androidx.lifecycle.LifecycleCoroutineScope
import java.math.BigInteger

interface Generator {

    fun getElement(position: Int): BigInteger
    fun extendSequence(start: Int = 0, size: Int = 0)
    fun getSequence(): ArrayList<BigInteger>
    fun getLifeScope(): LifecycleCoroutineScope
    fun getSequenceElement(position: Int) : BigInteger

}