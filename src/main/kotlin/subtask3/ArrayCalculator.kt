package subtask3

/*
3) Array Calculator
Your task is to implement the method, which calculates a product of N integers in array.
Example:
If we have an array: [1,2,3,4,5,6,7,8,9,0] and N = 3, the result of the function should be equal 504 (7 * 8 * 9).
If we have an array: [-1, 2, -3, 4, -5, 6, -7] and N = 5, the result should be equal to 1680 (2 * 4 * -5 * 6 * -7).
• Positive, negative and zero integers are calculated.
• Non-integer values (string, etc.) should not be included in calculation.
• If N is higher than number of integers in array, include all available integers.
*/
class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val numArray: IntArray = makeNumArray(itemsFromArray);
        if (numArray.isEmpty()) {
            return 0
        } else if (numArray.size <= numberOfItems) {
            var sum = numArray[0]
            for (i in 1..numArray.lastIndex) {
                sum *= numArray[i]
            }
            return sum;
        }
        return solveList(numArray, numberOfItems);
    }

    private fun solveList(numArray: IntArray, numberOfItems: Int): Int {
        numArray.sort()
        var multi = 1;
        var leftMulti = 0;
        var rightMulti = 0;
        var leftSide = 0;
        var rightSide = numArray.lastIndex;
        var actualNumberOfItems = numberOfItems;

        while (actualNumberOfItems>1) {
            if (rightSide - leftSide <=1 ) {
                break
            }
            leftMulti = numArray[leftSide] * numArray[leftSide + 1]
            rightMulti = numArray[rightSide] * numArray[rightSide - 1]
            if (leftMulti >= rightMulti) {
                leftSide += 2
                multi *= leftMulti
                actualNumberOfItems -=2
            } else {
                rightSide -= 2
                multi *= rightMulti
                actualNumberOfItems -=2
            }
        }
        if (actualNumberOfItems ==1){
            multi *= numArray[rightSide]
        }
        return multi
    }

    private fun makeNumArray(itemsFromArray: Array<Any>): IntArray {
        val list = emptyList<Int>().toMutableList()
        for (item in itemsFromArray) {
            if (item is Int) {
                list.add(item)
            }
        }
        return list.toIntArray()
    }
}
