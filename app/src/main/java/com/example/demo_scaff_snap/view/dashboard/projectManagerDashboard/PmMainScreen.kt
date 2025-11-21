package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo_scaff_snap.bottomNavigation.BottomNavItem
import com.example.demo_scaff_snap.bottomNavigation.BottomNavigationBar

@Preview(showBackground = true)
@Composable
fun PmMainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
            composable(BottomNavItem.ScaffoldLog.route) { ScaffoldLogScreen() }
            composable(BottomNavItem.Requests.route) { RequestsScreen() }
            composable(BottomNavItem.MyProjects.route) { MyProjectsScreen() }
        }
    }
}