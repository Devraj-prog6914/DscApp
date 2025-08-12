package com.example.blogapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.blogapp.databinding.ActivityMain4Binding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.shashank.sony.fancytoastlib.FancyToast
import kotlin.jvm.java

class MainActivity4 : AppCompatActivity() {

    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var binding: ActivityMain4Binding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // About Us Button
        binding.btnAboutUs.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }

        // Team Members Button
        binding.btnTeamMembers.setOnClickListener {
            startActivity(Intent(this, TeamMembersActivity::class.java))
        }

        // More Features Button
        binding.btnMore.setOnClickListener {
            FancyToast.makeText(
                this,
                "More features coming soon!",
                FancyToast.LENGTH_SHORT,
                FancyToast.INFO,
                false
            ).show()
        }

        // Logout Button with confirmation
        binding.logout.setOnClickListener {
            SweetAlertDialog(this@MainActivity4, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Do you want to logout?")
                .setConfirmText("Yes!")
                .setCancelText("No")
                .setConfirmClickListener {
                    // Firebase & Google Sign-Out
                    auth.signOut()
                    googleSignInClient.signOut()

                    // Navigate back to login
                    val intent = Intent(this, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setCancelClickListener { dialog ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}
