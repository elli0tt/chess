package com.elli0tt.chess

object BoardUtil {

    const val COLUMNS_COUNT = 8
    const val ROWS_COUNT = 8

    fun getLinearIndex(column: Int, row: Int): Int = column * COLUMNS_COUNT + row
}