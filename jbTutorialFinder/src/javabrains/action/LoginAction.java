package javabrains.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.util.StringUtils;

public class LoginAction extends ActionSupport
{
    private String userId;
    private String password;

    public String getUserId()
    {
        return userId;
    }


    public void setUserId(String userId)
    {
        this.userId = userId;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password)
    {
        this.password = password;
    }

    public void validate()
    {
        if ( userId.isEmpty() )
        {
            // UserId blank
            addFieldError( "userId", "User ID cannot be blank" );
        }
        if ( password.isEmpty() )
        {
            // Password blank
            addFieldError( "password", "Password cannot be blank" );
        }
    }
    
    
    public String execute()
    {
        if ( getUserId().equals( "userId" ) && getPassword().equals( "password" ) )
        {
            return SUCCESS;
        }
        return LOGIN;

    }
}
