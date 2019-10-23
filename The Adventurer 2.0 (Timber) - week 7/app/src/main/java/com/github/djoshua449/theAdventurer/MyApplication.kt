package com.github.djoshua449.theAdventurer

import android.app.Application

class MyApplication: Application() {

    data class Scene(
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"


        // Scenes
        val scenes: List<Scene> = listOf (
            // 0
            Scene (
                "Saat sedang mengembara di hutan, kamu bertemu beruang kecil, apa yang kamu lakukan?",
                listOf("Membantunya", "Membiarkannya")),

            // 1
            Scene (
                "Terdapat dua jalan, ke kiri melewati bukit berbatu, dan kanan melewati hutan buah-buahan, kemana kamu akan pergi?",
                actions = listOf("Bukit berbatu","Hutan buah-buahan")),

            // 2 BAD END Devaured by Bear
            Scene (
                "Kamu dan beruang kecil tersebut terpeleset saat sedang melewati bukti bebatuan itu dan mati.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 3
            Scene (
                "Kamu tetap berjalan dengan penuh kekhawatiran, dan beruang kecil tersebut tertidur di tengah hutan dan di lahap hewan buas.",
                actions = listOf ("Try again","")),

            // 4
            Scene (
                "Kamu dan beruang kecil terus berjalan dan tiba-tiba beruang kecil itu ingin sebuah buah karena lapar. Ada 2 macam buah yang berwarna merah dan berwarna hijau, buah mana yang akan kamu beri pada beruang kecil itu?",
                actions = listOf("Buah merah", "Buah Hijau")),

            // 5
            Scene (
                "Pedass!!! teriak beruang kecil itu, Ternyata itu paprika!. Kamu memberikannya cabai, dan pada akhirnya beruang itu mati kepedasan!. ",
                actions = listOf(MAIN_MENU,"")),

            // 6
            Scene (
                "",
                actions = listOf("", "")),

            // 7 NORMAL ENDING
            Scene (
                "",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 8 BAD END
            Scene (
                "",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 9 BAD END
            Scene (
                "",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 10 BAD END
            Scene (
                "",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 11 BAD END
            Scene (
                "",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 12
            Scene (
                "Kamu dan beruang lanjut berjalan dan akhirnya sampai dirumah beruang kecil itu? Beruang tersebut mengajakmu masuk. Apa yang kamu lakukan?",
                actions = listOf("Ikut masuk", "Tidak masuk dan langsung pergi.")),

            // 13
            Scene (
                "Kamu masuk dan beruang kecil itu berterima kasih. Apa yang kamu lakukan?",
                actions = listOf("Berkata, sama-sama", "Meminta imbalan!")),

            // 14 GOOD END
            Scene (
                "Beruang tersebut dapat tidur pada musim dingin bersama keluarganya dengan bahagia dan kamu pulang dengan selamat.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 15 BAD END 1
            Scene (
                "Kamu gantung untuk dijadikan santapan beruang-beruang setelah musim dingin selesai.",
                actions = listOf (MAIN_MENU, TRY_AGAIN)),

            // 16 BAD END 2
            Scene (
                "Kamu dikira penyusup didaerah tersebut, dan kamu dikejar dan setelah itu dilahap",
                actions = listOf (MAIN_MENU, TRY_AGAIN))
        )

        // Ending flags
        var badEnding = false
        var normalEnding = false
        var goodEnding = false

        // Utils
        lateinit var currentDisplayedEnding: Scene
    }
}