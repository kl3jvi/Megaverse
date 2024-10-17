# MegaVerse API Client

This project is a Kotlin-based client for interacting with the MegaVerse API. It allows you to retrieve and manipulate various astral objects such as Polyanets, Saloons, and Comeths on a goal map.

## Project Structure

- `src/main/kotlin/api/HttpSource.kt`: Contains the `HttpSource` class which configures the HTTP client using Ktor.
- `src/main/kotlin/api/MegaVerseApi.kt`: Defines the `MegaVerseApi` interface with methods for interacting with the MegaVerse API.
- `src/main/kotlin/api/MegaVerseApiImpl.kt`: Implements the `MegaVerseApi` interface.
- `src/main/kotlin/api/model/AstralObject.kt`: Defines the `AstralObject` enum and its companion object for converting strings to enum values.
- `src/main/kotlin/api/model/Goal.kt`: Defines the `Goal` data model.
- `src/main/kotlin/api/model/Polyanet.kt`: Defines the `Polyanet` data model.
- `src/main/kotlin/api/model/Soloon.kt`: Defines the `Soloon` data model.
- `src/main/kotlin/api/model/Cometh.kt`: Defines the `Cometh` data model.
- `src/main/kotlin/result/Result.kt`: Defines the `Result` sealed class for handling success and error cases.

## Getting Started

### Prerequisites

- Kotlin 1.5+
- Gradle 6.8+
- IntelliJ IDEA 2024.1.4

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/kl3jvi/megaverse-api-client.git
   cd megaverse-api-client
    ```
2. Open the project in IntelliJ IDEA.
3. Build the project:
   ```sh
   ./gradlew build
   ```
4. Run project with this command:
   ```sh
   ./gradlew run
   ```   
