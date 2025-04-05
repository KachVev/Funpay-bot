plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "Funpay-bot"
include("extensions")
include("extensions:files")
include("extensions:profiler")