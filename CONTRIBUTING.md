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

This repository uses build configurations from [Forge1.8.9Template]. To set up the development environment, see [Setting up your IDE](https://moddev.nea.moe/ide-setup/#setting-up-your-ide) on Legacy Modding Wiki. After opening the project with IntellJ IDEA, set up the correct JDK versions and sync Gradle projects according to the instructions on the page.

There should now be a run configuration called `Minecraft Client`, which you can find in the dropdown menu next to the run button. Use this to run the Minecraft client (not the `runClient` task in the Gradle tab).

Mixins: See [Forge1.8.9Template] for example usage (`$baseGroup/mixin/*`, `resources/accesstransformers.cfg`). If you make a change to `accesstransformers.cfg`, you might need to rebuild your project using `./gradlew build --refresh-dependencies`.

[DevAuth](https://github.com/DJtheRedstoner/DevAuth) can be optionally enabled to authenticate Minecraft accounts in development environments.

[Forge1.8.9Template]: https://github.com/lineargraph/Forge1.8.9Template
