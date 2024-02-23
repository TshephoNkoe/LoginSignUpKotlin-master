package com.codingstuff.loginandsignup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.firebase.auth.FirebaseAuth

class NavigationActivity : AppCompatActivity() {

    private lateinit var currentEditText: EditText
    private val AUTOCOMPLETE_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, "AIzaSyCJdsfLwFRhaAMi66kFG84ko3Hj4Uz3RqQ")
        }

        val editTextSource = findViewById<EditText>(R.id.source) // update this to navigation activity ids
        val editTextDestination = findViewById<EditText>(R.id.destination) // update this to navigation activity ids
        val button = findViewById<Button>(R.id.btnSubmit) // update this to navigation activity ids
        val goBackButton = findViewById<Button>(R.id.btnGoBack) // update this to navigation activity ids

        editTextSource.setOnClickListener {
            startAutocompleteActivity(editTextSource)
        }

        editTextDestination.setOnClickListener {
            startAutocompleteActivity(editTextDestination)
        }

        button.setOnClickListener {
            val source = editTextSource.text.toString()
            val destination = editTextDestination.text.toString()
            if (source == "" && destination == "") {
                Toast.makeText(applicationContext, "Enter both source and destination", Toast.LENGTH_SHORT).show()
            } else {
                val uri =
                    Uri.parse("https://www.google.com/maps/dir/?api=1&origin=$source&destination=$destination&dirflg=d")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                intent.setPackage("com.google.android.apps.maps")
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }

        goBackButton.setOnClickListener {
            // Go back to MainActivity
            val intent = Intent(this@NavigationActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun startAutocompleteActivity(editText: EditText) {
        val fields = listOf(Place.Field.ID, Place.Field.NAME)

        val intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
            .build(this)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)

        currentEditText = editText
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == AUTOCOMPLETE_REQUEST_CODE) {
            when (resultCode) {
                RESULT_OK -> {
                    data?.let {
                        val place = Autocomplete.getPlaceFromIntent(it)
                        currentEditText.setText(place.name)
                    }
                }

                AutocompleteActivity.RESULT_ERROR -> {
                    // TODO: Handle the error.
                    data?.let {
                        val status = Autocomplete.getStatusFromIntent(it)
                        Log.i(TAG, status.statusMessage ?: "Error occurred")
                    }
                }

                RESULT_CANCELED -> {
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        private const val TAG = "NavigationActivity"
    }
}
