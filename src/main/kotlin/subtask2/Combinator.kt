package subtask2

import kotlin.math.roundToInt

/*
2) Combinator
You know combinations: for example, if you take 5 cards from a 52 cards deck you have 2,598,960 different combinations.
In mathematics the number of x combinations you can take from a set of n elements is called the binomial coefficient of n and x,
or more often n choose x.
HINT: one of formulas(for m = n choose x) from combinatorics could help you with solution.
You are a renowned poster designer and painter. You are asked to provide 6 posters all having the same design each in 2 colors.
Posters must all have a different color combination and you have the choice of 4 colors: red, blue, yellow, green.
How many colors can you choose for each poster?
The answer is two since 4 choose 2 = 6. The combinations will be:
{red, blue}, {red, yellow}, {red, green},
{blue, yellow}, {blue, green}, {yellow, green}.
Now same question but you have 35 posters to provide and 7 colors available. How many colors for each poster?
If you take combinations 7 choose 2 you will get 21 with the above formula. But 21 schemes aren't enough for 35 posters.
If you take 7 choose 5 combinations you will get 21 too.
Fortunately if you take 7 choose 3 or 7 choose 4 combinations you get 35 and so each poster will have a different combination
of 3 colors or 5 colors. You will take 3 colors because it's less expensive.

Hence the problem is:
knowing m (number of posters to design), knowing n (total number of available colors), let us search x
(number of colors for each poster so that each poster has a unique combination of colors and the number of combinations is
exactly the same as the number of posters). In other words you should create a function which takes m(*Int*) and n(*Int*) and returns x(*Int*).
Some more conditions: m >= 0 and n > 0. If many x are solutions give as result the smallest x.
It can happen that when m is given at random there are no x satisfying equation (1) then return *null*.

Here's the examples:
[6, 4] would return 2
[4, 4] would return 1
[4, 2] would return *null*
*/
class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        var x :Int = 1
        val m = array[0]
        val n = array[1]
        for (i in 1..n) {
            x = (x * (n + 1 - i) / i)
            if (x == m){
                return i
            }
        }
        return null
    }
}
