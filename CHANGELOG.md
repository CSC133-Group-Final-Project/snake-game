## [v0.1.1] - 2023-12-11

**🐛 fix: update workflow and fix changelog generator** ([`da02f65`](https://github.com/Snake-Charmers/charming-snake/commit/da02f65d8d1765f4a34dd5ad17afab4f2a591d96))

**✨ Enhance Snake Game with New Graphics For Snake Head, Background Image, and UI Updates** ([`4cebeeb`](https://github.com/Snake-Charmers/charming-snake/commit/4cebeebb275668370491f66ba6bca74180afc35f))

    - 📝 CollisionEventPublisher.java:

    - 👍 Improved collision detection with size-aware algorithms.

    - 🚦 Utilized `snakeSize` from `ScreenInfo` for precise boundary calculations.

    - 🔃 Apple.java Updates:

    - 📝 Enlarged apple bitmap to triple the block size for better visibility.

    - 🔃 Modified apple reset logic to fit the updated size.

    - 📝 Snake.java Graphics Overhaul:

    - 📝 Introduced a new snake head bitmap, scaled to three times the segment size.

    - 🔃 Updated head and body bitmaps to align with new size standards.

    - ✨ GameRenderer.java Enhancements:

    - 👨‍💻 Implemented a new background image for a more engaging game environment.

    - 📝 Replaced plain canvas background with the new image.

    - 📝 SnakeActivity.java and SnakeGame.java:

    - 🔃 Minor comment updates for improved code clarity.

    - 🔃 Drawable Resource Update (`body.png`):

    - 📝 Aligned `body.png` image with new graphical standards.

**➕ feat: Add GameMenuActivity and related resources for menu screen** ([`5f2345a`](https://github.com/Snake-Charmers/charming-snake/commit/5f2345a0edbd474b878aa08f4f426f8b28813dc6))

    - ➕ New Activity: Added a new Android activity named GameMenuActivity. This activity is designed to serve as the main menu screen for the game.

    - 📝 Layout XML: Included a new layout XML file named menu_layout.xml. This XML file defines the layout of the game menu screen, including buttons for play, high score, sound settings, about, and exit.

    - ➕ Resource Strings: Added string resources for the menu items and buttons, such as "Play," "High Score," "Sound On/Off," "About," and "Exit." These strings are defined in both the default values/strings.xml and values-night/strings.xml resource files for localization and dark mode support.

    - 📝 Color Resources: Introduced color resources, including orange_500, which is used for button background tint, ensuring a consistent visual theme throughout the menu layout.

    - 🔧 GameMenuActivity Logic: In the GameMenuActivity class, implemented logic to handle button clicks. When the "Play" button is clicked, it launches the SnakeActivity. The "Exit" button is configured to close the application.

**🔀 Merge pull request #3 from Snake-Charmers/sprint2-updates** ([`f18fa5c`](https://github.com/Snake-Charmers/charming-snake/commit/f18fa5cc21c3f3a392b4d15e533be3246a3357ec))

**➕ (feat) Add Slow Down Power Up functionality and implement IResettable…** ([`f18fa5c`](https://github.com/Snake-Charmers/charming-snake/commit/f18fa5cc21c3f3a392b4d15e533be3246a3357ec))

**➕ (feat) Add Slow Down Power Up functionality and implement IResettableEntity** ([`40df221`](https://github.com/Snake-Charmers/charming-snake/commit/40df221b6fab0e496c1fcd03e309e3bc27201b17))

    - 👨‍💻 Implement `SlowDownPowerUp` class to introduce a new power-up in the game.

    - 🔃 Update `GameManager`, `Snake`, `Apple`, and `HighScoreBoard` to handle the new power-up.

    - ➕ Add `reset` method in `IResettableEntity` interface and its implementations for better game reset handling.

    - ✨ Refactor and comment code for enhanced clarity and maintainability.

    - 📝 Include graphical resources for the new power-up.

**🔀 Merge pull request #2 from Snake-Charmers/CollisionDetection** ([`0a2bdef`](https://github.com/Snake-Charmers/charming-snake/commit/0a2bdef5e5aac8d6c21f61e8ccd4cce62f13954a))

**📝 Collision detection** ([`0a2bdef`](https://github.com/Snake-Charmers/charming-snake/commit/0a2bdef5e5aac8d6c21f61e8ccd4cce62f13954a))

**🔨 Refactor Collision detector logic by introducing publisher and listeners** ([`61c0f7e`](https://github.com/Snake-Charmers/charming-snake/commit/61c0f7e35a7587920befa96cee93e57831d50568))

**📝 (feat) separate score tracker from GameManager class to HighScoreBoard class** ([`cdfa627`](https://github.com/Snake-Charmers/charming-snake/commit/cdfa627e7b43e8a810d92d7f4c4ceaa0aecc832c))

**🔀 Merge pull request #1 from Snake-Charmers/develop** ([`eadcf3d`](https://github.com/Snake-Charmers/charming-snake/commit/eadcf3d03673d1cbeb82cbba6aa3c2808a59cd66))

**📝 Major overhaul** ([`eadcf3d`](https://github.com/Snake-Charmers/charming-snake/commit/eadcf3d03673d1cbeb82cbba6aa3c2808a59cd66))

**🔀 Merge branch 'master' into develop** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**📝 * master:** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**📚   Update changelog** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**✨   feature: Add automated changelog generation and tagging workflow** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**📚   Create CHANGELOG.md** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**✨   Refactor and Enhance Game Mechanics for Snake Game** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**🔨   Implement AudioManager and Refactor Sound Management in Snake Game** ([`5c58c4f`](https://github.com/Snake-Charmers/charming-snake/commit/5c58c4f1ceabd5cd807fd4f1068f494172dadc1c))

**✨ feature: Add automated changelog generation and tagging workflow** ([`9e8f373`](https://github.com/Snake-Charmers/charming-snake/commit/9e8f373e815fe401aa79e0196dcce4debb3e6d16))

    - 📚 Introduce a new GitHub Actions workflow 'changelog-tagging.yml' for automated changelog generation and version tagging.

    - 🐛 Triggers workflow on pushes to 'master', 'develop', 'feature/*', 'bugfix/*', and 'hotfix/*' branches.

    - 📚 Add logic to check if a new tag is required based on the commit history, create and push new tags when needed, generate changelogs for new releases, and update the running changelog for upcoming releases.

    - 📚 Additionally, designed 'changelog_manager.py' script, which contains the necessary logic for these operations, such as determining the current version, incrementing patch versions, formatting commit messages, and managing changelog content.

**📚 Update changelog** ([`06045ab`](https://github.com/Snake-Charmers/charming-snake/commit/06045ab80950055a6eb38a506e1fbbdabf6ad2cf))

**✨ feature: Add automated changelog generation and tagging workflow** ([`4b988b7`](https://github.com/Snake-Charmers/charming-snake/commit/4b988b74b829d9a4db9743758ff4e99d3dd7c577))

    - 📚 Introduce a new GitHub Actions workflow 'changelog-tagging.yml' for automated changelog generation and version tagging.

    - 🐛 Triggers workflow on pushes to 'master', 'develop', 'feature/*', 'bugfix/*', and 'hotfix/*' branches.

    - 📚 Add logic to check if a new tag is required based on the commit history, create and push new tags when needed, generate changelogs for new releases, and update the running changelog for upcoming releases.

    - 📚 Additionally, designed 'changelog_manager.py' script, which contains the necessary logic for these operations, such as determining the current version, incrementing patch versions, formatting commit messages, and managing changelog content.

**📚 Create CHANGELOG.md** ([`4388c41`](https://github.com/Snake-Charmers/charming-snake/commit/4388c41941b71db02ae37200a33ea1a62e4931c0))

**✨ Refactor and Enhance Game Mechanics for Snake Game** ([`6b65fdf`](https://github.com/Snake-Charmers/charming-snake/commit/6b65fdf89dce8208aa5d04dbe40664fcab279222))

    - 👍 Implemented InputController for improved touch event handling.

    - 📝 Expanded GameEventPublisher with new event notification methods.

    - ✨ Removed GameEventListenerImpl, integrating its features into other classes.

    - ✨ Refined IGameEventListener and ITouchEventListener interfaces for enhanced event management.

    - ✨ Enhanced GameManager with updated game logic and interaction handling.

    - 📝 Introduced GameStateManager for effective game state and threading management.

    - ➕ Added GameRenderer for dynamic rendering, including conditional display of 'Tap to Play'.

    - 🎨 Updated GameConstants and ScreenInfo for extended functionality and screen information retrieval.

**🔨 Implement AudioManager and Refactor Sound Management in Snake Game** ([`2276233`](https://github.com/Snake-Charmers/charming-snake/commit/2276233c457ff9a9a74d3a584dcc8c81b16ef686))

    - 👨‍💻 Implemented `AudioManagerImpl`, a new class for managing audio functionalities in the Snake game.

    - 📝 Integrated the `IAudioManager` interface for consistent audio management across the application.

    - 🚀 Utilized `SoundPool` for efficient audio playback, supporting simultaneous streams with optimized attributes.

    - 🚦 Created singleton pattern in `AudioManagerImpl` for global access and resource efficiency.

    - ➕ Added sound loading and playing functionalities within `AudioManagerImpl`, handling exceptions and ensuring thread safety.

    - 📝 Defined new constants `EAT_SOUND` and `DEATH_SOUND` in `GameConstants` for clear identification of sound effects.

    - 🔨 Refactored `SnakeGame` to utilize `AudioManagerImpl` for sound effects, replacing direct `SoundPool` usage.

    - ➖ Removed commented-out code and unused imports in `SnakeGame` and `ScreenInfo` for cleaner and more maintainable code.

    - ✨ Enhanced overall sound management architecture, providing a robust and scalable solution for audio handling in the game.

**📚 Update changelog** ([`34be6b0`](https://github.com/Snake-Charmers/charming-snake/commit/34be6b00506bd23a614cfbda2e683772e0de4612))

**✨ feature: Add automated changelog generation and tagging workflow** ([`c61f465`](https://github.com/Snake-Charmers/charming-snake/commit/c61f46553b2d36040c9c6b965f9f3fdd8353da85))

    - 📚 Introduce a new GitHub Actions workflow 'changelog-tagging.yml' for automated changelog generation and version tagging.

    - 🐛 Triggers workflow on pushes to 'master', 'develop', 'feature/*', 'bugfix/*', and 'hotfix/*' branches.

    - 📚 Add logic to check if a new tag is required based on the commit history, create and push new tags when needed, generate changelogs for new releases, and update the running changelog for upcoming releases.

    - 📚 Additionally, designed 'changelog_manager.py' script, which contains the necessary logic for these operations, such as determining the current version, incrementing patch versions, formatting commit messages, and managing changelog content.

**📚 Create CHANGELOG.md** ([`c62895c`](https://github.com/Snake-Charmers/charming-snake/commit/c62895c5acc18ed9042f713c166dbf9f56bd895b))

**✨ Refactor and Enhance Game Mechanics for Snake Game** ([`1326e12`](https://github.com/Snake-Charmers/charming-snake/commit/1326e12fcdb6f36baaed82dd5ca9d39e04bd5a0c))

    - 👍 Implemented InputController for improved touch event handling.

    - 📝 Expanded GameEventPublisher with new event notification methods.

    - ✨ Removed GameEventListenerImpl, integrating its features into other classes.

    - ✨ Refined IGameEventListener and ITouchEventListener interfaces for enhanced event management.

    - ✨ Enhanced GameManager with updated game logic and interaction handling.

    - 📝 Introduced GameStateManager for effective game state and threading management.

    - ➕ Added GameRenderer for dynamic rendering, including conditional display of 'Tap to Play'.

    - 🎨 Updated GameConstants and ScreenInfo for extended functionality and screen information retrieval.

**🏷️ Update generate-apk-aab-debug-release.yml** ([`08209d6`](https://github.com/Snake-Charmers/charming-snake/commit/08209d6cafaa495e003447b13180fa6540ec03f0))

**🔨 Implement AudioManager and Refactor Sound Management in Snake Game** ([`726b1f1`](https://github.com/Snake-Charmers/charming-snake/commit/726b1f1b8bb6dd693d4832621beb2b74e1468ed7))

    - 👨‍💻 Implemented `AudioManagerImpl`, a new class for managing audio functionalities in the Snake game.

    - 📝 Integrated the `IAudioManager` interface for consistent audio management across the application.

    - 🚀 Utilized `SoundPool` for efficient audio playback, supporting simultaneous streams with optimized attributes.

    - 🚦 Created singleton pattern in `AudioManagerImpl` for global access and resource efficiency.

    - ➕ Added sound loading and playing functionalities within `AudioManagerImpl`, handling exceptions and ensuring thread safety.

    - 📝 Defined new constants `EAT_SOUND` and `DEATH_SOUND` in `GameConstants` for clear identification of sound effects.

    - 🔨 Refactored `SnakeGame` to utilize `AudioManagerImpl` for sound effects, replacing direct `SoundPool` usage.

    - ➖ Removed commented-out code and unused imports in `SnakeGame` and `ScreenInfo` for cleaner and more maintainable code.

    - ✨ Enhanced overall sound management architecture, providing a robust and scalable solution for audio handling in the game.

**🐛 gh-actions: update workflow to build on push to master, develop, feature/*, hotfix/*** ([`3c91017`](https://github.com/Snake-Charmers/charming-snake/commit/3c9101727d60429a0c69db0afa7367aeca8f8df3))

**🔨 Refactor Game Constants and Screen Info Handling in Snake Game** ([`f67f8f5`](https://github.com/Snake-Charmers/charming-snake/commit/f67f8f50e2d01562304c731b5d17277773da8e05))

    - 🔧 Introduced GameConstants.java to centralize game configuration, defining NUM_BLOCKS_WIDE as a constant.

    - 🚦 Added ScreenInfo.java to manage screen dimensions and block size calculations, replacing direct calculations in SnakeGame and SnakeActivity.

    - 🚦 Modified SnakeActivity and SnakeGame to use the new ScreenInfo class for screen dimension calculations, enhancing maintainability and readability.

    - ➖ Removed direct screen dimension calculations and replaced them with calls to ScreenInfo methods.

    - 🔃 Updated SnakeGame constructor to initialize ScreenInfo and use its methods for setting block size and calculating the number of blocks high.

    - 💬 Streamlined SnakeActivity by removing redundant screen dimension calculations and updating comments to better reflect the current implementation.

**🔨 Refactor project structure and implement initial classes for Snake game** ([`751e6d2`](https://github.com/Snake-Charmers/charming-snake/commit/751e6d227adcbc6247d9687b33464458d02e6337))

    - 📝 Migrate SnakeActivity and SnakeGame to views package.

    - 📝 Create new classes in controllers, events, factories, interfaces, managers, models, utils, viewmodels packages.

    - 🔃 Update AndroidManifest to reflect the relocation of SnakeActivity.

    - ➕ Add initial TODO comments in newly created classes for future implementation.

    - 👨‍💻 Implement basic structure for game mechanics, including collision detection, event handling, and game object management.

    - ✨ Prepare for extensive refactoring and feature enhancement in line with the new game design.

**📚 Update README.md** ([`a70cdd8`](https://github.com/Snake-Charmers/charming-snake/commit/a70cdd83a6fd86401428964c15e2bfbb750c80c0))

**📚 Update README.md** ([`5b3135e`](https://github.com/Snake-Charmers/charming-snake/commit/5b3135e134e52624d0b5b9fb066c41ff1f91c688))

**📚 Create README.md** ([`ad1ba83`](https://github.com/Snake-Charmers/charming-snake/commit/ad1ba836c02ee2a19dd674a2a97909749b08bc42))

**🎨 Add CI/CD workflow to build the game** ([`1fc930c`](https://github.com/Snake-Charmers/charming-snake/commit/1fc930c2c860bae6746671de55dbc1c178ef9271))

**➖ remove undue copy of assets** ([`26ab79e`](https://github.com/Snake-Charmers/charming-snake/commit/26ab79ecf6780c927dfa24fa65a6ac3e9d4b0739))

**📝 import src code from the book and get it to compile** ([`473c47a`](https://github.com/Snake-Charmers/charming-snake/commit/473c47a47bd467691fe2d629b7d15f00b1caa190))


---
