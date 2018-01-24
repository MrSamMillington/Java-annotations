package docgen;

import math.MathUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        //Reflection example
        //Get a class object
        /*Class<?> clazz = MathUtils.class; //clazz, as class is a reserved word

        //Get all declared methods
        Method[] methods = clazz.getDeclaredMethods(); //getMethods also returns inherited methods

        //Loop over methods
        for(Method method : methods){
            //Display method name
            System.out.printf("name: %s%n", method.getName());
            //Display parameter count
            System.out.printf("\t# parameters: %s%n", method.getParameterCount());
            //Display return type
            System.out.printf("\treturn type: %s%n", method.getReturnType().getSimpleName());
            //Display modifiers
            System.out.printf("\tmodifiers: %s%n%n", Modifier.toString(method.getModifiers()));
        }*/

        //Process the MathUtils class's annotations
        DocProcessor.process(MathUtils.class);


    }
}
