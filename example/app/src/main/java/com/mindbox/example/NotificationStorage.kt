package com.mindbox.example

import cloud.mindbox.mobile_sdk.pushes.MindboxRemoteMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

object NotificationStorage {

    //Don't use this approach in your app. This storage serves demonstration purpose only.
    private val scope = CoroutineScope(Dispatchers.IO)
    private val testNotifications = listOf(
        MindboxRemoteMessage(
            uniqueKey = "Push unique key: 1",
            title = "First notification title",
            description = "First notification text",
            pushActions = emptyList(),
            pushLink = "Link from push 1",
            imageUrl = "https://sdk.maestra-static.io/demo-images/307be696-77e6-4d83-b7eb-c94be85f7a03.png",
            payload = "{\"pushName\":\"<Push name>\",\"pushDate\":\"<Push date>\"}"
        ), MindboxRemoteMessage(
            uniqueKey = "Push unique key: 2",
            title = "Second notification title",
            description = "Second notification text",
            pushActions = emptyList(),
            pushLink = "Link from push 2",
            imageUrl = "https://sdk.maestra-static.io/demo-images/2397fea9-383d-49bf-a6a0-181a267faa94.png",
            payload = "{\"pushName\":\"<Push name>\",\"pushDate\":\"<Push date>\"}"
        ), MindboxRemoteMessage(
            uniqueKey = "Push unique key: 3",
            title = "Third notification title",
            description = "Third notification text",
            pushActions = emptyList(),
            pushLink = "Link from push: 3",
            imageUrl = "https://sdk.maestra-static.io/demo-images/bd4250b1-a7ac-4b8a-b91b-481b3b5c565c.png",
            payload = "{\"pushName\":\"<Push name>\",\"pushDate\":\"<Push date>\"}"
        )
    )

    var notifications: List<MindboxRemoteMessage> = testNotifications
    val notificationsFlow = MutableSharedFlow<List<MindboxRemoteMessage>>(replay = 100)


    fun addNotification(notification: MindboxRemoteMessage) {
        notifications = notifications + notification
        scope.launch {
            notificationsFlow.emit(notifications)
        }
    }

}

