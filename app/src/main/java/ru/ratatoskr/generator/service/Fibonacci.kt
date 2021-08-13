package ru.ratatoskr.generator.service

import androidx.lifecycle.LifecycleCoroutineScope
import java.math.BigInteger

class Fibonacci(lifecycleScope: LifecycleCoroutineScope) : Generator, Sequence(lifecycleScope) {

    override fun getElement(position: Int): BigInteger {

        if (position < 2)
            return position.toBigInteger().pow(2)

        return getSequenceElement(position - 1).plus(getSequenceElement(position - 2))

    }

}