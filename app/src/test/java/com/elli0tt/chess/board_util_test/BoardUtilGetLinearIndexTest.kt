package com.elli0tt.chess.board_util_test

import com.elli0tt.chess.BoardUtil
import org.junit.Assert.*
import org.junit.Test

class BoardUtilGetLinearIndexTest {

    @Test
    fun test_getLinearIndexOn_0_0_returns_0() {
        assertEquals(0, BoardUtil.getLinearIndex(0, 0))
    }

    @Test
    fun test_getLinearIndexOn_0_1_returns_1() {
        assertEquals(1, BoardUtil.getLinearIndex(0, 1))
    }

    @Test
    fun test_getLinearIndexOn_1_0_returns_8() {
        assertEquals(8, BoardUtil.getLinearIndex(1, 0))
    }

    @Test
    fun test_getLinearIndexOn_5_5_returns_44() {
        assertEquals(45, BoardUtil.getLinearIndex(5, 5))
    }

    @Test
    fun test_getLinearIndexOn_7_7_returns_63() {
        assertEquals(63, BoardUtil.getLinearIndex(7, 7))
    }
}