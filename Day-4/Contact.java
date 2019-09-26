/**
 * This class discusses about the Contact Object.
 * The attributes of the contact object
 * are as follows.
 * name : Name of the person / friend.
 * email : mail id of the person / friend.
 * phoneNumber : Phone Number of the person / friend.
  * @author Siva Sankar
 */
//  Your code goes here... For Contact class
public class Contact {
    public String name;
    public String email;
    public String phone;
    Contact(final String name, final String email, final String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phone;
    }
    public String toString() {
        return"{ Name = "+this.name +", Email = " +this.email+", Phone Number = " + this.phone + " }";
    }
    public void setName(final String toset) {
        this.name= toset;
    }
    public void setEmail(final String toset) {
        this.email = toset;
    }
    public void setPhoneNumber(final String toset) {
        this.phone = toset;
    }
}