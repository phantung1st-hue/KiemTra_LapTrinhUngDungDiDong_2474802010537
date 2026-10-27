package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010537

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var listViewSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ các thành phần giao diện
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        listViewSkills = findViewById(R.id.listViewSkills)

        // Nhận Email từ LoginActivity
        val email = intent.getStringExtra("EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // Hiển thị danh sách kỹ năng
        val skills = listOf(
            "Kotlin",
            "Java",
            "Android Studio",
            "Git và GitHub",
            "Thiết kế Layout XML"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skills
        )

        // Hiển thị Toast khi chọn kỹ năng
        listViewSkills.setOnItemClickListener { _, _, position, _ ->
            val selectedSkill = skills[position]

            Toast.makeText(
                this,
                "Bạn đã chọn: $selectedSkill",
                Toast.LENGTH_SHORT
            ).show()
        }

        listViewSkills.adapter = adapter

        // Xử lý nút Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }
    }
}
