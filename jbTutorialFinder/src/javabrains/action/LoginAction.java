package javabrains.action;

import com.opensymphony.xwork2.Action;

public class LoginAction implements Action
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


    public String execute()
    {
        if ( getUserId().equals( "userId" ) && getPassword().equals( "password" ) )
        {
            return SUCCESS;
        }
        return LOGIN;

    }
}
