package training.java6.ocp.io.bin;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Contact implements Externalizable {
    
    /**
     * Exception in readObject
     * java.io.InvalidClassException: com.examples.io.Contact; no valid constructor
     */
    public Contact() {
        
    }

    public Contact(String name) {
        this();
        this.name = name;
        this.id = ++count;
    }
    
    private static int count;
    
    private int id;

    private String name;

    private Date freshAt=new Date();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getFreshAt() {
        return freshAt;
    }

    public void setFreshAt(Date freshAt) {
        this.freshAt = freshAt;
    }

    @Override
    public String toString() {
        return "Contact [id=" + id + ", name=" + name + ", freshAt=" + freshAt + "]";
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(id);
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = (int) in.readObject();
        this.name = (String) in.readObject();
        this.freshAt = new Date();
    }

}
