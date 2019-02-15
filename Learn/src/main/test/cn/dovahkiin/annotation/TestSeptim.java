package cn.dovahkiin.annotation;

import cn.dovahkiin.learn.Util.ValidUtils;
import cn.dovahkiin.learn.bean.Dovahkiin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

/**
 * @author 骆长涛
 * @DateTime 2018/12/15 20:10
 * @description
 */
public class TestSeptim {
    public static final Log logger = LogFactory.getLog(TestSeptim.class);
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }
    @Test
    public void testValid(){

        Dovahkiin dovahkiin = new Dovahkiin();
        dovahkiin.setName("泰罗斯");
//        Set<ConstraintViolation<Object>> ss= validator.validate(dovahkiin);
//        logger.info(dovahkiin);
//        logger.info(ss.size());
//        for (ConstraintViolation s :ss
//             ) {
//            System.out.println(s.getPropertyPath() + " " + s.getMessage());
//        }
        boolean v=ValidUtils.checkTask(dovahkiin);
        logger.info("校验"+v);
    }
}
