package br.upf.ads.industria.model.constraints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexoValidoImpl implements 
                         ConstraintValidator<SexoValido, Object> {
    
    
    public void initialize(SexoValido a) {
    }
    
    public boolean isValid(Object value, ConstraintValidatorContext cvc) {
      if (value == null)
         return true;
      List<Character> list = new ArrayList<>();
      list.add('M'); list.add('F'); 
      if (list.contains(value))
         return true;
      else
         return false;
    }
}
