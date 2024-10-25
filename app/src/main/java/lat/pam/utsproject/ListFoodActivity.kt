package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Batagor asli enak dari Bandung", R.drawable.batagor),
            Food("Black Salad", "Salad segar yang dibuat secara langsung", R.drawable.black_salad),
            Food("Cappucino", "Kopi cappucino asli yang dibuat dari Kopi Arabica", R.drawable.cappuchino),
            Food("Cireng", "Cireng isi dengan varian berbagai rasa.", R.drawable.cireng),
            Food("Cheesecake", "Dessert keju dengan rasa yang enak dan bahan yang berkualitas.", R.drawable.cheesecake),
            Food("Donat Madu", "Cemilan donat yang lembut dengan harga terjangkau.", R.drawable.donut),
            Food("Nasi Goreng", "Nasi goreng dengan aneka topping yang melimpah.", R.drawable.nasigoreng),
            Food("Mie Goreng", "Mie goreng nikmat tiada dua.", R.drawable.mie_goreng),
        )

        adapter = FoodAdapter(foodList)
        recyclerView.adapter = adapter

        val btnOrder = findViewById<Button>(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

//        val btnLogout = findViewById<Button>(R.id.btnLogout)
//        btnOrder.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}