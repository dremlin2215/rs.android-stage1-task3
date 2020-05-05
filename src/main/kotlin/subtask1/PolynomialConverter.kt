package subtask1

import kotlin.math.abs
/*
1) Polynomial
A polynomial function can be represented by a vector of its coefficients.
For instance p(x) = 5x^3 + 2x + 3 can be described as (5, 0, 2, 3).
The latter representation is more 'computational friendly', while the first representation is more human readable.
Your task is to create function, which converts array of coefficients to equation.
The function takes an array with the *Int* coefficients as a parameter.
The coefficients array starts with the highest degree.
The function should return the polynomial in a simpel human readable form.
This means you skip 0 coefficient terms completely and you not write down 1 coefficients.
Please note that numbers could be negative. In case the input array is empty, return *null*.

Here is the example:
Input array [4, 0, 5, 20] should return "4x^3 + 5x + 20".
*/
class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {

        if (numbers.isEmpty()) {
            return null
        }
        val maxInd = numbers.size
        val sb = StringBuilder()
        sb.append("");
        for (index in numbers.indices) {
            val sign = if (numbers[index] >= 0) "+" else "-"
            val abs :String = if (abs(numbers[index]) == 1) "" else (abs(numbers[index])).toString()
            if (numbers[index] == 0) {
                continue
            }
            when {
                maxInd - index - 1 > 1 -> {
                    sb.append(" ").append(sign).append(" ").append(abs).append("x^")
                        .append(maxInd - index - 1)
                }
                maxInd - index - 1 == 1 -> {
                    sb.append(" ").append(sign).append(" ").append(abs).append("x")
                }
                else -> { //(maxInd - index - 1 == 0)
                    sb.append(" ").append(sign).append(" ").append(abs)
                }
            }
        }
        var res = sb.toString();
        res = if (res.startsWith(" +")){
            res.substring(3)
        } else {
            res.substring(1)
        }

        return res;
    }
}
