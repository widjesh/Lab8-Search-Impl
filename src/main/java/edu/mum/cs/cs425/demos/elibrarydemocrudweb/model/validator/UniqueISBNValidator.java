package edu.mum.cs.cs425.demos.elibrarydemocrudweb.model.validator;

import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.BookService;
import edu.mum.cs.cs425.demos.elibrarydemocrudweb.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueISBNValidator implements ConstraintValidator<UniqueISBN,String> {

    @Autowired
    public UniqueISBNValidator(BookService service) {
        this.service = service;
    }

    private BookService service;


    public UniqueISBNValidator() {
    }

    @Override
    public void initialize(UniqueISBN constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = false;
        if(service != null){
            valid = (s != null && !service.getBookByISBN(s).isPresent());
        }
        return valid;
    }
}
