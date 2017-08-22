package org.advanced.validators;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.annotation.Generated;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.groups.Default;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Constraint(validatedBy=UniqueKeyValidator.class)
public @interface UniqueKey {

		String columnName();
		Class<?> className();
		String message() default "error in field";
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};
	}