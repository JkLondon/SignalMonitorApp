package com.example.signalmonitorapp
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.telephony.PhoneStateListener
import android.telephony.SignalStrength
import android.telephony.TelephonyCallback
import android.telephony.TelephonyManager
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class SignalStrengthListener(private val context: Context, private val textView: TextView) : PhoneStateListener() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSignalStrengthsChanged(signalStrength: SignalStrength) {
        super.onSignalStrengthsChanged(signalStrength)

        // Get the signal strength as a percentage
        val signalStrengthPercent = signalStrength.level

        // Update the TextView with the signal strength
        textView.text = "Signal strength: $signalStrengthPercent%"

        // Log the signal strength
        Log.d("signal","Signal strength changed: $signalStrengthPercent%")
    }
}

fun startListeningForSignalStrength(context: Context, textView: TextView) {
    // Get the TelephonyManager
    val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager

    // Create a new SignalStrengthListener
    val listener = SignalStrengthListener(context, textView)

    // Register the listener with the TelephonyManager
    telephonyManager.listen(listener, PhoneStateListener.LISTEN_SIGNAL_STRENGTHS)
}

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startListeningForSignalStrength(this, )
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}