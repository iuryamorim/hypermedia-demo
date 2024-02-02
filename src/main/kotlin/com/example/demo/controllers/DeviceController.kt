package com.example.demo.controllers

import com.example.demo.assemblers.DeviceModelAssembler
import com.example.demo.models.DeviceModel
import com.example.demo.repositories.DeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/devices")
class DeviceController {
    @Autowired
    lateinit var deviceRepository: DeviceRepository

    val deviceModelAssembler = DeviceModelAssembler()

    @GetMapping
    fun getAll(): CollectionModel<DeviceModel> =
            deviceModelAssembler.toCollectionModel(deviceRepository.getAll())

    @GetMapping("/{name}")
    fun getByName(@PathVariable("name") name: String): DeviceModel =
            deviceModelAssembler.toModel(deviceRepository.getByName(name = name))
}