package com.github.sujankumarmitar.msscbeerservice.util;

import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.util.StringUtils.collectionToDelimitedString;

public class ConstrainedFields {

    private final ConstraintDescriptions constraintDescriptions;

    public ConstrainedFields(Class<?> input) {
        this.constraintDescriptions = new ConstraintDescriptions(input);
    }

    public FieldDescriptor withPath(String path) {
        return fieldWithPath(path)
                .attributes(key("constraints").value(
                        collectionToDelimitedString(
                                constraintDescriptions
                                        .descriptionsForProperty(path), ". ")));
    }
}
