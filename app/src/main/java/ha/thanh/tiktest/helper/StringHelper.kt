package ha.thanh.tiktest.helper

import java.util.*


// Magic here. Do not touch

object StringHelper {

    fun processKeyword(string: String): String {
        return if (countWord(string) == 1) {
            string
        } else {
            replaceCharAt(string, getBestPositionToCut(string), '\n')
        }
    }

    private fun countWord(string: String): Int {
        val temp = string.trim()
        val tokens = StringTokenizer(temp)
        return tokens.countTokens()
    }

    private fun getBestPositionToCut(string: String): Int {

        val middle = string.length / 2

        val preIndex = getPreIndexOfSpace(string, middle)
        val proIndex = getProIndexOfSpace(string, middle)

        return if (proIndex - middle > middle - preIndex) preIndex else proIndex
    }

    private fun getPreIndexOfSpace(string: String, middleIndex: Int): Int {
        var preIndex = -1
        var middle = middleIndex
        while (middle >= 0) {
            if (string[middle] == ' ') {
                preIndex = middle
                break
            } else {
                middle--
            }
        }
        return preIndex
    }

    private fun getProIndexOfSpace(string: String, middleIndex: Int): Int {
        var proIndex = string.length - 1
        var middle = middleIndex
        while (middle < string.length) {
            if (string[middle] == ' ') {
                proIndex = middle
                break
            } else {
                middle++
            }
        }
        return proIndex
    }

    private fun replaceCharAt(s: String, pos: Int, c: Char): String {
        return s.substring(0, pos) + c + s.substring(pos + 1)
    }
}