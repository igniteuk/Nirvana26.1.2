val mc_version: String by extra
val forge_config_port_version: String by extra

plugins {
    java
    id("dev.architectury.loom")
}

dependencies {
    modCompileOnly(libs.jei.common.api)
    modCompileOnly(libs.config.api.port.common)

    modCompileOnly(libs.registrate.neoforge)
    modCompileOnly(libs.multikulti.registrate.common)
    accessTransformers(libs.multikulti.core.common)
}
