package br.upf.ads.industria.model.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SexoValidoImpl.class)
@Documented
/**
 * Exemplo de uso 
 * @SexoValido(message="Sexo inválido!", opcoes={"M","F"} )
 */
public @interface SexoValido {
    String message() default "Opção inválida!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
}
