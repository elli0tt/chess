package com.elli0tt.chess.board_util_test

import com.elli0tt.chess.BoardUtil
import com.elli0tt.chess.model.Position
import org.junit.Assert.*
import org.junit.Test

class BoardUtilIsPositionInsideBoardTest {

    @Test
    fun test_isPosition_0_0_insideBoard_true() {
        assertTrue(BoardUtil.isPositionInsideBoard(Position(0, 0)))
    }

    @Test
    fun test_isPosition_7_0_insideBoard_true() {
        assertTrue(BoardUtil.isPositionInsideBoard(Position(7, 0)))
    }

    @Test
    fun test_isPosition_0_7_insideBoard_true() {
        assertTrue(BoardUtil.isPositionInsideBoard(Position(0, 7)))
    }

    @Test
    fun test_isPosition_7_7_insideBoard_true() {
        assertTrue(BoardUtil.isPositionInsideBoard(Position(0, 7)))
    }

    @Test
    fun test_isPosition_5_5_insideBoard_true() {
        assertTrue(BoardUtil.isPositionInsideBoard(Position(5, 5)))
    }

    @Test
    fun test_isPosition_minus1_minus1_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(-1, -1)))
    }

    @Test
    fun test_isPosition_minus1_0_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(-1, 0)))
    }

    @Test
    fun test_isPosition_0_minus1_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(0, -1)))
    }

    @Test
    fun test_isPosition_8_8_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(8, 8)))
    }

    @Test
    fun test_isPosition_1_8_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(1, 8)))
    }

    @Test
    fun test_isPosition_8_1_insideBoard_false() {
        assertFalse(BoardUtil.isPositionInsideBoard(Position(8, 1)))
    }
}