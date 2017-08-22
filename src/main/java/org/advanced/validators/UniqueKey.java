package org.advanced.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * Specifies the unique key of an entity.
 * can be used with fields such as Email, mobile phone, Identification number etc, that 
 * are unique.
 * Can be used with any primitive and wrapper type
 *   <pre>
 *   Example:
 *
 *   &#064;UniqueKey(className=EntityName,columnName=FieldName, message=ErrorMessage)
 *   public String Email() { return Email; }
 * </pre>
 **/
@Documented
@Retention(RUNTIME)
@Target({FIELD,METHOD, ANNOTATION_TYPE})
@Constraint(validatedBy=UniqueKeyValidator.class)
public @interface UniqueKey {

		String columnName();
		Class<?> className();
		String message() default "error in field";
		Class<?>[] groups() default {};
		Class<? extends Payload>[] payload() default {};
	}