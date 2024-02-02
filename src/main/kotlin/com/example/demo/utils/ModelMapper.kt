package com.example.demo.utils

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean

@Bean
fun modelMapper() = ModelMapper()
