package itheima.java2.studentmanager;

/**
 * @project: 学生管理系统学生类
 * @author: mikudd3
 * @version: 1.0
 */
public class Student {
    private String sId;//学号
    private String name;//姓名
    private String age;//年龄
    private String address;//地址

    //默认构造

    public Student() {

    }

    //有参构造
    public Student(String sId, String name, String age, String address) {
        this.sId = sId;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //get / set 函数

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
