package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val tvFoodName = findViewById<TextView>(R.id.tvFoodName)
        val tvQuantity = findViewById<TextView>(R.id.tvServings)
        val tvNotes = findViewById<TextView>(R.id.tvNote)
        val tvName = findViewById<TextView>(R.id.tvName)

        val foodName = intent.getStringExtra("foodName")
        val quantity = intent.getStringExtra("servings")
        val notes = intent.getStringExtra("notes")
        val name = intent.getStringExtra("customer")

        tvFoodName.text = "Nama Pesanan: $foodName"
        tvQuantity.text = "Jumlah Sajian: $quantity"
        tvName.text = "Nama Pemesan: $name"
        tvNotes.text = "Catatan Tambahan: $notes"

        val btnBackToMenu = findViewById<Button>(R.id.btnBackToMenu)
        btnBackToMenu.setOnClickListener {
            val intent = Intent(this, ListFoodActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}