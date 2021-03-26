package com.elli0tt.chess.use_cases

import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor
import com.elli0tt.chess.model.Position

class CellClickUseCase {

    fun invoke(
        piecesPositions: List<List<CellModel>>,
        clickedPosition: Position
    ): List<List<CellModel>> {
        val getPossibleMovesUseCase = GetPossibleMovesUseCase()
        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        val newPiecesPositions = piecesPositions.toList()
        possibleMoves.forEach {
            newPiecesPositions[it.column][it.row].cellType = CellType.DOT
            newPiecesPositions[it.column][it.row].pieceColor = PieceColor.NONE
        }
        return newPiecesPositions
    }
}