package com.example.service

import com.example.model.BoxCar
import jakarta.inject.Singleton

@Singleton
class RailRoadService {


    fun boxCarsToMaps(boxCarList: List<BoxCar>): List<Map<String, String>> {
        return boxCarList.map { boxCar ->
            mapOf(
                "nameOfCar" to boxCar.name,
                "destination" to boxCar.destination,
                "receiver" to boxCar.receiver
            )
        }
    }


    fun mapsToBoxCars(mapsList: List<Map<String, String>>): List<BoxCar> {
        return mapsList.map { map ->
            BoxCar(
                map["nameOfCar"] ?: error("No name of map available"),
                map["destination"] ?: error("No destination available"),
                map["receiver"] ?: error("No receiver available")
            )
        }
    }


    fun sortTrainValues(arrivingTrainValues: List<Map<String, String>>): List<Map<String, String?>> {
        return arrivingTrainValues.sortedWith(compareBy<Map<String, String?>> {
            when (it["destination"]) {
                "Houston" -> 1
                "Chicago" -> 2
                "LA" -> 3
                else -> 4
            }
        }.thenBy {
            when (it["receiver"]) {
                "UPS" -> 1
                "Fed Ex" -> 2
                "Old Dominion" -> 3
                else -> 4
            }
        })
    }


    fun listTrainValues(valuesList: List<Map<String, String?>>): String {
        var iterator: Int = 1
        var sortedValuesList = ""
        for (value in valuesList){
            sortedValuesList += "$iterator- ${value.toString()}\n"
            iterator += 1
        }
        return sortedValuesList
    }
}