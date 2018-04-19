package chapter3_1;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 29/03/2018 11:54 AM
 */
public class Ex4_timeAndEvent {

    public static void main(String[] args) {
        BinarySearchST<Time,String> st = new BinarySearchST<>();
        st.put(new Time("09:00:00"),"Chicago");
        st.put(new Time("09:00:03"),"Phoenix");
        st.put(new Time("09:00:13"),"Houston");
        st.put(new Time("09:00:59"),"Chicago");
        st.put(new Time("09:01:10"),"Houston");
        st.put(new Time("09:03:13"),"Chicago");
        st.put(new Time("09:10:11"),"Seattle");
        st.put(new Time("09:10:25"),"Seattle");
        st.put(new Time("09:14:25"),"Phoenix");
        st.put(new Time("09:19:32"),"Chicago");
        st.put(new Time("09:19:46"),"Chicago");
        st.put(new Time("09:21:05"),"Chicago");
        st.put(new Time("09:22:43"),"Seattle");
        st.put(new Time("09:22:54"),"Seattle");
        st.put(new Time("09:25:52"),"Chicago");
        st.put(new Time("09:35:21"),"Chicago");
        st.put(new Time("09:36:14"),"Seattle");
        st.put(new Time("09:37:44"),"Phoenix");

        System.out.println(st.size(new Time("09:15:00"),new Time("09:25:00")));
    }

}

class Time implements Comparable<Time>{

    private int hour;
    private int minute;
    private int second;

    public Time(String time) {
        String[] s = time.split(":");
        hour = Integer.parseInt(s[0]);
        minute = Integer.parseInt(s[1]);
        second = Integer.parseInt(s[2]);
    }

    @Override
    public int compareTo(Time t) {
        return (hour-t.hour)*3600 + (minute-t.minute)*60 + second-t.second;
    }
}

//Event 用String即可
