/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package serverpackage;

import java.io.Serializable;

/**
 *
 * @author Karim
 */
public class Emp implements Serializable {

    private String name;
    private String add;
    private int id;

    public void setName(String n) {
        name = n;
    }

    public void setadd(String a) {
        add = a;
    }

    public void setId(int i) {
        id = i;
    }

    public String getName() {
        return name;
    }

    public String getAdd() {
        return add;
    }

    public int getId() {
        return id;
    }
}
