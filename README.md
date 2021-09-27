# kotlin.kts

Kotlin DSL Wrapper around `kotlin` and `kotlinc` shell commands

### Example:

What in shell is:

`kotlin -version`

now becomes:

```kotlin
kotlin { version }
```