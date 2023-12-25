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

rootProject.name = "ch11"
include(":app")
include(":title")
include(":test11_recyclerview")
include(":test11_viewpager")
include(":test11_viewpager_fragment")
include(":test11_drawrlayout")
