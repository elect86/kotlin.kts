package kts

import java.io.File

@KotlinMarker
class KotlincBuilder(val ktc: KotlinC = KotlinC()) {

    /** List of directories and JAR/ZIP archives to search for user class files */
    val classpath: ArrayList<File> by ktc::classpath

    /** Destination for generated class files */
    var dst: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.dst = value
        }

    /** Evaluate the given string as a Kotlin script */
    var expression: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.expression = value
        }

    /** Include Kotlin runtime into the resulting JAR */
    val includeRuntime: Unit
        get() {
            ktc.includeRuntime = true
        }

    /** Generate metadata for Java 1.8 reflection on method parameters */
    val javaParameters: Unit
        get() {
            ktc.javaParameters = true
        }

    /** Include a custom JDK from the specified location into the classpath instead of the default JAVA_HOME */
    var jdkHome: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.jdkHome = value
        }

    /** Target version of the generated JVM bytecode (1.6 (DEPRECATED), 1.8, 9, 10, 11, 12, 13, 14, 15 or 16), default is 1.8 */
    var jvmTarget: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            check(value in 8..16)
            ktc.jvmTarget = value
        }

    /** Name of the generated .kotlin_module file */
    var moduleName: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.moduleName = value
        }

    /** Don't automatically include the Java runtime into the classpath */
    var noJdk: Boolean
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.noJdk = value
        }

    /** Don't automatically include Kotlin reflection into the classpath */
    var noReflect: Boolean
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.noReflect = value
        }

    /** Don't automatically include the Kotlin/JVM stdlib and Kotlin reflection into the classpath */
    var noStdlib: Boolean
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.noStdlib = value
        }

    /** Script definition template classes */
    val scriptTemplates: ArrayList<String> by ktc::scriptTemplates

    /** Report an error if there are any warnings */
    val wError: Unit
        get() {
            ktc.wError = true
        }

    /** Allow using declarations only from the specified version of bundled libraries */
    var apiVersion: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.apiVersion = value
        }

    /** Print a synopsis of advanced options */
    inline fun advanced(block: KotlincAdvancedBuilder.() -> Unit) = KotlincAdvancedBuilder(ktc).block()

    /** Print a synopsis of advanced options */
    inline fun X(block: KotlincAdvancedBuilder.() -> Unit) = KotlincAdvancedBuilder(ktc).block()

    /** Print a synopsis of standard options */
    val help: Unit
        get() {
            ktc.help = true
        }

    /** Path to the home directory of Kotlin compiler used for discovery of runtime libraries */
    var kotlinHome: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.kotlinHome = value
        }

    /** Provide source compatibility with the specified version of Kotlin */
    var languageVersion: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.languageVersion = value
        }

    /** Pass an option to a plugin */
    inline fun plugin(block: Plugin.() -> Unit) = Plugin().block()

    inner class Plugin {
        operator fun String.invoke(option: Pair<String, String>) {
            ktc.plugins += "$this:${option.first}=${option.second}"
        }
    }

    /** Enable progressive compiler mode. In this mode, deprecations and bug fixes for unstable code take effect
     *  immediately, instead of going through a graceful migration cycle.
     *  Code written in the progressive mode is backward compatible; however, code written in non-progressive mode
     *  may cause compilation errors in the progressive mode. */
    val progressive: Unit
        get() {
            ktc.progressive = true
        }

    /** Evaluate the given Kotlin script (*.kts) file */
    var script: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.script = value
        }

    /** Generate no warnings */
    val noWarn: Unit
        get() {
            ktc.nowarn = true
        }

    /** Enable verbose logging output */
    val verbose: Unit
        get() {
            ktc.verbose = true
        }

    /** Display compiler version */
    val version: Unit
        get() {
            ktc.version = true
        }

    /** Pass an option directly to JVM */
    inline fun jvmOptions(block: JvmOptionsBuilder.() -> Unit) = JvmOptionsBuilder(ktc.jvmOptions).block()

    /** Read compiler arguments and file paths from the given file */
    var argFile: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            ktc.argFile = value
        }


    /** source files */
    val sourceFiles: ArrayList<File> by ktc::sourceFiles
}