package org.rsreu.library.servlet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class SessionRequestContent {

    private Map<String, Object> requestAttributes;
    private Map<String, String[]> requestParameters;
    private Map<String, Object> sessionAttributes;

    public SessionRequestContent() {
        requestAttributes = new HashMap<>();
        requestParameters = new HashMap<>();
        sessionAttributes = new HashMap<>();
    }

    public void extractValues(jakarta.servlet.http.HttpServletRequest request) {
        // Extract request attributes
        Enumeration<String> requestAttributeNames = request.getAttributeNames();
        while (requestAttributeNames.hasMoreElements()) {
            String attributeName = requestAttributeNames.nextElement();
            requestAttributes.put(attributeName, request.getAttribute(attributeName));
        }

        // Extract request parameters
        requestParameters.putAll(request.getParameterMap());

        // Extract session attributes
        Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
        while (sessionAttributeNames.hasMoreElements()) {
            String attributeName = sessionAttributeNames.nextElement();
            sessionAttributes.put(attributeName, request.getSession().getAttribute(attributeName));
        }
    }

    public void insertAttributes(jakarta.servlet.http.HttpServletRequest request) {
        // Set request attributes
        for (Map.Entry<String, Object> entry : requestAttributes.entrySet()) {
            request.setAttribute(entry.getKey(), entry.getValue());
        }

        // Set request parameters
        for (Map.Entry<String, String[]> entry : requestParameters.entrySet()) {
            request.getParameterMap().put(entry.getKey(), entry.getValue());
        }

        // Set session attributes
        for (Map.Entry<String, Object> entry : sessionAttributes.entrySet()) {
            request.getSession().setAttribute(entry.getKey(), entry.getValue());
        }
    }
}
