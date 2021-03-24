package com.elli0tt.chess.custom_view

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.elli0tt.chess.BoardUtil
import com.elli0tt.chess.R
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType

class BoardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    @ColorInt
    private val blackCellColor = ContextCompat.getColor(context, R.color.black_cell)

    @ColorInt
    private val whiteCellColor = ContextCompat.getColor(context, R.color.white_cell)

    init {
        drawEmptyBoard()
    }

    private fun drawEmptyBoard() {
        for (column in 0 until BoardUtil.COLUMNS_COUNT) {
            for (row in 0 until BoardUtil.ROWS_COUNT) {
                CellView(context).also {
                    it.setColor(getCellColor(column, row))
                    it.column = column
                    it.row = row
                    addView(it)
                }
            }
        }
    }

    @ColorInt
    private fun getCellColor(column: Int, row: Int): Int {
        var linearCellValue = BoardUtil.getLinearIndex(column, row)
        if (column % 2 == 1) {
            ++linearCellValue
        }
        return if (linearCellValue % 2 == 0) {
            whiteCellColor
        } else {
            blackCellColor
        }
    }

    fun setCurrentPiecesPositions(piecesPositions: List<List<CellModel>>) {
        for (column in piecesPositions.indices) {
            for (row in piecesPositions.indices) {
                (getChildAt(BoardUtil.getLinearIndex(column, row)) as CellView).apply {
                    redraw(piecesPositions[column][row])
                }
            }
        }
    }
}