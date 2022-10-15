package Setting;


/**
 * @author dj
 * @version 1.0
 **/

public class Score {
    public static int highScore;
    public static int nowScore;


    public static void addNowScore() {
        nowScore++;
        if(nowScore >= highScore){
            //当目前成绩大于最高时
            highScore = nowScore;

        }

    }

    //读取最高score




}
