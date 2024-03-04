package org.swapnil.convertor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helger.jcodemodel.*;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

@Named
@Singleton
public class RunExecJsonPojoConvertor implements JsonPojoConvertor {

    private Map<String, Integer> accessModMap;

    public RunExecJsonPojoConvertor() {
        accessModMap = new HashMap<>();
        accessModMap.put("protected", 2);
        accessModMap.put("public", 1);
        accessModMap.put("private", 4);
        accessModMap.put("default", 0);
    }

    @Override
    public void generate(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file and convert it to JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            String className = jsonNode.get("className").asText();
            JsonNode properties = jsonNode.get("properties");

            generateClass(properties, className);

        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (JCodeModelException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    @Override
    public void generateClass(JsonNode properties, String className) throws IOException, JCodeModelException {

        // Instantiate a new JCodeModel
        JCodeModel codeModel = new JCodeModel();
        // Create a new package
        JPackage jp = codeModel._package("");
        // Create a new class
        JDefinedClass jc = jp._class(className);

        // Implement Serializable
        jc._implements(Serializable.class);

        // Add Javadoc
        jc.javadoc().add("A simple Json2PoJo convertor.");

        // Add default constructor
        jc.constructor(JMod.PUBLIC).javadoc().add("Creates a new " + jc.name() + ".");

        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = properties.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> fieldEntry = fieldsIterator.next();

            String fieldName = fieldEntry.getKey();
            String fieldType = fieldEntry.getValue().get("type").asText();
            String accessModifier = fieldEntry.getValue().get("accessModifier").asText();

            addAttribute(accessModifier, fieldName, fieldType, jc, codeModel);

        }
        // Generate the code
        codeModel.build(new File("src/gen/"));
    }





    void addAttribute(String accessModifier, String fieldName, String fieldType, JDefinedClass jc, JCodeModel codeModel) {
        accessModMap.put("protected", 2);
        accessModMap.put("public", 1);
        accessModMap.put("private", 4);
        accessModMap.put("default", 0);
        JFieldVar field;
        switch (fieldType) {
            case "integer":
                field = jc.field(accessModMap.get(accessModifier), Integer.class, fieldName);
                addGetterSetters(jc, field, fieldName, codeModel);
                break;
            case "boolean":
                field = jc.field(accessModMap.get(accessModifier), Boolean.class, fieldName);
                addGetterSetters(jc, field, fieldName, codeModel);
                break;
            case "string":
                field = jc.field(accessModMap.get(accessModifier), String.class, fieldName);
                addGetterSetters(jc, field, fieldName, codeModel);
                break;
        }
    }

    ;

    void addGetterSetters(JDefinedClass jc, JFieldVar var, String fieldName, JCodeModel codeModel) {
        // Add get method
        JMethod getter = jc.method(JMod.PUBLIC, var.type(), "get" + fieldName);
        getter.body()._return(var);
        getter.javadoc().add("Returns the "+fieldName+ ".");
        // Add set method
        JMethod setter = jc.method(JMod.PUBLIC, codeModel.VOID, "set" + fieldName);
        setter.param(var.type(), var.name());
        setter.body().assign(JExpr._this().ref(var.name()), JExpr.ref(var.name()));
        setter.javadoc().add("Set the " +fieldName+ ".");

    }

}
