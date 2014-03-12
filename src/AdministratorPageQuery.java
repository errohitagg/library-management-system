/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rohit Aggarwal
 */
public abstract class AdministratorPageQuery {

    abstract boolean check_library();
    abstract boolean check_member();
    abstract boolean check_member_type();
    abstract boolean check_book();
    abstract boolean check_membership();
    abstract boolean check_isbn_book();
    abstract String retrieve_member_id();
    abstract boolean check_member_reference();
    abstract boolean check_member_id();
    abstract void delete_member();
    abstract void delete_membership();
    abstract void delete_book();

}
