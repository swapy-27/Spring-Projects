package org.swapnil.convertor;

import com.fasterxml.jackson.databind.JsonNode;
import com.helger.jcodemodel.JCodeModelException;

import java.io.IOException;

public interface JsonPojoConvertor {

    void generateClass(JsonNode properties, String className) throws IOException, JCodeModelException;

    void generate(String filePath);
}
