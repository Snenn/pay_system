package by.snenn.Command;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

abstract public class Action {
    public abstract Action execute(HttpServletRequest reg) throws ParseException;

    @Override
    public String toString() {
        String name=this.getClass().getSimpleName();
        name=name.replace("Command","");
        return name;
    }

    public String getJsp(){
        String name=this.toString().toLowerCase();
        return "/"+name+".jsp";
    }



}
