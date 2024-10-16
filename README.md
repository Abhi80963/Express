# Express News App with Authentication

A simple news app built with **Jetpack Compose** that allows users to browse, search for news, and view detailed articles. It includes a login/signup authentication system.

## Features
- Browse top headlines by category (Business, Health, Science, Sports, etc.).
- Search for news articles by keywords.
- View full articles.
- User authentication (login/signup).
- Clean UI using Jetpack Compose.

## Tech Stack
- **Jetpack Compose**: UI
- **ViewModel**: State management
- **Retrofit**: Networking
- **Navigation Component**: Screen navigation
- **Coroutines**: Async tasks

## Project Structure
```
app/
├── ui/                  # Screens (Login, Signup, Home, etc.)
├── viewmodel/           # ViewModels (NewsViewModel, AuthViewModel)
├── repository/          # Data handling (news, authentication)
├── model/               # Data models
├── network/             # API service (news data)
└── MainActivity.kt      # Main entry point
```

## Prerequisites
- Android Studio Bumblebee or later
- Kotlin 1.9.0
- API key from [NewsAPI](https://newsapi.org/)

## App Demo
### Light Mode

<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/user-attachments/assets/c71d4519-08d7-45a8-a14e-900f0af416a5" width="24%" />
  <img src="https://github.com/user-attachments/assets/6083f1a2-5fff-4006-bc4b-c7f61c032520" width="24%" />
  <img src="https://github.com/user-attachments/assets/c3c98a24-518d-4649-b6b1-1d82cb329a2a" width="24%" />
  <img src="https://github.com/user-attachments/assets/2b73599b-65b8-4fbc-87b2-cf33e26df44b" width="24%" />
</div>

### Dark Mode

<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/user-attachments/assets/5fe0751b-c388-4b2b-a12d-f69dc53de1e2" width="32%" />
  <img src="https://github.com/user-attachments/assets/d2619900-cc3c-438d-8711-686b9a59a0c1" width="32%" />
  <img src="https://github.com/user-attachments/assets/c96cf8ce-2646-4ecd-a5ef-e7790781ba25" width="32%" />
</div>




### Setup
1. Clone the repo:
```bash
git clone [https://github.com/Abhi80963/Express.git]
```
2. Add your API key in `local.properties`:
```plaintext
NEWS_API_KEY=your_api_key_here
```
3. Sync and run the app in Android Studio.

## Future Improvements
- User profiles with side navigation bar
- Favorites
- Push notifications

## License
This project is licensed under the MIT License.
