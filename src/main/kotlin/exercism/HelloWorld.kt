fun hello(name: String = ""): String {
    val finalName =   when  {
        name.isBlank() -> "World"
        else -> "$name"
    }
    return "Hello, $finalName!"
}
