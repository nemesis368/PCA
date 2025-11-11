package com.example.dentigest // ¡IMPORTANTE! Reemplaza esto con el nombre exacto de tu paquete

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// **INICIO DE CORRECCIONES:**

// 1. Importación del archivo R para acceder a resources (layouts, drawables)
import com.example.dentigest.R

// 2. Importación de la clase del Modelo de Datos (Taller.kt)
import com.example.dentigest.Taller

// **FIN DE CORRECCIONES**

private val Taller.iconoResId: Int
    get() {
        TODO()
    }

class TalleresAdapter(private val listaTalleres: List<Taller>) :
    RecyclerView.Adapter<TalleresAdapter.TallerViewHolder>() {

    // 1. Crea las vistas de las tarjetas
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TallerViewHolder {
        // R.layout.item_category_card debe existir en res/layout
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_category_card,
            parent,
            false
        )
        return TallerViewHolder(view)
    }

    // 2. Rellena los datos en cada tarjeta
    override fun onBindViewHolder(holder: TallerViewHolder, position: Int) {
        val taller = listaTalleres[position]
        holder.bind(taller)

        // Opcional: Manejar el clic en la tarjeta
        holder.itemView.setOnClickListener {
            // Lógica para ir a la lista de cursos de este taller
            // Ejemplo: Toast.makeText(it.context, "Abriendo ${taller.nombre}", Toast.LENGTH_SHORT).show()
        }
    }

    // 3. Devuelve el número total de elementos
    override fun getItemCount() = listaTalleres.size

    // Clase interna para guardar las referencias de los elementos de la vista
    inner class TallerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Las IDs deben coincidir con tu item_category_card.xml
        private val title: TextView = itemView.findViewById(R.id.tv_category_title)
        private val count: TextView = itemView.findViewById(R.id.tv_category_count)
        private val icon: ImageView = itemView.findViewById(R.id.iv_category_icon)

        fun bind(taller: Taller) {
            title.text = taller.nombre as CharSequence?
            count.text = "${taller.cursosDisponibles} cursos disponibles"
            // Se utiliza el ID de recurso pasado desde la clase Taller
            icon.setImageResource(taller.iconoResId)
        }
    }
}
