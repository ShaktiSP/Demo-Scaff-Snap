package com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.pmScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.demo_scaff_snap.bottomNavigation.BottomNavItem
import com.example.demo_scaff_snap.bottomNavigation.BottomNavigationBar
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.HomeScreen
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.MyProjectsScreen
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.RequestsScreen
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.ScaffoldDetailsScreen
import com.example.demo_scaff_snap.view.dashboard.projectManagerDashboard.ScaffoldLogScreen

@Preview(showBackground = true)
@Composable
fun PmMainScreen() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val bottomBarHiddenRoutes = listOf(
        "scaffold_details",
    )

    Scaffold(
        bottomBar = {
            AnimatedVisibility(
                visible = currentRoute !in bottomBarHiddenRoutes,
                enter = slideInVertically { it },
                exit = slideOutVertically { it }
            ) {
                BottomNavigationBar(navController)
            }
        },
        containerColor = Color.White
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) {
                HomeScreen()
            }
            composable(BottomNavItem.ScaffoldLog.route) {
                ScaffoldLogScreen(navController)
            }
            composable(BottomNavItem.Requests.route) {
                RequestsScreen()
            }

            composable(BottomNavItem.MyProjects.route) {
                MyProjectsScreen()
            }

            composable("scaffold_details") {
                ScaffoldDetailsScreen()
            }
        }
    }
}