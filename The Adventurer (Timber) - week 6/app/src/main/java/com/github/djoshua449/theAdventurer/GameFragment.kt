package com.github.djoshua449.theAdventurer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.github.djoshua449.theAdventurer.databinding.FragmentGameBinding
import com.github.djoshua449.theAdventurer.MyApplication.Scene

class GameFragment : Fragment() {

    // Variables
    private val scenes = MyApplication.scenes
    lateinit var currentScene: Scene
    private var selectedActionId: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false
        )

        // This is IMPORTANT! without this, "@{}" things in [fragment_game.sml] won't work.
        currentScene = scenes[0]

        // Bind this fragment class to the layout
        binding.scene = this

        // Listener for action button
        binding.actionButton.setOnClickListener {

            if (binding.actions.checkedRadioButtonId != -1) {

                when (binding.actions.checkedRadioButtonId) {
                    binding.actionOne.id -> selectedActionId = 0
                    binding.actionTwo.id -> selectedActionId = 1

                }

                when (currentScene) {
                    scenes[0] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[1]
                            1 -> currentScene = scenes[3]
                        }
                    }
                    scenes[1] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[2]
                            1 -> currentScene = scenes[4]
                        }
                    }
                    scenes[2] -> {
                        MyApplication.badEnding = true
                        ending()
                    }
                    scenes[3] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[0]

                        }
                    }
                    scenes[4] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[5]
                            1 -> currentScene = scenes[12]
                        }
                    }
                    scenes[5] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[0]
                            1 -> currentScene = scenes[11]
                        }
                    }
                    scenes[6] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[7]
                            1 -> currentScene = scenes[10]
                        }
                    }
                    scenes[7] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[8]
                            1 -> currentScene = scenes[9]
                        }
                    }
                    scenes[8] -> {
                        MyApplication.normalEnding = true
                        ending()
                    }

                    scenes[9] -> {
                        MyApplication.badEnding = true
                        ending()
                    }

                    scenes[10] -> {
                        MyApplication.badEnding = true
                        ending()
                    }

                    scenes[11] -> {
                        MyApplication.badEnding = true
                        ending()
                    }

                    scenes[12] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[13]
                            1 -> currentScene = scenes[16]
                        }
                    }

                    scenes[13] -> {
                        when (selectedActionId) {
                            0 -> currentScene = scenes[14]
                            1 -> currentScene = scenes[15]
                        }
                    }

                    scenes[14] -> {
                        MyApplication.goodEnding = true
                        ending()
                    }

                    scenes[15] -> {
                        MyApplication.badEnding = true
                        ending()
                    }

                    scenes[16] -> {
                        MyApplication.badEnding = true
                        ending()
                    }
                }

                // Disabling options if choice == "" and enabling them if not
                binding.actionOne.isEnabled = currentScene.actions[0] != ""
                binding.actionTwo.isEnabled = currentScene.actions[1] != ""


                binding.actions.clearCheck()
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.invalidateAll()
            } else {
                Toast.makeText(
                    this.activity,
                    "Jawab salah satu opsi untuk melanjutkan!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        return binding.root
    }

    private fun ending() {

        when (selectedActionId) {
            0 -> this.activity!!.onBackPressed()
            1 -> currentScene = scenes[0]
        }
    }

}
