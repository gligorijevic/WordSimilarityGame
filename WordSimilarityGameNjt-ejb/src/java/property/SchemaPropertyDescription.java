/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package property;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Djordje Gligorijevic
 */
public class SchemaPropertyDescription {

    public static String schemaPropertyDescription(String propertyName) throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head><title>" + propertyName + "property</title><head><body>");

        File data = new File("e:\\Semantic web baze\\Schema.org\\schemaorgallproperties.csv");

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        while ((line = bufRdr.readLine()) != null) {
            String[] items = line.split(",");
            if (items[0].trim().equals(propertyName)) {
                builder.append("<div>Comments: " + items[2] + "</div>");
                builder.append("<br/>");
                builder.append("<div>Domain: " + items[3] + "</div>");
                builder.append("<br/>");
                builder.append("<div>Range: " + items[4] + "</div>");
                builder.append("<br/>");



            }
        }

        builder.append("</body></html>");
        String page = builder.toString();

        return page;
    }

    public static String schemaPropertyDescriptionJSF(String propertyName) throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>  <html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:h=\"http://java.sun.com/jsf/html\"  xmlns:f=\"http://java.sun.com/jsf/core\"  xmlns:ui=\"http://java.sun.com/jsf/facelets\"  xmlns:p=\"http://primefaces.org/ui\"> <h:head>" + propertyName + "property</h:head> <h:body>");

        File data = new File("e:\\Semantic web baze\\Schema.org\\schemaorgallproperties.csv");

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        while ((line = bufRdr.readLine()) != null) {
            String[] items = line.split(",");
            if (items[0].trim().equals(propertyName)) {
                builder.append("<div>Comments: " + items[2] + "</div>");
                builder.append("<br/>");
                builder.append("<div>Domain: " + items[3] + "</div>");
                builder.append("<br/>");
                builder.append("<div>Range: " + items[4] + "</div>");
                builder.append("<br/>");

            }
        }

        builder.append("</h:body></html>");
        String page = builder.toString();

        return page;
    }

    public static String schemaPropertyDescriptionTxt(String propertyName) throws FileNotFoundException, IOException {
        StringBuilder builder = new StringBuilder();
        builder.append(propertyName + " property\n");

        File data = new File("e:\\Semantic web baze\\Schema.org\\schemaorgallproperties.csv");

        BufferedReader bufRdr = new BufferedReader(new FileReader(data));

        String line = null;
        while ((line = bufRdr.readLine()) != null) {
            String[] items = line.split(",");
            if (items[0].trim().equals(propertyName)) {
                builder.append("Comments: ").append(items[2]).append(",\n");
                builder.append("\n");
                builder.append("Domain: ").append(items[3]).append(",\n");
                builder.append("\n");
                builder.append("Range: ").append(items[4]).append("\n");
                builder.append("\n");
            }
        }
        String page = builder.toString();

        return page;
    }
}
