package com.cs.btcoauth2poc;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_FIELD_INJECTION;
import static com.tngtech.archunit.library.GeneralCodingRules.NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

@AnalyzeClasses(packages = "com.cs.btcoauth2poc")
public class ArchitectureTest {

    @ArchTest
    static final ArchRule no_field_injection = NO_CLASSES_SHOULD_USE_FIELD_INJECTION;

    @ArchTest
    static final ArchRule no_usage_jul = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING;

    @ArchTest
    static final ArchRule no_usage_system_streams = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS;

    @ArchTest
    static final ArchRule interfaces_must_not_be_placed_in_implementation_packages =
            noClasses().that().resideInAPackage("..impl..").should().beInterfaces();

    @ArchTest
    static final ArchRule config_class_location =
            classes().that().haveSimpleNameEndingWith("Configuration")
                     .should().resideInAPackage("..config..");

    @ArchTest
    static final ArchRule controller_class_location =
            classes().that().haveSimpleNameEndingWith("Controller")
                     .should().resideInAPackage("..controller..");

    @ArchTest
    static final ArchRule service_class_location =
            classes().that().haveSimpleNameEndingWith("Service")
                     .should().resideInAPackage("..service..");

    @ArchTest
    static final ArchRule model_class_location =
            classes().that().haveSimpleNameEndingWith("Model")
                     .should().resideInAPackage("..model..");
}
