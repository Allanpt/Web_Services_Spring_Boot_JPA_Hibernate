package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services.exceptions;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String msg){
        super(msg);
    }
}
