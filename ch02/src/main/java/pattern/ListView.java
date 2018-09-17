package pattern;

public class ListView extends Command {
    @Override
    public void excute() {
        forward("/list.jsp");
    }
}
