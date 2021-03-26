package com.elli0tt.chess.use_cases

import com.elli0tt.chess.BoardUtil
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.Position

class GetPossibleMovesUseCase {

    private lateinit var piecesPositions: List<List<CellModel>>
    private lateinit var clickedPosition: Position
    private lateinit var clickedCellModel: CellModel

    fun invoke(
        piecesPositions: List<List<CellModel>>,
        clickedPosition: Position
    ): List<Position> {
        this.piecesPositions = piecesPositions
        this.clickedPosition = clickedPosition
        clickedCellModel = piecesPositions[clickedPosition.column][clickedPosition.row]
        return when (clickedCellModel.cellType) {
            CellType.PAWN -> getPawnPossibleMoves()
            CellType.KNIGHT -> getKnightPossibleMoves()
            CellType.BISHOP -> getBishopPossibleMoves()
            CellType.ROOK -> getRookPossibleMoves()
            CellType.QUEEN -> getQueenPossibleMoves()
            CellType.KING -> getKingPossibleMoves()
            else -> return emptyList()
        }
    }

    private fun getPawnPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()

        return result
    }

    private fun getKnightPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()
        tryAddingPosition(result, Position(clickedPosition.column + 2, clickedPosition.row + 1))
        tryAddingPosition(result, Position(clickedPosition.column + 2, clickedPosition.row - 1))
        tryAddingPosition(result, Position(clickedPosition.column - 2, clickedPosition.row + 1))
        tryAddingPosition(result, Position(clickedPosition.column - 2, clickedPosition.row - 1))
        tryAddingPosition(result, Position(clickedPosition.column + 1, clickedPosition.row + 2))
        tryAddingPosition(result, Position(clickedPosition.column - 1, clickedPosition.row + 2))
        tryAddingPosition(result, Position(clickedPosition.column + 1, clickedPosition.row - 2))
        tryAddingPosition(result, Position(clickedPosition.column - 1, clickedPosition.row - 2))
        return result
    }

    private fun getBishopPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()

        return result
    }

    private fun getRookPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()

        return result
    }

    private fun getQueenPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()

        return result
    }

    private fun getKingPossibleMoves(): List<Position> {
        val result = ArrayList<Position>()

        return result
    }

    private fun tryAddingPosition(
        resultPositions: MutableList<Position>,
        position: Position,
    ) {
        if (BoardUtil.isPositionInsideBoard(position) &&
            piecesPositions[position.column][position.row].pieceColor != clickedCellModel.pieceColor
        ) {
            resultPositions.add(position)
        }
    }
}