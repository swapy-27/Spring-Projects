package org.swapnil.example;

import org.apache.maven.plugin.MojoExecutionException;

public interface VersionProvider {

    String getVersion(String command) throws MojoExecutionException
            ;

}
