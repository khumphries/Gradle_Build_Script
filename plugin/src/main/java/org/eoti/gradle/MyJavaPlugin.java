package org.eoti.gradle;

import org.gradle.api.Project;
import org.gradle.api.Plugin;

public class MyJavaPlugin implements Plugin<Project> {

    @Override
    public void apply(Project target) {
        //target.task("javaTask");
        target.getExtensions().create("MyJava", MyJavaExtension.class);
        target.getTasks().create("javaTask", MyJavaTask.class);
    }

}