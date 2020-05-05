package subtask5

/*
5) Telephone Finder
Started in 2008 and recently resurging in popularity, a game known as Number Neighbour or Text Door Neighbor has people
sending a text message to phone numbers near their own.
Traditionally this was done for numbers ±1, so someone with the phone number 555-555-5555 has neighbors 555-555-5554 and 555- 555-5556.
We're going to take this a step further and think about neighbors based on a classic phone keypad.
First, let's take a look at the classic phone keypad:
<img alt="phone keypad" src="/images/PhoneKeypad.png" />
We can consider certain numbers adjacent if they appear directly next to or above/below each other.
For example, 1 is adjacent to 2 and 4 (and nothing else), while 5 is adjacent to 2, 4, 6, and 8.
Let's look for phone numbers that are "neighbors" of a given phone number by having any one (and only one)
of their digits be off-by-one as a number adjacent to the original.
By this definition, 555-555-5555 has both its original neighbors but also, e.g., 554-555-5555 and 555-555-5558.
Problem:
Given a phone number of string from integers length N (1 ≤ N ≤ 10) as a number string (e.g. 555-555-5555 would be passed as "5555555555"),
return an array of all phone numbers as number strings that would be considered neighbors of that phone number.
Examples:
Given "1" returns ["2", "4"]
Given "8675309" returns ["5675309", "7675309", "9675309", "0675309", "8375309", "8575309",
                        "8975309", "8645309", "8685309", "8672309", "8674309", "8676309",
                        "8678309", "8675209", "8675609", "8675389", "8675306", "8675308"]
Notes:
Do not wrap around a side of the keypad when finding adjacent numbers.
That is, do not consider 6 adjacent to 4 nor 0 adjacent to 2.
Do not consider numbers that are diagonal to each other adjacent.

In case input number is negative return *null*.

Do not worry about the order of number strings in the array being returned.
*/

class TelephoneFinder {
    private val dictionary = mapOf<String, String>(
        "1" to "24",
        "2" to "135",
        "3" to "26",
        "4" to "157",
        "5" to "2468",
        "6" to "359",
        "7" to "48",
        "8" to "5790",
        "9" to "68",
        "0" to "8"
    )

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (Integer.parseInt(number) < 0) {
            return null
        }
        val listRes = emptyList<String>().toMutableList()
        for (i in number.indices) {
            for (dict in dictionary.getValue(number[i].toString())) {
                val tmp = replace(number, i, dict)
                listRes.add(tmp)
            }
        }
        return Array(listRes.size) { i -> listRes[i] }
    }

    private fun replace(str: String, index: Int, replace: Char): String {
        val chars = str.toCharArray()
        chars[index] = replace
        return String(chars)
    }

}
