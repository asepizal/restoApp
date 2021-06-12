package com.example.restoapp

object RestoData {
    private val restoNames = arrayOf(
        "Ampiran Kota",
        "Drinky Squash",
        "Fairy Cafe",
        "Gigitan Cepat",
        "Istana Emas",
        "Kafe Kita",
        "Kafein",
        "Makan Mudah",
        "Melting Point",
        "Rumah Senja"
    )

    private val restoCity = arrayOf(
        "Balikpapan",
        "Surabaya",
        "Surabaya",
        "Bali",
        "Balikpapan",
        "Gorontalo",
        "Aceh",
        "Medan",
        "Ternate",
        "Bandung"
    )

    private val restoRating = doubleArrayOf(
        4.2,
        2.0,
        3.5,
        4.6,
        4.0,
        4.0,
        4.1,
        2.9,
        3.8,
        5.0,
    )

    private val restoImages = intArrayOf(
        R.drawable.ampiran_kota,
        R.drawable.drinky_squash,
        R.drawable.fairy_cafe,
        R.drawable.gigitan_cepat,
        R.drawable.istana_emas,
        R.drawable.kafe_kita,
        R.drawable.kafein,
        R.drawable.makan_mudah,
        R.drawable.melting_point,
        R.drawable.rumah_senja,
    )

    private val restoMenuFoods = arrayOf(
        arrayOf("Paket Murah 1","Paket Hemat 1", "Paket Combo 1", "Paket Promo 1", "Paket Keluarga 1"),
        arrayOf("Paket Murah 2","Paket Hemat 2", "Paket Combo 2", "Paket Promo 2", "Paket Keluarga 2"),
        arrayOf("Paket Murah 3","Paket Hemat 3", "Paket Combo 3", "Paket Promo 3", "Paket Keluarga 3"),
        arrayOf("Paket Murah 4","Paket Hemat 4", "Paket Combo 4", "Paket Promo 4", "Paket Keluarga 4"),
        arrayOf("Paket Murah 5","Paket Hemat 5", "Paket Combo 5", "Paket Promo 5", "Paket Keluarga 5"),
        arrayOf("Paket Murah 6","Paket Hemat 6", "Paket Combo 6", "Paket Promo 6", "Paket Keluarga 6"),
        arrayOf("Paket Murah 7","Paket Hemat 7", "Paket Combo 7", "Paket Promo 7", "Paket Keluarga 7"),
        arrayOf("Paket Murah 8","Paket Hemat 8", "Paket Combo 8", "Paket Promo 8", "Paket Keluarga 8"),
        arrayOf("Paket Murah 9","Paket Hemat 9", "Paket Combo 9", "Paket Promo 9", "Paket Keluarga 9"),
        arrayOf("Paket Murah 10","Paket Hemat 10", "Paket Combo 10", "Paket Promo 10", "Paket Keluarga 10"),
    )

    val listData : ArrayList<Resto>
        get() {
            val list = arrayListOf<Resto>()
            for (position in restoNames.indices){
                var resto = Resto()
                resto.name = restoNames[position]
                resto.city = restoCity[position]
                resto.rating = restoRating[position]
                resto.photo = restoImages[position]
                resto.menuFoods = restoMenuFoods[position]
                list.add(resto)
            }
            return list
        }
}