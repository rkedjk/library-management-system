package org.rsreu.library.command.factory;

import org.rsreu.library.command.ActionCommand;
import org.rsreu.library.command.EmptyCommand;
import org.rsreu.library.resource.MessageManager;
import  org.rsreu.library.command.client.CommandEnum;

public class ActionFactory {

    public static ActionCommand defineCommand(jakarta.servlet.http.HttpServletRequest request) {
        ActionCommand current = new EmptyCommand();
        // извлечение имени команды из запроса
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            // если команда не задана в текущем запросе
            return current;
        }
        // получение объекта, соответствующего команде
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            request.setAttribute("wrongAction", action
                    + MessageManager.getProperty("message.wrongaction"));
        }
        return current;
    }
}
