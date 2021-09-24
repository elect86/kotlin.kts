package kts

import java.io.File

// https://www.oracle.com/java/technologies/javase/vmoptions-jsp.html

@KotlinMarker
class KotlinBuilder(val kt: Kotlin = Kotlin()) {
    /** How to run the supplied command with arguments */
    var howToRun: Kotlin.HowToRun? by kt::howToRun

    /** Paths where to find user class files */
    val classpath: ArrayList<File> by kt::classpath

    /** Set a system JVM property */
    val jvmProperties: MutableMap<String, String> by kt::jvmProperties

    /** Pass an option directly to JVM */
    inline fun jvmOptions(block: JvmOptionsBuilder.() -> Unit) = JvmOptionsBuilder(kt.jvmOptions).block()

    /** Don't include Kotlin standard library into classpath */
    fun noStdlib() {
        kt.noStdlib = true
    }

    /** Don't include Kotlin reflection implementation into classpath */
    fun noReflect() {
        kt.noReflect = true
    }

    /** Kotlin compiler classpath for compiling script or expression or running REPL
     *  If not specified, try to find the compiler in the environment */
    var compilerPath: String by kt::compilerPath

    /** Pass -X argument to the compiler */
    val flags: ArrayList<String> by kt::flags

    /** Display Kotlin version */
    fun version() {
        kt.version = true
    }

    /** Print a synopsis of options */
    fun help() {
        kt.help = true
    }

    var command: File? by kt::command

    var expression: String by kt::expression

    val arguments: ArrayList<String> by kt::arguments
}

operator fun Boolean.invoke() = if (this) '+' else '-'