## For Contributors

## Current Practices

- Use coding best practices.
- Write good tests, automated or manual.

## Project Structure

- The top-level project directory has two possible subdirectories: `feature` and `common`.
    - Each subdirectory of `feature` consists of a feature of the mod.
    - Normally, feature code should remain isolated to that feature until it becomes beneficial to share a piece of code.
    - The `common` directory consists of code that are sparingly shared between features.

## Important Files

To bump version, update `gradle.properties`. Refresh Gradle.

Mod settings may exist in these places:

- `gradle.properties`
- `build.gradle`
- `mcmod.info`
- `ModProperties.java`

## Development Environment

[DevAuth](https://github.com/DJtheRedstoner/DevAuth) can be optionally enabled to authenticate Minecraft accounts in development environments.
