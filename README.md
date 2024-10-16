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
-Light Mode

![Screenshot_20241016_220547](https://github.com/user-attachments/assets/c71d4519-08d7-45a8-a14e-900f0af416a5)![Screenshot_20241016_220653](https://github.com/user-attachments/assets/6083f1a2-5fff-4006-bc4b-c7f61c032520)
![Screenshot_20241016_220743](https://github.com/user-attachments/assets/c3c98a24-518d-4649-b6b1-1d82cb329a2a)

![Screenshot_20241016_220815](https://github.com/user-attachments/assets/2b73599b-65b8-4fbc-87b2-cf33e26df44b)

-Dark Mode
![Screenshot_20241016_221055](https://github.com/user-attachments/assets/5fe0751b-c388-4b2b-a12d-f69dc53de1e2)
![Screenshot_20241016_221040](https://github.com/user-attachments/assets/d2619900-cc3c-438d-8711-686b9a59a0c1)
![Screenshot_20241016_221029](https://github.com/user-attachments/assets/c96cf8ce-2646-4ecd-a5ef-e7790781ba25)



### Setup
1. Clone the repo:
```bash
git clone https://github.com/your-username/news-app-with-auth.git
```
2. Add your API key in `local.properties`:
```plaintext
NEWS_API_KEY=your_api_key_here
```
3. Sync and run the app in Android Studio.

## Future Improvements
- User profiles
- Favorites
- Push notifications

## License
This project is licensed under the MIT License.
