/*
 * Copyright (C) 2019 Oliver.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package client.presentation;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author Oliver
 */
public class UserWrapper {
    private String userName;
    private String fullName;
    private String institution;
    private String employeeID;

    public UserWrapper(String userName, String fullName, String institution, String employeeID) {
        this.userName = userName;
        this.fullName = fullName;
        this.institution = institution;
        this.employeeID = employeeID;
    }
    
    public UserWrapper(String[] array)
    {
        if (array.length != 4)
        {
            throw new IllegalArgumentException("Wrong array length");
        }
        this.userName = array[0];
        this.fullName = array[1];
        this.institution = array[2];
        this.employeeID = array[3];
    }

    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInstitution() {
        return institution;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    
    public static ObservableList<UserWrapper> generateUsers(String uName, String pWord)
    {
       List<String[]> userData = InteractionCommunicatior.getInstance().getUsers(uName, pWord);
       List<UserWrapper> userWrapperList = new ArrayList<>();
       userData.forEach(sa->userWrapperList.add(new UserWrapper(sa)));
       return FXCollections.observableArrayList(userWrapperList);
    }
    
    
}
