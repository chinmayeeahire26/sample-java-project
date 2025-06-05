public class File1 {

    public String methodA() {
        return helperX();
    }

    public String methodX() {
        return "something else";
    }

    private String helperX() {
        return "from X new1";
    }
}
