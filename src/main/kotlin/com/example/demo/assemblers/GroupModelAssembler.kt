package com.example.demo.assemblers

import com.example.demo.controllers.DeviceController
import com.example.demo.controllers.GroupController
import com.example.demo.entities.Group
import com.example.demo.models.GroupModel
import com.example.demo.utils.modelMapper
import org.springframework.hateoas.CollectionModel
import org.springframework.hateoas.IanaLinkRelations
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn
import org.springframework.stereotype.Component


@Component
class GroupModelAssembler: RepresentationModelAssemblerSupport<Group, GroupModel>(GroupController::class.java, GroupModel::class.java) {
    override fun toModel(group: Group): GroupModel {
        val resource = modelMapper().map(group, GroupModel::class.java)

        resource.add(linkTo(methodOn(GroupController::class.java).getByName(group.name)).withSelfRel())
        resource.add(linkTo(methodOn(GroupController::class.java).getAll()).withRel(IanaLinkRelations.COLLECTION))


        return resource
    }

    override fun toCollectionModel(entities: Iterable<Group>): CollectionModel<GroupModel> {
        val resources: CollectionModel<GroupModel> = super.toCollectionModel(entities)

        resources.add(linkTo(methodOn(DeviceController::class.java).getAll()).withSelfRel())

        return resources
    }
}