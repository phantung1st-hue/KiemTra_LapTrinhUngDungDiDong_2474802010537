package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010537

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ giao diện bằng findViewById
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener {

            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập Email!"
                }

                password.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập Mật khẩu!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text = "Email không đúng định dạng!"
                }

                password.length < 6 -> {
                    tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                }

                else -> {
                    tvStatus.text = "Xác thực thành công!"
                }
            }
        }
    }
}