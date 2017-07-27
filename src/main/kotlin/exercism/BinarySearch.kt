object BinarySearch {
    fun search(lst: List<Int>, elem: Int): Int {
        fun isSorted(lst: List<Int>): Boolean {
            if (lst?.size ?:0 <= 1) return true
            else {
                for (i in 0..lst.size - 2) {
                    if (lst[i] > lst[i + 1]) return false
                }
            }
            return true
        }

        fun binarySearch(left: Int, right: Int): Int {
            if (left > right) return -1
            else {
                val middle = (left + right) / 2
                return when {
                    lst[middle] < elem -> binarySearch(middle + 1, right)
                    lst[middle] > elem -> binarySearch(left, middle - 1)
                    else -> middle
                }
            }
        }
        when {
            !isSorted(lst) -> throw IllegalArgumentException()
            lst?.isEmpty() -> return -1
            else ->  return binarySearch(0, lst.size - 1)
        }

    }
}