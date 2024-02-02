package com.example.demo

import com.example.demo.entities.Device
import com.example.demo.entities.Group

val devices = listOf(
    Device(name = "IOS"),
    Device(name = "ANDROID"),
    Device(name = "APPLE_TV"),
    Device(name = "ANDROID_TV"),
)

val groups = listOf(
    Group(name = "Mobiles", devices = listOf(devices[0], devices[1])),
    Group(name = "TVs", devices = listOf(devices[3], devices[2])),
)
