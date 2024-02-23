package com.codingstuff.loginandsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class FAQActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_faqactivity)

        val question1 = findViewById<TextView>(R.id.question1)
        val answer1 = findViewById<TextView>(R.id.answer1)

        // Set question and answer
        question1.text = "Q1: How do I start a new navigation?"
        answer1.text =
            "A1: To start a new navigation, you simply have to input your starting location and destination in the provided fields and then click on \"Get Directions\"."

        val question2 = findViewById<TextView>(R.id.question2)
        val answer2 = findViewById<TextView>(R.id.answer2)

        question2.text = "Q2: Why is the app not finding my location?"
        answer2.text =
            "A2: This could be due to a few reasons. Make sure that you have granted the app location permissions and that your device's location settings are turned on. If you're indoors or surrounded by high buildings, it may also affect your device's ability to receive GPS signals."

        val question3 = findViewById<TextView>(R.id.question3)
        val answer3 = findViewById<TextView>(R.id.answer3)

        question3.text = "Q3: How does the app determine the best route?"
        answer3.text =
            "A3: The app uses complex algorithms that take into account various factors such as distance, traffic conditions, and road types to determine the most efficient route for your journey."

        val question4 = findViewById<TextView>(R.id.question4)
        val answer4 = findViewById<TextView>(R.id.answer4)

        question4.text = "Q4: Can I search for specific places or landmarks?"
        answer4.text =
            "A4: Yes, our app allows you to search for specific places or landmarks. Simply enter the name of the place or landmark in the search field and the app will show it on the map and provide directions if required."

        val question5 = findViewById<TextView>(R.id.question5)
        val answer5 = findViewById<TextView>(R.id.answer5)

        question5.text = "Q5: Can I save a location for future reference?"
        answer5.text =
            "A5: Yes, our app has a feature that allows you to save locations that you frequent. This can save time as you won't have to enter these addresses every time you want directions."

        val goBackButton = findViewById<Button>(R.id.go_back_button)
        goBackButton.setOnClickListener {
            finish()
        }
    }
}
