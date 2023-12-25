pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ch13"
include(":app")
include(":test13_app1")
include(":test13_app2")
include(":test13_app3")
include(":test13_app4")
include(":test13_app5")
