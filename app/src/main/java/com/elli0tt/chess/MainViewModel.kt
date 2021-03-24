package com.elli0tt.chess

import androidx.lifecycle.ViewModel
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor

class MainViewModel : ViewModel() {

    private val whiteKingsRow = listOf(
        CellModel(CellType.ROOK, PieceColor.WHITE),
        CellModel(CellType.KNIGHT, PieceColor.WHITE),
        CellModel(CellType.BISHOP, PieceColor.WHITE),
        CellModel(CellType.QUEEN, PieceColor.WHITE),
        CellModel(CellType.KING, PieceColor.WHITE),
        CellModel(CellType.BISHOP, PieceColor.WHITE),
        CellModel(CellType.KNIGHT, PieceColor.WHITE),
        CellModel(CellType.ROOK, PieceColor.WHITE)
    )

    private val blackKingsRow = listOf(
        CellModel(CellType.ROOK, PieceColor.BLACK),
        CellModel(CellType.KNIGHT, PieceColor.BLACK),
        CellModel(CellType.BISHOP, PieceColor.BLACK),
        CellModel(CellType.QUEEN, PieceColor.BLACK),
        CellModel(CellType.KING, PieceColor.BLACK),
        CellModel(CellType.BISHOP, PieceColor.BLACK),
        CellModel(CellType.KNIGHT, PieceColor.BLACK),
        CellModel(CellType.ROOK, PieceColor.BLACK)
    )

    private val whilePawnsRow = listOf(
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE),
        CellModel(CellType.PAWN, PieceColor.WHITE)
    )

    private val blackPawnsRow = listOf(
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK),
        CellModel(CellType.PAWN, PieceColor.BLACK)
    )

    private val emptyRow = listOf(
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE),
        CellModel(CellType.EMPTY, PieceColor.NONE)
    )

    val defaultPiecePositions = listOf(
        blackKingsRow,
        blackPawnsRow,
        emptyRow,
        emptyRow,
        emptyRow,
        emptyRow,
        whilePawnsRow,
        whiteKingsRow
    )
}