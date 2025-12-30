package com.orenanfer.classic_cars

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.File

@RestController
@RequestMapping("/cars")
class CarController {

    @GetMapping
    fun helloWorld(): String {
        val pathName = "/home/renan/Documentos/projects/Kotlin/experiments/classic_cars/api/src/main/kotlin/com/orenanfer/classic_cars/data/cars.json"
        val jsonString: String = File(pathName).readText()
        return jsonString
    }
}