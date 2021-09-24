package kts

import java.io.File

inline fun kotlin(block: KotlinBuilder.() -> Unit) {
    val kt = Kotlin()
    KotlinBuilder(kt).block()
    kt()
}

class Kotlin {

    var howToRun: HowToRun? = null
    val classpath = ArrayList<File>()
    val jvmProperties = mutableMapOf<String, String>()
    val jvmOptions = JvmOptions()
    var noStdlib = false
    var noReflect = false
    var compilerPath = ""
    val flags = ArrayList<String>()
    var version = false
    var help = false
    var command: File? = null
    var expression = ""
    val arguments = ArrayList<String>()

    operator fun invoke(): String {
        val cmd = buildString {
            append("kotlin")
            howToRun?.let { append(" -howtorun $it") }
            if (classpath.isNotEmpty()) append(" -cp ${classpath.joinToString(File.pathSeparator) { it.absolutePath }}")
            for (prop in jvmProperties) append(" -D${prop.key}=${prop.value}")
            jvmOptions(this)
            if(noStdlib) append(" -no-stdlib")
            if (noReflect) append(" -no-reflect")
            if (compilerPath.isNotEmpty()) append(" -compiler-path $compilerPath")
            for (flag in flags) append(" -X$flag")
            if (version) append(" -version")
            if (help)append(" -h")
            command?.apply { append(" $absolutePath") }
            if (expression.isNotEmpty()) append(" -e $expression")
            if(arguments.isNotEmpty()) append(" ${arguments.joinToString(" ")}")
        }
//        print(cmd)
        return cmd()
    }

    enum class HowToRun { guess, classfile, jar, script }

}

val NUL = '\u0000'

