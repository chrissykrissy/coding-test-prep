package coding.프로그래머스.PCCP;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class VideoPlayer {

    /*
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int[] posInt = timeConverter(pos);
        int[] op_start_Int = timeConverter(op_start);
        int[] op_end_Int = timeConverter(op_end);
        if(withInStart(posInt, op_start_Int, op_end_Int)){
            posInt = op_end_Int;
        }
        for(String s : commands){
            if(s.equals("prev")){
                posInt = prevTime(posInt);
                if(withInStart(posInt, op_start_Int, op_end_Int)){
                    posInt = op_end_Int;
                }
            }else{
                posInt = nextTime(posInt, op_end_Int);
                if(withInStart(posInt, op_start_Int, op_end_Int)){
                    posInt = op_end_Int;
                }
            }
        }
        return timeToString(posInt);
    }

    public boolean withInStart(int[] time, int[] start, int[] end){
        if(time[0] >= start[0] && time[0] <= end[0]){
            return true;
        }else if (time[0] == start[0]){
            if(time[1] > start[1]) return true;
            else return false;
        }else{
            if(time[1] < end[1]) return true;
            else return false;
        }
    }

    public int[] timeConverter(String time){
        String[] timeArray = time.split(":");
        int min = Integer.parseInt(timeArray[0]);
        int sec = Integer.parseInt(timeArray[1]);
        return new int[] {min, sec};
    }

    public int[] prevTime(int[] time){
        int min = time[0];
        int sec = time[1];
        if(sec < 10 && min == 0){
            return new int[] {0, 0};
        }else{
            if(sec > 10){
                sec-=10;
            }else{
                min-=1;
                sec= sec + 60 - 10;
            }
        }
        return new int[] {min, sec};
    }

//    public int timeCompare(int[] time, int[] time2){
//        if(time[0] == time2[0] || time[0] > time2[0]){
//            if(time[1] > time2[1]){
//                return 1;
//            }else if(time[1] < time2[1]){
//                return -1;
//            }else{
//                return 0;
//            }
//        }else{
//            return -1;
//        }
//    }

    public int[] nextTime(int[] time, int[] endTime){
        int min1 = time[0];
        int sec1 = time[1];
        if(endTime[0] == min1 && endTime[1]-10 > sec1){
            return endTime;
        }else{
            if(sec1 > 50){
                min1+=1;
                sec1= sec1+10-60;
            }else{
                sec1+=10;
            }
        }
        return new int[] {min1, sec1};
    }

    public String timeToString(int[] time){
        return time[0]+":"+time[1];
    }

     */

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        LocalTime localLen = LocalTime.parse("00:" + video_len, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime localPos = LocalTime.parse("00:" + pos, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime localOpStart = LocalTime.parse("00:" + op_start, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime localOpEnd = LocalTime.parse("00:" + op_end, DateTimeFormatter.ofPattern("HH:mm:ss"));
        if (!localPos.isBefore(localOpStart) && !localPos.isAfter(localOpEnd)) localPos = localOpEnd;

        for (String move : commands) {
            localPos = move.equals("next") ? localPos.plusSeconds(10) : localPos.minusSeconds(10);

            if (localPos.getHour() > 0) localPos = LocalTime.of(0, 0, 0);
            else if (localPos.isAfter(localLen)) localPos = localLen;

            if (!localPos.isBefore(localOpStart) && !localPos.isAfter(localOpEnd)) localPos = localOpEnd;
        }

        answer = localPos.format(DateTimeFormatter.ofPattern("mm:ss"));

        return answer;
    }

    public static void main(String[] args) {

    }
}
