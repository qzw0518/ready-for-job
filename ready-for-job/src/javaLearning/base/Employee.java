package javaLearning.base;

import java.util.Date;
import java.util.Objects;

/**
 * @author zhiwen.qi
 * @description
 * @date 2019/10/26
 */
public class Employee {
    String name;

    float salary;

    Date hireDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false; //另外还有通过instanceof检测，主要针对有超类的情况
        Employee other = (Employee)obj;
        return Objects.equals(name,other.name)  //使用Objects类主要只为了保证null安全
                && salary == other.salary
                && hireDate.equals(other.hireDate);
    }

    @Override
    public int hashCode() { //如果覆写了equals方法，必须覆写hashCode方法，以便将对象插入到[散列表]中
        return Objects.hash(name,salary,hireDate); //使用Objects类的hash方法可以组合多个散列值,即将name、salary、hireDate的hashCode组合
    }

    @Override
    public String toString() {
        return "Employee[name=" + name + ",salary=" + salary + ",hireDate=" + hireDate + "]";
    }
}
