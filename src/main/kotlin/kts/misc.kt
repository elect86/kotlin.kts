package kts

@DslMarker
annotation class KotlinMarker

operator fun String.invoke(args: ArrayList<String>): String {
    args.add(0, this)
    val process = ProcessBuilder(args)
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