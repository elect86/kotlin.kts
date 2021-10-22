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
    inline fun advanced(block: Advanced.() -> Unit) = Advanced().block()

    /** Print a synopsis of advanced options */
    inline fun X(block: Advanced.() -> Unit) = Advanced().block()

    @KotlinMarker
    inner class Advanced {
        /** When using unstable compiler features such as FIR, use 'stable' to mark generated class files as stable to
         *  prevent diagnostics from stable compilers at the call site.
         *  When using the JVM IR backend, conversely, use 'unstable' to mark generated class files as unstable
         *  to force diagnostics to be reported. */
        var abiStability: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.abiStability = value
            }

        /** Root modules to resolve in addition to the initial modules,
         *  or all modules on the module path if <module> is ALL-MODULE-PATH */
        val addModules: ArrayList<String> by this@KotlincBuilder.ktc.advanced::addModules

        /** Allow no source files */
        val allowNoSourceFiles: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.allowNoSourceFiles = true
            }

        /** Do not report errors on classes in dependencies, which were compiled by an unstable version of the
         *  Kotlin compiler */
        val allowUnstableDependencies: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.allowUnstableDependencies = true
            }

        /** Assert calls behaviour */
        var assertions: KotlinC.Advanced.Assertion
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.assertion = value
            }

        /** Path to the .xml build file to compile */
        var buildFile: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.buildFile = value
            }

        /** Reuse javac analysis and compile Java source files */
        val compileJava: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.compileJava = true
            }

        /** Normalize constructor calls (disable: don't normalize; enable: normalize),
         *  default is 'disable' in language version 1.2 and below, 'enable' since language version 1.3 */
        var normalizeConstructorCalls: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.normalizeConstructorCalls = value
            }

        /** Path to JSON file to dump Java to Kotlin declaration mappings */
        var dumpDeclarationsTo: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.dumpDeclarationsTo = value
            }

        /** Compile expressions and unrecognized scripts passed with the -script argument as scripts with given
         *  filename extension */
        var defaultScriptExtension: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.defaultScriptExtension = value
            }

        /** Disable standard kotlin script support */
        val disableStandardScript: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.disableStandardScript = true
            }

        /** When using the IR backend, do not clear BindingContext between psi2ir and lowerings */
        val irDoNotClearBindingContext: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.irDoNotClearBindingContext = true
            }

        /** Emit JVM type annotations in bytecode */
        val emitJvmTypeAnnotations: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.emitJvmTypeAnnotations = true
            }

        /** Allow using features from Java language that are in preview phase. Works as `--enable-preview` in Java.
         *  All class files are marked as preview-generated thus it won't be possible to use them in release environment */
        val jvmEnablePreview: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.jvmEnablePreview = true
            }

        /** Paths to output directories for friend modules (whose internals should be visible) */
        val friendPaths: ArrayList<File> by this@KotlincBuilder.ktc.advanced::friendPaths

        /** Compile multifile classes as a hierarchy of parts and facade */
        val multifilePartsInherit: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.multifilePartsInherit = true
            }

        /** Paths where to find Java 9+ modules */
        val modulePaths: ArrayList<File> by this@KotlincBuilder.ktc.advanced::modulePaths

        /** Package prefix for Java files */
        val javaPackagePrefix: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.javaPackagePrefix = true
            }

        /** Paths to directories with Java source files */
        val javacArguments: ArrayList<String> by this@KotlincBuilder.ktc.advanced::javacArguments

        /** Specify behavior for jspecify annotations. Default value is 'warn' */
        var jspecifyAnnotations: KotlinC.Advanced.Annotation
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.jspecifyAnnotations = value
            }

        /** Specify behavior for JSR-305 nullability annotations:
         *      jsr305(ignore/strict/warn)                      globally (all non-@UnderMigration annotations)
         *      jsr305(ignore/strict/warn, "under-migration")   all @UnderMigration annotations
         *      jsr305(ignore/strict/warn, "@<fq.name>")        annotation with the given fully qualified class name */
        fun jsr305(behavior: KotlinC.Advanced.Annotation, annotation: String? = null) {
            val ann = annotation?.let { "$it:" } ?: ""
            this@KotlincBuilder.ktc.advanced.jsr305 = "$ann$behavior"
        }

        /** Emit JVM default methods for interface declarations with bodies. */
        var jvmDefault: KotlinC.Advanced.JvmDefalt
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.jvmDefault = value
            }

        /** Paths to cross-platform libraries in .klib format */
        val klib: ArrayList<File> by this@KotlincBuilder.ktc.advanced::klib

        /** Select code generation scheme for lambdas. */
        var lambdas: KotlinC.Advanced.Lambdas
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.lambdas = value
            }

        /** Don't generate not-null assertions for arguments of platform types */
        val noCallAssertions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noCallAssertions = true
            }

        /** Do not throw NPE on explicit 'equals' call for null receiver of platform boxed primitive type */
        val noExceptionOnExplicitEqualsForBoxedNull: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noExceptionOnExplicitEqualsForBoxedNull = true
            }

        /** Do not use KotlinNothingValueException available since 1.4 */
        val noKotlinNothingValueException: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noKotlinNothingValueException = true
            }

        /** Disable optimizations */
        val dontOptimize: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noOptimize = true
            }

        /** Do not use optimized callable reference superclasses available from 1.4 */
        val noOptimizedCallableReferences: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noOptimizedCallableReferences = true
            }

        /** Don't generate not-null assertions on parameters of methods accessible from Java */
        val noParamAssertions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noParamAssertions = true
            }

        /** Don't generate not-null assertion for extension receiver arguments of platform types */
        val noReceiverAssertions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noReceiverAssertions = true
            }

        /** Do not reset jar entry timestamps to a fixed date */
        val dontResetJarTimestamps: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noResetJarTimestamps = true
            }

        /** Use pre-1.4 exception types in null checks instead of java.lang.NPE. See KT-22275 for more details */
        val noUnifiedNullChecks: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noUnifiedNullChecks = true
            }

        /** Specify behavior for specific Java nullability annotations (provided with fully qualified package name) */
        val nullabilityAnnotations: MutableMap<String, KotlinC.Advanced.Annotation> by this@KotlincBuilder.ktc.advanced::nullabilityAnnotations

        /** When using the IR backend, run lowerings by file in N parallel threads.
         *  0 means use a thread per processor core. Default value is 1 */
        var parallelBackendThreads: Int
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.parallelBackendThreads = value
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
                this@KotlincBuilder.ktc.advanced.profile = "${profilerPath.absolutePath}:${commands.joinToString(",")}:${outputDir.absolutePath}"
            }
        }

        /** Debug option: Repeats modules compilation <number> times */
        var repeat: Int
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.repeat = value
            }

        /** Select code generation scheme for SAM conversions. */
        var samConversions: KotlinC.Advanced.SamConvertions
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.samConversions = value
            }

        /** Transform '(' and ')' in method names to some other character sequence.
         *  This mode can BREAK BINARY COMPATIBILITY and is only supposed to be used to workaround problems with
         *  parentheses in identifiers on certain platforms */
        val sanitizeParentheses: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.sanitizeParentheses = true
            }

        /** Script resolver environment in key-value pairs (the value could be quoted and escaped) */
        val scriptResolverEnvironment: MutableMap<String, String> by this@KotlincBuilder.ktc.advanced::scriptResolverEnvironment

        /** Combine modules for source files and binary dependencies into a single module */
        val singleModule: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.singleModule = true
            }

        /** Allow Kotlin runtime libraries of incompatible versions in the classpath */
        val skipRuntimeVersionCheck: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.skipRuntimeVersionCheck = true
            }

        /** Generate nullability assertions for non-null Java expressions */
        val strictJavaNullabilityAssertions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.strictJavaNullabilityAssertions = true
            }

        /** Generate metadata with strict version semantics (see kdoc on Metadata.extraInt) */
        val generateStrictMetadataVersion: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.generateStrictMetadataVersion = true
            }

        /** Select code generation scheme for string concatenation.
         *  default: `indy-with-constants` for JVM target 9 or greater, `inline` otherwise */
        var stringConcat: KotlinC.Advanced.StringConcat
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.stringConcat = value
            }

        /** Specify behavior for Checker Framework compatqual annotations (NullableDecl/NonNullDecl).
         *  Default value is 'enable' */
        var supportCompatqualCheckerFrameworkAnnotations: Boolean
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.supportCompatqualCheckerFrameworkAnnotations = value
            }

        /** Suppress deprecation warning about deprecated JVM target versions */
        val suppressDeprecatedJvmTargetWarning: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.suppressDeprecatedJvmTargetWarning = true
            }

        /** Suppress the "cannot access built-in declaration" error (useful with -no-stdlib) */
        val suppressMissingBuiltinsError: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.suppressMissingBuiltinsError = true
            }

        /** Enable strict mode for some improvements in the type enhancement for loaded Java types based on nullability
         *  annotations,including freshly supported reading of the type use annotations from class files.
         *  See KT-45671 for more details */
        val typeEnhancementImprovementsStrictMode: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.typeEnhancementImprovementsStrictMode = true
            }

        /** Use the IR backend. This option has no effect unless the language version less than 1.5 is used */
        val useIr: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useIr = true
            }

        /** Use javac for Java source and class files analysis */
        val useJavac: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useJavac = true
            }

        /** Use the old JVM backend */
        val useOldBackend: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useOldBackend = true
            }

        /** Use old class files reading implementation. This may slow down the build and cause problems with Groovy
         *  interop. Should be used in case of problems with the new implementation */
        val useOldClassFilesReading: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useOldClassFilesReading = true
            }

        /** Use 1.4 inline classes mangling scheme instead of 1.4.30 one */
        val use14InlineClassesManglingScheme: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.use14InlineClassesManglingScheme = true
            }

        /** Use old, SourceInterpreter-based analysis for fields, used for spilled variables in coroutines */
        val useOldSpilledVarTypeAnalysis: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useOldSpilledVarTypeAnalysis = true
            }

        /** Use type table in metadata serialization */
        val useTypeTable: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useTypeTable = true
            }

        /** Allow compiling code in package 'kotlin' and allow not requiring kotlin.stdlib in module-info */
        val allowKotlinPackage: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.allowKotlinPackage = true
            }

        /** Allow compiling code when `kotlin.Result` is used as a return type */
        val allowResultReturnType: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.allowResultReturnType = true
            }

        /** Check pre- and postconditions on phases */
        val checkPhaseConditions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.checkPhaseConditions = true
            }

        /** Run sticky condition checks on subsequent phases as well. Implies -Xcheck-phase-conditions */
        val checkStickyPhaseConditions: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.checkStickyPhaseConditions = true
            }

        /** Sources of the common module that need to be compiled together with this module in the multi-platform mode.
         *  Should be a subset of sources passed as free arguments */
        val commonSources: ArrayList<String> by this@KotlincBuilder.ktc.advanced::commonSources

        /** Do not enable scripting plugin by default */
        val disableDefaultScriptingPlugin: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.disableDefaultScriptingPlugin = true
            }

        /** Disable backend phases */
        val disablePhases: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.disablePhases = true
            }

        /** Do not use the ultra light classes implementation */
        val disableUltraLightClasses: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.disableUltraLightClasses = true
            }

        /** Dump backend state into directory */
        val dumpDirectory: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.dumpDirectory = true
            }

        /** FqName of declaration that should be dumped */
        val dumpFqname: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.dumpFqname = true
            }

        /** Dump detailed performance statistics to the specified file */
        var dumpPerf: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.dumpPerf = value
            }

        /** Enable experimental language feature: effect system */
        val effectSystem: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.effectSystem = true
            }

        /** Enable experimental expect/actual linker */
        val expectActualLinker: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.expectActualLinker = true
            }

        /** Enable and propagate usages of experimental API for marker annotation with the given fully qualified name */
        var experimental: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.experimental = value
            }

        /** Force compiler to report errors on all public API declarations without explicit visibility or return type.
         *  Use 'warning' level to issue warnings instead of errors. */
        var explicitApi: KotlinC.Advanced.ExplicitApi
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.explicitApi = value
            }

        /** Enable additional compiler checks that might provide verbose diagnostic information for certain errors.
         *  Warning: this mode is not backward-compatible and might cause compilation errors in previously compiled code. */
        val extendedCompilerChecks: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.extendedCompilerChecks = true
            }

        /** Enable compatibility changes for generic type inference algorithm */
        val inferenceCompatibility: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.inferenceCompatibility = true
            }

        /** Enable experimental inline classes */
        val inlineClasses: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.inlineClasses = true
            }

        /** Path to the kotlin-compiler.jar or directory where IntelliJ configuration files can be found */
        var intellijPluginRoot: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.intellijPluginRoot = value
            }

        /** Allow var smart casts despite assignment in try block */
        val legacySmartCastAfterTry: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.legacySmartCastAfterTry = true
            }

        /** List backend phases */
        val listPhases: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.listPhases = true
            }

        /** Change metadata version of the generated binary files */
        val metadataVersion: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.metadataVersion = true
            }

        /** Enable experimental language support for multi-platform projects */
        val multiPlatform: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.multiPlatform = true
            }

        /** Names of elements that should not be dumped */
        val excludeFromDumping: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.excludeFromDumping = true
            }

        /** Enable new experimental generic type inference algorithm */
        val newInference: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.newInference = true
            }

        /** Do not check presence of 'actual' modifier in multi-platform projects */
        val noCheckActual: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noCheckActual = true
            }

        /** Disable method inlining */
        val dontInline: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.noInline = true
            }

        /** Enable usages of API that requires opt-in with an opt-in requirement marker with the given fully
         *  qualified name */
        var optIn: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.optIn = value
            }

        /** Dump backend state both before and after these phases */
        val phasesToDump: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToDump = true
            }

        /** Dump backend state after these phases */
        val phasesToDumpAfter: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToDumpAfter = true
            }

        /** Dump backend state before these phases */
        val phasesToDumpBefore: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToDumpBefore = true
            }

        /** Validate backend state both before and after these phases */
        val phasesToValidate: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToValidate = true
            }

        /** Validate backend state after these phases */
        val phasesToValidateAfter: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToValidateAfter = true
            }

        /** Validate backend state before these phases */
        val phasesToValidateBefore: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.phasesToValidateBefore = true
            }

        /** Load plugins from the given classpath */
        var plugin: File
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.plugin = value
            }

        /** Enable experimental support for @PolymorphicSignature (MethodHandle/VarHandle) */
        val polymorphicSignature: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.polymorphicSignature = true
            }

        /** Profile backend phases */
        val profilePhases: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.profilePhases
            }

        /** Generate proper IEEE 754 comparisons in all cases if values are statically known to be of primitive
         *  numeric types */
        val properIeee754Comparisons: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.properIeee754Comparisons = true
            }

        /** Enable reading of contracts from metadata */
        val readDeserializedContracts: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.readDeserializedContracts = true
            }

        /** Report source to output files mapping */
        val reportOutputFiles: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.reportOutputFiles = true
            }

        /** Report detailed performance statistics */
        val reportPerf: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.reportPerf = true
            }

        /** Support inferring type arguments based on only self upper bounds of the corresponding type parameters */
        val selfUpperBoundInference: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.selfUpperBoundInference = true
            }

        /** Allow to load classes with bad metadata version and pre-release classes */
        val skipMetadataVersionCheck: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.skipMetadataVersionCheck = true
            }

        /** Allow to load pre-release classes */
        val skipPrereleaseCheck: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.skipPrereleaseCheck = true
            }

        /** Suppress warnings about outdated, inconsistent or experimental language or API versions */
        val suppressVersionWarnings: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.suppressVersionWarnings = true
            }

        /** Eliminate builder inference restrictions like allowance of returning type variables of a builder
         *  inference call */
        val unrestrictedBuilderInference: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.unrestrictedBuilderInference = true
            }

        /** Enable, but don't propagate usages of experimental API for marker annotation with the given fully
         *  qualified name */
        var useExperimental: String
            @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
            set(value) {
                this@KotlincBuilder.ktc.advanced.useExperimental = value
            }

        /** Compile using Front-end IR. Warning: this feature is far from being production-ready */
        val useFir: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useFir = true
            }

        /** Use extended analysis mode based on Front-end IR. Warning: this feature is far from being production-ready */
        val useFirExtendedCheckers: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useFirExtendedCheckers = true
            }

        /** Enable Support named arguments in their own position even if the result appears as mixed */
        val useMixedNamedArguments: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.useMixedNamedArguments = true
            }

        /** Be verbose while performing these backend phases */
        val verbosePhases: Unit
            get() {
                this@KotlincBuilder.ktc.advanced.verbosePhases = true
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


    /** source files */
    val sourceFiles: ArrayList<File> by ktc::sourcefiles
}