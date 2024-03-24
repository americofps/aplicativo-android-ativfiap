package br.com.fiap.recicheck.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.recicheck.R
import br.com.fiap.recicheck.ui.theme.poppins

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.corAppFundo))
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo do aplicativo",
                modifier = Modifier
                    .width(200.dp)
                    .padding(top = 12.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Image(
                    painter = painterResource(id = R.drawable.lixo_logo),
                    contentDescription = "Logo do lixo",
                    modifier = Modifier
                        .padding(top = 128.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Bem-vindo ao recicheck!",
                    fontSize = 28.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontFamily = poppins
                )
                Text(
                    text = "\n" +
                            "Com uma tecnologia IoT integrada,\n" +
                            "conseguimos detectar substânticas tóxicas \n" +
                            "e nocivas no lixo armazenado em nossa lixeira e enviar informações para o usuário através do aplicativo!\n" +
                            "Para conferir, clique em avançar!",
                    fontSize = 16.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontFamily = poppins
                )
            }
            Box() {
                Column() {
                    Button(
                        onClick = {
                            navController.navigate("load")
                        },
                        modifier = Modifier
                            .height(43.dp)
                            .width(177.dp)
                            .offset(x = 124.dp, y = 650.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors((colorResource(id = R.color.corBotao)))
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24),
                            contentDescription = "Logo do lixo"
                        )
                    }
                }
            }
        }
    }
}