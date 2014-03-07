package javabrains.action;

import javabrains.model.User;
import javabrains.service.LoginService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.internal.ws.util.StringUtils;

public class LoginAction extends ActionSupport implements ModelDriven<User>
{
    private User user= new User();


    public void validate()
    {
        if ( user.getUserId().isEmpty() )
        {
            // UserId blank
            addFieldError( "userId", "User ID cannot be blank" );
        }
        if ( user.getPassword().isEmpty() )
        {
            // Password blank
            addFieldError( "password", "Password cannot be blank" );
        }
    }


    public User getUser()
    {
        return user;
    }


    public void setUser(User user)
    {
        this.user = user;
    }


    public String execute()
    {
        LoginService loginService = new LoginService();

        if ( loginService.verifyLogin( user ) )
        {
            return SUCCESS;
        }
        return LOGIN;

    }


    @Override
    public User getModel()
    {
        return user;
    }
}
