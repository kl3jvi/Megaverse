package org.example.di.utils

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Retrieves an instance of the specified type from the Koin dependency injection framework.
 *
 * This function uses reified type parameters to allow for type-safe retrieval of instances.
 * It creates an anonymous object that implements the KoinComponent interface, which provides
 * access to the Koin context. The instance of the specified type is then injected and returned.
 *
 * @param T The type of the instance to retrieve.
 * @return An instance of the specified type.
 */
inline fun <reified T> getKoinInstance(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}