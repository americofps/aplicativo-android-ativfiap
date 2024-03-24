package br.com.fiap.recicheck.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
fun LoadingScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.corAppFundo))
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo do aplicativo",
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 12.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)

            ) {
                Text(
                    text = "Aguarde um momento...\n" +
                            "Nosso sistema está verificando seu lixo... ",
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Light,
                    fontFamily = poppins
                )
                Spacer(modifier = Modifier.height(12.dp))
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Row() {
                    Image(
                        painter =
                        painterResource(id = R.drawable.loading),
                        contentDescription = "Carregando",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = " carregando informações adicionais...",
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontFamily = poppins
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 24.dp)
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.icone_loading),
                        contentDescription = "",
                        modifier = Modifier.size(170.dp)
                    )
                }
                //DEFINIR VARIAVEL DE ESTADO __________________________________________
                Text(
                    text = "0%",
                    modifier = Modifier.height(100.dp),
                    fontSize = 32.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = poppins
                )
                Row() {
                    Image(
                        painter =
                        painterResource(id = R.drawable.concluido),
                        contentDescription = "Carregando",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = " Lixo reciclável!",
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontFamily = poppins
                    )
                }
                Row() {
                    Image(
                        painter =
                        painterResource(id = R.drawable.negativo),
                        contentDescription = "Carregando",
                        modifier = Modifier
                            .size(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Text(
                        text = " Tipos de lixo diferente? Não!",
                        fontSize = 16.sp,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontFamily = poppins
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    //BOTÕES DE INTERAÇÃO DA SEGUNDA TELA-----------------------------------------

                    Button(
                        onClick = {
                            navController.navigate("result")
                                  },
                        modifier = Modifier
                            .width(150.dp)
                            .height(38.dp),
                        shape = RoundedCornerShape(0.dp),
                        colors = ButtonDefaults.buttonColors((colorResource(id = R.color.corBotao)))
                    ) {
                        Text(text = "Próximo")
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24),
                            contentDescription = ""
                        )
                    }
                }

            }
        }
    }
}