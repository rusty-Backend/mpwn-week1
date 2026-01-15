package com.example.taskapp_week1.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.taskapp_week1.domain.*

@Composable
fun HomeScreen() {

    var tasks by remember { mutableStateOf(mockTasks) }
    var newTaskTitle by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "My Tasks",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally)
            ){

            OutlinedButton(onClick = {
                tasks = filterByDone(tasks, true)
            },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
            ) {
                Text("✅")
            }

            OutlinedButton (onClick = {
                tasks = sortByDueDate(tasks)
            },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                Text("\uD83D\uDCC5")
            }

            OutlinedButton(onClick = {
                tasks = mockTasks
            },
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                ) {
                Text("\uD83D\uDD04")
            }
        }
            }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically)

        {
        OutlinedTextField(
            value = newTaskTitle,
            onValueChange = { newTaskTitle = it },
            label = { Text("New task title") },
            singleLine = true,
            modifier = Modifier.weight(1f)
        )


        OutlinedButton(
            onClick = {
                        val newTask = createTask(
                            id = tasks.size + 1,
                            title = newTaskTitle
                        )
                        tasks = addTask(tasks, newTask)
                        newTaskTitle = ""
            },
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text("➕", color = MaterialTheme.colorScheme.onBackground)
        }
        }

        Spacer(modifier = Modifier.height(16.dp))

        tasks.forEach { task ->

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(text = task.description)

                    OutlinedButton(onClick = {
                        tasks = toggleDone(tasks, task.id)
                    },
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
                        ) {
                        Text(if (task.done) "Undo" else "Done")
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Due: ${task.dueDate}")
            }

            HorizontalDivider()
        }
    }
}
