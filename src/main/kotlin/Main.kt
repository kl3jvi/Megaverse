package org.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.example.api.MegaVerseApi
import org.example.api.model.AstralObject
import org.example.di.networkModule
import org.example.di.utils.getKoinInstance
import org.koin.core.context.startKoin
import result.Result


/**
 * The main function that runs the application.
 *
 * This function initializes the Koin dependency injection framework with the network module.
 * It retrieves the MegaVerseApi instance from the Koin context and fetches the goal map.
 * The goal map is then iterated over, and astral objects are created based on the object type.
 * The function then prints the result of creating each astral object.
 */
suspend fun main() = coroutineScope {
    startKoin {
        modules(networkModule)
    }
    val megaVerseApi: MegaVerseApi = getKoinInstance()
    megaVerseApi.getGoalMap().run {
        when (this) {
            is Result.Error -> println("Error: ${this.error}")
            is Result.Success -> {
                val goalMap: List<List<String>> = this.data.goal
                for (j in goalMap[0].indices) {
                    for (i in goalMap.indices) {
                        if (goalMap[i][j] != "SPACE") {
                            handleAstralObject(megaVerseApi, goalMap[i][j], i, j)
                            delay(1500) // to avoid rate limiting
                        }
                    }
                }
            }
        }
    }
    Unit
}

/**
 * Handles the creation of different astral objects based on the object type.
 *
 * This function takes the MegaVerseApi instance, the type of the astral object, and its position (row and column).
 * It creates the corresponding astral object (Polyanet, Soloon, or Cometh) and prints the result.
 *
 * @param megaVerseApi The MegaVerseApi instance used to create astral objects.
 * @param objectType The type of the astral object to create.
 * @param row The row position of the astral object.
 * @param column The column position of the astral object.
 */
private suspend fun handleAstralObject(megaVerseApi: MegaVerseApi, objectType: String, row: Int, column: Int) {
    when (val astralObject = AstralObject.fromString(objectType)) {
        AstralObject.POLYANET -> {
            megaVerseApi.createPolyanet(row, column).run {
                when (this) {
                    is Result.Error -> println("Error creating Polyanet: ${this.error}")
                    is Result.Success -> println("Created Polyanet at ($row, $column)")
                }
            }
        }

        AstralObject.RED_SOLOON, AstralObject.WHITE_SOLOON, AstralObject.PURPLE_SOLOON, AstralObject.BLUE_SOLOON -> {
            val color = astralObject.name.split("_")[0].lowercase()
            megaVerseApi.createSoloon(row, column, color).run {
                when (this) {
                    is Result.Error -> println("Error creating Soloon: ${this.error}")
                    is Result.Success -> println("Created $color Soloon at ($row, $column)")
                }
            }
        }

        AstralObject.LEFT_COMETH, AstralObject.RIGHT_COMETH, AstralObject.DOWN_COMETH, AstralObject.UP_COMETH -> {
            val direction = astralObject.name.split("_")[0].lowercase()
            megaVerseApi.createCometh(row, column, direction).run {
                when (this) {
                    is Result.Error -> println("Error creating Cometh: ${this.error}")
                    is Result.Success -> println("Created $direction Cometh at ($row, $column)")
                }
            }
        }

        else -> {
            // null or SPACE as it's preloaded
        }
    }
}