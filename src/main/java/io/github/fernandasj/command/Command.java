package io.github.fernandasj.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amanda
 */
public interface Command {
    void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException;
}
