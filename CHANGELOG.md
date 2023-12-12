<!-- RUNNING CHANGELOG START -->
## [v0.4.0] - 2023-12-12

**✨ Merge pull request #9 from Snake-Charmers/audio-enhancements** ([`4825302`](https://github.com/Snake-Charmers/charming-snake/commit/482530264aba796c345a157cc58b10e2c0449bbc))

**🐛 bugfix: release audio resources onDestroy and fix sound toggle logic …** ([`4825302`](https://github.com/Snake-Charmers/charming-snake/commit/482530264aba796c345a157cc58b10e2c0449bbc))

**🐛 bugfix: release audio resources onDestroy and fix sound toggle logic for background audio** ([`2a15fec`](https://github.com/Snake-Charmers/charming-snake/commit/2a15fec9d3af816345baad3378ee06d147b6aed2))

**📚 Update changelog** ([`a34cc43`](https://github.com/Snake-Charmers/charming-snake/commit/a34cc43f0d75d549e87c410b5faf0f6dc9ef6a94))

**✨ Merge pull request #8 from Snake-Charmers/audio-enhancements** ([`ce6d2c6`](https://github.com/Snake-Charmers/charming-snake/commit/ce6d2c66b10557163c4aade67972ddbfdc310872))

**➖ remove resources which we did not end up implementing** ([`ce6d2c6`](https://github.com/Snake-Charmers/charming-snake/commit/ce6d2c66b10557163c4aade67972ddbfdc310872))

**➖ remove resources which we did not end up implementing** ([`7914fa0`](https://github.com/Snake-Charmers/charming-snake/commit/7914fa01e3f0b3111c8f3cf71e949a93e0f2a0a8))

**📚 Update changelog** ([`84a324e`](https://github.com/Snake-Charmers/charming-snake/commit/84a324e52aa377f2c75ffba7289986ed1d3994df))


<!-- RUNNING CHANGELOG END -->




## [v0.2.0] - 2023-12-12

**✨ Merge pull request #5 from Snake-Charmers/audio-enhancements** ([`b92f084`](https://github.com/Snake-Charmers/charming-snake/commit/b92f084112ccfb57e2e412897e0cd6e149ca1e85))

**✨ Audio enhancements** ([`b92f084`](https://github.com/Snake-Charmers/charming-snake/commit/b92f084112ccfb57e2e412897e0cd6e149ca1e85))

**🔨 Refactor AudioManagerImpl to Improve Background Music Management** ([`837f73e`](https://github.com/Snake-Charmers/charming-snake/commit/837f73e79248c5f3d8692c5acf2414be7a3d93cb))

    - 📝 Extracted background music loading into a separate method `loadBackgroundMusic`.

    - 👨‍💻 Implemented `playBackgroundMusic` and `pauseBackgroundMusic` methods for better control over background music playback.

    - ➖ Removed unused `playMainMenuMusic` method and streamlined the `toggleSound` method to directly control background music.

    - 🏷️ Added `releaseMediaPlayer` method to properly release MediaPlayer resources.

    - 📝 Simplified the loading logic of background music and sound effects.

    - 📝 Ensured background music playback respects the `isSoundEnabled` flag consistently.

**🔃 final audio updates to implement background music with game menu** ([`7a619bc`](https://github.com/Snake-Charmers/charming-snake/commit/7a619bc2cd548a1ed5b81585f68a3b935af5cd47))

**🐛 fix: touch controller logic** ([`d66f32b`](https://github.com/Snake-Charmers/charming-snake/commit/d66f32beba95f267c36b5568b1d072d04ee9ef54))

**📝 Integrate KeyboardInputController in SnakeGame for keyboard input handling** ([`ff2744d`](https://github.com/Snake-Charmers/charming-snake/commit/ff2744de6fa46a95ed5f2080afe3ca50178cd28a))

**➖ Remove direct input handling from GameManager** ([`a17c99b`](https://github.com/Snake-Charmers/charming-snake/commit/a17c99b5265e7d95622c876908630499ca4911d8))

**📝 Create IKeyboardEventListener interface for keyboard event handling** ([`f3faba4`](https://github.com/Snake-Charmers/charming-snake/commit/f3faba48eefdc418f173d23544320e17221c66d0))

**➕ Add keyboard controls and improve dialog handling in Snake game** ([`8b8dad3`](https://github.com/Snake-Charmers/charming-snake/commit/8b8dad30395df561a8e9b8445f262554a8d85e4d))

    - 👨‍💻 Implemented a new KeyboardInputController class to handle keyboard inputs for controlling the snake's direction and pausing the game.

    - ✨ Enhanced the GameMenuActivity by adding a dialog dismissal step to improve user experience when submitting a username.

    - 📝 Extended the Snake model with a switchDirection method to support directional changes via keyboard events.

**🔁 Rename InputController to TouchInputController to account for upcoming keystrokes support** ([`513e119`](https://github.com/Snake-Charmers/charming-snake/commit/513e1194c7549b4a3478db6eccc3d1c8fb17eebe))

    - ➖ Remove redundant highscore board logic

**🎨 Update project configuration and UI elements in SnakeActivity** ([`1436fe0`](https://github.com/Snake-Charmers/charming-snake/commit/1436fe069064fa2d6755e45bb9a767f70622765f))

    - 🎨 Update UI layout in activity_game.xml:

    - ➕ Add a SnakeGame view with id "snakeGame" to the layout.

    - 📝 Include a sound toggle checkbox layout.

    - 📝 Modify SnakeActivity.java:

    - 👨‍💻 Implement sound management logic using a Switch element.

    - ➕ Add a method to update the sound status text based on the Switch state.

    - 📝 Initialize the SnakeGame object.

    - 📝 Set the content view to the SnakeGame view for rendering the game.

    - ➕ Add custom drawable resources:

    - 📝 Create custom_thumb.xml for the Switch thumb with different states.

    - 📝 Create custom_track.xml for the Switch track with different states.

    - 📝 Define color resources in colors.xml:

    - 📝 Define "switchThumbColor" for custom thumb color.

    - 📝 Define "switchTrackColor" for custom track color.

    - 📝 Define "switchTextColor" for custom text color.

    - 📝 Other miscellaneous changes:

    - 📝 Delete CollisionDetector.java, a currently unused class.

    - 🔃 Update playMainMenuMusic() in AudioManagerImpl.java to handle sound enabling and disabling.

**🔨 refactor SnakeActivity and GameMenuActivity to activities** ([`7ce3bef`](https://github.com/Snake-Charmers/charming-snake/commit/7ce3bef9afd34fedaeabf3d3a699d7237aadefa0))

**🐛 bugfix: do not dismiss onGameOver dialog box when entering to high score view** ([`fb3f678`](https://github.com/Snake-Charmers/charming-snake/commit/fb3f67860a759181ddf714597a02647bf345eadb))

**📝 Stop tracking .idea/ directory** ([`d1fc8b3`](https://github.com/Snake-Charmers/charming-snake/commit/d1fc8b3953978be59268ca0b3e5e45d4fcd3e28a))

**👨‍💻 Implement game-over dialog in SnakeGame with score display and navigation options** ([`225a3e0`](https://github.com/Snake-Charmers/charming-snake/commit/225a3e06680b0e5d5462f787e09651cd01ed9335))

**🔃 Update GameRenderer for score drawing and pass username in SnakeActivity** ([`00e3db4`](https://github.com/Snake-Charmers/charming-snake/commit/00e3db40e670da4f7e86cc9d5977ff4af1b32503))

**📝 Expand NavigationUtils with high score dialog and main menu navigation** ([`f82b659`](https://github.com/Snake-Charmers/charming-snake/commit/f82b65912b3a798586fbdcac00643072474b23f3))

**🔃 Update Snake model for centralized drawing and collision adjustments** ([`c5a2a9a`](https://github.com/Snake-Charmers/charming-snake/commit/c5a2a9a7c00c59afc93222c054b56dc515c4f377))

**🔨 Refactor Score model for score tracking functionality** ([`e095f76`](https://github.com/Snake-Charmers/charming-snake/commit/e095f763c15139645bfc3f3c6351497dd1768172))

**📝 Modify Apple model for adjusted spawning and drawing logic** ([`2a0434b`](https://github.com/Snake-Charmers/charming-snake/commit/2a0434bee27eae7574f738d5b9d051d3a9a07b94))

**🔨 Refactor GameManager with new collision and audio logic** ([`9ce482f`](https://github.com/Snake-Charmers/charming-snake/commit/9ce482f62d7767b41ee9faa6d4752ed8b8021b9c))

**📝 extend audio management methods in IAudioManager and AudioManagerImpl to support sound on/off toggle** ([`f6eca9e`](https://github.com/Snake-Charmers/charming-snake/commit/f6eca9ea4173275a4b2af1179fa8cf351fb2ac0c))

**🔨 Refactor collision detection in CollisionEventPublisher** ([`e224cb1`](https://github.com/Snake-Charmers/charming-snake/commit/e224cb1d3ac83bc6128542b7d474d7980f9b5ce6))

**🎨 Add Gson library to build.gradle for JSON processing** ([`415fbe5`](https://github.com/Snake-Charmers/charming-snake/commit/415fbe53bb6702ef8c598ddd8dc7f27fa2c8c281))

**✨ Add High Score functionality and UI enhancements to Snake Game** ([`63ae66e`](https://github.com/Snake-Charmers/charming-snake/commit/63ae66e03084f146dc20de0a029b5d9167bbb5f5))

    - 👨‍💻 Implement HighScoreAdapter, GlobalStateManager, and HighScore model classes for managing high scores.

    - 📝 Modify HighScoreBoard to handle persistent storage and retrieval of high scores.

    - 🎨 Introduce dialog-based UI for username input, high score display, and about section.

    - 🎨 Add animation resources for UI transitions and custom styles for dialog elements.

    - 🔃 Update GameMenuActivity with logic for new dialogs and sound toggle.

    - 📝 Create new XML layouts for high score list items, high score screen, about page, and username dialog.

    - 🎨 Update string resources with new text entries for UI elements.

**🐛 fix changelog generator mechanism** ([`5d2efbf`](https://github.com/Snake-Charmers/charming-snake/commit/5d2efbfc29cafeebd05f60c124e705bccc3c0f23))

    - 🐛 Fix the issue with it grabbing all of the commit history instead of only grabbing commits since the previous tag

    - 📚 Switch to append mode to not overwrite CHANGELOG.md but make sure to maintain the order by reading into it first before adding the new tag at top

**📚 Revert "Update changelog"** ([`1e82654`](https://github.com/Snake-Charmers/charming-snake/commit/1e826545e9b9885d75754c6d89bbeb894cd6e238))

**⏪ This reverts commit 96c167544eae90677359c2ac212b43af0eec9843.** ([`1e82654`](https://github.com/Snake-Charmers/charming-snake/commit/1e826545e9b9885d75754c6d89bbeb894cd6e238))

**📚 Update changelog** ([`96c1675`](https://github.com/Snake-Charmers/charming-snake/commit/96c167544eae90677359c2ac212b43af0eec9843))

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

**🏷️ Update generate-apk-aab-debug-release.yml** ([`08209d6`](https://github.com/Snake-Charmers/charming-snake/commit/08209d6cafaa495e003447b13180fa6540ec03f0))



## [v0.1.0] - 2023-11-12

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
