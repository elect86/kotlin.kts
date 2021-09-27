package kts

import java.io.File

class JvmOptions {

    var minHeapSize = ""
    var maxHeapSize = ""

    //  Behavioral Options
    var allowUserSignalHandlers: Boolean? = null
    var disableExplicitGC: Boolean? = null
    var failOverToOldVerifier: Boolean? = null
    var handlePromotionFailure: Boolean? = null
    var maxFDLimit: Boolean? = null
    var relaxAccessControlCheck: Boolean? = null
    var scavengeBeforeFullGC: Boolean? = null
    var useAltSigs: Boolean? = null
    var useBoundThreads: Boolean? = null
    var useConcMarkSweepGC: Boolean? = null
    var useGCOverheadLimit: Boolean? = null
    var useLWPSynchronization: Boolean? = null
    var useParallelGC: Boolean? = null
    var useParallelOldGC: Boolean? = null
    var useSerialGC: Boolean? = null
    var useTLAB: Boolean? = null
    var useSplitVerifier: Boolean? = null
    var useThreadPriorities: Boolean? = null
    var useVMInterruptibleIO: Boolean? = null

    // G1 Options
    var useG1GC: Boolean? = null
    var maxGCPauseMillis = -1
    var initiatingHeapOccupancyPercent = -1
    var newRatio = -1
    var survivorRatio = -1
    var maxTenuringThreshold = -1
    var parallelGCThreads = -1
    var concGCThreads = -1
    var g1ReservePercent = -1
    var g1HeapRegionSize = -1

    // Performance Options
    var aggressiveOpts: Boolean? = null
    var compileThreshold = -1
    var largePageSizeInBytes = -1
    var maxHeapFreeRatio = -1
    var maxNewSize = -1
    var maxPermSize = -1
    var minHeapFreeRatio = -1

    //        var newRatio = -1
    var newSize = -1
    var reservedCodeCacheSize = -1

    //        var survivorRatio = -1
    var targetSurvivorRatio = -1
    var threadStackSize = -1
    var useBiasedLocking: Boolean? = null
    var useFastAccessorMethods: Boolean? = null
    var useISM: Boolean? = null
    var useLargePages: Boolean? = null
    var useMPSS: Boolean? = null
    var useStringCache: Boolean? = null
    var allocatePrefetchLines = -1
    var allocatePrefetchStyle = -1
    var useCompressedStrings: Boolean? = null
    var optimizeStringConcat: Boolean? = null

    // Debug Options
    var ciTime: Boolean? = null
    var errorFile: File? = null
    var extendedDTraceProbes: Boolean? = null
    var heapDumpPath: File? = null
    var heapDumpOnOutOfMemoryError: Boolean? = null
    val onError = ArrayList<String>()
    val onOutOfMemoryError = ArrayList<String>()
    var printClassHistogram: Boolean? = null
    var printConcurrentLocks: Boolean? = null
    var printCommandLineFlags: Boolean? = null
    var printCompilation: Boolean? = null
    var printGC: Boolean? = null
    var printGCDetails: Boolean? = null
    var printGCTimeStamps: Boolean? = null
    var printAdaptiveSizePolicy: Boolean? = null
    var traceClassLoading: Boolean? = null
    var traceClassLoadingPreorder: Boolean? = null
    var traceClassResolution: Boolean? = null
    var traceClassUnloading: Boolean? = null
    var traceLoaderConstraints: Boolean? = null
    var perfDataSaveToFile: Boolean? = null

    //        var parallelGCThreads = -1
    var alwaysPreTouch: Boolean? = null
    var allocatePrefetchDistance = -1
    var inlineSmallCode = -1
    var maxInlineSize = -1
    var freqInlineSize = -1
    var loopUnrollLimit = -1
    var initialTenuringThreshold = -1

    //        var maxTenuringThreshold = -1
    var loggc: File? = null
    var useGCLogFileRotation: Boolean? = null
    var numberOfGClogFiles = -1
    var gcLogFileSize = -1

    operator fun invoke(args: ArrayList<String>) {

        operator fun Int.invoke(name: String) {
            if (this != -1) args += "-J-XX:$name=$this"
        }

        operator fun Boolean?.invoke(name: String) {
            this?.let {
                val enable = if (it) '+' else '-'
                args += "-J-XX:$enable$name"
            }
        }
        //  Behavioral Options
        allowUserSignalHandlers("AllowUserSignalHandlers")
        disableExplicitGC("DisableExplicitGC")
        failOverToOldVerifier("FailOverToOldVerifier")
        maxFDLimit("MaxFDLimit")
        relaxAccessControlCheck("RelaxAccessControlCheck")
        scavengeBeforeFullGC("ScavengeBeforeFullGC")
        useAltSigs("UseAltSigs")
        useBoundThreads("UseBoundThreads")
        useConcMarkSweepGC("UseConcMarkSweepGC")
        useGCOverheadLimit("UseGCOverheadLimit")
        useLWPSynchronization("UseLWPSynchronization")
        useParallelGC("UseParallelGC")
        useParallelOldGC("UseParallelOldGC")
        useSerialGC("UseSerialGC")
        useTLAB("UseTLAB")
        useSplitVerifier("UseSplitVerifier")
        useThreadPriorities("UseThreadPriorities")
        useVMInterruptibleIO("UseVMInterruptibleIO")
        // G1 Options
        useG1GC("UseG1GC")
        maxGCPauseMillis("MaxGCPauseMillis")
        initiatingHeapOccupancyPercent("InitiatingHeapOccupancyPercent")
        newRatio("NewRatio")
        survivorRatio("SurvivorRatio")
        maxTenuringThreshold("MaxTenuringThreshold")
        parallelGCThreads("ParallelGCThreads")
        concGCThreads("ConcGCThreads")
        g1ReservePercent("G1ReservePercent")
        g1HeapRegionSize("G1HeapRegionSize")
        // Performance Options
        aggressiveOpts("AggressiveOpts")
        compileThreshold("CompileThreshold")
        largePageSizeInBytes("LargePageSizeInBytes")
        maxHeapFreeRatio("MaxHeapFreeRatio")
        maxNewSize("MaxNewSize")
        maxPermSize("MaxPermSize")
        minHeapFreeRatio("MinHeapFreeRatio")
        newSize("NewSize")
        reservedCodeCacheSize("ReservedCodeCacheSize")
        targetSurvivorRatio("TargetSurvivorRatio")
        threadStackSize("ThreadStackSize")
        useBiasedLocking("UseBiasedLocking")
        useFastAccessorMethods("UseFastAccessorMethods")
        useISM("UseISM")
        useLargePages("UseLargePages")
        useMPSS("UseMPSS")
        useStringCache("UseStringCache")
        allocatePrefetchLines("AllocatePrefetchLines")
        allocatePrefetchStyle("AllocatePrefetchStyle")
        useCompressedStrings("UseCompressedStrings")
        optimizeStringConcat("OptimizeStringConcat")
        // Debug Options
        ciTime("CITime")
        errorFile?.let { args += "-J-XX:ErrorFile=${it.absolutePath}" }
        extendedDTraceProbes("ExtendedDTraceProbes")
        heapDumpPath?.let { args += "-J-XX:HeapDumpPath=${it.absolutePath}" }
        heapDumpOnOutOfMemoryError("HeapDumpOnOutOfMemoryError")
        if (onError.isNotEmpty()) args += "-J-XX:OnError=\"${onError.joinToString(";")}\""
        if (onOutOfMemoryError.isNotEmpty()) args += "-J-XX:OnOutOfMemoryError=\"${onOutOfMemoryError.joinToString(",")}\""
        printClassHistogram("PrintClassHistogram")
        printConcurrentLocks("PrintConcurrentLocks")
        printCommandLineFlags("PrintCommandLineFlags")
        printCompilation("PrintCompilation")
        printGC("PrintGC")
        printGCDetails("PrintGCDetails")
        printGCTimeStamps("PrintGCTimeStamps")
        printAdaptiveSizePolicy("PrintAdaptiveSizePolicy")
        traceClassLoading("TraceClassLoading")
        traceClassLoadingPreorder("TraceClassLoadingPreorder")
        traceClassResolution("TraceClassResolution")
        traceClassUnloading("TraceClassUnloading")
        traceLoaderConstraints("TraceLoaderConstraints")
        perfDataSaveToFile("PerfDataSaveToFile")
        parallelGCThreads("ParallelGCThreads")
        alwaysPreTouch("AlwaysPreTouch")
        allocatePrefetchDistance("AllocatePrefetchDistance")
        inlineSmallCode("InlineSmallCode")
        maxInlineSize("MaxInlineSize")
        freqInlineSize("FreqInlineSize")
        loopUnrollLimit("LoopUnrollLimit")
        initialTenuringThreshold("InitialTenuringThreshold")
        loggc?.let { args += "-J-Xloggc:${it.absolutePath}" }
        useGCLogFileRotation("UseGCLogFileRotation")
        numberOfGClogFiles("NumberOfGClogFiles")
        gcLogFileSize("GCLogFileSize")
    }
}