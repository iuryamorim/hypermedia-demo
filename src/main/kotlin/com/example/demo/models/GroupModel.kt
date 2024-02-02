package com.example.demo.models

import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.core.Relation

@Relation(collectionRelation = "groups")
open class GroupModel: RepresentationModel<GroupModel> () {
    lateinit var name: String
    lateinit var devices: List<DeviceModel>
}