package com.yogo.wifood.presentation.view.placeList.newPlaceInfo

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.yogo.wifood.R
import com.yogo.wifood.presentation.view.component.MainButton
import com.yogo.wifood.presentation.view.component.PlaceInputTopAppBar
import com.yogo.wifood.presentation.view.component.YOGOLargeText
import com.yogo.wifood.presentation.view.component.YOGOTextPM15
import com.yogo.wifood.presentation.view.placeList.component.YOGOBaseTextField
import com.yogo.wifood.presentation.view.placeList.component.YOGOTransformTextField
import com.yogo.wifood.view.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetPlaceInfoMenuInfo() {
    val scrollState = rememberScrollState()
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Scaffold(
        topBar = {
            PlaceInputTopAppBar(
                leftButtonClicked = {

                },
                rightButtonOn = false
            )
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(horizontal = sidePaddingValue.dp)
            ) {
                Spacer(Modifier.weight(1f))
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_3by4),
                    contentDescription = "",
                    modifier = Modifier.wrapContentSize(),
                    tint = Color.Unspecified
                )
                Spacer(Modifier.height(6.dp))
                YOGOLargeText(
                    text = "?????? ????????? ??????????????????."
                )
                Spacer(Modifier.height(24.dp))
                YOGOSubTextField(
                    titleText = "?????????",
                    inputText = "",
                    placeholder = "???????????? ??????????????????",
                    onValueChange = {}
                )
                Spacer(Modifier.height(24.dp))
                YOGOSubTextField(
                    titleText = "??????",
                    inputText = "",
                    placeholder = "????????? ??????????????????",
                    onValueChange = {}
                )
                Spacer(Modifier.height(24.dp))
                YOGOSubTextField(
                    titleText = "?????? ??????",
                    inputText = "",
                    placeholder = "?????? ????????? ??????????????????",
                    onValueChange = {}
                )
                Spacer(Modifier.height(24.dp))
                Icon(
                    ImageVector.vectorResource(id = R.drawable.ic_add_menu_eval_button),
                    contentDescription = "left button of top app bar",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable(
                            indication = null,
                            interactionSource = interactionSource
                        ) {
                            //TODO
                        },
                    tint = Color.Unspecified
                )
                Spacer(Modifier.height(24.dp))
                Spacer(Modifier.weight(1f))
                MainButton(
                    text = "?????? ????????????",
                    onClick = { /*TODO*/ }
                )
                Spacer(Modifier.height(buttonBottomValue.dp))
            }
        }
    }
}

@Composable
fun YOGOSubTextField(
    titleText: String = "?????????",
    inputText: String = "?????????",
    placeholder: String = "???????????? ??????????????????",
    onValueChange: (String) -> Unit = {},
    transformEnable: Boolean = false
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        YOGOTextPM15(
            titleText
        )
        if (transformEnable) {
            YOGOTransformTextField(
                text = inputText,
                onValueChange = onValueChange,
                placeholderText = placeholder
            )
        } else {
            YOGOBaseTextField(
                text = inputText,
                onValueChange = onValueChange,
                placeholderText = placeholder
            )
        }
    }
}


@Composable
fun YOGOSubTextFieldWithButton_SB(
    titleText: String,
    inputText: String = "",
    placeholder: String = "?????? ????????? ??????????????????",
    onValueChange: (String) -> Unit = {},
    onTextFieldClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        YOGOTextPM15(
            buildText = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = MainColor
                    ),
                ) {
                    append("* ")
                }
                append(titleText)
            }
        )
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clickable() {
                    onTextFieldClick()
                }
        ){
            YOGOBaseTextField(
                text = inputText,
                onValueChange = onValueChange,
                placeholderText = placeholder,
                selectable = true,
                selectFunction = onTextFieldClick
            )
        }
    }
}