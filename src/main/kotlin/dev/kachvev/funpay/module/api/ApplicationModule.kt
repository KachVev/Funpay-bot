package dev.kachvev.funpay.module.api

interface ApplicationModule {
    val name: String
        get() = this::class.simpleName ?: "None"

    // The `start()` function is empty because it might be intended to be implemented by
    // classes that extend or implement this interface. It could serve as a placeholder
    // for specific setup or initialization logic that subclasses would define.
    fun start() {
        // Implementation in subclasses should provide the logic for starting the module.
    }

    // Similarly, the `stop()` function is empty as it is intended for subclasses to
    // define the cleanup or shutdown behavior. This allows each module to have
    // custom logic for halting its processes.
    fun stop() {
        // Implementation in subclasses should provide the logic for stopping the module.
    }
}
