package docgen;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class DocProcessor {
    /**
    * Analyzes the given classes Doc annotation, displaying output
    * for the class and for each for each of its non-private methods.
    * @param clazz Class to analyze
    * @return true if Doc annotation is used sufficiently on the class
    *               and it's methods, false otherwise
    * */
    public static boolean process(Class clazz){

        //Store simple name of the class for quick access
        String className = clazz.getSimpleName();

        //Display class name
        System.out.printf("Analyzing '%s ...", className);

        //Track the number of class errors
        int classErrors = 0;

        // Does @Doc annotation appear on class?
        if(clazz.isAnnotationPresent(Doc.class)){

            // loop over delcared methods of class
            for(Method method : clazz.getDeclaredMethods()){

                //Get method modifiers
                int modifierInt = method.getModifiers();

                //Get method name
                String methodName = method.getName();

                //Is method non-private?
                if(!Modifier.isPrivate(modifierInt)){
                    int methodErrors = 0;

                    //Display method name
                    System.out.printf("%n%n\t%s:", methodName);

                    //does @Doc annotation appear on method?
                    if(method.isAnnotationPresent(Doc.class)){

                        //Get a reference to the actual annotation
                        Doc doc = method.getAnnotation(Doc.class);

                        //Does the number of items in param description match
                        //the number of actual parameters?
                        int numMissing = getNumMissingParams(method, doc);
                        if (numMissing > 0){
                            methodErrors ++;
                            String message = "%n\t\t=> Missing %s paramters description(s)";
                            System.out.printf(message, numMissing);
                        }

                        //Is there a return description when needed?
                        if(!hasReturnDescription(method, doc)){
                            methodErrors++;
                            String message = "%n\t\t=> Missing description of return value";
                            System.out.printf(message);
                        }
                    }else{
                        methodErrors++;
                        System.out.printf("%n\t\t=> Doc annotation missing");
                    }

                    if(methodErrors == 0){
                        System.out.printf("%n\t\t => No changes needed");
                    }

                    //Add method errors to class erros
                    classErrors += methodErrors;
                }
            }
        } else {
            classErrors ++;
            System.out.printf("%n\t\t=> Class does not contain the proper documentation");
        }

        //Display final message
        String yayOrNay = classErrors == 0 ? "YAY" : "Get to documenting";
        String finalMessage = "%n%nDocProcessor has found %s error(s) in class '%s'. %s!%n";
        System.out.printf(finalMessage, classErrors, className, yayOrNay);


        return false;
    }

    /** Determines whether or not a methods return value description is missing
     * @param method Method method under consideration
     * @param doc Annotation to check
     * @return True if method has a void return or the annnoation has a non-empty return description
     */
    private static boolean hasReturnDescription(Method method, Doc doc) {
        //Return true when the method return is void or return val non-empty
        return method.getReturnType().equals(Void.TYPE) || !doc.returnValue().isEmpty();
    }

    /** Whether or not the number of descriptions prodivded in the doc annotation
     * match the number of paramters in the given method.
     * @param method method Method under consideration
     * @param doc Annotation to check
     * @return Number of descriptions missing
     */
    private static int getNumMissingParams(Method method, Doc doc) {
        int numMissing = 0;

        //Check if the number of param desc in the annotation
        //Is less than the methods param count
        int annotatedParamCount = doc.params().length;
        int actualParamCount = method.getParameterCount();
        if (annotatedParamCount < actualParamCount) {
            //Calc the number of missing param descriptions
            numMissing = actualParamCount - annotatedParamCount;
        }

        return numMissing;
    }


}
