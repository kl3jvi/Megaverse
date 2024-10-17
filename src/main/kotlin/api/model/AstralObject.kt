package org.example.api.model

import kotlinx.serialization.Serializable


@Serializable
enum class AstralObject {
    SPACE,
    POLYANET,
    RED_SOLOON,
    WHITE_SOLOON,
    PURPLE_SOLOON,
    BLUE_SOLOON,
    LEFT_COMETH,
    RIGHT_COMETH,
    DOWN_COMETH,
    UP_COMETH;

    companion object {
        /**
         * Converts a string value to an AstralObject enum.
         *
         * This function attempts to convert the given string value to an AstralObject enum by
         * uppercasing the string and replacing spaces with underscores. If the conversion fails,
         * it returns the SPACE enum as a default.
         *
         * @param value The string value to convert.
         * @return The corresponding AstralObject enum, or SPACE if the conversion fails.
         */
        fun fromString(value: String): AstralObject? {
            return runCatching {
                valueOf(value.uppercase().replace(" ", "_"))
            }.fold(
                onSuccess = { it },
                onFailure = { SPACE }
            )
        }
    }
}