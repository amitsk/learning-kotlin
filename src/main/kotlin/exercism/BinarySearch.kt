object BinarySearch {
    fun search(lst: List<Int>, elem: Int): Int {
        fun isSorted(aLst: List<Int>): Boolean {
            if (aLst.size <= 1) return true
            else {
                for (i in 0..aLst.size - 2) {
                    if (aLst[i] > aLst[i + 1]) return false
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
            lst.isEmpty() -> return -1
            else ->  return binarySearch(0, lst.size - 1)
        }

    }
}