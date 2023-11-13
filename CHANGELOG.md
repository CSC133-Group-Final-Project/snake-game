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
