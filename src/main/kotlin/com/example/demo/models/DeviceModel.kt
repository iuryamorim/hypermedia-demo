package com.example.demo.models

import org.springframework.hateoas.RepresentationModel
import org.springframework.hateoas.server.core.Relation

@Relation(collectionRelation = "devices")
open class DeviceModel: RepresentationModel<DeviceModel> () {
    lateinit var name: String
}