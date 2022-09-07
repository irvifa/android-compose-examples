package com.github.irvifa.bussinesscardapplication.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.irvifa.bussinesscardapplication.businesscard.api.Contact
import com.github.irvifa.bussinesscardapplication.businesscard.api.Person
import com.github.irvifa.bussinesscardapplication.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun GetBasicInformation(person: Person) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        Text(text = person.fullName, color = Color.White)
        Text(text = person.title, color = Color(0xFF3ddc84))
    }
}

@Composable
fun GetContactDetail(icon: Painter, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 40.dp),

        ) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.padding(start = 60.dp),
            Color(0xFF3ddc84)
        )
        Text(
            text = text,
            modifier = Modifier.padding(start = 25.dp),
            color = Color.White
        )

    }
}

@Composable
fun GetContact(contact: Contact) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 500.dp)
            .padding(bottom = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        GetContactDetail(
            painterResource(id = R.drawable.ic_baseline_local_phone_24),
            contact.phoneNumber
        )
        GetContactDetail(
            painterResource(id = R.drawable.ic_baseline_email_24),
            contact.email)
        GetContactDetail(
            painterResource(id = R.drawable.ic_baseline_share_24),
            contact.socialMediaHandle
        )
    }
}

@Composable
fun BusinessCard() {
    val contact = Contact(
        stringResource(R.string.phone_number),
        stringResource(R.string.email),
        stringResource(R.string.social_media_handle)
    );
    val person =
        Person(
            stringResource(R.string.full_name),
            stringResource(R.string.title),
            contact
        )
    GetBasicInformation(person)
    GetContact(contact = person.contact)
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface {
            BusinessCard()
        }

    }
}