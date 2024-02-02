package com.example.demo.assemblers

import com.example.demo.controllers.DeviceController
import com.example.demo.entities.Device
import com.example.demo.models.DeviceModel
import com.example.demo.utils.modelMapper
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
import org.springframework.stereotype.Component



@Component
class DeviceModelAssembler: RepresentationModelAssemblerSupport<Device, DeviceModel>(DeviceController::class.java, DeviceModel::class.java) {
    override fun toModel(device: Device): DeviceModel {
        val resource = modelMapper().map(device, DeviceModel::class.java)

        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DeviceController::class.java).getByName(device.name)).withSelfRel())
        resource.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DeviceController::class.java).getAll()).withRel(IanaLinkRelations.COLLECTION))

        return resource
    }

    override fun toCollectionModel(entities: Iterable<Device>): CollectionModel<DeviceModel> {
        val resources: CollectionModel<DeviceModel> = super.toCollectionModel(entities)

        resources.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DeviceController::class.java).getAll()).withSelfRel())

        return resources
    }
}