package cn.dovahkiin.learn.Util;

import cn.dovahkiin.learn.bean.Dovahkiin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.*;
import java.util.Set;

/**
 * @author 骆长涛 Ex-luozhangtao001
 * @DateTime 2019/2/15 10:37
 * @description
 */
public class ValidUtils {
    public static final Log logger = LogFactory.getLog(ValidUtils.class);
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }
    public static boolean checkTask(Object object){
        Set<ConstraintViolation<Object>> ss= validator.validate(object);
        if(ss!=null && ss.size()>0) return Boolean.FALSE;
        return Boolean.TRUE;
    }

}
