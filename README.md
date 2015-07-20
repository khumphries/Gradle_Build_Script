# Gradle_Build_Script


You have to be in the plugin directory and run the command "gradle uploadArchives"

Then you can go to the consumer directory and that gradle.build file can be moved anywhere on your computer and run

The only thing is that you must add the path of the repo folder which will be created in you project_drc directory (where consumer and plugin should be) to the gradle.build that you move anywhere on your computer.

You add the path here
buildscript {
    repositories {
        maven {
            url "file:///Add the path here."