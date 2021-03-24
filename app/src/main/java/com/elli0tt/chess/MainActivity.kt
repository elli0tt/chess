package com.elli0tt.chess

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.elli0tt.chess.custom_view.BoardView
import com.elli0tt.chess.model.CellModel
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor

class MainActivity : AppCompatActivity() {

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

    private val defaultPiecePositions = listOf(
        blackKingsRow,
        blackPawnsRow,
        emptyRow,
        emptyRow,
        emptyRow,
        emptyRow,
        whilePawnsRow,
        whiteKingsRow
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<BoardView>(R.id.board_view).setCurrentPiecesPositions(defaultPiecePositions)
    }
}