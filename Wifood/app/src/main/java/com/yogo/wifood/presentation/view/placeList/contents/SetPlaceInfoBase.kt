package com.yogo.wifood.presentation.view.placeList.newPlaceListComposeView

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.yogo.wifood.R
import com.yogo.wifood.presentation.view.component.PlaceInputTopAppBar
import com.yogo.wifood.presentation.view.component.YOGOLargeText
import com.yogo.wifood.presentation.view.component.YOGOSwitch
import com.yogo.wifood.presentation.view.component.YOGOTextPM15
import com.yogo.wifood.presentation.view.placeList.componentGroup.DoubleButton
import com.yogo.wifood.presentation.view.placeList.newPlaceInfo.YOGOSubTextFieldWithButton_SB
import com.yogo.wifood.view.ui.theme.sidePaddingValue

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetPlaceInfoBase(

){
    val scrollState = rememberScrollState()
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            PlaceInputTopAppBar(
                leftButtonClicked = {

                },
                rightButtonClicked = {

                },
                rightButtonOn = true
            )
        }
    ){
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = sidePaddingValue.dp)
            ){
                Spacer(Modifier.weight(1f))
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_1by4),
                    contentDescription = "",
                    modifier = Modifier.wrapContentSize(),
                    tint = Color.Unspecified
                )
                Spacer(Modifier.height(6.dp))
                YOGOLargeText(
                    text = "?????? ????????? ??????????????????.",
                )
                Spacer(Modifier.height(24.dp))
                YOGOSubTextFieldWithButton_SB(
                    titleText = "?????? ??????",
                    inputText = "",
                    placeholder = "?????? ????????? ??????????????????",
                    onTextFieldClick = {}
                )
                Spacer(Modifier.height(24.dp))
                YOGOSubTextFieldWithButton_SB(
                    titleText = "?????? ??????",
                    inputText = "",
                    placeholder = "?????? ????????? ??????????????????",
                    onTextFieldClick = {}
                )
                Spacer(Modifier.height(24.dp))
                YOGOTextPM15(
                    text = "?????? ??????"
                )
                YOGOSwitch(
                    checked = false,
                    onCheckedChange = {},
                    modifier = Modifier
                )
                Spacer(Modifier.height(24.dp))
                Spacer(Modifier.weight(1f))
                DoubleButton(
                    leftButtonText = "????????????",
                    leftButtonClicked = {},
                    rightButtonText = "??? ????????????",
                    rightButtonClicked = {}
                )
                Spacer(Modifier.weight(1f))
            }
        }
    }
}