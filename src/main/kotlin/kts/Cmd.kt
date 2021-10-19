package kts

interface Cmd<Builder> {

    val cmd: String

    fun cmdLine(): List<String>

    val cmdLine: String
        get() = "$cmd ${cmdLine().joinToString(" ")}"

    operator fun invoke(): String {

        //        if (_println)
        //            print("$cmd ${line.joinToString(" ")}")
        val command = arrayListOf(cmd) + cmdLine()
        val process = ProcessBuilder(command)
            .inheritIO()
            //        .directory(workingDir)
            //        .redirectOutput(Redirect.INHERIT)
            //        .redirectError(Redirect.INHERIT)
            .start().apply { waitFor() }
        //        .waitFor(60, TimeUnit.MINUTES)
        return String(process.inputStream.readAllBytes())
    }

    operator fun invoke(block: Builder.() -> Unit): Cmd<Builder>
}