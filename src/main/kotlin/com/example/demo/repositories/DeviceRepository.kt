package com.example.demo.repositories

import com.example.demo.devices
import com.example.demo.entities.Device
import org.springframework.stereotype.Repository

@Repository
class DeviceRepository {
    fun getAll(): List<Device> = devices
    fun getByName(name: String): Device = devices.first { it.name.equals(name, ignoreCase = true) }
}