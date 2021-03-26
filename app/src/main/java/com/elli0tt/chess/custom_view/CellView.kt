package com.elli0tt.chess.custom_view

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import com.elli0tt.chess.R
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor
import com.elli0tt.chess.model.Position

class CellView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val NO_DRAWABLE_ID = -1
    }

    private val cellSize = resources.getDimension(R.dimen.board_cell_size)
    private val pieceSize = resources.getDimension(R.dimen.piece_size)

    var position: Position = Position(0, 0)
        set(value) {
            field = value
            translationY = (cellSize * value.column)
            translationX = (cellSize * value.row)
        }

    init {
        layoutParams = ViewGroup.LayoutParams(cellSize.toInt(), cellSize.toInt())
    }

    fun setColor(@ColorInt color: Int) {
        setBackgroundColor(color)
    }

    fun redraw(cellModel: CellModel) {
        removeAllViews()
        if (cellModel.cellType == CellType.EMPTY) {
            return
        }
        val pieceLayoutParams = LayoutParams(pieceSize.toInt(), pieceSize.toInt())
        pieceLayoutParams.gravity = Gravity.CENTER
        val pieceView = AppCompatImageView(context)
        pieceView.layoutParams = pieceLayoutParams
        pieceView.setImageResource(getCellPieceDrawableId(cellModel))
        addView(pieceView)
    }

    @DrawableRes
    private fun getCellPieceDrawableId(cellModel: CellModel): Int {
        return when (cellModel.pieceColor) {
            PieceColor.WHITE -> getWhitePieceDrawableId(cellModel.cellType)
            PieceColor.BLACK -> getBlackPieceDrawableId(cellModel.cellType)
            PieceColor.NONE -> R.drawable.ic_possible_move_dot
        }
    }

    @DrawableRes
    private fun getWhitePieceDrawableId(cellType: CellType): Int {
        return when (cellType) {
            CellType.PAWN -> R.drawable.ic_white_pawn
            CellType.ROOK -> R.drawable.ic_white_rook
            CellType.KNIGHT -> R.drawable.ic_white_knight
            CellType.BISHOP -> R.drawable.ic_white_bishop
            CellType.QUEEN -> R.drawable.ic_white_queen
            CellType.KING -> R.drawable.ic_white_king
            else -> NO_DRAWABLE_ID
        }
    }

    @DrawableRes
    private fun getBlackPieceDrawableId(cellType: CellType): Int {
        return when (cellType) {
            CellType.PAWN -> R.drawable.ic_black_pawn
            CellType.ROOK -> R.drawable.ic_black_rook
            CellType.KNIGHT -> R.drawable.ic_black_knight
            CellType.BISHOP -> R.drawable.ic_black_bishop
            CellType.QUEEN -> R.drawable.ic_black_queen
            CellType.KING -> R.drawable.ic_black_king
            else -> NO_DRAWABLE_ID
        }
    }
}