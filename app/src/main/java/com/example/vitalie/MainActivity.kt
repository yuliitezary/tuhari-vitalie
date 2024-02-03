package com.example.vitalie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myButton: Button = findViewById(R.id.myButton)
        myButton.setOnClickListener {
            showLoginDialog()
        }
    }

    private fun showLoginDialog() {
        val builder = AlertDialog.Builder(this)
        val inflater = LayoutInflater.from(this)
        val dialogView: View = inflater.inflate(R.layout.login_dialog, null)

        val usernameEditText: EditText = dialogView.findViewById(R.id.usernameEditText)
        val passwordEditText: EditText = dialogView.findViewById(R.id.passwordEditText)

        builder.setView(dialogView)
            .setPositiveButton("Login") { dialog, which ->
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()
                showSalutMessage(username)
            }
            .setNegativeButton("Cancel") { dialog, which ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }

    private fun showSalutMessage(username: String) {
        val salutMessage = "Salut, eu mă numesc Tuhari Vitalie. Utilizator: pe linba de programare kotlin java $username"
        showTextDialog(salutMessage)
    }

    private fun showTextDialog(message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Salut Message")
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }

        val dialog = builder.create()
        dialog.show()
    }
}
