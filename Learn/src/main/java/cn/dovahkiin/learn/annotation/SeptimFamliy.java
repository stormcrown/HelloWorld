package cn.dovahkiin.learn.annotation;

import cn.dovahkiin.learn.annotation.impl.SeptimFamliyImpl;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;

/**
 * @author 骆长涛
 * @DateTime 2018/12/14 10:00
 * @description
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {SeptimFamliyImpl.class})
@Documented
public @interface SeptimFamliy   {
    String message() default " He(She) must be a Septim ! ! !";


    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        SeptimFamliy[]  value();
    }
}
