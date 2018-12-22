package ha.thanh.tiktest

import ha.thanh.tiktest.helper.StringHelper
import org.junit.Assert
import org.junit.Test

class StringHelperShould {

    @Test
    fun return_RightStuffs() {
        val input = "thanh ha van"
        val expected = "thanh\nha van"
        Assert.assertEquals(expected, StringHelper.processKeyword(input))
    }

    @Test
    fun return_RightStuffs_Case_2() {
        val input = "ha van thanh"
        val expected = "ha van\nthanh"
        Assert.assertEquals(expected, StringHelper.processKeyword(input))
    }

    @Test
    fun return_RightStuffs_Case_3() {
        val input = "long long long"
        val expected = "long long\nlong"
        Assert.assertEquals(expected, StringHelper.processKeyword(input))
    }
    @Test
    fun return_RightStuffs_Case_4() {
        val input = "long long long"
        val expected = "long long\nlong"
        Assert.assertEquals(expected, StringHelper.processKeyword(input))
    }
    @Test
    fun return_RightStuffs_Case_5() {
        val input = "single"
        val expected = "single"
        Assert.assertEquals(expected, StringHelper.processKeyword(input))
    }
}