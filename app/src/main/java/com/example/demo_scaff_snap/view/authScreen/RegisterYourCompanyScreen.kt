package com.example.demo_scaff_snap.view.authScreen

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import androidx.core.content.FileProvider
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.android.libraries.places.api.model.Place
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController
import java.io.File
import com.example.demo_scaff_snap.R
import com.example.demo_scaff_snap.utils.FontUtils


@Composable
fun RegisterYourCompanyScreen(navController: NavController) {
    val context = LocalContext.current

    val scrollState = rememberScrollState()
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var showImagePickerDialog by remember { mutableStateOf(false) }
    var showSettingsDialog by remember { mutableStateOf(false) }
    var cameraImageUri by remember { mutableStateOf<Uri?>(null) }

    val permissionState = remember { mutableStateOf(false) }

    val requiredPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.READ_MEDIA_IMAGES, Manifest.permission.CAMERA
        )
    } else {
        arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA
        )
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val allGranted = permissions.values.all { it }
        permissionState.value = allGranted
        if (allGranted) {
            showImagePickerDialog = true
        } else {
            showSettingsDialog = true
        }
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicture()
    ) { success ->
        if (success) {
            selectedImageUri = cameraImageUri
        }
    }

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        uri?.let { selectedImageUri = it }
    }

    val createImageFile: () -> File = {
        val storageDir = context.getExternalFilesDir("Pictures")
        File.createTempFile(
            "IMG_${System.currentTimeMillis()}", ".jpg", storageDir
        )
    }

    val onImageClick = {
        permissionLauncher.launch(requiredPermissions)
    }

    var companyName by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val autocompleteLauncher = rememberLauncherForActivityResult(
        contract = StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val place = Autocomplete.getPlaceFromIntent(result.data!!)
  //          address = place.address ?: ""
        }
    }


    if (showSettingsDialog) {
        AlertDialog(
            onDismissRequest = { showSettingsDialog = false },
            title = { Text("Permission Required") },
            text = { Text("You have denied permissions. Please go to settings to enable them.") },
            confirmButton = {
                TextButton(onClick = {
                    showSettingsDialog = false
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                        //             Intent.setData = Uri.fromParts("package", context.packageName, null)
                    }
                    context.startActivity(intent)
                }) {
                    Text("Open Settings")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSettingsDialog = false }) {
                    Text("Cancel")
                }
            })
    }

    if (showImagePickerDialog) {
        AlertDialog(
            onDismissRequest = { showImagePickerDialog = false },
            title = { Text("Select Image") },
            text = {
                Column {
                    Text(
                        "Camera", modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                val imageFile = createImageFile()
                                val imageUri = FileProvider.getUriForFile(
                                    context, "${context.packageName}.provider", imageFile
                                )
                                cameraImageUri = imageUri
                                cameraLauncher.launch(imageUri)
                                showImagePickerDialog = false
                            }
                            .padding(8.dp))
                    Text(
                        "Gallery", modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                galleryLauncher.launch("image/*")
                                showImagePickerDialog = false
                            }
                            .padding(8.dp))
                }
            },
            confirmButton = {
                TextButton(onClick = { showImagePickerDialog = false }) {
                    Text("Cancel")
                }
            })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF))
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFFFDB001), Color(0xFFD66801))
                    )
                )
                .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Text(
                text = "REGISTER YOUR COMPANY",
                color = Color.White,
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 30.dp),
                fontFamily = FontUtils.poppinsSemiBold,
                textAlign = TextAlign.Center
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-20).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            ) {
                val imageModifier =
                    Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                        .clickable { onImageClick() }

                when {
                    selectedBitmap != null -> {
                        Image(
                            bitmap = selectedBitmap!!.asImageBitmap(),
                            contentDescription = "Selected Image",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    }

                    selectedImageUri != null -> {
                        val painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(context).data(selectedImageUri).size(Size.ORIGINAL)
                                .crossfade(true).allowHardware(false).build()
                        )

                        Image(
                            painter = painter,
                            contentDescription = "Selected Image",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    }

                    else -> {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = "Default Image",
                            contentScale = ContentScale.Crop,
                            modifier = imageModifier
                        )
                    }
                }
            }

            OutlinedTextField(
                value = companyName,
                onValueChange = { companyName = it },
                label = {
                    Text(
                        "Company Name", fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular, fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp)
            )


            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },
                label = {
                    Text(
                        "Mobile Number", fontFamily = FontUtils.poppinsRegular,   // ← Label Font
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,       // ← Typed Text Font
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(
                        "Email", fontFamily = FontUtils.poppinsRegular,    // ← Label font
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,        // ← Typed text font
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )


            // 🔍 Location Picker on click
            OutlinedTextField(
                value = address,
                onValueChange = {
                    // address readOnly hai, isliye blank ignore
                },
                label = {
                    Text(
                        "Address", fontFamily = FontUtils.poppinsRegular,   // ← Label font
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,       // ← Text font
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .clickable {
//                        val fields = listOf(
//                            Place.Field.ID, Place.Field.NAME, Place.Field.ADDRESS
//                        )
//                        val intent = Autocomplete.IntentBuilder(
//                            AutocompleteActivityMode.FULLSCREEN, fields
//                        ).build(context)
//                        autocompleteLauncher.launch(intent)
                    },
                readOnly = true
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {
                    Text(
                        "Create Password", fontFamily = FontUtils.poppinsRegular,   // ← Label font
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,       // ← Input text font
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )


            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                label = {
                    Text(
                        "Confirm Password", fontFamily = FontUtils.poppinsRegular,   // ← Label font
                        fontSize = 14.sp
                    )
                },
                textStyle = TextStyle(
                    fontFamily = FontUtils.poppinsRegular,       // ← Typed text font
                    fontSize = 14.sp, color = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            Button(
                onClick = { /* Handle submit */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                )
            ) {
                Text(
                    text = "SUBMIT", style = TextStyle(
                        fontSize = 14.sp, fontFamily = FontUtils.poppinsSemiBold
                    )
                )
            }
        }
    }
}
