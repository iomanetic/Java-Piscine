package edu.school21.spring;

import edu.school21.spring.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppContext {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("PrinterPrefix", Printer.class);
        printer.print("Hello!");

        printer = context.getBean("PrinterDate", Printer.class);
        printer.print("it's date");
    }
}