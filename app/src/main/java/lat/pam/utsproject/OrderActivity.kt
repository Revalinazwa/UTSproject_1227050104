package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val etFoodName = findViewById<EditText>(R.id.etFoodName)
        val etServings = findViewById<EditText>(R.id.etServings)
        val etNotes = findViewById<EditText>(R.id.etNotes)
        val btnPesanSekarang = findViewById<Button>(R.id.btnPesanSekarang)
        val etName = findViewById<EditText>(R.id.etName)

        btnPesanSekarang.setOnClickListener {
            val foodName = etFoodName.text.toString()
            val servings = etServings.text.toString()
            val notes = etNotes.text.toString()
            val customer = etName.text.toString()

            val intent = Intent(this, ConfirmationActivity::class.java).apply {
                putExtra("foodName", foodName)
                putExtra("servings", servings)
                putExtra("notes", notes)
                putExtra("customer", customer)
            }
            startActivity(intent)
        }

        val btnDaftarMenu = findViewById<Button>(R.id.btnDaftarMenu)
        btnDaftarMenu.setOnClickListener {
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