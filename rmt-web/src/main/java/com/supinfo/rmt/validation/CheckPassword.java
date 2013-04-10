package com.supinfo.rmt.validation;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Antoine Rouaze <antoine.rouaze@zenika.com>
 */
@NotEmpty
@Size(min = 6)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckPasswordConstraint.class)
@Documented
public @interface CheckPassword {

    String message() default "{com.supinfo.constraint.password}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
