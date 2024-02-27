package com.example.controller

import com.example.model.BoxCar
import com.example.service.RailRoadService
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/railroad")
class RailRoadController(private val railRoadService: RailRoadService) {

    //List of values from the BoxCar model
    private val arrivingTrainValues: List<BoxCar> = listOf(
        BoxCar("BoxCar1", "Houston", "Fed Ex"),
        BoxCar("BoxCar2","Chicago", "Fed Ex"),
        BoxCar("BoxCar3", "Houston", "UPS"),
        BoxCar("BoxCar4", "LA", "Old Dominion"),
        BoxCar("BoxCar5", "LA", "Fed Ex"),
        BoxCar("BoxCar6", "Houston", "Old Dominion")
    )

    private var sortedTrainValues = railRoadService.listTrainValues(
        railRoadService.sortTrainValues(
            railRoadService.boxCarsToMaps(arrivingTrainValues)
        )
    )


    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return sortedTrainValues
    }
}

