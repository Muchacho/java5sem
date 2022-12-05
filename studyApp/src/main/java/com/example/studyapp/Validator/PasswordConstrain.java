package com.example.studyapp.Validator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConstrain  {
    String message() default "Invalid password, try again ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}