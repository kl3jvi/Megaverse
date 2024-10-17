package result

/**
 * A sealed class representing the result of an operation, which can either be a success or an error.
 *
 * @param T The type of the data in case of a successful result.
 */
sealed class Result<out T> {
    /**
     * Represents a successful result of an operation.
     *
     * @param T The type of the data.
     * @property data The data returned by the successful operation.
     */
    data class Success<out T>(val data: T) : Result<T>()

    /**
     * Represents an error result of an operation.
     *
     * @property error The throwable that caused the error.
     */
    data class Error(val error: Throwable) : Result<Nothing>()
}
