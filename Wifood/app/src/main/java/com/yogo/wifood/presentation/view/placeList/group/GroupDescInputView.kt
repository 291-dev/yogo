package com.yogo.wifood.presentation.view.placeList.group

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.yogo.wifood.presentation.util.Route
import com.yogo.wifood.presentation.view.component.MainButton
import com.yogo.wifood.presentation.view.component.YOGOTopAppBar
import com.yogo.wifood.presentation.view.groupComponent.TextAndInputField
import com.yogo.wifood.presentation.util.ValidationEvent
import com.yogo.wifood.presentation.view.component.MyPageTopAppBar
import com.yogo.wifood.presentation.view.groupComponent.SimpleInputView
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GroupDescInputView(
    navController: NavController,
    viewModel: GroupViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val state = viewModel.formState
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = context) {
        viewModel.validationEvents.collectLatest { event ->
            when (event) {
                is ValidationEvent.Success -> {
                    navController.navigate(Route.Main.route)
                }
                is ValidationEvent.Error -> {
                    scaffoldState.snackbarHostState.showSnackbar(event.message)
                }
            }
        }
    }

    Column {
        MyPageTopAppBar(
            titleText = "",
            leftButtonClicked = {
                navController.popBackStack()
            },
            showUnderLine = false
        )
        SimpleInputView(
            explainText = "????????? ??????\n????????? ????????? ????????????.",
            textFieldText = state.description,
            onTextFieldValueChanged = {
                scope.launch {
                    viewModel.onEvent(GroupFormEvent.DescriptionChange(it))
                }
            },
            onTextFieldValueReset = {
                scope.launch {
                    viewModel.onEvent(GroupFormEvent.ResetDescriptionText)
                }
            },
            placeholderText = "?????? ?????? ??????",
            buttonText = "?????? ?????? ????????????",
            onButtonClick = {
                scope.launch {
                    viewModel.onEvent(GroupFormEvent.AddBtnClick)
                }
            },
            buttonActivate = state.description.isNotEmpty()
        )
    }
    /*
    Scaffold(
        topBar = {
            YOGOTopAppBar(
                text = "?????? ?????? ??????",
                leftButtonClicked = { navController.popBackStack() }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxSize()
        ) {
            Spacer(Modifier.height(30.dp))
            TextAndInputField(
                titleText = "????????????",
                inputFieldPlaceHolder = "????????????",
                inputFieldText = state.description,
                onValueChange = {
                    scope.launch {
                        viewModel.onEvent(GroupFormEvent.DescriptionChange(it))
                    }
                },
                onValueReset = {
                    scope.launch {
                        viewModel.onEvent(GroupFormEvent.ResetDescriptionText)
                    }
                }
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
            MainButton(
                text = "?????? ?????? ????????????",
                activate = state.description.isNotEmpty(),
                onClick = {
                    scope.launch {
                        viewModel.onEvent(GroupFormEvent.AddBtnClick)
                    }
                }
            )
            Spacer(Modifier.height(50.dp))
        }
    }
    */
}