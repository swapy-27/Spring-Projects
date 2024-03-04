package org.swapnil.convertor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;

@Mojo(name = "generate-pojo", defaultPhase = LifecyclePhase.INITIALIZE)
public class JsonToPojo extends AbstractMojo {
    @Parameter(property = "filepath", defaultValue = "C:/Users/SWAPNILJ/Documents/maven-plugin/example-maven-plugin/src/main/resources/emoloyee.json")
    private String path;


    @Inject
    private JsonPojoConvertor jsonPojoConvertor;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {

            jsonPojoConvertor.generateJson(path);

    }
}
