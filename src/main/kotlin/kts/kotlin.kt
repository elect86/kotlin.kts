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
        val cmd = "kotlin"
        val args = arrayListOf<String>()
        howToRun?.let { args.add("-howtorun", it) }
        if (classpath.isNotEmpty()) args.add("-cp", classpath.joinToString(File.pathSeparator) { it.absolutePath })
        for (prop in jvmProperties) args += "-D${prop.key}=${prop.value}"
        jvmOptions(args)
        if (noStdlib) args += "-no-stdlib"
        if (noReflect) args += "-no-reflect"
        if (compilerPath.isNotEmpty()) args.add("-compiler-path", compilerPath)
        for (flag in flags) args += "-X$flag"
        if (version) args += "-version"
        if (help) args += "-h"
        command?.apply { args += absolutePath }
        if (expression.isNotEmpty()) args.add("-e", expression)
        if (arguments.isNotEmpty()) args += arguments

        //        print(cmd)
        return cmd(args)
    }

    enum class HowToRun { guess, classfile, jar, script }

}