package com.elli0tt.chess

import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor
import com.elli0tt.chess.model.Position

object BoardUtil {

    const val COLUMNS_COUNT = 8
    const val ROWS_COUNT = 8

    fun getLinearIndex(column: Int, row: Int): Int = column * COLUMNS_COUNT + row

    fun isPositionInsideBoard(position: Position): Boolean {
        return position.column in 0 until COLUMNS_COUNT &&
                position.row in 0 until ROWS_COUNT
    }

    fun generateEmptyBoard(): List<MutableList<CellModel>> {
        val piecesPositions = ArrayList<ArrayList<CellModel>>(BoardUtil.COLUMNS_COUNT)
        for (column in 0 until BoardUtil.COLUMNS_COUNT) {
            piecesPositions.add(ArrayList(BoardUtil.ROWS_COUNT))
            for (row in 0 until BoardUtil.ROWS_COUNT) {
                piecesPositions[column].add(CellModel(CellType.EMPTY, PieceColor.NONE))
            }
        }
        return piecesPositions
    }
}