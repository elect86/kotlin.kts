package kts

import java.io.File

inline fun kotlinc(block: KotlincBuilder.() -> Unit) {
    val ktc = KotlinC()
    KotlincBuilder(ktc).block()
    ktc()
}

class KotlinC(override val cmd: String = "kotlinc") : Cmd<KotlincBuilder> {

    val classpath = ArrayList<File>()
    var dst: File? = null
    var expression = ""
    var includeRuntime = false
    var javaParameters = false
    var jdkHome: File? = null
    var jvmTarget = -1
    var moduleName = ""
    var noJdk = false
    var noReflect = false
    var noStdlib = false
    val scriptTemplates = ArrayList<String>()
    var wError = false
    var apiVersion = ""
    var help = false
    var kotlinHome: File? = null
    var languageVersion = -1
    val plugins = ArrayList<String>()
    var progressive = false
    var script = ""
    var nowarn = false
    var verbose = false
    var version = false
    val jvmOptions = JvmOptions()
    var argFile: File? = null

    val custom = ArrayList<String>()

    val sourceFiles = ArrayList<File>()

    override operator fun invoke(block: KotlincBuilder.() -> Unit) = apply { KotlincBuilder(this).block() }

    override fun cmdLine(): List<String> {
        val args = arrayListOf<String>()
        if (classpath.isNotEmpty()) args.add("-cp", classpath.joinToString(File.pathSeparator))
        dst?.run { args.add("-d", absolutePath) }
        if (expression.isNotEmpty()) args.add("-e", expression)
        if (includeRuntime) args += "-include-runtime"
        if (javaParameters) args += "-java-parameters"
        jdkHome?.run { args.add("-jdk-home", absolutePath) }
        if (jvmTarget != -1) args.add("-jvm-target", if (jvmTarget < 9) "1.$jvmTarget" else jvmTarget)
        if (moduleName.isNotEmpty()) args.add("-module-name", moduleName)
        if (noJdk) args += "-no-jdk"
        if (noReflect) args += "-no-reflect"
        if (noStdlib) args += "-no-stdlib"
        if (scriptTemplates.isNotEmpty()) args.add("-script-templates", scriptTemplates.joinToString(","))
        if (wError) args += "-Werror"
        if (apiVersion.isNotEmpty()) args.add("-api-version", apiVersion)
        if (help) args += "-h"
        kotlinHome?.run { args.add("-kotlin-home", absolutePath) }
        if (languageVersion != -1) args.add("-language-version", languageVersion)
        if (plugins.isNotEmpty()) {
            args += "-P"
            for (plugin in plugins)
                args += "plugin:$plugin"
        }
        if (progressive) args += "-progressive"
        if (script.isNotEmpty()) args.add("-script", script)
        if (nowarn) args += "-nowarn"
        if (verbose) args += "-verbose"
        if (version) args += "-version"
        jvmOptions(args)
        argFile?.run { args += "@$absolutePath" }

        advanced(args)

        args += custom

        args += sourceFiles.map { it.absolutePath }

        return args
    }

    val advanced = KotlincAdvanced(this)
}
