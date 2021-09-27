package kts

import java.io.File

class JvmOptionsBuilder(override val opt: JvmOptions) : BehavioralJvmOptionsBuilder,
                                                        G1JvmOptionsBuilder,
                                                        PerformanceJvmOptionsBuilder,
                                                        DebugJvmOptionsBuilder {

    /** Units can be marked as ‘g' for GB, ‘m' for MB and ‘k' for KB. */
    var minHeapSize: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.minHeapSize = value
        }

    /** Units can be marked as ‘g' for GB, ‘m' for MB and ‘k' for KB. */
    var maxHeapSize: String
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxHeapSize = value
        }

    inline fun behavioral(block: BehavioralJvmOptionsBuilder.() -> Unit) = block()
    inline fun g1(block: G1JvmOptionsBuilder.() -> Unit) = block()
    inline fun performance(block: PerformanceJvmOptionsBuilder.() -> Unit) = block()
    inline fun debug(block: DebugJvmOptionsBuilder.() -> Unit) = block()
}

interface BehavioralJvmOptionsBuilder {

    val opt: JvmOptions

    /** Do not complain if the application installs signal handlers. (Relevant to Solaris and Linux only.) */
    var allowUserSignalHandlers: Boolean
        get() {
            opt.allowUserSignalHandlers = true
            return true
        }
        set(value) {
            opt.allowUserSignalHandlers = value
        }

    /** By default calls to System.gc() are enabled (-XX:-DisableExplicitGC). Use -XX:+DisableExplicitGC to disable
     *  calls to System.gc(). Note that the JVM still performs garbage collection when necessary. */
    var disableExplicitGC: Boolean
        get() {
            opt.disableExplicitGC = true
            return true
        }
        set(value) {
            opt.disableExplicitGC = value
        }

    /** Fail over to old verifier when the new type checker fails. (Introduced in 6.) */
    var failOverToOldVerifier: Boolean
        get() {
            opt.failOverToOldVerifier = true
            return true
        }
        set(value) {
            opt.failOverToOldVerifier = value
        }

    /** The youngest generation collection does not require a guarantee of full promotion of all live objects.
     *  (Introduced in 1.4.2 update 11) [5.0 and earlier: false.] */
    var handlePromotionFailure: Boolean
        get() {
            opt.handlePromotionFailure = true
            return true
        }
        set(value) {
            opt.handlePromotionFailure = value
        }

    /** Bump the number of file descriptors to max. (Relevant  to Solaris only.) */
    var maxFDLimit: Boolean
        get() {
            opt.maxFDLimit = true
            return true
        }
        set(value) {
            opt.maxFDLimit = value
        }

    /** Relax the access control checks in the verifier. (Introduced in 6.) */
    var relaxAccessControlCheck: Boolean
        get() {
            opt.relaxAccessControlCheck = true
            return true
        }
        set(value) {
            opt.relaxAccessControlCheck = value
        }

    /** Do young generation GC prior to a full GC. (Introduced in 1.4.1.) */
    var scavengeBeforeFullGC: Boolean
        get() {
            opt.scavengeBeforeFullGC = true
            return true
        }
        set(value) {
            opt.scavengeBeforeFullGC = value
        }

    /** Use alternate signals instead of SIGUSR1 and SIGUSR2 for VM internal signals. (Introduced in 1.3.1 update
     *  9, 1.4.1. Relevant to Solaris only.) */
    var useAltSigs: Boolean
        get() {
            opt.useAltSigs = true
            return true
        }
        set(value) {
            opt.useAltSigs = value
        }

    /** Bind user level threads to kernel threads. (Relevant to Solaris only.) */
    var useBoundThreads: Boolean
        get() {
            opt.useBoundThreads = true
            return true
        }
        set(value) {
            opt.useBoundThreads = value
        }

    /** Use concurrent mark-sweep collection for the old generation. (Introduced in 1.4.1) */
    var useConcMarkSweepGC: Boolean
        get() {
            opt.useConcMarkSweepGC = true
            return true
        }
        set(value) {
            opt.useConcMarkSweepGC = value
        }

    /** Use a policy that limits the proportion of the VM's time that is spent in GC before an OutOfMemory error is
     * thrown. (Introduced in 6.) */
    var useGCOverheadLimit: Boolean
        get() {
            opt.useGCOverheadLimit = true
            return true
        }
        set(value) {
            opt.useGCOverheadLimit = value
        }

    /** Use LWP-based instead of thread based synchronization. (Introduced in 1.4.0. Relevant to Solaris only.) */
    var useLWPSynchronization: Boolean
        get() {
            opt.useLWPSynchronization = true
            return true
        }
        set(value) {
            opt.useLWPSynchronization = value
        }

    /** Use parallel garbage collection for scavenges. (Introduced in 1.4.1) */
    var useParallelGC: Boolean
        get() {
            opt.useParallelGC = true
            return true
        }
        set(value) {
            opt.useParallelGC = value
        }

    /** Use parallel garbage collection for the full collections. Enabling this option automatically sets
     *  -XX:+UseParallelGC. (Introduced in 5.0 update 6.) */
    var useParallelOldGC: Boolean
        get() {
            opt.useParallelOldGC = true
            return true
        }
        set(value) {
            opt.useParallelOldGC = value
        }

    /** Use serial garbage collection. (Introduced in 5.0.) */
    var useSerialGC: Boolean
        get() {
            opt.useSerialGC = true
            return true
        }
        set(value) {
            opt.useSerialGC = value
        }

    /** Use thread-local object allocation (Introduced in 1.4.0, known as UseTLE prior to that.) [1.4.2 and earlier,
     *  x86 or with -client: false] */
    var useTLAB: Boolean
        get() {
            opt.useTLAB = true
            return true
        }
        set(value) {
            opt.useTLAB = value
        }

    /** Use the new type checker with StackMapTable attributes. (Introduced in 5.0.)[5.0: false] */
    var useSplitVerifier: Boolean
        get() {
            opt.useSplitVerifier = true
            return true
        }
        set(value) {
            opt.useSplitVerifier = value
        }

    /** Use native thread priorities. */
    var useThreadPriorities: Boolean
        get() {
            opt.useThreadPriorities = true
            return true
        }
        set(value) {
            opt.useThreadPriorities = value
        }

    /** Thread interrupt before or with EINTR for I/O operations results in OS_INTRPT. (Introduced in 6. Relevant
     *  to Solaris only.) */
    var useVMInterruptibleIO: Boolean
        get() {
            opt.useVMInterruptibleIO = true
            return true
        }
        set(value) {
            opt.useVMInterruptibleIO = value
        }
}

interface G1JvmOptionsBuilder {

    val opt: JvmOptions

    /** Use the Garbage First (G1) Collector */
    var useG1GC: Boolean
        get() {
            opt.useG1GC = true
            return true
        }
        set(value) {
            opt.useG1GC = value
        }

    /** Sets a target for the maximum GC pause time. This is a soft goal, and the JVM will make its best effort to
     *  achieve it. */
    var maxGCPauseMillis: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxGCPauseMillis = value
        }

    /** Percentage of the (entire) heap occupancy to start a concurrent GC cycle. It is used by GCs that trigger a
     *  concurrent GC cycle based on the occupancy of the entire heap, not just one of the generations (e.g., G1).
     *  A value of 0 denotes 'do constant GC cycles'. The default value is 45. */
    var initiatingHeapOccupancyPercent: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.initiatingHeapOccupancyPercent = value
        }

    /** Ratio of old/new generation sizes. The default value is 2. */
    var newRatio: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.newRatio = value
        }

    /** Ratio of eden/survivor space size. The default value is 8. */
    var survivorRatio: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.survivorRatio = value
        }

    /** Maximum value for tenuring threshold. The default value is 15. */
    var maxTenuringThreshold: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxTenuringThreshold = value
        }

    /** Sets the number of threads used during parallel phases of the garbage collectors. The default value varies
     *  with the platform on which the JVM is running. */
    var parallelGCThreads: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.parallelGCThreads = value
        }

    /** Number of threads concurrent garbage collectors will use. The default value varies with the platform on
     *  which the JVM is running. */
    var concGCThreads: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.concGCThreads = value
        }

    /** Sets the amount of heap that is reserved as a false ceiling to reduce the possibility of promotion failure.
     *  The default value is 10. */
    var g1ReservePercent: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.g1ReservePercent = value
        }

    /** With G1 the Java heap is subdivided into uniformly sized regions. This sets the size of the individual
     *  sub-divisions. The default value of this parameter is determined ergonomically based upon heap size.
     *  The minimum value is 1Mb and the maximum value is 32Mb. */
    var g1HeapRegionSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.g1HeapRegionSize = value
        }
}

interface PerformanceJvmOptionsBuilder {

    val opt: JvmOptions

    /** Turn on point performance compiler optimizations that are expected to be default in upcoming releases.
     *  (Introduced in 5.0 update 6.) */
    var aggressiveOpts: Boolean
        get() {
            opt.aggressiveOpts = true
            return true
        }
        set(value) {
            opt.aggressiveOpts = value
        }

    /** Number of method invocations/branches before compiling [-client: 1,500] */
    var compileThreshold: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.compileThreshold = value
        }

    /** Sets the large page size used for the Java heap. (Introduced in 1.4.0 update 1.) [amd64: 2m.] */
    var largePageSizeInBytes: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.largePageSizeInBytes = value
        }

    /** Maximum percentage of heap free after GC to avoid shrinking. */
    var maxHeapFreeRatio: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxHeapFreeRatio = value
        }

    /** Maximum size of new generation (in bytes). Since 1.4, MaxNewSize is computed as a function of NewRatio.
     *  [1.3.1 Sparc: 32m; 1.3.1 x86: 2.5m.] */
    var maxNewSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxNewSize = value
        }

    /** Size of the Permanent Generation.
     *  [5.0 and newer: 64 bit VMs are scaled 30% larger; 1.4 amd64: 96m; 1.3.1 -client: 32m.] */
    var maxPermSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxPermSize = value
        }

    /** Minimum percentage of heap free after GC to avoid expansion. */
    var minHeapFreeRatio: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.minHeapFreeRatio = value
        }

    //        /** Ratio of old/new generation sizes.
    //         *  [Sparc -client: 8; x86 -server: 8; x86 -client: 12.]-client: 4 (1.3) 8 (1.3.1+), x86: 12] */
    //        var newRatio: Int
    //            get() = error("")
    //            set(value) {Kotlin.opt.newRatio=value}

    /** Default size of new generation (in bytes)
     *  [5.0 and newer: 64 bit VMs are scaled 30% larger; x86: 1m; x86, 5.0 and older: 640k] */
    var newSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.newSize = value
        }

    /** Reserved code cache size (in bytes) - maximum code cache size.
     *  [Solaris 64-bit, amd64, and -server x86: 2048m; in 1.5.0_06 and earlier, Solaris 64-bit and amd64: 1024m.] */
    var reservedCodeCacheSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.reservedCodeCacheSize = value
        }

    //        /** Ratio of eden/survivor space size
    //         *  [Solaris amd64: 6; Sparc in 1.3.1: 25; other Solaris platforms in 5.0 and earlier: 32] */
    //        var survivorRatio: Int
    //            get() = error("")
    //        set(value) {Kotlin.opt.survivorRatio=value}

    /** Desired percentage of survivor space used after scavenge. */
    var targetSurvivorRatio: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.targetSurvivorRatio = value
        }

    /** Thread Stack Size (in Kbytes). (0 means use default stack size)
     *  [Sparc: 512; Solaris x86: 320 (was 256 prior in 5.0 and earlier);
     *  Sparc 64 bit: 1024; Linux amd64: 1024 (was 0 in 5.0 and earlier); all others 0.] */
    var threadStackSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.threadStackSize = value
        }

    /** Enable biased locking. For more details, see this tuning example:
     *      https://www.oracle.com/java/technologies/java-tuning.html#section4.2.5
     *  (Introduced in 5.0 update 6.) [5.0: false] */
    var useBiasedLocking: Boolean
        get() {
            opt.useBiasedLocking = true
            return true
        }
        set(value) {
            opt.useBiasedLocking = value
        }

    /** Use optimized versions of Get<Primitive>Field. */
    var useFastAccessorMethods: Boolean
        get() {
            opt.useFastAccessorMethods = true
            return true
        }
        set(value) {
            opt.useFastAccessorMethods = value
        }

    /** Use Intimate Shared Memory. [Not accepted for non-Solaris platforms.] */
    var useISM: Boolean
        get() {
            opt.useISM = true
            return true
        }
        set(value) {
            opt.useISM = value
        }

    /** Use large page memory. (Introduced in 5.0 update 5.) For details, see Java Support for Large Memory Pages.
     *      https://www.oracle.com/java/technologies/javase/largememory-pages.html */
    var useLargePages: Boolean
        get() {
            opt.useLargePages = true
            return true
        }
        set(value) {
            opt.useLargePages = value
        }

    /** Use Multiple Page Size Support w/4mb pages for the heap. Do not use with ISM as this replaces the need for
     * ISM. (Introduced in 1.4.0 update 1, Relevant to Solaris 9 and newer.) [1.4.1 and earlier: false] */
    var useMPSS: Boolean
        get() {
            opt.useMPSS = true
            return true
        }
        set(value) {
            opt.useMPSS = value
        }

    /** Enables caching of commonly allocated strings. */
    var useStringCache: Boolean
        get() {
            opt.useStringCache = true
            return true
        }
        set(value) {
            opt.useStringCache = value
        }

    /** Number of cache lines to load after the last object allocation using prefetch instructions generated in JIT
     *  compiled code. Default values are 1 if the last allocated object was an instance and 3 if it was an array. */
    var allocatePrefetchLines: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.allocatePrefetchLines = value
        }

    /** Generated code style for prefetch instructions.
     *  0 - no prefetch instructions are generate*d*,
     *  1 - execute prefetch instructions after each allocation,
     *  2 - use TLAB allocation watermark pointer to gate when prefetch instructions are executed. */
    var allocatePrefetchStyle: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.allocatePrefetchStyle = value
        }

    /** Use a byte[] for Strings which can be represented as pure ASCII.
     *  (Introduced in Java 6 Update 21 Performance Release) */
    var useCompressedStrings: Boolean
        get() {
            opt.useCompressedStrings = true
            return true
        }
        set(value) {
            opt.useCompressedStrings = value
        }

    /** Optimize String concatenation operations where possible. (Introduced in Java 6 Update 20) */
    var optimizeStringConcat: Boolean
        get() {
            opt.optimizeStringConcat = true
            return true
        }
        set(value) {
            opt.optimizeStringConcat = value
        }
}

interface DebugJvmOptionsBuilder {

    val opt: JvmOptions

    /** Prints time spent in JIT Compiler. (Introduced in 1.4.0.) */
    var ciTime: Boolean
        get() {
            opt.ciTime = true
            return true
        }
        set(value) {
            opt.ciTime = value
        }

    /** If an error occurs, save the error data to this file. (Introduced in 6.) */
    var errorFile: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.errorFile = value
        }

    /** Enable performance-impacting dtrace probes.
     *      http://docs.oracle.com/javase/6/docs/technotes/guides/vm/dtrace.html
     *  (Introduced in 6. Relevant to Solaris only.) */
    var extendedDTraceProbes: Boolean
        get() {
            opt.extendedDTraceProbes = true
            return true
        }
        set(value) {
            opt.extendedDTraceProbes = value
        }

    /** Path to directory or filename for heap dump. Manageable. (Introduced in 1.4.2 update 12, 5.0 update 7.) */
    var heapDumpPath: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.heapDumpPath = value
        }

    /** Dump heap to file when java.lang.OutOfMemoryError is thrown. Manageable.
     *  (Introduced in 1.4.2 update 12, 5.0 update 7.) */
    var heapDumpOnOutOfMemoryError: Boolean
        get() {
            opt.heapDumpOnOutOfMemoryError = true
            return true
        }
        set(value) {
            opt.heapDumpOnOutOfMemoryError = value
        }

    /** Run user-defined commands on fatal error. (Introduced in 1.4.2 update 9.) */
    val onError: ArrayList<String>
        get() = opt.onError

    /** Run user-defined commands when an OutOfMemoryError is first thrown. (Introduced in 1.4.2 update 12, 6) */
    val onOutOfMemoryError: ArrayList<String>
        get() = opt.onOutOfMemoryError

    /** Print a histogram of class instances on Ctrl-Break. Manageable. (Introduced in 1.4.2.)
     *  The jmap -histo command provides equivalent functionality.
     *      http://docs.oracle.com/javase/6/docs/technotes/tools/share/jmap.html    */
    var printClassHistogram: Boolean
        get() {
            opt.printClassHistogram = true
            return true
        }
        set(value) {
            opt.printClassHistogram = value
        }

    /** Print java.util.concurrent locks in Ctrl-Break thread dump. Manageable. (Introduced in 6.)
     *  The jstack -l command provides equivalent functionality.
     *      http://docs.oracle.com/javase/6/docs/technotes/tools/share/jstack.html  */
    var printConcurrentLocks: Boolean
        get() {
            opt.printConcurrentLocks = true
            return true
        }
        set(value) {
            opt.printConcurrentLocks = value
        }

    /** Print flags that appeared on the command line. (Introduced in 5.0.) */
    var printCommandLineFlags: Boolean
        get() {
            opt.printCommandLineFlags = true
            return true
        }
        set(value) {
            opt.printCommandLineFlags = value
        }

    /** Print message when a method is compiled. */
    var printCompilation: Boolean
        get() {
            opt.printCompilation = true
            return true
        }
        set(value) {
            opt.printCompilation = value
        }

    /** Print messages at garbage collection. Manageable. */
    var printGC: Boolean
        get() {
            opt.printGC = true
            return true
        }
        set(value) {
            opt.printGC = value
        }

    /** Print more details at garbage collection. Manageable. (Introduced in 1.4.0.) */
    var printGCDetails: Boolean
        get() {
            opt.printGCDetails = true
            return true
        }
        set(value) {
            opt.printGCDetails = value
        }

    /** Print timestamps at garbage collection. Manageable (Introduced in 1.4.0.) */
    var printGCTimeStamps: Boolean
        get() {
            opt.printGCTimeStamps = true
            return true
        }
        set(value) {
            opt.printGCTimeStamps = value
        }

    /** Enables printing of information about adaptive generation sizing. */
    var printAdaptiveSizePolicy: Boolean
        get() {
            opt.printAdaptiveSizePolicy = true
            return true
        }
        set(value) {
            opt.printAdaptiveSizePolicy = value
        }

    /** Trace loading of classes. */
    var traceClassLoading: Boolean
        get() {
            opt.traceClassLoading = true
            return true
        }
        set(value) {
            opt.traceClassLoading = value
        }

    /** Trace all classes loaded in order referenced (not loaded). (Introduced in 1.4.2.) */
    var traceClassLoadingPreorder: Boolean
        get() {
            opt.traceClassLoadingPreorder = true
            return true
        }
        set(value) {
            opt.traceClassLoadingPreorder = value
        }

    /** Trace constant pool resolutions. (Introduced in 1.4.2.) */
    var traceClassResolution: Boolean
        get() {
            opt.traceClassResolution = true
            return true
        }
        set(value) {
            opt.traceClassResolution = value
        }

    /** Trace unloading of classes. */
    var traceClassUnloading: Boolean
        get() {
            opt.traceClassUnloading = true
            return true
        }
        set(value) {
            opt.traceClassUnloading = value
        }

    /** Trace recording of loader constraints. (Introduced in 6.) */
    var traceLoaderConstraints: Boolean
        get() {
            opt.traceLoaderConstraints = true
            return true
        }
        set(value) {
            opt.traceLoaderConstraints = value
        }

    /** Saves jvmstat binary data on exit. */
    var perfDataSaveToFile: Boolean
        get() {
            opt.perfDataSaveToFile = true
            return true
        }
        set(value) {
            opt.perfDataSaveToFile = value
        }

    //        /** Sets the number of garbage collection threads in the young and old parallel garbage collectors.
    //         *  The default value varies with the platform on which the JVM is running. */
    //        var parallelGCThreads: Int
    //            get() = error("")
    //            set(value) {
    //                Kotlin.opt.parallelGCThreads = value
    //            }

    /** Pre-touch the Java heap during JVM initialization. Every page of the heap is thus demand-zeroed during
     *  initialization rather than incrementally during application execution. */
    var alwaysPreTouch: Boolean
        get() {
            opt.alwaysPreTouch = true
            return true
        }
        set(value) {
            opt.alwaysPreTouch = value
        }

    /** Sets the prefetch distance for object allocation. Memory about to be written with the value of new objects
     *  is prefetched into cache at this distance (in bytes) beyond the address of the last allocated object.
     *  Each Java thread has its own allocation point. The default value varies with the platform on which the JVM
     *  is running. */
    var allocatePrefetchDistance: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.allocatePrefetchDistance = value
        }

    /** Inline a previously compiled method only if its generated native code size is less than this.
     *  The default value varies with the platform on which the JVM is running. */
    var inlineSmallCode: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.inlineSmallCode = value
        }

    /** Maximum bytecode size of a method to be inlined. */
    var maxInlineSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.maxInlineSize = value
        }

    /** Maximum bytecode size of a frequently executed method to be inlined. The default value varies with the
     *  platform on which the JVM is running. */
    var freqInlineSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.freqInlineSize = value
        }

    /** Unroll loop bodies with server compiler intermediate representation node count less than this value.
     *  The limit used by the server compiler is a function of this value, not the actual value.
     *  The default value varies with the platform on which the JVM is running. */
    var loopUnrollLimit: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.loopUnrollLimit = value
        }

    /** Sets the initial tenuring threshold for use in adaptive GC sizing in the parallel young collector.
     *  The tenuring threshold is the number of times an object survives a young collection before being promoted
     *  to the old, or tenured, generation. */
    var initialTenuringThreshold: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.initialTenuringThreshold = value
        }

    //        /** Sets the maximum tenuring threshold for use in adaptive GC sizing. The current largest value is 15.
    //         *  The default value is 15 for the parallel collector and is 4 for CMS. */
    //        maxTenuringThreshold

    /** Log GC verbose output to specified file. The verbose output is controlled by the normal verbose GC flags. */
    var loggc: File
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.loggc = value
        }

    /** Enabled GC log rotation, requires -Xloggc. */
    var useGCLogFileRotation: Boolean
        get() {
            opt.useGCLogFileRotation = true
            return true
        }
        set(value) {
            opt.useGCLogFileRotation = value
        }

    /** Set the number of files to use when rotating logs, must be >= 1. The rotated log files will use the
     *  following naming scheme, <filename>.0, <filename>.1, ..., <filename>.n-1. */
    var numberOfGClogFiles: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.numberOfGClogFiles = value
        }

    /** The size of the log file at which point the log will be rotated, must be >= 8K. */
    var gcLogFileSize: Int
        @Deprecated(message = "Write only property", level = DeprecationLevel.HIDDEN) get() = error("")
        set(value) {
            opt.gcLogFileSize = value
        }
}