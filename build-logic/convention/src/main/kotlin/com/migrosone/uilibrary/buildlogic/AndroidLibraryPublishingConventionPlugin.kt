package com.migrosone.uilibrary.buildlogic

import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SourcesJar
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryPublishingConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("com.vanniktech.maven.publish")

        extensions.configure<MavenPublishBaseExtension> {
            configure(
                AndroidSingleVariantLibrary(
                    javadocJar = JavadocJar.Empty(),
                    sourcesJar = SourcesJar.Sources(),
                    variant = "release",
                ),
            )
            coordinates(
                groupId = publishingProperty("GROUP"),
                artifactId = publishingArtifactId(),
                version = publishingProperty("VERSION_NAME"),
            )
            publishToMavenCentral(automaticRelease = false)
            pom {
                name.set(publishingName())
                description.set(publishingDescription())
                inceptionYear.set(publishingProperty("PUBLISHING_INCEPTION_YEAR"))
                url.set(publishingProperty("PUBLISHING_URL"))
                licenses {
                    license {
                        name.set(publishingProperty("PUBLISHING_LICENSE_NAME"))
                        url.set(publishingProperty("PUBLISHING_LICENSE_URL"))
                        distribution.set(publishingProperty("PUBLISHING_LICENSE_DIST"))
                    }
                }
                developers {
                    developer {
                        id.set(publishingProperty("PUBLISHING_DEVELOPER_ID"))
                        name.set(publishingProperty("PUBLISHING_DEVELOPER_NAME"))
                        url.set(publishingProperty("PUBLISHING_DEVELOPER_URL"))
                    }
                }
                scm {
                    url.set(publishingProperty("PUBLISHING_SCM_URL"))
                    connection.set(publishingProperty("PUBLISHING_SCM_CONNECTION"))
                    developerConnection.set(publishingProperty("PUBLISHING_SCM_DEV_CONNECTION"))
                }
            }

            if (hasSigningCredentials()) {
                signAllPublications()
            }
        }
    }

    private fun Project.publishingProperty(name: String): String {
        return providers.gradleProperty(name).get()
    }

    private fun Project.hasSigningCredentials(): Boolean {
        return providers.gradleProperty("signingInMemoryKey").isPresent ||
            providers.gradleProperty("signing.secretKeyRingFile").isPresent
    }

    private fun Project.publishingArtifactId(): String {
        return when (path) {
            ":ui-compose" -> "migrosone-ui-library-compose"
            ":ui-theme" -> "migrosone-ui-library-theme"
            else -> error("Publishing is only configured for :ui-compose and :ui-theme.")
        }
    }

    private fun Project.publishingName(): String {
        return when (path) {
            ":ui-compose" -> "MigrosOne UI Library Compose"
            ":ui-theme" -> "MigrosOne UI Library Theme"
            else -> error("Publishing is only configured for :ui-compose and :ui-theme.")
        }
    }

    private fun Project.publishingDescription(): String {
        return when (path) {
            ":ui-compose" -> "Jetpack Compose components for MigrosOne UI Library."
            ":ui-theme" -> "Migros design system theme tokens for MigrosOne UI Library."
            else -> error("Publishing is only configured for :ui-compose and :ui-theme.")
        }
    }
}
