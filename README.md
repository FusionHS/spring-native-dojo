A small Dojo and presentation on various runtime improvements for JVM projects

https://docs.google.com/presentation/d/1EumDL7mfOJPKQQcgEtyHx1bAvmlaHPib2kEvxemUDu0/edit?usp=sharing

# GraalVM Native

Add the following to the plugin section

    id("org.graalvm.buildtools.native") version "0.10.2"

Then Run

    gradle bootBuildImage
    docker run -it --rm docker.io/library/spring-native-dojo:1.0.0

# CDS support

Add the following to the tasks.bootBuildImage section

    environment.put("BP_JVM_CDS_ENABLED", "true")

Then Run

    gradle bootBuildImage
    docker run -it --rm docker.io/library/spring-native-dojo:1.0.0

# Spring AOT

Add the following to the tasks.bootBuildImage section

    environment.put("BP_SPRING_AOT_ENABLED", "true")

Then Run

    gradle bootBuildImage
    docker run -it --rm docker.io/library/spring-native-dojo:1.0.0