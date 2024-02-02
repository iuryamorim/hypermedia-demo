package com.example.demo.repositories

import com.example.demo.groups
import com.example.demo.entities.Group
import org.springframework.stereotype.Repository

@Repository
class GroupRepository {
    fun getAll(): List<Group> = groups
    fun getByName(name: String): Group = groups.first { it.name.equals(name, ignoreCase = true) }

}