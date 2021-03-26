package com.elli0tt.chess

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.elli0tt.chess.custom_view.BoardView
import com.elli0tt.chess.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListeners()
        subscribeToViewModel()
    }

    private fun setListeners() {
        binding.boardView.onCellClickListener = BoardView.OnCellClickListener {
            viewModel.onCellClick(it)
        }
    }

    private fun subscribeToViewModel() {
        viewModel.currentPiecesPositions.observe(this) {
            binding.boardView.setCurrentPiecesPositions(it)
        }
    }
}