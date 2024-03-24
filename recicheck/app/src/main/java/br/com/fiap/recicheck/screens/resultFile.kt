package br.com.fiap.recicheck.screens


//
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Snackbar
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.material.TextField
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.recicheck.R
import br.com.fiap.recicheck.ui.theme.poppins
import br.com.fiap.recicheck.viewModel.CoordenadasScreanViewModel
import kotlinx.coroutines.delay


@Composable
fun resultScreen(navController: NavController, viewModel: CoordenadasScreanViewModel) {
 // Declarando funcoes
    val statelugar by viewModel.statelugar.observeAsState(initial = "")

    val lat by viewModel.lat.observeAsState(initial = "Carregando...")
    val lon by viewModel.lon.observeAsState(initial = "Carregando...")

    val showMessageNulo by viewModel.showMessageNulo.observeAsState(initial = false)
    val showMessageNExiste by viewModel.showMessageNExise.observeAsState(initial = false)


    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.corAppFundo))) {
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
                //TEXTBOX
                TextField(
                    value = statelugar,
                    onValueChange = { viewModel.onStatelugarChange(it) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .padding(horizontal = 20.dp),
                    textStyle = TextStyle(fontSize = 20.sp),
                    placeholder = {
                        Text(text = "Digite uma cidade para retornar a lat/long")
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "",
                            tint = Color.Black
                        )
                    },
                    trailingIcon = {
                        if (statelugar.isNotEmpty()) {
                            Icon(
                                imageVector = Icons.Default.Clear,
                                contentDescription = "Clear Icon",
                                tint = Color.Black,
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .clickable { viewModel.Clear() }
                            )
                        }
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            if (statelugar.isNotEmpty()) {
                                viewModel.consumirApi()
                            }else {
                                viewModel.ShowTrueNulo()
                            }
                        },
                    ),
                    shape = RoundedCornerShape(10.dp),
                    interactionSource = remember { MutableInteractionSource() },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White,
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }
            if (showMessageNulo) {
                Snackbar(
                    action = {

                    },
                    backgroundColor = Color(0xff2A5A26),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)

                ) {
                    Text(text = "O campo não pode estar vazio", color = Color.White)
                }
                LaunchedEffect(true) {
                    // Aguarde um atraso de 3 segundos antes de ocultar o Snackbar
                    delay(2000)
                    viewModel.ShowFalseNulo()
                }
            }
            if (showMessageNExiste) {
                Snackbar(
                    action = {

                    },
                    backgroundColor = Color(0xff2A5A26),
                    elevation = 4.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)

                ) {
                    Text(text = "Esse lugar não existe no nosso banco de dados.", color = Color.White)
                }
                LaunchedEffect(true) {
                    // Aguarde um atraso de 3 segundos antes de ocultar o Snackbar
                    delay(3000)
                    viewModel.ShowFalseNexiste()
                }
            }
        }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                Spacer(modifier = Modifier.height(15.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()) {

                    Column (horizontalAlignment = Alignment.CenterHorizontally,

                        modifier = Modifier.padding(top = 150.dp)){

                        //Retorno API
                        Text(
                            text = "${lat}/${lon} - Latitude e Longitude.",
                            fontSize = 28.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light,
                            fontFamily = poppins
                        )

                        Image(painter = painterResource(id = R.drawable.concluido_hd),
                            contentDescription = "",
                            modifier = Modifier.size(170.dp)
                        )
                    }
                    Row(modifier = Modifier.padding(top = 24.dp)) {
                        Image(painter =
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
                        Image(painter =
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
                    Row() {
                        Image(painter =
                        painterResource(id = R.drawable.concluido),
                            contentDescription = "Carregando",
                            modifier = Modifier
                                .size(16.dp)
                                .align(Alignment.CenterVertically)
                        )
                        Text(
                            text = "Esse lixo não contém nenhuma substância tóxica",
                            fontSize = 14.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Light,
                            fontFamily = poppins
                        )
                    }
                    Row (modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        //BOTÕES DE INTERAÇÃO DA SEGUNDA TELA-----------------------------------------

                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(150.dp)
                                .height(38.dp),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors((colorResource(id = R.color.corBotao)))
                        ) {
                            Text(text = "Baixar PDF")
                            Icon(painter = painterResource(id = R.drawable.baseline_download_24), contentDescription = "")
                        }
                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier
                                .width(170.dp)
                                .height(38.dp),
                            shape = RoundedCornerShape(0.dp),
                            colors = ButtonDefaults.buttonColors((colorResource(id = R.color.corBotao)))) {
                            Text(text = "Nova verificação")
                            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "")
                        }
                    }
                }
            }

        }



