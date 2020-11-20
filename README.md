# GithubTask

## Description
- Simple App which downloads 30 Github users, displays data in form of list with user name (login), user avatar and 3 user repos names.
- There is a search feature which returns results based on user name or repo name, app also has cache mechanism, after first download data will be saved and retrieved if there will be no internet connection.
- Application is based on simple MVP architecture with clean packaging, and is using Retrofit/OkHttp for network, RxJava2 for async calls and data flow, Shared Preferences for cache, Glide for image processing

## Comments
If there will be a more time space:
- Add separate module for data/domain/model packages, make it more transparent
- Add proper Dependency Injection with Dagger2
- Add Unit tests
- Add mappers between data, domain, view layers
- Make UI a bit more polished
