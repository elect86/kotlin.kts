package kts

import java.io.File

// https://www.oracle.com/java/technologies/javase/vmoptions-jsp.html

@KotlinMarker
class KotlinBuilder(val kt: Kotlin = Kotlin()) {
    /** How to run the supplied command with arguments */
    var howToRun: Kotlin.HowToRun
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            kt.howToRun = value
        }

    /** Paths where to find user class files */
    val classpath: ArrayList<File> by kt::classpath

    /** Set a system JVM property */
    val jvmProperties: MutableMap<String, String> by kt::jvmProperties

    /** Pass an option directly to JVM */
    inline fun jvmOptions(block: JvmOptionsBuilder.() -> Unit) = JvmOptionsBuilder(kt.jvmOptions).block()

    /** Don't include Kotlin standard library into classpath */
    val noStdlib: Unit
        get() {
            kt.noStdlib = true
        }

    /** Don't include Kotlin reflection implementation into classpath */
    val noReflect: Unit
        get() {
            kt.noReflect = true
        }

    /** Kotlin compiler classpath for compiling script or expression or running REPL
     *  If not specified, try to find the compiler in the environment */
    var compilerPath: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            kt.compilerPath = value
        }

    /** Pass -X argument to the compiler */
    val flags: ArrayList<String> by kt::flags

    /** Display Kotlin version */
    val version: Unit
        get() {
            kt.version = true
        }

    /** Print a synopsis of options */
    val help: Unit
        get() {
            kt.help = true
        }

    var command: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            kt.command = value
        }

    var expression: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            kt.expression = value
        }

    val arguments: ArrayList<String> by kt::arguments
}

operator fun Boolean.invoke() = if (this) '+' else '-'