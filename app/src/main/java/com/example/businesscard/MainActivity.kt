package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

// MainActivity class represents the main entry point of the Android application.
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xff000000)
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

// BusinessCard function represents the main composable function for displaying the business card.
@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff000000)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Displaying the Android logo
        val logo = painterResource(R.drawable.android_logo)
        Image(
            painter = logo,
            contentDescription = "Android logo",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 32.dp)
        )
        Spacer(
            modifier = Modifier
                .height(16.dp)
        )
        // Displaying the name card.
        NameCard(
            name = stringResource(R.string.FullName),
            occupationOne = stringResource(R.string.OccupationOne),
            occupationTwo = stringResource(R.string.OccupationTwo),
            backgroundColor = Color(0xff000000),
            textColor = Color(0xffffffff)
        )
        Spacer(
            modifier = Modifier.weight(1f)
        )
        // Displaying the contact card
        ContactCard(
            telephone = stringResource(R.string.Telephone),
            email = stringResource(R.string.Email),
            scholar = stringResource(R.string.Scholar),
            backgroundColor = Color(0xff000000),
            textColor = Color(0xff1fef64),
        )

    }
}

// NameCard function represents the composable for displaying the name-related information.
@Composable
fun NameCard(
    name: String,
    occupationOne: String,
    occupationTwo: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    // Displaying the name card with relevant information.
        Column(
            modifier = modifier
                .background(backgroundColor),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name,
                color = textColor,
                fontSize = 28.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = occupationOne,
                color = Color(0xff1fef64),
                fontSize = 20.sp
            )
            Text(
                text = occupationTwo,
                color = Color(0xff1fef64),
                fontSize = 20.sp
            )
        }
}
// ContactCard function represents the composable for displaying contact-related information.
@Composable
fun ContactCard(
    telephone: String,
    email: String,
    scholar: String,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier

) {
    // Displaying the contact card with relevant information.
        Column(
            modifier = modifier
                .background(backgroundColor),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Displaying dividers with 50% transparency
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color(0xff1fef64)
                    .copy(alpha = 0.25f)
            )
            // Displaying telephone information.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp)
            ) {
                val phoneIcon = painterResource(R.drawable.baseline_phone_24)
                Image(
                    painter = phoneIcon,
                    contentDescription = "Telephone",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = telephone,
                    color = textColor,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            // Displaying dividers with 50% transparency.
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color(0xff1fef64)
                    .copy(alpha = 0.25f)
            )
            //Displaying email information.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp)
            ) {
                val emailIcon = painterResource(R.drawable.baseline_email_24)
                Image(
                    painter = emailIcon,
                    contentDescription = "email address",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = email,
                    color = textColor,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            // Displaying dividers with 50% transparency.
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 2.dp,
                color = Color(0xff1fef64)
                    .copy(alpha = 0.25f)
            )
            // Displaying scholar information.
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 50.dp)
            ) {
                val outputIcon = painterResource(R.drawable.baseline_output_24)
                Image(
                    painter = outputIcon,
                    contentDescription = "Research output",
                    modifier = Modifier.padding(8.dp)
                )
                Text(
                    text = scholar,
                    color = textColor,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
}

// Preview function for showing how the business card looks in the Compose preview.
@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}