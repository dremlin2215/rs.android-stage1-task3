package subtask4

import java.util.*

/*
4) Square Decomposer
My younger sister came back home from school with the following task: given a squared sheet of paper she has to cut it in pieces which,
when assembled, give squares the sides of which form an increasing sequence of numbers.
At the beginning it was lot of fun but little by little we were tired of seeing the pile of torn paper.
So we decided to write a program that could help us and protects trees.
Task:
Given a positive integral number n, return a strictly increasing sequence (array) of numbers, so that the sum of the squares is equal to n².
If there are multiple solutions (and there will be), return as far as possible the result with the largest possible values:

Examples
Decompose 11 must return [1, 2, 4, 10]. Note that there are actually two ways to decompose 11²,
11² = 121 = 2² + 6² + 9²
11² = 121 = 1² + 2² + 4² + 10²
but don't return [2, 6, 9], since 9 is smaller than 10.
For decompose 50 don't return [1, 1, 4, 9, 49] but [1, 3, 5, 8, 49] since [1, 1, 4, 9, 49] doesn't form a strictly increasing sequence.
Note
Neither [n] nor [1, 1, 1, …, 1] are valid solutions. If no valid solution exists, return *null*.
The function "decompose" will take a positive *Int* n and return the decomposition of N = n² as [x1 ... xk]
If n is negative, return *null* as well.

Examples:
decompose 50 returns [1, 3, 5, 8, 49]
decompose 4 returns *null*
*/

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val resStack = emptyList<Long>().toMutableList()
        resStack.add(number.toLong())
        var goal : Long = 0
        while (resStack.isNotEmpty()) {
            val current :Long = resStack[resStack.lastIndex];
            resStack.removeAt(resStack.lastIndex);
            goal += current * current;
            for (i in (current - 1) downTo 0) {
                val iMul:Long = (i * i)
                if (goal - iMul >= 0) {
                    resStack.add(i)
                    goal -= iMul
                }
                if (goal == 0L) {
                    val results = Array(resStack.size) { i -> resStack[i].toInt() }
                    Arrays.sort(results)
                    return results
                }
            }
        }
        return null
    }
}
