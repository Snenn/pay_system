package by.snenn.Command;

import javax.servlet.http.HttpServletRequest;

public enum Actions {

    MAINUSER {{
        this.action = new CommandMainUser();
    }},
    MAINADMIN {{
        this.action = new CommandMainAdmin();
    }},

    SIGNUP {{
        this.action = new CommandSignUp();
    }},
    LOGIN {{
        this.action = new CommandLogin();
    }};



    protected Action action = null;

    public static Action defineFrom(HttpServletRequest req) {
        Action result=Actions.LOGIN.action;
        String cmdName = req.getParameter("command");
        if (cmdName!=null && !cmdName.isEmpty())
            try {
                result = Actions.valueOf(cmdName.toUpperCase()).action;
            } catch (IllegalArgumentException e) {
                result = Actions.LOGIN.action;
            }
        return result;
    }

}