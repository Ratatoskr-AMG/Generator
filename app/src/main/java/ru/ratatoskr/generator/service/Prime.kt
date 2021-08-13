package ru.ratatoskr.generator.service

import androidx.lifecycle.LifecycleCoroutineScope
import java.math.BigInteger

class Prime(lifecycleScope: LifecycleCoroutineScope) : Generator, Sequence(lifecycleScope) {

    fun isPrime(number: BigInteger?): Boolean {

        val num = number?.toInt();

        if (num == 1)
            return false;

        for (i in 2..num!!.div(2)) {
            if (num % i == 0) {
                return false
            }
        }

        return true
    }

    override fun getElement(position: Int): BigInteger {

        var flag = 0

        if (position == 0) {
            return 2.toBigInteger()
        }

        var iterator = getSequenceElement(position - 1)

        while (flag < 1) {
            iterator++
            if (isPrime(iterator)) {
                flag++
            }
        }

        return iterator
    }

}