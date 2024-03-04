package org.swapnil.convertor;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.inject.Inject;

@Mojo(name = "generate-pojo", defaultPhase = LifecyclePhase.GENERATE_RESOURCES)
public class JsonToPojo extends AbstractMojo {
    @Parameter(property = "filepath", defaultValue = "C:/Users/SWAPNILJ/Documents/maven-plugin/example-maven-plugin/src/main/resources/emoloyee.json")
    private String filePath;


    @Inject
    private JsonPojoConvertor jsonPojoConvertor;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("------------------- Json to Pojo convertor started() -------------------");
        jsonPojoConvertor.generate(filePath);
        getLog().info("------------------- Json to Pojo convertor ended() ---------------------");
    }
}
