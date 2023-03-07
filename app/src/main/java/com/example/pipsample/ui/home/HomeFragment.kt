package com.example.pipsample.ui.home

import android.app.PictureInPictureParams
import android.os.Build
import android.os.Bundle
import android.util.Rational
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pipsample.MainActivity
import com.example.pipsample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClick()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setClick() {
        binding.startPipBtn.setOnClickListener {
            startPIPMode()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startPIPMode() {
        val builder = PictureInPictureParams.Builder()
        builder.setAspectRatio(Rational(16, 9))
        this.activity?.enterPictureInPictureMode(builder.build())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}