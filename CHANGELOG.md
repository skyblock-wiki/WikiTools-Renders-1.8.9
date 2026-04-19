# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

The original WikiTools mod is split into two mods: WikiTools and WikiTools Renders. This mod becomes WikiTools Renders, which supports rendering features.

In this version, the non-rendering parts of the last version are removed, the mod is restructured, and various issues are fixed.

### Added

- In Render Entity GUI, add visible text descriptions for icon buttons on hover
- Add license: LGPL-3.0-or-later

### Changed

- For Render Entity GUI,
  - Buttons now appear based on usability on the entity
  - Change appearance of icon buttons
  - Change Download Head output to the new standard with hat overlay
  - The Render Entity GUI keybind now also exits the GUI
- In Add Item To Entity, move the behavior to copy armor pieces into entity armor slot from default to Shift+Key
- Remind Mod Update now expects versions that are valid SemVer
- Remind Mod Update now warns failures in console

### Removed

- Remove Copy NBT
- Remove Copy Wiki Tooltip
- Remove View SkyBlock ID
- Remove Copy Skull ID
- Remove Copy Wiki UI
- Remove Self Modifier keybind

### Fixed

- Fix big entities block controls in Render Entity GUI
  - Entities rendered in GUI are now scaled to fit in the display box
- Fix Download Head and Download Skin crash when used on default skins

## [2.6.6] - 2022-10-03

### Added

- Add wikitext slot copying

### Changed

- Change default option to no-fill

### Fixed

- Fix various UI item detection issues

## [2.6.5] - 2022-05-17

### Fixed

- Fix the issue with the lang file that causes messages to not format

If you want to translate the mod into a language you speak, create a pull request!

## [2.6.4] - 2022-03-02

### Fixed

- Fix detection for colored Blank items
- Fix text escaping for Copy Wiki Tooltip and Copy Wiki UI

## [2.6.3] - 2022-01-22

### Changed

- Update the Render Entity GUI to have Minecraft-Themed colors

### Fixed

- Fix a crash to do with creating conflicting bindings
- Fix formatting for & symbols for Copy Wiki Tooltip and Copy Wiki UI
- Fix Blank panes being exported as Empty for Copy Wiki UI

## [2.6.2] - 2021-08-22

### Fixed

- Fix Fake Player Skin Detection
- Fix Set To Steve

## [2.6.1] - 2021-08-13

### Added

- Add a manual toggle for Small Arms (Alex's Slim model) in Render Entity GUI

### Fixed

- Fix an issue with transparent pixels on skins in Render Entity GUI

## [2.6] - 2021-06-14

### Added

- Add the ability to add things to the Copied Entity by pressing the Copy Entity key when hovering over items Armors will automatically be placed onto it, and holding shift will place blocks on its head

### Changed

- Re-enable Remove Item in Render Entity GUI

### Fixed

- Fix Remove Armor not removing all armor pieces in Render Entity GUI

## [2.5] - 2021-06-13

### Added

- Add Copy Wiki UI (Key C): Copy the UI menu you have open into a Wiki UI format to your clipboard
- Add Remind Mod Update: Remind user of new mod releases as a game message

### Changed

- Add message for Copy NBT

### Fixed

- Fix some formatting issues

## [2.4] - 2021-05-18

### Changed

- Skull IDs can now be copied from placed Skulls and Entities wearing Skulls (excluding Players)

## [2.3] - 2021-05-18

### Added

- Add Copy Wiki Tooltip (Key X): Copy the item you are hovering over's generated Wiki Tooltip to your clipboard
- Add View SkyBlock ID: When Advanced Tooltips are enabled, the Skyblock ID will be shown in tooltips

## [2.2] - 2021-05-17

### Added

- Add Copy Skull ID (Key Z): Copy the Skull you are hovering over's Texture ID (usable in `https://textures.minecraft.net/texture/[texture-id]`) to your clipboard

## [2.1] - 2021-05-16

### Added

- For Render Entity GUI,
  - Add slider for Head Pitch
  - Add slider for Head Yaw
  - Add option to render a player's (or fake player's) Head as 64x64

### Changed

- Remove Item has been disabled in Render Entity GUI as the built mod behaves differently than in editor, and the method doesn't work in both

## [2.0] - 2021-05-11

This release contains the basic features of WikiTools accessible through the new GUI

### Added

- Add Open Render Entity GUI (Key K): Opens the Render Entity GUI
- Add Render Entity GUI
- Add buttons in Render Entity GUI: Set to Steve, Toggle Invisible, Remove Enchants, Remove Armor, and Remove Held Item
- Add top-right buttons of the Render Entity GUI: Copy Self, Render Skin, and Render Entity
- Add Copy Entity (Key M): Copies the entity you are looking at to the Render Entity GUI. Armors and held items will automatically go onto the entity

### Changed

- Change the Render Entity keybind to Copy Entity keybind

### Removed

- Steve Modifier keybind
- Enchant Modifier keybind
- Invisible Modifier keybind

### Deprecated

- Self Modifier keybind

## [1.0] - 2020-09-20

### Added

- Add Render Entity (Key: M): Renders the entity you are looking at to a png with the size of the minecraft window or 512/511px
  - Note: Because some entities require very fine scaling to render exactly 512px, sometimes they will render to 511px if it takes too long
- For Render Entity,
  - Add Steve Modifier (Key: RSHIFT): Changes the skin to Steve if you render a player
  - Add Enchant Modifier (Key: RCONTROL): Does not render enchantment glow
  - Add Self Modifier (Key: RMENU): Renders yourself instead
  - Add Invisible Modifier (Key: APPS): Makes the entity invisible
    - Note: This is like an invisibility potion, it will still render armor
- Add Copy NBT (Key: N): Copy the associated NBT of the entity you are looking at or the item you are hovering over to your clipboard

[unreleased]: https://github.com/skyblock-wiki/wikitools-renders-1.8.9/compare/v2.6.6...HEAD
[2.6.6]: https://github.com/Charzard4261/wikitools/compare/v2.6.5...v2.6.6
[2.6.5]: https://github.com/Charzard4261/wikitools/compare/v2.6.4...v2.6.5
[2.6.4]: https://github.com/Charzard4261/wikitools/compare/v2.6.3...v2.6.4
[2.6.3]: https://github.com/Charzard4261/wikitools/compare/v2.6.2...v2.6.3
[2.6.2]: https://github.com/Charzard4261/wikitools/compare/v2.6.1...v2.6.2
[2.6.1]: https://github.com/Charzard4261/wikitools/compare/v2.6...v2.6.1
[2.6]: https://github.com/Charzard4261/wikitools/compare/v2.5...v2.6
[2.5]: https://github.com/Charzard4261/wikitools/compare/v2.4...v2.5
[2.4]: https://github.com/Charzard4261/wikitools/compare/v2.3...v2.4
[2.3]: https://github.com/Charzard4261/wikitools/compare/v2.2...v2.3
[2.2]: https://github.com/Charzard4261/wikitools/compare/v2.1...v2.2
[2.1]: https://github.com/Charzard4261/wikitools/compare/v2.0...v2.1
[2.0]: https://github.com/Charzard4261/wikitools/compare/b1a7968...v2.0
[1.0]: https://github.com/mikuhl-dev/wikitools/tree/b1a7968
