package com.example.demo_scaff_snap.bottomNavigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.demo_scaff_snap.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home : BottomNavItem("home", "Home", R.drawable.ic_home)
    object ScaffoldLog : BottomNavItem("Scaffold Log", "Scaffold Log", R.drawable.ic_log)
    object Requests : BottomNavItem("Requests", "Requests", R.drawable.ic_send_selected)
    object MyProjects : BottomNavItem("My Projects", "My Projects", R.drawable.ic_folder_selected)
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.ScaffoldLog,
        BottomNavItem.Requests,
        BottomNavItem.MyProjects
    )

    NavigationBar {
        val currentDestination = navController.currentDestination
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painterResource(item.icon), contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentDestination?.route == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
