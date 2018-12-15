package cn.dovahkiin.learn.bean;


import cn.dovahkiin.learn.annotation.SeptimFamliy;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

/**
 * @author 骆长涛
 * @DateTime 2018/12/14 10:14
 * @description
 */
public class Dovahkiin {
    private Integer age;
    @NotNull
    @SeptimFamliy(message = "必须是赛普丁家族成员！！！")
    private String name;
    private Double power;

    public Dovahkiin() {
    }
    public Dovahkiin(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Dovahkiin setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dovahkiin setName(String name) {
        this.name = name;
        return this;
    }

    public Double getPower() {
        return power;
    }

    public Dovahkiin setPower(Double power) {
        this.power = power;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Dovahkiin{");
        sb.append("age=").append(age);
        sb.append(", name=").append(name == null ? "null" : Arrays.asList(name).toString());
        sb.append(", power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
