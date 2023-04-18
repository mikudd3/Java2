package itheima.java2.d01.myexception;

/**
 * @project: 自定义成绩异常类
 * @author: mikudd3
 * @version: 1.0
 */
public class ScoreException extends Exception {
    public ScoreException() {

    }

    public ScoreException(String message) {
        super(message);
    }
}
