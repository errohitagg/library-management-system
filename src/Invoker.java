/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit Aggarwal
 */
public enum Invoker {

    ADMINISTRATOR ("Administrator"),
    LIBRARIAN ("Librarian"),
    EMPLOYEE ("Employee"),
    MEMBER ("Member");

    private final String invoke;

    private Invoker(String invoke)
    {
        this.invoke = invoke;
    }

}
