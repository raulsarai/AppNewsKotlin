package com.raul.appNewsKotlin.ui

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.raul.appnewskotlin.databinding.ActivitySplashBinding

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAction()

        supportActionBar?.hide()
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        if (checkForInternet(this@SplashActivity)) {
            changeToList()
        } else {
            binding.progressBar.visibility = View.GONE
            binding.btnTry.visibility = View.VISIBLE
            binding.linearText.visibility = View.VISIBLE
            binding.linearImg.visibility = View.VISIBLE
        }

    }

    private fun initAction() {
        binding.btnTry.setOnClickListener(View.OnClickListener {
            if (checkForInternet(this@SplashActivity)) {
                changeToList()
            }
        })
    }

    fun changeToList() {
        if (binding.btnTry.visibility == View.VISIBLE) {
            binding.btnTry.visibility = View.GONE
            binding.linearText.visibility = View.GONE
            binding.linearImg.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
        }

        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        Handler(Looper.getMainLooper()).postDelayed({
            intent.change()
            finish()
        }, 3000)
    }

    fun Intent.change() {
        startActivity(this)
        finish()
    }

    //verificando se tem internet
    private fun checkForInternet(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork ?: return false
            val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false

            return when {
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true

                else -> false
            }
        } else {
            @Suppress("DEPRECATION") val networkInfo =
                connectivityManager.activeNetworkInfo ?: return false
            @Suppress("DEPRECATION") return networkInfo.isConnected
        }
    }
}
