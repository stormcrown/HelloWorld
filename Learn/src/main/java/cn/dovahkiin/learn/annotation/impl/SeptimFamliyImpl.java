package cn.dovahkiin.learn.annotation.impl;

import cn.dovahkiin.learn.annotation.SeptimFamliy;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SeptimFamliyImpl implements ConstraintValidator<SeptimFamliy,Object> {
//    @Override
    public void initialize(SeptimFamliy septimFamliy) {
        System.out.println("初始化");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        System.out.println("验证");
        if(value instanceof String ){
            return checkValue((String) value);
        }else if(value instanceof String[]){
            for(String str:(String[]) value){
                if(!checkValue(str))return false;
            }
        }
        return true;
    }
    private boolean checkValue(String value){
        if(StringUtils.hasText(value)  && !value.contains("Septim")  ){
            return false;
        }
        return true;
    }
}
