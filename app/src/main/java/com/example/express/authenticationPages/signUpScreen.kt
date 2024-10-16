package com.example.express.authenticationPages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.express.AuthState
import com.example.express.HomePageScreen
import com.example.express.LoginScreen
import com.example.express.NewsViewModel
import com.example.express.R

@Composable
fun SignUpPage(newsViewModel: NewsViewModel, navController: NavHostController ) {

  var name by remember { mutableStateOf("") }
  var email by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }
  var showPassword by remember { mutableStateOf(false) }

  val authState = newsViewModel.authState.observeAsState()
  val context = LocalContext.current

  LaunchedEffect(authState.value) {
    when (authState.value) {
      is AuthState.Authenticated -> {
        navController.navigate(HomePageScreen)
      }
      is AuthState.Error -> Toast.makeText(
        context,
        (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT
      ).show()
      else -> Unit
    }
  }

  Box(
    modifier = Modifier
      .fillMaxSize()
  )
  {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .wrapContentHeight()
        .verticalScroll(rememberScrollState()),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Image(
        painter = painterResource(R.drawable.newspaper), contentDescription = null,
        modifier = Modifier
          .width(200.dp)
          .padding(top = 16.dp)
          .padding(8.dp)
      )
      Text(
        text = "Sign Up", fontSize = 30.sp,
        fontFamily = FontFamily.Serif,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(3.dp)
      )

      OutlinedTextField(
        value = name, onValueChange = {
          name = it
        },
        label = { Text(text = "Name") },
        modifier = Modifier.padding(5.dp),
        singleLine = true,
        shape = RoundedCornerShape(percent = 30)
      )
      OutlinedTextField(
        value = email, onValueChange = {
          email = it
        },
        label = { Text(text = "E-mail") },
        modifier = Modifier.padding(5.dp),
        singleLine = true,
        shape = RoundedCornerShape(percent = 30)
      )
      OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Password") },
        modifier = Modifier
          .padding(5.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        shape = RoundedCornerShape(percent = 30),
        visualTransformation = if (showPassword) {
          VisualTransformation.None
        } else {
          PasswordVisualTransformation()
        },
        trailingIcon = {
          val image = if (showPassword) {
            painterResource(id = R.drawable.visibility)
          } else {
            painterResource(id = R.drawable.hide)
          }

          IconButton(onClick = {
            showPassword = !showPassword
          }, modifier = Modifier.size(30.dp)) {
            Icon(painter = image, contentDescription = null)
          }
        }
      )
      Button(
        onClick = { newsViewModel.signUp(email, password) },
        modifier = Modifier.padding(8.dp)
      )
      {
        Text(text = "Create Account")
      }
      TextButton(onClick = { navController.navigate(LoginScreen) }
      )
      {
        Text(text = "Already have an account? Go to Login")
      }
    }
  }
}