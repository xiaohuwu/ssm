package component;

/**
 * Created by dell on 2018-11-22.
 */
import model.Employee;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return Employee.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        // TODO Auto-generated method stub
        ValidationUtils.rejectIfEmpty(errors, "lastName", null, "lastName is empty.");
        Employee user = (Employee) obj;
        if (null == user.getEmail()||"".equals( user.getEmail())){
            errors.rejectValue("email", null, "getEmail is empty.");
        }
    }

}
