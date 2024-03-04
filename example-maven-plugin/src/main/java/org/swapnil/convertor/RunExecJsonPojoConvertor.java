package org.swapnil.convertor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helger.jcodemodel.*;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

@Named
@Singleton
public class RunExecJsonPojoConvertor implements JsonPojoConvertor {
    @Override
    public Object generateJson(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read the JSON file and convert it to JsonNode
            JsonNode jsonNode = objectMapper.readTree(new File(filePath));

            String className = jsonNode.get("className").asText();
            JsonNode properties = jsonNode.get("properties");


            // Instantiate a new JCodeModel
            JCodeModel codeModel = new JCodeModel();
            // Create a new package
            JPackage jp = codeModel._package("org.swapnil.gen");
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


                switch (fieldType) {
                    case "integer":
                        jc.field(JMod.PUBLIC, Integer.class, fieldName);
                        break;
                    case "boolean":
                        jc.field(JMod.PUBLIC, Boolean.class, fieldName);
                        break;
                    case "string":
                        jc.field(JMod.PUBLIC, String.class, fieldName);
                        break;

                }

            }

//
//            // Add constant serializable id
//            jc.field(JMod.STATIC | JMod.FINAL, Long.class, "serialVersionUID", JExpr.lit(1L));
//
//            // Add private variable
//            JFieldVar quantity = jc.field(JMod.PRIVATE, Integer.class, "quantity");
//
//            // Add get method
//            JMethod getter = jc.method(JMod.PUBLIC, quantity.type(), "getQuantity");
//            getter.body()._return(quantity);
//            getter.javadoc().add("Returns the quantity.");
//            getter.javadoc().addReturn().add(quantity.name());
//
//            // Add set method
//            JMethod setter = jc.method(JMod.PUBLIC, codeModel.VOID, "setQuantity");
//            setter.param(quantity.type(), quantity.name());
//            setter.body().assign(JExpr._this().ref(quantity.name()), JExpr.ref(quantity.name()));
//            setter.javadoc().add("Set the quantity.");
//            setter.javadoc().addParam(quantity.name()).add("the new quantity");

            // Generate the code
            codeModel.build(new File("src/gen/"));


        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (JCodeModelException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    ;
}
