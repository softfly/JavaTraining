package training.java6.ocp.io.bin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Date;

public class ContactV2 implements Serializable {

    /**
     * Exception in readObject
     * java.io.InvalidClassException: com.examples.io.Contact; no valid constructor
     */
    //public ContactV2() {
    //}

    public ContactV2(String fistName, String surname) {
        this.fistName = fistName;
        this.surname = surname;
    }

    private String fistName;

    private String surname;

    private Date freshAt = new Date();

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getFreshAt() {
        return freshAt;
    }

    public void setFreshAt(Date freshAt) {
        this.freshAt = freshAt;
    }

    @Override
    public String toString() {
        return "ContactV2 [fistName=" + fistName + ", surname=" + surname + ", freshAt=" + freshAt + "]";
    }

    //@Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(fistName);
        out.writeObject(surname);
    }

    //@Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fistName = (String) in.readObject();
        surname = (String) in.readObject();

    }

}
