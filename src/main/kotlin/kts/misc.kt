package kts

@DslMarker
annotation class KotlinMarker

operator fun String.invoke(args: List<String>): String {
    val process = ProcessBuilder(this, *args.toTypedArray())
        .inheritIO()
        //        .directory(workingDir)
        //        .redirectOutput(Redirect.INHERIT)
        //        .redirectError(Redirect.INHERIT)
        .start()
    //        .waitFor(60, TimeUnit.MINUTES)
    return String(process.inputStream.readAllBytes())
}

fun main() {
    kotlin {
        version
//        jvmOptions {
//            allowUserSignalHandlers
//        }
    }

    kotlinc {
        version
    }
}

fun ArrayList<String>.add(key: String, value: Any) {
    add(key)
    add(value.toString())
}