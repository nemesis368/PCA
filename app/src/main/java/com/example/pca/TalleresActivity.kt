package com.example.dentigest // ¡IMPORTANTE! Reemplaza esto con el nombre exacto de tu paquete

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
// **INICIO DE CORRECCIONES:**

// 1. Importación del archivo R para acceder a resources (layouts, drawables)

// 2. Importación de la clase del Adaptador que creaste

// 3. Importación de la clase del Modelo de Datos que creaste

class Taller(string: String, i: Int, icTallerComputacion: Int) {

    val cursosDisponibles: String
        get() {
            TODO()
        }
    val nombre: Any
        get() {
            TODO()
        }
}

// **FIN DE CORRECCIONES**

class TalleresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // R.layout.activity_talleres debe existir en res/layout
        setContentView(R.layout.activity_talleres)

        val recyclerView: RecyclerView = findViewById(R.id.rv_talleres_categories)

        // 1. Crear la lista de datos de ejemplo
        val talleres = kotlin.collections.listOf(
            // R.drawable.ic_taller_xxx deben existir en res/drawable
            Taller("Computación Básica", 15, R.drawable.ic_taller_computacion),
            Taller("Dibujo y Pintura", 8, R.drawable.ic_taller_dibujo),
            Taller("Música y Producción", 5, R.drawable.ic_taller_musica),
            Taller("Culinaria Avanzada", 12, R.drawable.ic_taller_cocina),

        )

        // 2. Configurar el RecyclerView para que muestre 2 columnas
        val adapter = TalleresAdapter(talleres)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        // 3. Asignar el adaptador
        recyclerView.adapter = adapter
    }
}
