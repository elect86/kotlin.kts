package kts

import java.io.File

class KotlincBuilder(val ktc: KotlinC = KotlinC()) {

    /** List of directories and JAR/ZIP archives to search for user class files */
    val classpath: ArrayList<String> by ktc::classpath

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
    var jdkTarget: Int
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
    inline fun advanced(block: Advanced.() -> Unit) = Advanced().block()

    inner class Advanced {
        /** When using unstable compiler features such as FIR, use 'stable' to mark generated class files as stable to
         *  prevent diagnostics from stable compilers at the call site.
         *  When using the JVM IR backend, conversely, use 'unstable' to mark generated class files as unstable
         *  to force diagnostics to be reported. */
        var abiStability: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.abiStability = value
            }

        /** Root modules to resolve in addition to the initial modules,
         *  or all modules on the module path if <module> is ALL-MODULE-PATH */
        val addModules: ArrayList<String> by KotlinC.Advanced::addModules

        /** Allow no source files */
        val allowNoSourceFiles: Unit
            get() {
                KotlinC.Advanced.allowNoSourceFiles = true
            }

        /** Do not report errors on classes in dependencies, which were compiled by an unstable version of the
         *  Kotlin compiler */
        val allowUnstableDependencies: Unit
            get() {
                KotlinC.Advanced.allowUnstableDependencies = true
            }

        /** Assert calls behaviour */
        var assertions: KotlinC.Advanced.Assertion
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.assertion = value
            }

        /** Path to the .xml build file to compile */
        var buildFile: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.buildFile = value
            }

        /** Reuse javac analysis and compile Java source files */
        val compileJava: Unit
            get() {
                KotlinC.Advanced.compileJava = true
            }

        /** Normalize constructor calls (disable: don't normalize; enable: normalize),
         *  default is 'disable' in language version 1.2 and below, 'enable' since language version 1.3 */
        var normalizeConstructorCalls: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.normalizeConstructorCalls = value
            }

        /** Path to JSON file to dump Java to Kotlin declaration mappings */
        var dumpDeclarationsTo: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.dumpDeclarationsTo = value
            }

        /** Compile expressions and unrecognized scripts passed with the -script argument as scripts with given
         *  filename extension */
        var defaultScriptExtension: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.defaultScriptExtension = value
            }

        /** Disable standard kotlin script support */
        val disableStandardScript: Unit
            get() {
                KotlinC.Advanced.disableStandardScript = true
            }

        /** When using the IR backend, do not clear BindingContext between psi2ir and lowerings */
        val irDoNotClearBindingContext: Unit
            get() {
                KotlinC.Advanced.irDoNotClearBindingContext = true
            }

        /** Emit JVM type annotations in bytecode */
        val emitJvmTypeAnnotations: Unit
            get() {
                KotlinC.Advanced.emitJvmTypeAnnotations = true
            }

        /** Allow using features from Java language that are in preview phase. Works as `--enable-preview` in Java.
         *  All class files are marked as preview-generated thus it won't be possible to use them in release environment */
        val jvmEnablePreview: Unit
            get() {
                KotlinC.Advanced.jvmEnablePreview = true
            }

        /** Paths to output directories for friend modules (whose internals should be visible) */
        val friendPaths: ArrayList<File> by KotlinC.Advanced::friendPaths

        /** Compile multifile classes as a hierarchy of parts and facade */
        val multifilePartsInherit: Unit
            get() {
                KotlinC.Advanced.multifilePartsInherit = true
            }

        /** Paths where to find Java 9+ modules */
        val modulePaths: ArrayList<File> by KotlinC.Advanced::modulePaths

        /** Package prefix for Java files */
        val javaPackagePrefix: Unit
            get() {
                KotlinC.Advanced.javaPackagePrefix = true
            }

        /** Paths to directories with Java source files */
        val javacArguments: ArrayList<String> by KotlinC.Advanced::javacArguments

        /** Specify behavior for jspecify annotations. Default value is 'warn' */
        var jspecifyAnnotations: KotlinC.Advanced.Annotation
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.jspecifyAnnotations = value
            }

        /** Specify behavior for JSR-305 nullability annotations:
         *      jsr305(ignore/strict/warn)                      globally (all non-@UnderMigration annotations)
         *      jsr305(ignore/strict/warn, "under-migration")   all @UnderMigration annotations
         *      jsr305(ignore/strict/warn, "@<fq.name>")        annotation with the given fully qualified class name */
        fun jsr305(behavior: KotlinC.Advanced.Annotation, annotation: String? = null) {
            val ann = annotation?.let { "$it:" } ?: ""
            KotlinC.Advanced.jsr305 = "$ann$behavior"
        }

        /** Emit JVM default methods for interface declarations with bodies. */
        var jvmDefault: KotlinC.Advanced.JvmDefalt
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.jvmDefault = value
            }

        /** Paths to cross-platform libraries in .klib format */
        val klib: ArrayList<File> by KotlinC.Advanced::klib

        /** Select code generation scheme for lambdas. */
        var lambdas: KotlinC.Advanced.Lambdas
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.lambdas = value
            }

        /** Don't generate not-null assertions for arguments of platform types */
        val noCallAssertions: Unit
            get() {
                KotlinC.Advanced.noCallAssertions = true
            }

        /** Do not throw NPE on explicit 'equals' call for null receiver of platform boxed primitive type */
        val noExceptionOnExplicitEqualsForBoxedNull: Unit
            get() {
                KotlinC.Advanced.noExceptionOnExplicitEqualsForBoxedNull = true
            }

        /** Do not use KotlinNothingValueException available since 1.4 */
        val noKotlinNothingValueException: Unit
            get() {
                KotlinC.Advanced.noKotlinNothingValueException = true
            }

        /** Disable optimizations */
        val dontOptimize: Unit
            get() {
                KotlinC.Advanced.noOptimize = true
            }

        /** Do not use optimized callable reference superclasses available from 1.4 */
        val noOptimizedCallableReferences: Unit
            get() {
                KotlinC.Advanced.noOptimizedCallableReferences = true
            }

        /** Don't generate not-null assertions on parameters of methods accessible from Java */
        val noParamAssertions: Unit
            get() {
                KotlinC.Advanced.noParamAssertions = true
            }

        /** Don't generate not-null assertion for extension receiver arguments of platform types */
        val noReceiverAssertions: Unit
            get() {
                KotlinC.Advanced.noReceiverAssertions = true
            }

        /** Do not reset jar entry timestamps to a fixed date */
        val dontResetJarTimestamps: Unit
            get() {
                KotlinC.Advanced.noResetJarTimestamps = true
            }

        /** Use pre-1.4 exception types in null checks instead of java.lang.NPE. See KT-22275 for more details */
        val noUnifiedNullChecks: Unit
            get() {
                KotlinC.Advanced.noUnifiedNullChecks = true
            }

        /** Specify behavior for specific Java nullability annotations (provided with fully qualified package name) */
        val nullabilityAnnotations: MutableMap<String, KotlinC.Advanced.Annotation> by KotlinC.Advanced::nullabilityAnnotations

        /** When using the IR backend, run lowerings by file in N parallel threads.
         *  0 means use a thread per processor core. Default value is 1 */
        var parallelBackendThreads: Int
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.parallelBackendThreads = value
            }

        /** Debug option: Run compiler with async profiler, save snapshots to outputDir, command is passed to
         *  async-profiler on start
         *  You'll have to provide async-profiler.jar on classpath to use this
         *  profilerPath is a path to libasyncProfiler.so
         *  Example: -Xprofile=<PATH_TO_ASYNC_PROFILER>/async-profiler/build/libasyncProfiler.so:event=cpu,interval=1ms,threads,start,framebuf=50000000:<SNAPSHOT_DIR_PATH> */
        inline fun profile(block: Profile.() -> Unit) {
            val profile = Profile()
            profile.block()
            profile()
        }

        inner class Profile {
            /** profilerPath is a path to libasyncProfiler.so:
             *  <PATH_TO_ASYNC_PROFILER>/async-profiler/build/libasyncProfiler.so */
            lateinit var profilerPath: File

            /** ex: event=cpu,interval=1ms,threads,start,framebuf=50000000 */
            val commands = ArrayList<String>()

            /** SNAPSHOT_DIR_PATH */
            lateinit var outputDir: File

            operator fun invoke() {
                KotlinC.Advanced.profile = "${profilerPath.absolutePath}:${commands.joinToString(",")}:${outputDir.absolutePath}"
            }
        }

        /** Debug option: Repeats modules compilation <number> times */
        var repeat: Int
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.repeat = value
            }

        /** Select code generation scheme for SAM conversions. */
        var samConversions: KotlinC.Advanced.SamConvertions
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.samConversions = value
            }

        /** Transform '(' and ')' in method names to some other character sequence.
         *  This mode can BREAK BINARY COMPATIBILITY and is only supposed to be used to workaround problems with
         *  parentheses in identifiers on certain platforms */
        val sanitizeParentheses: Unit
            get() {
                KotlinC.Advanced.sanitizeParentheses = true
            }

        /** Script resolver environment in key-value pairs (the value could be quoted and escaped) */
        val scriptResolverEnvironment: MutableMap<String, String> by KotlinC.Advanced::scriptResolverEnvironment

        /** Combine modules for source files and binary dependencies into a single module */
        val singleModule: Unit
            get() {
                KotlinC.Advanced.singleModule = true
            }

        /** Allow Kotlin runtime libraries of incompatible versions in the classpath */
        val skipRuntimeVersionCheck: Unit
            get() {
                KotlinC.Advanced.skipRuntimeVersionCheck = true
            }

        /** Generate nullability assertions for non-null Java expressions */
        val strictJavaNullabilityAssertions: Unit
            get() {
                KotlinC.Advanced.strictJavaNullabilityAssertions = true
            }

        /** Generate metadata with strict version semantics (see kdoc on Metadata.extraInt) */
        val generateStrictMetadataVersion: Unit
            get() {
                KotlinC.Advanced.generateStrictMetadataVersion = true
            }

        /** Select code generation scheme for string concatenation.
         *  default: `indy-with-constants` for JVM target 9 or greater, `inline` otherwise */
        var stringConcat: KotlinC.Advanced.StringConcat
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.stringConcat = value
            }

        /** Specify behavior for Checker Framework compatqual annotations (NullableDecl/NonNullDecl).
         *  Default value is 'enable' */
        var supportCompatqualCheckerFrameworkAnnotations: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.supportCompatqualCheckerFrameworkAnnotations = value
            }

        /** Suppress deprecation warning about deprecated JVM target versions */
        val suppressDeprecatedJvmTargetWarning: Unit
            get() {
                KotlinC.Advanced.suppressDeprecatedJvmTargetWarning = true
            }

        /** Suppress the "cannot access built-in declaration" error (useful with -no-stdlib) */
        val suppressMissingBuiltinsError: Unit
            get() {
                KotlinC.Advanced.suppressMissingBuiltinsError = true
            }

        /** Enable strict mode for some improvements in the type enhancement for loaded Java types based on nullability
         *  annotations,including freshly supported reading of the type use annotations from class files.
         *  See KT-45671 for more details */
        val typeEnhancementImprovementsStrictMode: Unit
            get() {
                KotlinC.Advanced.typeEnhancementImprovementsStrictMode = true
            }

        /** Use the IR backend. This option has no effect unless the language version less than 1.5 is used */
        val useIr: Unit
            get() {
                KotlinC.Advanced.useIr = true
            }

        /** Use javac for Java source and class files analysis */
        val useJavac: Unit
            get() {
                KotlinC.Advanced.useJavac = true
            }

        /** Use the old JVM backend */
        val useOldBackend: Unit
            get() {
                KotlinC.Advanced.useOldBackend = true
            }

        /** Use old class files reading implementation. This may slow down the build and cause problems with Groovy
         *  interop. Should be used in case of problems with the new implementation */
        val useOldClassFilesReading: Unit
            get() {
                KotlinC.Advanced.useOldClassFilesReading = true
            }

        /** Use 1.4 inline classes mangling scheme instead of 1.4.30 one */
        val use14InlineClassesManglingScheme: Unit
            get() {
                KotlinC.Advanced.use14InlineClassesManglingScheme = true
            }

        /** Use old, SourceInterpreter-based analysis for fields, used for spilled variables in coroutines */
        val useOldSpilledVarTypeAnalysis: Unit
            get() {
                KotlinC.Advanced.useOldSpilledVarTypeAnalysis = true
            }

        /** Use type table in metadata serialization */
        val useTypeTable: Unit
            get() {
                KotlinC.Advanced.useTypeTable = true
            }

        /** Allow compiling code in package 'kotlin' and allow not requiring kotlin.stdlib in module-info */
        val allowKotlinPackage: Unit
            get() {
                KotlinC.Advanced.allowKotlinPackage = true
            }

        /** Allow compiling code when `kotlin.Result` is used as a return type */
        val allowResultReturnType: Unit
            get() {
                KotlinC.Advanced.allowResultReturnType = true
            }

        /** Check pre- and postconditions on phases */
        val checkPhaseConditions: Unit
            get() {
                KotlinC.Advanced.checkPhaseConditions = true
            }

        /** Run sticky condition checks on subsequent phases as well. Implies -Xcheck-phase-conditions */
        val checkStickyPhaseConditions: Unit
            get() {
                KotlinC.Advanced.checkStickyPhaseConditions = true
            }

        /** Sources of the common module that need to be compiled together with this module in the multi-platform mode.
         *  Should be a subset of sources passed as free arguments */
        val commonSources: ArrayList<String> by KotlinC.Advanced::commonSources

        /** Do not enable scripting plugin by default */
        val disableDefaultScriptingPlugin: Unit
            get() {
                KotlinC.Advanced.disableDefaultScriptingPlugin = true
            }

        /** Disable backend phases */
        val disablePhases: Unit
            get() {
                KotlinC.Advanced.disablePhases = true
            }

        /** Do not use the ultra light classes implementation */
        val disableUltraLightClasses: Unit
            get() {
                KotlinC.Advanced.disableUltraLightClasses = true
            }

        /** Dump backend state into directory */
        val dumpDirectory: Unit
            get() {
                KotlinC.Advanced.dumpDirectory = true
            }

        /** FqName of declaration that should be dumped */
        val dumpFqname: Unit
            get() {
                KotlinC.Advanced.dumpFqname = true
            }

        /** Dump detailed performance statistics to the specified file */
        var dumpPerf: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.dumpPerf = value
            }

        /** Enable experimental language feature: effect system */
        val effectSystem: Unit
            get() {
                KotlinC.Advanced.effectSystem = true
            }

        /** Enable experimental expect/actual linker */
        val expectActualLinker: Unit
            get() {
                KotlinC.Advanced.expectActualLinker = true
            }

        /** Enable and propagate usages of experimental API for marker annotation with the given fully qualified name */
        var experimental: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.experimental = value
            }

        /** Force compiler to report errors on all public API declarations without explicit visibility or return type.
         *  Use 'warning' level to issue warnings instead of errors. */
        var explicitApi: KotlinC.Advanced.ExplicitApi
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.explicitApi = value
            }

        /** Enable additional compiler checks that might provide verbose diagnostic information for certain errors.
         *  Warning: this mode is not backward-compatible and might cause compilation errors in previously compiled code. */
        val extendedCompilerChecks: Unit
            get() {
                KotlinC.Advanced.extendedCompilerChecks = true
            }

        /** Enable compatibility changes for generic type inference algorithm */
        val inferenceCompatibility: Unit
            get() {
                KotlinC.Advanced.inferenceCompatibility = true
            }

        /** Enable experimental inline classes */
        val inlineClasses: Unit
            get() {
                KotlinC.Advanced.inlineClasses = true
            }

        /** Path to the kotlin-compiler.jar or directory where IntelliJ configuration files can be found */
        var intellijPluginRoot: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.intellijPluginRoot = value
            }

        /** Allow var smart casts despite assignment in try block */
        val legacySmartCastAfterTry: Unit
            get() {
                KotlinC.Advanced.legacySmartCastAfterTry = true
            }

        /** List backend phases */
        val listPhases: Unit
            get() {
                KotlinC.Advanced.listPhases = true
            }

        /** Change metadata version of the generated binary files */
        val metadataVersion: Unit
            get() {
                KotlinC.Advanced.metadataVersion = true
            }

        /** Enable experimental language support for multi-platform projects */
        val multiPlatform: Unit
            get() {
                KotlinC.Advanced.multiPlatform = true
            }

        /** Names of elements that should not be dumped */
        val excludeFromDumping: Unit
            get() {
                KotlinC.Advanced.excludeFromDumping = true
            }

        /** Enable new experimental generic type inference algorithm */
        val newInference: Unit
            get() {
                KotlinC.Advanced.newInference = true
            }

        /** Do not check presence of 'actual' modifier in multi-platform projects */
        val noCheckActual: Unit
            get() {
                KotlinC.Advanced.noCheckActual = true
            }

        /** Disable method inlining */
        val dontInline: Unit
            get() {
                KotlinC.Advanced.noInline = true
            }

        /** Enable usages of API that requires opt-in with an opt-in requirement marker with the given fully
         *  qualified name */
        var optIn: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.optIn = value
            }

        /** Dump backend state both before and after these phases */
        val phasesToDump: Unit
            get() {
                KotlinC.Advanced.phasesToDump = true
            }

        /** Dump backend state after these phases */
        val phasesToDumpAfter: Unit
            get() {
                KotlinC.Advanced.phasesToDumpAfter = true
            }

        /** Dump backend state before these phases */
        val phasesToDumpBefore: Unit
            get() {
                KotlinC.Advanced.phasesToDumpBefore = true
            }

        /** Validate backend state both before and after these phases */
        val phasesToValidate: Unit
            get() {
                KotlinC.Advanced.phasesToValidate = true
            }

        /** Validate backend state after these phases */
        val phasesToValidateAfter: Unit
            get() {
                KotlinC.Advanced.phasesToValidateAfter = true
            }

        /** Validate backend state before these phases */
        val phasesToValidateBefore: Unit
            get() {
                KotlinC.Advanced.phasesToValidateBefore = true
            }

        /** Load plugins from the given classpath */
        var plugin: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.plugin = value
            }

        /** Enable experimental support for @PolymorphicSignature (MethodHandle/VarHandle) */
        val polymorphicSignature: Unit
            get() {
                KotlinC.Advanced.polymorphicSignature = true
            }

        /** Profile backend phases */
        val profilePhases: Unit
            get() {
                KotlinC.Advanced.profilePhases
            }

        /** Generate proper IEEE 754 comparisons in all cases if values are statically known to be of primitive
         *  numeric types */
        val properIeee754Comparisons: Unit
            get() {
                KotlinC.Advanced.properIeee754Comparisons = true
            }

        /** Enable reading of contracts from metadata */
        val readDeserializedContracts: Unit
            get() {
                KotlinC.Advanced.readDeserializedContracts = true
            }

        /** Report source to output files mapping */
        val reportOutputFiles: Unit
            get() {
                KotlinC.Advanced.reportOutputFiles = true
            }

        /** Report detailed performance statistics */
        val reportPerf: Unit
            get() {
                KotlinC.Advanced.reportPerf = true
            }

        /** Support inferring type arguments based on only self upper bounds of the corresponding type parameters */
        val selfUpperBoundInference: Unit
            get() {
                KotlinC.Advanced.selfUpperBoundInference = true
            }

        /** Allow to load classes with bad metadata version and pre-release classes */
        val skipMetadataVersionCheck: Unit
            get() {
                KotlinC.Advanced.skipMetadataVersionCheck = true
            }

        /** Allow to load pre-release classes */
        val skipPrereleaseCheck: Unit
            get() {
                KotlinC.Advanced.skipPrereleaseCheck = true
            }

        /** Suppress warnings about outdated, inconsistent or experimental language or API versions */
        val suppressVersionWarnings: Unit
            get() {
                KotlinC.Advanced.suppressVersionWarnings = true
            }

        /** Eliminate builder inference restrictions like allowance of returning type variables of a builder
         *  inference call */
        val unrestrictedBuilderInference: Unit
            get() {
                KotlinC.Advanced.unrestrictedBuilderInference = true
            }

        /** Enable, but don't propagate usages of experimental API for marker annotation with the given fully
         *  qualified name */
        var useExperimental: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                KotlinC.Advanced.useExperimental = value
            }

        /** Compile using Front-end IR. Warning: this feature is far from being production-ready */
        val useFir: Unit
            get() {
                KotlinC.Advanced.useFir = true
            }

        /** Use extended analysis mode based on Front-end IR. Warning: this feature is far from being production-ready */
        val useFirExtendedCheckers: Unit
            get() {
                KotlinC.Advanced.useFirExtendedCheckers = true
            }

        /** Enable Support named arguments in their own position even if the result appears as mixed */
        val useMixedNamedArguments: Unit
            get() {
                KotlinC.Advanced.useMixedNamedArguments = true
            }

        /** Be verbose while performing these backend phases */
        val verbosePhases: Unit
            get() {
                KotlinC.Advanced.verbosePhases = true
            }
    }

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

}