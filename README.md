# Currency_data
Тестовое приложение для отслеживания курса валют
# API:
https://currate.ru/
# Основные функции:
1. Возможность добавить выбранную котировку в избранное
2. Фильтрация списка по 4 категориям 
3. Поисковая строка для вода названия котировок
4. Удобная навигация
# Architecture: MVI
# Stack:
    def lifecycle_version = "2.5.0-rc01"
    def retrofit_version = "2.9.0"
    def coroutines_version = "1.6.2"
    def gson_version = "2.9.0"
    def koin_version = "3.2.0"
    def logging_interceptor  = "4.10.0"
    def room_version = "2.4.3"
    def adapter_delegates_version = "4.3.2"
    
    // ViewModel
    implementation "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    // LiveData
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version"
    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
    // Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines_version"
    // Gson
    implementation "com.squareup.retrofit2:converter-gson:$retrofit_version"
    // Gson_Converter
    implementation "com.google.code.gson:gson:$gson_version"
    // Koin
    implementation "io.insert-koin:koin-android:$koin_version"
    // LoggingInterceptor
    implementation "com.squareup.okhttp3:logging-interceptor:$logging_interceptor"
    // Room
    implementation "androidx.room:room-runtime:$room_version"
    // To use Kotlin annotation processing tool (kapt)
    kapt "androidx.room:room-compiler:$room_version"
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation "androidx.room:room-ktx:$room_version"
    // Adapter_Delegates
    implementation "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapter_delegates_version"
    implementation "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:$adapter_delegates_version"
 
