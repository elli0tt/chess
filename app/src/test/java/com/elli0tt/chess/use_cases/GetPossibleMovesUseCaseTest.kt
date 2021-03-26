package com.elli0tt.chess.use_cases

import com.elli0tt.chess.BoardUtil
import com.elli0tt.chess.model.CellType
import com.elli0tt.chess.model.PieceColor
import com.elli0tt.chess.model.Position
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GetPossibleMovesUseCaseTest {

    val getPossibleMovesUseCase = GetPossibleMovesUseCase()

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * K # # # # # # # 0
     * # # M # # # # # 1
     * # M # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_0_0_onEmptyBoard() {
        val clickedPosition = Position(0, 0)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(2, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(1, 2)))
        assertTrue(possibleMoves.contains(Position(2, 1)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # M # # # # # # 5
     * # # M # # # # # 6
     * K # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_0_7_onEmptyBoard() {
        val clickedPosition = Position(0, 7)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(2, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(1, 5)))
        assertTrue(possibleMoves.contains(Position(2, 6)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # K 0
     * # # # # # M # # 1
     * # # # # # # M # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_7_0_onEmptyBoard() {
        val clickedPosition = Position(7, 0)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(2, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(5, 1)))
        assertTrue(possibleMoves.contains(Position(6, 2)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # M # 5
     * # # # # # M # # 6
     * # # # # # # # K 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_7_7_onEmptyBoard() {
        val clickedPosition = Position(7, 7)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(2, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(5, 6)))
        assertTrue(possibleMoves.contains(Position(6, 5)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # K # # # # # # 0
     * # # # M # # # # 1
     * M # M # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_0_onEmptyBoard() {
        val clickedPosition = Position(1, 0)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(3, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 2)))
        assertTrue(possibleMoves.contains(Position(2, 2)))
        assertTrue(possibleMoves.contains(Position(3, 1)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # K # 0
     * # # # # M # # # 1
     * # # # # # M # M 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_0_onEmptyBoard() {
        val clickedPosition = Position(6, 0)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(3, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 1)))
        assertTrue(possibleMoves.contains(Position(5, 2)))
        assertTrue(possibleMoves.contains(Position(7, 2)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # M # M 5
     * # # # # M # # # 6
     * # # # # # # K # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_7_onEmptyBoard() {
        val clickedPosition = Position(6, 7)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(3, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 6)))
        assertTrue(possibleMoves.contains(Position(5, 5)))
        assertTrue(possibleMoves.contains(Position(7, 5)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * M # M # # # # # 5
     * # # # M # # # # 6
     * # K # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_7_onEmptyBoard() {
        val clickedPosition = Position(1, 7)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(3, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 5)))
        assertTrue(possibleMoves.contains(Position(2, 5)))
        assertTrue(possibleMoves.contains(Position(3, 6)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # M # # # # 0
     * # K # # # # # # 1
     * # # # M # # # # 2
     * M # M # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_1_onEmptyBoard() {
        val clickedPosition = Position(1, 1)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(4, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 3)))
        assertTrue(possibleMoves.contains(Position(2, 3)))
        assertTrue(possibleMoves.contains(Position(3, 0)))
        assertTrue(possibleMoves.contains(Position(3, 2)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # M # # # 0
     * # # # # # # K # 1
     * # # # # M # # # 2
     * # # # # # M # M 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_1_onEmptyBoard() {
        val clickedPosition = Position(6, 1)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(4, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 0)))
        assertTrue(possibleMoves.contains(Position(4, 2)))
        assertTrue(possibleMoves.contains(Position(5, 3)))
        assertTrue(possibleMoves.contains(Position(7, 3)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * M # M # # # # # 4
     * # # # M # # # # 5
     * # K # # # # # # 6
     * # # # M # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_6_onEmptyBoard() {
        val clickedPosition = Position(1, 6)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(4, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 4)))
        assertTrue(possibleMoves.contains(Position(2, 4)))
        assertTrue(possibleMoves.contains(Position(3, 5)))
        assertTrue(possibleMoves.contains(Position(3, 7)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # # # # 3
     * # # # # # M # M 4
     * # # # # M # # # 5
     * # # # # # # K # 6
     * # # # # M # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_6_onEmptyBoard() {
        val clickedPosition = Position(6, 6)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(4, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 5)))
        assertTrue(possibleMoves.contains(Position(4, 7)))
        assertTrue(possibleMoves.contains(Position(5, 4)))
        assertTrue(possibleMoves.contains(Position(7, 4)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * M # M # # # # # 0
     * # # # M # # # # 1
     * # K # # # # # # 2
     * # # # M # # # # 3
     * M # M # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_2_onEmptyBoard() {
        val clickedPosition = Position(1, 2)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(6, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 0)))
        assertTrue(possibleMoves.contains(Position(0, 4)))
        assertTrue(possibleMoves.contains(Position(2, 0)))
        assertTrue(possibleMoves.contains(Position(2, 4)))
        assertTrue(possibleMoves.contains(Position(3, 1)))
        assertTrue(possibleMoves.contains(Position(3, 3)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # M # M 0
     * # # # # M # # # 1
     * # # # # # # K # 2
     * # # # # M # # # 3
     * # # # # # M # M 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_2_onEmptyBoard() {
        val clickedPosition = Position(6, 2)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(6, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 1)))
        assertTrue(possibleMoves.contains(Position(4, 3)))
        assertTrue(possibleMoves.contains(Position(5, 0)))
        assertTrue(possibleMoves.contains(Position(5, 4)))
        assertTrue(possibleMoves.contains(Position(7, 0)))
        assertTrue(possibleMoves.contains(Position(7, 4)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * M # M # # # # # 3
     * # # # M # # # # 4
     * # K # # # # # # 5
     * # # # M # # # # 6
     * M # M # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_1_5_onEmptyBoard() {
        val clickedPosition = Position(1, 5)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(6, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 3)))
        assertTrue(possibleMoves.contains(Position(0, 7)))
        assertTrue(possibleMoves.contains(Position(2, 3)))
        assertTrue(possibleMoves.contains(Position(2, 7)))
        assertTrue(possibleMoves.contains(Position(3, 4)))
        assertTrue(possibleMoves.contains(Position(3, 6)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # # # # # # # # 0
     * # # # # # # # # 1
     * # # # # # # # # 2
     * # # # # # M # M 3
     * # # # # M # # # 4
     * # # # # # # K # 5
     * # # # # M # # # 6
     * # # # # # M # M 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_6_5_onEmptyBoard() {
        val clickedPosition = Position(6, 5)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(6, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(4, 4)))
        assertTrue(possibleMoves.contains(Position(4, 6)))
        assertTrue(possibleMoves.contains(Position(5, 3)))
        assertTrue(possibleMoves.contains(Position(5, 7)))
        assertTrue(possibleMoves.contains(Position(7, 3)))
        assertTrue(possibleMoves.contains(Position(7, 7)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * # - cell
     * 0 1 2 3 4 5 6 7
     * # M # M # # # # 0
     * M # # # M # # # 1
     * # # K # # # # # 2
     * M # # # M # # # 3
     * # M # M # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_2_2_onEmptyBoard() {
        val clickedPosition = Position(2, 2)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(8, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(0, 1)))
        assertTrue(possibleMoves.contains(Position(0, 3)))
        assertTrue(possibleMoves.contains(Position(1, 0)))
        assertTrue(possibleMoves.contains(Position(1, 4)))
        assertTrue(possibleMoves.contains(Position(3, 0)))
        assertTrue(possibleMoves.contains(Position(3, 4)))
        assertTrue(possibleMoves.contains(Position(4, 1)))
        assertTrue(possibleMoves.contains(Position(4, 3)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * E - enemy piece
     * # - cell
     * 0 1 2 3 4 5 6 7
     * K # # # # # # # 0
     * # # E # # # # # 1
     * # M # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_0_0_onBoardWithEnemy_CanTakeEnemy() {
        val clickedPosition = Position(0, 0)
        val enemyPosition = Position(2, 1)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }
        piecesPositions[enemyPosition.column][enemyPosition.row].apply {
            cellType = CellType.PAWN
            pieceColor = PieceColor.BLACK
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(2, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(1, 2)))
        assertTrue(possibleMoves.contains(Position(2, 1)))
    }

    /**
     * M - cells on which piece can be moved
     * K - knight
     * F - friendly piece
     * # - cell
     * 0 1 2 3 4 5 6 7
     * K # # # # # # # 0
     * # # F # # # # # 1
     * # M # # # # # # 2
     * # # # # # # # # 3
     * # # # # # # # # 4
     * # # # # # # # # 5
     * # # # # # # # # 6
     * # # # # # # # # 7
     */
    @Test
    fun test_getPossibleMovesForKnightOn_0_0_onBoardWithFriend_CanNotTakeFriend() {
        val clickedPosition = Position(0, 0)
        val friendPosition = Position(2, 1)
        val piecesPositions = BoardUtil.generateEmptyBoard()
        piecesPositions[clickedPosition.column][clickedPosition.row].apply {
            cellType = CellType.KNIGHT
            pieceColor = PieceColor.WHITE
        }
        piecesPositions[friendPosition.column][friendPosition.row].apply {
            cellType = CellType.PAWN
            pieceColor = PieceColor.WHITE
        }

        val possibleMoves = getPossibleMovesUseCase.invoke(piecesPositions, clickedPosition)

        assertEquals(1, possibleMoves.size)
        assertTrue(possibleMoves.contains(Position(1, 2)))
    }
}