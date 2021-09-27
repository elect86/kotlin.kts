package kts

import java.io.File

inline fun kotlinc(block: KotlincBuilder.() -> Unit) {
    val ktc = KotlinC()
    KotlincBuilder(ktc).block()
    ktc()
}

class KotlinC {

    val classpath = ArrayList<String>()
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
    var wError = true
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

    operator fun invoke(): String {
        val cmd = "kotlinc"
        val args = arrayListOf<String>()
        if (classpath.isNotEmpty()) args += classpath.joinToString(File.pathSeparator)
        dst?.run { args.add("-d", absolutePath) }
        if (expression.isNotEmpty()) args.add("-e", expression)
        if (includeRuntime) args += "-include-runtime"
        if (javaParameters) args+="-java-parameters"
        jdkHome?.run { args.add("-jdk-home", absolutePath) }
        if (jvmTarget != -1) args.add("-jvm-target", jvmTarget)
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

        //        print(cmd)
        return cmd(args)
    }

    object Advanced {
        var abiStability: Boolean? = null
        val addModules = ArrayList<String>()
        var allowNoSourceFiles = false
        var allowUnstableDependencies = false
        var assertion: Assertion? = null
        var buildFile: File? = null
        var compileJava = false
        var normalizeConstructorCalls: Boolean? = null
        var dumpDeclarationsTo: File? = null
        var defaultScriptExtension = ""
        var disableStandardScript = false
        var irDoNotClearBindingContext = false
        var emitJvmTypeAnnotations = false
        var jvmEnablePreview = false
        val friendPaths = ArrayList<File>()
        var multifilePartsInherit = false
        val modulePaths = ArrayList<File>()
        var javaPackagePrefix = false
        val javaSourceRoots = ArrayList<File>()
        val javacArguments = ArrayList<String>()
        var jspecifyAnnotations: Annotation? = null
        var jsr305 = ""
        var jvmDefault: JvmDefalt? = null
        val klib = ArrayList<File>()
        var lambdas: Lambdas? = null
        var noCallAssertions = false
        var noExceptionOnExplicitEqualsForBoxedNull = false
        var noKotlinNothingValueException = false
        var noOptimize = false
        var noOptimizedCallableReferences = false
        var noParamAssertions = false
        var noReceiverAssertions = false
        var noResetJarTimestamps = false
        var noUnifiedNullChecks = false
        val nullabilityAnnotations = mutableMapOf<String, Annotation>()
        var parallelBackendThreads = -1
        var profile = ""
        var repeat = -1
        var samConversions: SamConvertions? = null
        var sanitizeParentheses = false
        val scriptResolverEnvironment = mutableMapOf<String, String>()
        var singleModule = false
        var skipRuntimeVersionCheck = false
        var strictJavaNullabilityAssertions = false
        var generateStrictMetadataVersion = false
        var stringConcat: StringConcat? = null
        var supportCompatqualCheckerFrameworkAnnotations: Boolean? = null
        var suppressDeprecatedJvmTargetWarning = false
        var suppressMissingBuiltinsError = false
        var typeEnhancementImprovementsStrictMode = false
        var useIr = false
        var useJavac = false
        var useOldBackend = false
        var useOldClassFilesReading = false
        var use14InlineClassesManglingScheme = false
        var useOldSpilledVarTypeAnalysis = false
        var useTypeTable = false
        var allowKotlinPackage = false
        var allowResultReturnType = false
        var checkPhaseConditions = false
        var checkStickyPhaseConditions = false
        val commonSources = ArrayList<String>()
        var disableDefaultScriptingPlugin = false
        var disablePhases = false
        var disableUltraLightClasses = false
        var dumpDirectory = false
        var dumpFqname = false
        var dumpPerf: File? = null
        var effectSystem = false
        var expectActualLinker = false
        var experimental = ""
        var explicitApi: ExplicitApi? = null
        var extendedCompilerChecks = false
        var inferenceCompatibility = false
        var inlineClasses = false
        var intellijPluginRoot: File? = null
        var legacySmartCastAfterTry = false
        var listPhases = false
        var metadataVersion = false
        var multiPlatform = false
        var excludeFromDumping = false
        var newInference = false
        var noCheckActual = false
        var noInline = false
        var optIn = ""
        var phasesToDump = false
        var phasesToDumpAfter = false
        var phasesToDumpBefore = false
        var phasesToValidate = false
        var phasesToValidateAfter = false
        var phasesToValidateBefore = false
        var plugin: File? = null
        var polymorphicSignature = false
        var profilePhases = false
        var properIeee754Comparisons = false
        var readDeserializedContracts = false
        var reportOutputFiles = false
        var reportPerf = false
        var selfUpperBoundInference = false
        var skipMetadataVersionCheck = false
        var skipPrereleaseCheck = false
        var suppressVersionWarnings = false
        var unrestrictedBuilderInference = false
        var useExperimental = ""
        var useFir = false
        var useFirExtendedCheckers = false
        var useMixedNamedArguments = false
        var verbosePhases = false

        operator fun invoke() {
            val cmd = "kotlinc"
            val args = arrayListOf<String>()
            fun ap(s: String, v: Any? = null) {
                var arg = "-X$s"
                v?.let { arg += "=$it" }
                args += arg
            }
            abiStability?.let { ap("abi-stability", if (it) "stable" else "unstable") }
            if (addModules.isNotEmpty()) ap("add-modules", addModules.joinToString(","))
            if (allowNoSourceFiles) ap("allow-no-source-files")
            if (allowUnstableDependencies) ap("allow-unstable-dependencies")
            assertion?.let { ap("assertions", it) }
            buildFile?.run { ap("build-file", absolutePath) }
            if (compileJava) ap("compile-java")
            normalizeConstructorCalls?.let { ap("normalize-constructor-calls", if (it) "enable" else "disable") }
            dumpDeclarationsTo?.run { ap("dump-declarations-to", absolutePath) }
            if (defaultScriptExtension.isNotEmpty()) ap("default-script-extension", defaultScriptExtension)
            if (disableStandardScript) ap("disable-standard-script")
            if (irDoNotClearBindingContext) ap("ir-do-not-clear-binding-context")
            if (emitJvmTypeAnnotations) ap("emit-jvm-type-annotations")
            if (jvmEnablePreview) ap("jvm-enable-preview")
            if (friendPaths.isNotEmpty()) ap("friend-paths", friendPaths.joinToString(File.pathSeparator))
            if (multifilePartsInherit) ap("multifile-parts-inherit")
            if (modulePaths.isNotEmpty()) ap("module-path", modulePaths.joinToString(File.pathSeparator))
            if (javaPackagePrefix) ap("java-package-prefix")
            if (javaSourceRoots.isNotEmpty()) ap("java-source-roots", javaSourceRoots.joinToString(File.pathSeparator))
            if (javacArguments.isNotEmpty()) ap("javac-arguments", javacArguments.joinToString(","))
            jspecifyAnnotations?.let { ap("jspecify-annotations", it) }
            if (jsr305.isNotEmpty()) ap("jsr305", jsr305)
            jvmDefault?.let { ap("jvm-default", it) }
            if (klib.isNotEmpty()) ap("klib", klib.joinToString(File.pathSeparator))
            lambdas?.let { ap("lamdas", it) }
            if (noCallAssertions) ap("no-call-assertions")
            if (noExceptionOnExplicitEqualsForBoxedNull) ap("no-exception-on-explicit-equals-for-boxed-null")
            if (noKotlinNothingValueException) ap("no-kotlin-nothing-value-exception")
            if (noOptimize) ap("no-optimize")
            if (noOptimizedCallableReferences) ap("no-optimized-callable-references")
            if (noParamAssertions) ap("no-param-assertions")
            if (noReceiverAssertions) ap("no-receiver-assertions")
            if (noResetJarTimestamps) ap("no-reset-jar-timestamps")
            if (noUnifiedNullChecks) ap("no-unified-null-checks")
            for ((key, value) in nullabilityAnnotations) ap("nullability-annotations", "$key:$value")
            if (parallelBackendThreads != -1) ap("parallel-backend-threads", parallelBackendThreads)
            if (profile.isNotEmpty()) ap("nullability-annotations", profile)
            if (repeat != -1) ap("repeat", repeat)
            samConversions?.let { ap("sam-conversions", it) }
            if (sanitizeParentheses) ap("sanitize-parentheses")
            if (scriptResolverEnvironment.isNotEmpty())
                ap("script-resolver-environment", scriptResolverEnvironment.map { (key, value) -> "$key=$value" }.joinToString(","))
            if (singleModule) ap("single-module")
            if (skipRuntimeVersionCheck) ap("skip-runtime-version-check")
            if (strictJavaNullabilityAssertions) ap("strict-java-nullability-assertions")
            if (generateStrictMetadataVersion) ap("generate-strict-metadata-version")
            stringConcat?.let { args.add("string-concat", it) }
            supportCompatqualCheckerFrameworkAnnotations?.let {
                ap("support-compatqual-checker-framework-annotations", if (it) "enable" else "disable")
            }
            if (suppressDeprecatedJvmTargetWarning) ap("suppress-deprecated-jvm-target-warning")
            if (suppressMissingBuiltinsError) ap("suppress-missing-builtins-error")
            if (typeEnhancementImprovementsStrictMode) ap("type-enhancement-improvements-strict-mode")
            if (useIr) ap("use-ir")
            if (useJavac) ap("use-javac")
            if (useOldBackend) ap("use-old-backend")
            if (useOldClassFilesReading) ap("use-old-class-files-reading")
            if (use14InlineClassesManglingScheme) ap("use-14-inline-classes-mangling-scheme")
            if (useOldSpilledVarTypeAnalysis) ap("use-old-spilled-var-type-analysis")
            if (useTypeTable) ap("use-type-table")
            if (allowKotlinPackage) ap("allow-kotlin-package")
            if (allowResultReturnType) ap("allow-result-return-type")
            if (checkPhaseConditions) ap("check-phase-conditions")
            if (checkStickyPhaseConditions) ap("check-sticky-phase-conditions")
            if (commonSources.isNotEmpty()) ap("common-sources", commonSources.joinToString(File.pathSeparator))
            if (disableDefaultScriptingPlugin) ap("disable-default-scripting-plugin")
            if (disablePhases) ap("disable-phases")
            if (disableUltraLightClasses) ap("disable-ultra-light-classes")
            if (dumpDirectory) ap("dump-directory")
            if (dumpFqname) ap("dump-fqname")
            dumpPerf?.run { ap("dump-perf", absolutePath) }
            if (effectSystem) ap("effect-system")
            if (expectActualLinker) ap("expect-actual-linker")
            if (experimental.isNotEmpty()) ap("experimental", experimental)
            explicitApi?.let { ap("explicit-api", it) }
            if (extendedCompilerChecks) ap("extended-compiler-checks")
            if (inferenceCompatibility) ap("inference-compatibility")
            if (inlineClasses) ap("inline-classes")
            intellijPluginRoot?.run { ap("intellij-plugin-root", absolutePath) }
            if (legacySmartCastAfterTry) ap("legacy-smart-cast-after-try")
            if (listPhases) ap("list-phases")
            if (metadataVersion) ap("metadata-version")
            if (multiPlatform) ap("multi-platform")
            if (excludeFromDumping) ap("exclude-from-dumping")
            if (newInference) ap("new-inference")
            if (noCheckActual) ap("no-check-actual")
            if (noInline) ap("no-inline")
            if (optIn.isNotEmpty()) ap("opt-in", optIn)
            if (phasesToDump) ap("phases-to-dump")
            if (phasesToDumpAfter) ap("phases-to-dump-after")
            if (phasesToDumpBefore) ap("phases-to-dump-before")
            if (phasesToValidate) ap("phases-to-validate")
            if (phasesToValidateAfter) ap("phases-to-validate-after")
            if (phasesToValidateBefore) ap("phases-to-validate-before")
            plugin?.run { ap("plugin", absolutePath) }
            if (polymorphicSignature) ap("polymorphic-signature")
            if (profilePhases) ap("profile-phases")
            if (properIeee754Comparisons) ap("proper-ieee754-comparisons")
            if (readDeserializedContracts) ap("read-deserialized-contracts")
            if (reportOutputFiles) ap("report-output-files")
            if (reportPerf) ap("report-perf")
            if (selfUpperBoundInference) ap("self-upper-bound-inference")
            if (skipMetadataVersionCheck) ap("skip-metadata-version-check")
            if (skipPrereleaseCheck) ap("skip-prerelease-check")
            if (suppressVersionWarnings) ap("suppress-version-warnings")
            if (unrestrictedBuilderInference) ap("unrestricted-builder-inference")
            if (useExperimental.isNotEmpty()) ap("use-experimental", useExperimental)
            if (useFir) ap("use-fir")
            if (useFirExtendedCheckers) ap("use-fir-extended-checkers")
            if (useMixedNamedArguments) ap("use-mixed-named-arguments")
            if (verbosePhases) ap("verbose-phases")
        }

        enum class Assertion {
            /** enable, ignore jvm assertion settings */
            `always-enable`,

            /** disable, ignore jvm assertion settings */
            `always-disable`,

            /** enable, depend on jvm assertion settings */
            jvm,

            /** calculate condition on each call, check depends on jvm assertion settings in the kotlin package.
             *  Default option  */
            legacy
        }

        enum class Annotation {
            ignore,

            /** experimental; treat as other supported nullability annotations */
            strict,

            /** report a warning */
            warn
        }

        enum class JvmDefalt {
            /** Generate both a default method in the interface, and a compatibility accessor in the DefaultImpls class.
             *  In case of inheritance from a Kotlin interface compiled in the old scheme (DefaultImpls, no default
             *  methods), the compatibility accessor in DefaultImpls will delegate to the DefaultImpls method of the
             *  superinterface. Otherwise the compatibility accessor will invoke the default method on the interface,
             *  with standard JVM runtime resolution semantics.
             *  Note that if interface delegation is used, all interface methods are delegated.
             *  The only exception are methods annotated with the deprecated @JvmDefault annotation. */
            `all-compatibility`,

            /** Generate default methods for all interface declarations with bodies. Do not generate DefaultImpls
             *  classes at all. BREAKS BINARY COMPATIBILITY if some client code relies on the presence of DefaultImpls
             *  classes. Also prohibits the produced binaries to be read by Kotlin compilers earlier than 1.4.
             *  Note that if interface delegation is used, all interface methods are delegated.
             *  The only exception are methods annotated with the deprecated @JvmDefault annotation. */
            all,

            /** Do not generate JVM default methods and prohibit @JvmDefault annotation usage. */
            disable,

            /** Allow usages of @JvmDefault; only generate the default method for annotated method in the interface
             *  (annotating an existing method can break binary compatibility) */
            enable,

            /** Allow usages of @JvmDefault; generate a compatibility accessor in the 'DefaultImpls' class in addition
             *  to the default interface method */
            compatibility
        }

        enum class Lambdas {
            /** Generate lambdas using `invokedynamic` with `LambdaMetafactory.metafactory`. Requires `-jvm-target 1.8`
             *  or greater. */
            indy,

            /** Lambda objects created using `LambdaMetafactory.metafactory` will have different `toString()`.
             *  Generate lambdas as explicit classes */
            `class`

        }

        enum class SamConvertions {
            /** Generate SAM conversions using `invokedynamic` with `LambdaMetafactory.metafactory`.
             *  Requires `-jvm-target 1.8` or greater. */
            indy,

            /** Generate SAM conversions as explicit classes */
            `class`
        }

        enum class StringConcat {
            /** Concatenate strings using `invokedynamic` `makeConcatWithConstants`. Requires `-jvm-target 9` or greater. */
            `indy-with-constants`,

            /** Concatenate strings using `invokedynamic` `makeConcat`. Requires `-jvm-target 9` or greater. */
            indy,

            /** Concatenate strings using `StringBuilder` */
            `inline`

        }

        enum class ExplicitApi { strict, warning, disable }
    }
}
