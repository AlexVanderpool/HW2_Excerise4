package com.example.myapplication
import android.widget.Button
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var isGo = false
    var isWait = true
    var isStop = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            if (isGo) {
                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.Green))
                binding.button.text = getString(R.string.go)
                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.VISIBLE

                isStop = false
                isGo = false
                isWait = true

            } else if (isWait) {

                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.Yellow))
                binding.button.text = getString(R.string.wait)

                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.VISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                isStop = true
                isGo = false
                isWait = false

            } else {

                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                binding.button.text = getString(R.string.stop)

                binding.redLight.visibility = View.VISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                isStop = false
                isGo = true
                isWait = false
            }
        }
    }
}