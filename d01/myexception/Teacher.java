package itheima.java2.d01.myexception;

/**
 * @project: 老师类
 * @author: mikudd3
 * @version: 1.0
 */
public class Teacher {
    public void checkScore(int score) {
        try {
            if (score < 0 || score > 100) {
                throw new ScoreException("你给的分数有误，请重新输入");
            }
        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        }
    }
}
