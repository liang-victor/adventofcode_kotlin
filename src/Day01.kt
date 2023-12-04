fun main() {
    fun first_and_last_digit(line: String): Int {
        val digits = line.filter { it.isDigit() }
        val joined = digits.first().toString() + digits.last()
        return joined.toInt()
    }

    fun part1(input: List<String>): Int {
        return input.map { first_and_last_digit(it) }.sum()
    }


    /**
     * finds the first and last instances of number words
     * and replaces the first character with the number character
     */
    fun word_numbers_to_digits(line: String): String {
        val word_numbers = mapOf(
            "one" to "1",
            "two" to "2",
            "three" to "3",
            "four" to "4",
            "five" to "5",
            "six" to "6",
            "seven" to "7",
            "eight" to "8",
            "nine" to "9"
        )
        var result = line


        val find_first_number: Pair<Int, String>? = line.findAnyOf(word_numbers.keys)
        if (find_first_number != null) {
            val first_index = find_first_number.first
            result = result.replaceRange(
                startIndex = first_index,
                endIndex = first_index + 1,
                replacement = word_numbers.getValue(find_first_number.second)
            )
        }

        val find_last_number: Pair<Int, String>? = line.findLastAnyOf(word_numbers.keys)
        if (find_last_number != null) {
            val last_index = find_last_number.first
            result = result.replaceRange(
                startIndex = last_index,
                endIndex = last_index + 1,
                replacement = word_numbers.getValue(find_last_number.second)
            )
        }

        return result
    }

    fun part2(input: List<String>): Int {
        return input.map { word_numbers_to_digits(it) }
            .map { first_and_last_digit(it) }
            .sum()

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 142)

    val testInput2 = readInput("Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

