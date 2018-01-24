package docgen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//declared with @interface
//specify retention and targets
//SOURCE, CLASS or RUNTIME
//source -throw away on compiling
//class - retain in the byte code -> not loaded into the jvm while running
//runtime - available for runtime

//targets
//Type - classes
//method, methods

//reflection - write code to examine or modify structure or code


//in parenthesis -> passing value to the processor
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Doc {

    /* Description of class or method */
    String desc() default "";

    /* Description of paramters, if annotated element is a method & has parameters */
    String[] params() default {};

    /* Description of return value, if annotated element is a method & isn't void */
    String returnValue() default "";
}
