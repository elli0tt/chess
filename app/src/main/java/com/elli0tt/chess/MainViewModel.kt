package com.elli0tt.chess

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor
import com.elli0tt.chess.model.Position
import com.elli0tt.chess.use_cases.CellClickUseCase

class MainViewModel : ViewModel() {

    private fun generateDefaultPiecesPositions(): List<List<CellModel>> {
        val result = BoardUtil.generateEmptyBoard()

        var column = 0
        result[column][0] = CellModel(CellType.ROOK, PieceColor.BLACK)
        result[column][1] = CellModel(CellType.KNIGHT, PieceColor.BLACK)
        result[column][2] = CellModel(CellType.BISHOP, PieceColor.BLACK)
        result[column][3] = CellModel(CellType.QUEEN, PieceColor.BLACK)
        result[column][4] = CellModel(CellType.KING, PieceColor.BLACK)
        result[column][5] = CellModel(CellType.BISHOP, PieceColor.BLACK)
        result[column][6] = CellModel(CellType.KNIGHT, PieceColor.BLACK)
        result[column][7] = CellModel(CellType.ROOK, PieceColor.BLACK)

        column = 1
        for (row in 0 until BoardUtil.COLUMNS_COUNT) {
            result[column][row] = CellModel(CellType.PAWN, PieceColor.BLACK)
        }

        column = 6
        for (row in 0 until BoardUtil.COLUMNS_COUNT) {
            result[column][row] = CellModel(CellType.PAWN, PieceColor.WHITE)
        }

        column = 7
        result[column][0] = CellModel(CellType.ROOK, PieceColor.WHITE)
        result[column][1] = CellModel(CellType.KNIGHT, PieceColor.WHITE)
        result[column][2] = CellModel(CellType.BISHOP, PieceColor.WHITE)
        result[column][3] = CellModel(CellType.QUEEN, PieceColor.WHITE)
        result[column][4] = CellModel(CellType.KING, PieceColor.WHITE)
        result[column][5] = CellModel(CellType.BISHOP, PieceColor.WHITE)
        result[column][6] = CellModel(CellType.KNIGHT, PieceColor.WHITE)
        result[column][7] = CellModel(CellType.ROOK, PieceColor.WHITE)

        return result
    }

    private var _currentPiecesPositions = MutableLiveData(generateDefaultPiecesPositions())
    val currentPiecesPositions: LiveData<List<List<CellModel>>> = _currentPiecesPositions

    fun onCellClick(position: Position) {
        val cellClickUseCase = CellClickUseCase()
        currentPiecesPositions.value?.let {
            _currentPiecesPositions.value = cellClickUseCase.invoke(it, position)
        }
    }
}