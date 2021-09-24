package kts

import java.io.File

class JvmOptions {

    var minHeapSize = ""
    var maxHeapSize = ""

    //  Behavioral Options
    var allowUserSignalHandlers = NUL
    var disableExplicitGC = NUL
    var failOverToOldVerifier = NUL
    var handlePromotionFailure = NUL
    var maxFDLimit = NUL
    var relaxAccessControlCheck = NUL
    var scavengeBeforeFullGC = NUL
    var useAltSigs = NUL
    var useBoundThreads = NUL
    var useConcMarkSweepGC = NUL
    var useGCOverheadLimit = NUL
    var useLWPSynchronization = NUL
    var useParallelGC = NUL
    var useParallelOldGC = NUL
    var useSerialGC = NUL
    var useTLAB = NUL
    var useSplitVerifier = NUL
    var useThreadPriorities = NUL
    var useVMInterruptibleIO = NUL

    // G1 Options
    var useG1GC = NUL
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
    var aggressiveOpts = NUL
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
    var useBiasedLocking = NUL
    var useFastAccessorMethods = NUL
    var useISM = NUL
    var useLargePages = NUL
    var useMPSS = NUL
    var useStringCache = NUL
    var allocatePrefetchLines = -1
    var allocatePrefetchStyle = -1
    var useCompressedStrings = NUL
    var optimizeStringConcat = NUL

    // Debug Options
    var ciTime = NUL
    var errorFile: File? = null
    var extendedDTraceProbes = NUL
    var heapDumpPath: File? = null
    var heapDumpOnOutOfMemoryError = NUL
    val onError = ArrayList<String>()
    val onOutOfMemoryError = ArrayList<String>()
    var printClassHistogram = NUL
    var printConcurrentLocks = NUL
    var printCommandLineFlags = NUL
    var printCompilation = NUL
    var printGC = NUL
    var printGCDetails = NUL
    var printGCTimeStamps = NUL
    var printAdaptiveSizePolicy = NUL
    var traceClassLoading = NUL
    var traceClassLoadingPreorder = NUL
    var traceClassResolution = NUL
    var traceClassUnloading = NUL
    var traceLoaderConstraints = NUL
    var perfDataSaveToFile = NUL

    //        var parallelGCThreads = -1
    var alwaysPreTouch = NUL
    var allocatePrefetchDistance = -1
    var inlineSmallCode = -1
    var maxInlineSize = -1
    var freqInlineSize = -1
    var loopUnrollLimit = -1
    var initialTenuringThreshold = -1

    //        var maxTenuringThreshold = -1
    var loggc: File? = null
    var useGCLogFileRotation = NUL
    var numberOfGClogFiles = -1
    var gcLogFileSize = -1

    operator fun invoke(builder: StringBuilder) = builder.apply {
        operator fun Char.invoke(name: String) {
            if (this != NUL) append(" -J-XX:$this$name")
        }

        operator fun Int.invoke(name: String) {
            if (this != -1) append(" -J-XX:$name=$this")
        }
        //  Behavioral Options
        allowUserSignalHandlers("AllowUserSignalHandlers")
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
        errorFile?.let { append(" -J-XX:ErrorFile=${it.absolutePath}") }
        extendedDTraceProbes("ExtendedDTraceProbes")
        heapDumpPath?.let { append(" -J-XX:HeapDumpPath=${it.absolutePath}") }
        heapDumpOnOutOfMemoryError("HeapDumpOnOutOfMemoryError")
        if (onError.isNotEmpty()) append(" -J-XX:OnError=\"${onError.joinToString(";")}\"")
        if (onOutOfMemoryError.isNotEmpty()) append(" -J-XX:OnOutOfMemoryError=\"${onOutOfMemoryError.joinToString(",")}\"")
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
        loggc?.let { append(" -J-Xloggc:${it.absolutePath}") }
        useGCLogFileRotation("UseGCLogFileRotation")
        numberOfGClogFiles("NumberOfGClogFiles")
        gcLogFileSize("GCLogFileSize")
    }
}