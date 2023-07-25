package com.webServicesProjects.Web._Services_Spring_Boot_JPA_Hibernate.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not found. Id: " + id);
    }
}
