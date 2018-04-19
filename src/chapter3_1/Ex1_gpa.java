package chapter3_1;

/**
 * @author Jacob Zhang
 * @ProjectName: algorithm_4th_edition_exercises
 * @Package: chapter3_1
 * @Description:
 * @date 29/03/2018 8:43 AM
 */
public class Ex1_gpa {
    
    public static void main(String[] args) {
        BinarySearchST<String,Float> st = new BinarySearchST<>();
        st.put("A+",4.33f);
        st.put("A",4.00f);
        st.put("A-",3.67f);
        st.put("B+",3.33f);
        st.put("B",3.00f);
        st.put("B-",2.67f);
        st.put("C+",2.33f);
        st.put("C",2.00f);
        st.put("C-",1.67f);
        st.put("D",1.00f);
        st.put("F",0.00f);

        String[] grades = {"B","A","C","A-","B+"};
        float sum = 0;
        for(String s : grades){
            System.out.println(s);
            sum += st.get(s);
        }
        System.out.println("GPA:" + sum / grades.length);
    }
}
