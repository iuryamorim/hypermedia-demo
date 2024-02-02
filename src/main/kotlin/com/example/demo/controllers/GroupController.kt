package com.example.demo.controllers

import com.example.demo.assemblers.GroupModelAssembler
import com.example.demo.entities.Group
import com.example.demo.models.GroupModel
import com.example.demo.repositories.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.hateoas.CollectionModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/groups")
class GroupController {
    @Autowired
    lateinit var groupRepository: GroupRepository

    val groupModelAssembler = GroupModelAssembler()

    @GetMapping
    fun getAll(): CollectionModel<GroupModel> = groupModelAssembler.toCollectionModel(groupRepository.getAll())

    @GetMapping("/{name}")
    fun getByName(@PathVariable("name") name: String): GroupModel = groupModelAssembler.toModel(groupRepository.getByName(name = name))

}